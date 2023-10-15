package com.moderneinstein.web.vertx;


import io.vertx.jdbcclient.JDBCPool ;
import io.vertx.jdbcclient.JDBCConnectOptions ;
import io.vertx.core.Future ; 
import  io.vertx.core.Vertx ;
import io.vertx.core.Handler ;
import io.vertx.sqlclient.PoolOptions ; 
import io.vertx.core.AsyncResult ;
import io.vertx.sqlclient.SqlConnection ; 
import io.vertx.ext.sql.SQLClient ; 
import io.vertx.ext.jdbc.JDBCClient ; 

import java.util.logging.Logger ;
import java.util.logging.Level ; 

import io.vertx.ext.mongo.MongoClientUpdateResult ; 
import io.vertx.ext.mongo.MongoClient ; 
import io.vertx.ext.mongo.MongoClientDeleteResult ; 
import io.vertx.core.json.JsonObject ; 


public class ConnectionSource {

        public static  JDBCPool pools ; 
        public static JDBCConnectOptions  connects ;
        public static PoolOptions options ; 
        public static SqlConnection  variant = null  ;   
        public  static Logger logger  =  Logger.getLogger("ConnectionSource")  ; 
        public static String database = new String() ;
         public static String users = new String () ;
        public static int fetchSize =  10 ;
        public static int  loopSize = 3 ; 
        public static String optionsName = new String () ; 
         public static String  password = new String() ; 
         public  static int maxSize =  10 ;    
         public static String[]  MongoOptions = 
         new String[]{"Library4","mongodb://localhost/Library4?connectTimeoutMS=120000"} ;   
         ///"mongodb://127.0.0.1/?connectTimeoutMS=120000"
                //   "mongodb+srv://username:password@127.0.0.1:27017/?connectTimeoutMS=120000" 
                // "mongodb+srv://username:password@127.0.0.1/?connectTimeoutMS=120000"  
                // "mongodb://localhost/?connectTimeoutMS=120000"
        public static  void configure (){
            options = new PoolOptions() ; 
            options.setShared(true) ; 
            options.setEventLoopSize(loopSize) ; 
            options.setName(optionsName);
            options.setMaxSize(maxSize) ;
            connects = new JDBCConnectOptions( );
            connects.setPassword(password) ; 
            connects.setUser(users) ;
            connects.setFetchSize(fetchSize) ;
            connects.setDatabase(database) ;
        }
            //            SqlConnection  variant = null  ;  
            //        if(present==null){return ;}  
            ///    variant = sqlconnection  ; 
        public static  SqlConnection connection(Vertx source){
            configure() ;
            pools = JDBCPool.pool(source,connects,options) ;
            Future<SqlConnection> futures = pools.getConnection() ;  
            SqlConnection[] holder = new SqlConnection[4] ;  
             futures.onComplete(
                new Handler<AsyncResult<SqlConnection>>(){
                    @ Override 
                    public void handle(AsyncResult<SqlConnection> present){
                        if(present.succeeded()){
                            SqlConnection  sqlconnection = present.result() ; 
                            holder[0] = sqlconnection ;  }  }   }  ) ;
                return holder[0] ;  
        }   
        /* 
         else{  Throwable thrown = present.cause() ; 
             logger.log(Level.INFO,thrown.getMessage() ) ;  }
             return variant  ;   */
        public static JsonObject  MongoJson(){
             JsonObject grace =  new JsonObject( ) ; 
            grace.put("useObjectId",true)  ; 
            grace.put("db_name",MongoOptions[0]) ; 
            grace.put("connection_string",MongoOptions[1]) ;
            return grace   ;  
        }
        public static  MongoClient MongoClient(Vertx context){
                JsonObject kinds = MongoJson( ) ;
               // MongoClient clients =  MongoClient.createShared(context,kinds) ;   
               MongoClient clients = MongoClient.create(context,kinds) ;
                return clients ; 
        }
}
