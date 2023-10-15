package com.moderneinstein.web.vertx ;  

import  io.vertx.core.AbstractVerticle ;
import io.vertx.core.Promise ;
import io.vertx.core.Future  ;
import io.vertx.core.Verticle ;
import io.vertx.core.Handler ;  

 import io.vertx.core.AsyncResult ;
 import io.vertx.core.http.HttpClient  ;
 import io.vertx.core.http.HttpServer ;
 import  io.vertx.core.json.JsonObject ;
import io.vertx.core.Vertx ; 

import  java.util.Objects ;
import  java.util.Arrays  ;
import java.util.Set ;
import  java.util.Queue ;
 
import  org.junit.jupiter.api.Test  ;

public class  BaseTestVerticle extends AbstractVerticle{
     //  public  String[] dependencies 
    public  String[] depends = new String[]{"com.moderneinstein.web.vertx.BookTestVerticle","com.moderneinstein.web.vertx.AuthorTestVerticle"};   
    public HttpServer central ;   

      //   int range = dependencies.length  ; 
    public void CommenceTests(Handler<AsyncResult<String>> holder){
        int range = depends.length  ; 
        for(int mt=0;mt<range;mt++){ 
            String template =  depends[mt] ;
            vertx.deployVerticle(template,holder) ;
        }
    }  
    //  String template =  dependencies[mt] ;     
     @Test
    public void Trials( ) {
        System.out.println(44) ;  
        Utilities.LogEntry(this.getClass().getName( )) ; 
        Utilities.LogEntry(this.getClass().toString( )) ; 
        System.out.println(66) ;   
    }
    @Test
    @Override
    public void start(){
         vertx = Vertx.vertx(); 
        central = vertx.createHttpServer( ) ;  
       Handler<AsyncResult<String>> delegate = new Handler<AsyncResult<String>> (){
        @Override 
        public void handle(AsyncResult<String> pending){
            if(pending.succeeded( ))
            {String plains = pending.result() ; 
            Utilities.LogEntry(plains)  ;   }  else{
            Utilities.DefaultHandler(pending.cause( )) ; }
        }
       }    ;  
       CommenceTests(delegate) ;    
       JsonObject kinds =  new JsonObject( )  ; 
       kinds = Utilities.serialiseBook (new Book("Harry Potter and the Goblet of Fire","J.K Rowling")) ;  
        BaseVerticle.outer.println(kinds.encode( )) ; 
       while(central!=null){}
    }
}
