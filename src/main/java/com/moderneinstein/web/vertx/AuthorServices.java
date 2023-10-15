package com.moderneinstein.web.vertx;


import  io.vertx.sqlclient.SqlConnection ; 
import io.vertx.sqlclient.RowSet ; 
import  io.vertx.sqlclient.Row ; 
import io.vertx.sqlclient.Query ; 

import io.vertx.core.Promise ;
import io.vertx.core.Handler ; 
import io.vertx.core.json.JsonArray   ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.AsyncResult ; 


import java.util.Objects ; 
import java.lang.reflect.Array ; 
import java.util.Vector ; 
import java.util.List ;   

import java.util.Arrays ; 
import java.lang.Thread ; 
import java.util.ArrayList ; 


import  io.vertx.core.Vertx ;
import  io.vertx.core.Future ;
import  io.vertx.sqlclient.PreparedQuery   ;
import  io.vertx.sqlclient.PreparedStatement  ; 
import io.vertx.sqlclient.Tuple ;  

import io.vertx.ext.mongo.MongoClient ; 
import io.vertx.ext.mongo.MongoClientUpdateResult ;
import io.vertx.ext.mongo.MongoClientDeleteResult  ;


public class AuthorServices {
    
    public  Vertx related ; 
    private SqlConnection connected ;  
    public  static  String  query6 =  new String("") ; 
    public static String query5 = new String("") ; 
     public static String query4 = new String("") ; 
    public static String query3 = new String("" ) ; 
    public String collection =  new String("Authors_2") ;  
    public MongoClient  client  ; 
     public  AuthorServices(SqlConnection sqlconnect ){
        this.connected = sqlconnect ; 
    }
    
    public   AuthorServices(Vertx  access,SqlConnection dynamic){
        this.related =  access  ;  
        this.connected = dynamic  ;
    }
   public AuthorServices(Vertx polygons,JsonObject adapter){
        client = MongoClient.create( polygons,adapter) ; 
        this.related  = polygons ;
   }  
   public AuthorServices(Vertx activity,MongoClient starter){
        this.client  =  starter ;
        this.related = activity ;   
        starter.createCollection (collection).onSuccess(
            new Handler<Void>(){
                @Override 
                public void handle(Void voided){
                     Utilities.LogEntry(new String(collection)) ;
                }
            }
        ) ;
   }
    public Tuple  convert(Author verses){
        Tuple tuples  =  Tuple.tuple() ; 
        tuples= Tuple.from(verses.getBooks()) ; 
        tuples.addLong(verses.getMainId()) ; 
        tuples.addString(verses.getFirstName()) ;
        tuples.addString(verses.getLastName( ))  ; 
        return tuples ; 
     }

    public  void insertAuthor(Author authorised){
        Future<PreparedStatement> futures =  connected.prepare(query5) ; 
        PreparedStatement statement = futures.result() ;
        PreparedQuery<RowSet<Row>>  prepared =  statement.query( ) ;  
        Tuple tuples  =  convert(authorised) ; 
        prepared.execute(tuples) ;  
    }
   public List<Author> deriveAuthors(List<JsonObject> serial){
        List<Author> ranges = new Vector<Author> (); 
         for(int fr =0;fr<serial.size();fr++){
            JsonObject jsons =  serial.get(fr) ;
            Author parts =  Utilities.deserialiseAuthor(jsons); 
            ranges.add(parts)  ;
         } 
         return  ranges ; 
   }
    public  void  createAuthor(Author creator){
        Future<PreparedStatement> inFront =  connected.prepare(query6) ;
        PreparedStatement statement =  inFront.result( ) ;
        PreparedQuery<RowSet<Row>>  queries =  statement.query () ; 
        Objects.requireNonNull(creator) ; 
        Tuple content = convert(creator) ; 
        queries.execute(content) ;  }   
       
      //  public void  findAuthorByName2(String lastName){
            
      //  }  
      //       List<JsonObject>   //   Author yield = 
      //writers.get(0) ;  //  void ,  Author[] buffer  
    ///  public Future<Author> findAuthorById2(String identity, Author[] buffer
        public Future<Author> findAuthorById2(String identity) {
            JsonObject coded =new JsonObject( ).put( "SelfId",identity) ; 
            Future<List<JsonObject>> probable  = client.find(collection,coded) ;   
            Promise<Author>  verse = Promise.promise( ) ; 
            probable.onComplete( 
                new Handler<AsyncResult<List<JsonObject>>>(){  
                    @Override 
                    public void handle(AsyncResult<List<JsonObject>> braces){
                        if(braces.succeeded()){ 
                         List<JsonObject> listed =   (List<JsonObject>)braces.result( ); 
                        List<Author>  writers = deriveAuthors(listed) ;
                         verse.complete(writers.get(0))  ; 
                           }else{ verse.fail(braces.cause() ) ; 
                        Utilities.DefaultHandler(braces.cause())  ; }  }   } ) ;  
                return  verse.future( ) ; 
        }
        /*   buffer[0] = Utilities.deserialiseAuthor(listed.get(0)) ; 
                            buffer[0] =  writers.get(0) ; */
        // ,JsonObject[] buffers,boolean[] cases  // void  
        //  long mainId   // ,
       // JsonObject[] buffers,boolean[] cases   // $addToSet
        public Future<JsonObject> updateAuthorById2(String mainId,Author generic){ 
            JsonObject inserted = Utilities.serialiseAuthor(generic) ;
            JsonObject query =  new JsonObject( ).put("SelfId",mainId) ; 
             JsonObject updated =  new JsonObject().put("$set",inserted)   ;   
             Promise<JsonObject> frames = Promise.promise() ; 
            client.updateCollection(collection,query,updated,
            new Handler<AsyncResult<MongoClientUpdateResult>>( ){
                @Override 
                public void handle(AsyncResult<MongoClientUpdateResult> updates){
                        if(updates.succeeded( )){
                            MongoClientUpdateResult result =  updates.result() ;  
                            JsonObject represent = result.toJson () ;  
                            frames.complete( represent) ; 
                        }else{
                            frames.fail( updates.cause()) ; 
                            Utilities.DefaultHandler(updates.cause()) ;
                          }    }  }  )  ;  
            return frames.future() ; 
        }        
        /*        buffers[0] = represent;   
                            cases[0] = true  ;  */
        //,long[] identity  // identity[0] = gains ;  //,long[] identity
        public Future<String> insertAuthor2(Author forms){
            JsonObject encoded = Utilities.serialiseAuthor(forms) ; 
           Future<String> plans =  client.save(collection, encoded) ;  
           Promise<String> pounds = Promise.promise( ) ;
        plans.onSuccess(
            new  Handler<String>(){
                @Override 
                public void handle(String patterns){
                   // long gains =  Long.parseLong(patterns);  
                  //  pounds.complete(patterns) ;   
                     JsonObject changes = new JsonObject().put("$set",new JsonObject().put("SelfId",patterns))   ;  
                     JsonObject input = new JsonObject().put("_id",patterns)  ;   
                    client.updateCollection(collection,input,changes).onSuccess(
                        new Handler<MongoClientUpdateResult>(){
                            @Override 
                            public void handle(MongoClientUpdateResult updates){
                                pounds.complete (patterns) ; 
                            }
                        }
                    ) ;   
                    }   }   );  
        plans.onFailure(
        new Handler<Throwable>(){
            @Override 
            public void handle(Throwable thrown){
                Utilities.DefaultHandler( thrown )  ;  
                pounds.fail(thrown) ; 
            }  }  ) ; 
         return pounds.future( ) ;   }   
         //   ,JsonObject[] returns ,boolean[] notice // long  
         /* returns[0] = jsons ;  
         notice[0] = true  ;   */ // ,JsonObject[] returns ,boolean[] notice  
         /// ,JsonObject[] returns ,boolean[] notice 
        public Future<JsonObject> deleteAuthorById2(String notes)   {
                JsonObject created = new JsonObject().put("SelfId", notes)  ; 
                Future<MongoClientDeleteResult> prosper =  client.removeDocument(collection,created) ;   
                Promise<JsonObject> terrain = Promise.promise() ; 
                prosper.onComplete(
                    new  Handler<AsyncResult<MongoClientDeleteResult>>(){
                        @Override 
                        public void handle(AsyncResult<MongoClientDeleteResult> asyncs){
                            if(!asyncs.succeeded( )){terrain.fail(asyncs.cause()) ; } 
                            else{MongoClientDeleteResult updated = asyncs.result( ) ; 
                            JsonObject jsons = updated.toJson ()  ;  terrain.complete(jsons) ;
                             }//else{ terrain.fail(asyncs.cause()) ; }
                        } 
                    } 
                ) ; 
                return  terrain.future() ; 
        }    
        //     JsonObject kinds = new JsonObject("FirstName",names) ;   // void
        //  public void handle(AsyncResult<List<JsonObject>> listed  // Long.valueOf(notes)  
        ///     findAuthorByFirstName2(String names,List<Author>[] verses
        public  Future<List<Author>>  findAuthorByFirstName2(String names) {
             JsonObject kinds = new JsonObject().put("FirstName",names) ;  
             Promise<List<Author>> attempt =  Promise.promise() ; 
             client.find(collection,kinds, 
             new Handler<AsyncResult<List<JsonObject>>>( ){
                @Override 
                public void handle(AsyncResult<List<JsonObject>>  pending ){
                    if(pending.succeeded()){
                     List<JsonObject> jsons =  pending.result( ) ; 
                    List<Author> converted = deriveAuthors(jsons); 
                    attempt.complete(converted) ; }  else{ attempt.fail(pending.cause()) ;    }
                }
             })  ;   
             return  attempt.future() ; 
         }   
        public  Future<List<Author>> findAll( ){
            JsonObject clean = new JsonObject () ;
            Promise crest = Promise.promise( ) ;
            client.find(collection,clean,new  Handler<AsyncResult<List<JsonObject>>>(){ 
                @Override 
                public void handle(AsyncResult<List<JsonObject>> asyncs){
                    if(asyncs.succeeded()){ 
                        List<JsonObject> content =  asyncs.result( ) ;
                        List<Author> listed =  deriveAuthors(content) ;
                        crest.complete(listed) ; 
                    } else{ 
                        crest.fail(asyncs.cause()) ;
                    }
                }
            }) ;  
            return crest.future( ) ;
        }   
        // Future<Author>   //  Promise<JsonObject> promises = Promise.promise( )  ;   // toJsonObject())
    public Future<JsonObject> updateAuthorByFirstName (String point,Author verse) {
        JsonObject kinds  =  Utilities.serialiseAuthor ( verse)   ;
        JsonObject input = new JsonObject( ).put("$set",kinds) ; 
        JsonObject first = new JsonObject().put("FirstName", point)  ; 
        Promise<JsonObject> attempt = Promise.promise( )  ; 
        Future<MongoClientUpdateResult> fortune =  client.updateCollection(collection,first,input) ; 
        fortune.onComplete( 
            new Handler<AsyncResult<MongoClientUpdateResult>>(){ 
                @Override  
                public void handle(AsyncResult<MongoClientUpdateResult> trials){  
                    if(trials.failed()){attempt.fail(trials.cause () ) ;}
                    if( trials.succeeded( )){ attempt.complete(trials.result( ).toJson()) ;} 
                     
                }
            }
        ) ;   
        return  attempt.future ()  ;  
        }    
        public Future<List<Author>> findAuthorByLastName(String last) {
            JsonObject input =  new JsonObject().put("LastName",last)  ; 
            Promise<List<Author>> promise = Promise.promise( ) ; 
            Future<List<JsonObject>> points =  client.find( collection ,input  ) ; 
            points.onFailure( 
                new Handler<Throwable>( ) {
                    @Override 
                    public void handle(Throwable thrown){
                        Utilities.DefaultHandler(thrown) ; 
                    }   }   ) ; 
            points.onSuccess( 
                new  Handler<List<JsonObject>>(){
                    @Override 
                    public  void handle(List<JsonObject> listed){
                        List<Author> auths = deriveAuthors(listed) ;
                        promise.complete(auths) ; 
                    }   }  ) ; 
            return promise.future( ) ;
        }     //  new    JsonObject(
        public Future<JsonObject> updateAuthorByLastName(String last,Author changes){ 
            JsonObject initial =Utilities.serialiseAuthor( changes)  ;
            JsonObject entrance = new JsonObject().put("$set",initial)  ;  
            JsonObject frames = new JsonObject().put("LastName",last)  ;  
             Promise<JsonObject> prospects = Promise.promise( ) ; 
            client.updateCollection(collection,frames,entrance,
            new Handler<AsyncResult<MongoClientUpdateResult>> (){
                 @Override 
                 public void handle(AsyncResult<MongoClientUpdateResult> pending){ 
                if(pending.failed()){//!pending.succeeded( )){
                     prospects.fail(pending.cause()) ; 
                     Utilities.DefaultHandler(pending.cause()) ; 
                }
                  if(pending.succeeded()){
                    JsonObject access = pending.result ( ).toJson() ; 
                    prospects.complete(access) ; 
                  }
                 }
            }) ;  
            return   prospects.future()  ; 
        }
         //  verses[0] = converted ;
        //    JsonObject updated =  JsonOnbject.iset   ;
    
}
