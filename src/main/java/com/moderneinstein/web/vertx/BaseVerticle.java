package com.moderneinstein.web.vertx;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.http.HttpServer ; 
import io.vertx.ext.web.RoutingContext ;
import io.vertx.core.Handler ; 
import io.vertx.core.Vertx ; 
import io.vertx.ext.web.Router ; 
import io.vertx.core.Verticle ; 

import io.vertx.core.AsyncResult ; 
import io.vertx.core.Promise ; 
import io.vertx.core.Future ; 

import  java.util.Arrays ; 
import  java.util.LinkedList  ;
import java.io.PrintStream ; 
import  java.util.logging.Logger ; 
//import com.mongodb.internal.binding.AsyncReadBinding;
import java.util.logging.Level ; 

import io.vertx.ext.mongo.MongoClient ; 

public class BaseVerticle extends AbstractVerticle {
   //new BaseVerticle(),
    public  Verticle[] verticles = new  Verticle[]{new BookVerticle(),new AuthorVerticle( ) } ;  
    public String[]  classes = new String[] {"com.moderneinstein.web.vertx.BookVerticle","com.moderneinstein.web.vertx.AuthorVerticle"}   ;   // "BookVerticle.class","AuthorVerticle.class"
    public  HttpServer server ; 
    public static PrintStream outer =  System.out ; 
    public static Logger logger =  Logger.getLogger("Logger") ;
    // ,BaseVerticle.class 
    public  void deployVerticles(Handler<AsyncResult<String>> handler) {
        int width =  verticles.length ;   
        for(int dc=0;dc<width;dc++){
            Verticle temps = verticles[dc] ;  System.out.println(temps.getClass().getName( )) ; 
             vertx.deployVerticle(classes[dc],handler) ;   
        }    // temps.getClass().getName( )  ;   //  vertx.deployVerticle(temps.getClass().getName( ) ,handler) ; 
      //  System.out.println (55) ;   //    vertx.deployVerticle(classes[dc],handler) ;   
        MongoClient client =  ConnectionSource.MongoClient(vertx) ; 
        Utilities.LogEntry(client.toString( )) ;  
        Future<Void> futures = client.createCollection("Bases")  ;
        futures.onSuccess(
            new Handler<Void>(){
                @Override 
                public void handle(Void voided){
                    outer.println("The collection was created") ;
                }
            }
        ) ;   
        futures.onFailure( 
            new Handler<Throwable>(){
                @Override 
                public void handle(Throwable thrown){
                    Utilities.DefaultHandler(thrown) ;
                }
            }
        ) ;
    }     
    /*new Handler<AsyncResult<String>>(){
                @Override 
                public void handle(AsyncResult<String> syncs){
                    if(syncs.succeeded()){
                    String yield =syncs.result() ; outer.println(yield) ;
                    outer.println("This was an attempt") ;}
                else{Throwable thrown =  syncs.cause() ; 
                Utilities.DefaultHandler(thrown ) ; }}
            } */
    //  vertx.deployVerticle(temps,handler) ; 
    @Override
    public void start() { 
        vertx = Vertx.vertx( ) ; 
        //  System.out.println(44) ; 
        Handler<AsyncResult<String>> mechanism = new Handler<AsyncResult<String>>(){
            @Override 
            public void handle(AsyncResult<String>  present){
                if(present.succeeded()) {
                String notes = present.result() ; 
               logger.info(notes) ; 
               outer.println("Braces")  ;    }
               else{String patterns = present.cause().toString() ;
                Utilities.LogEntry( patterns) ;  }  }  }  ; 
        deployVerticles(mechanism) ;    
        
             }
 /**  vertx =  Vertx.vertx() ;
        server = vertx.createHttpServer(  );  */
    public BaseVerticle(){
        super()  ; 
         vertx =  Vertx.vertx() ;
        server = vertx.createHttpServer(  ); 
        Router router = Router.router(vertx ) ; 
       server.requestHandler(router) ; 
      // start( )  ;
    }  
   /* public static void main(String[]args){
        BaseVerticle bases = new BaseVerticle()  ; 
        bases.start( )  ;
    } */
         //  logger.info("RF")  ;   
       //   outer.println(notes) ;   
}
