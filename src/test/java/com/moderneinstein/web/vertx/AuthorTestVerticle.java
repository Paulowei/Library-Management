 package com.moderneinstein.web.vertx ; 
 
import io.vertx.core.Verticle ;
import io.vertx.core.Vertx ;
import io.vertx.core.AbstractVerticle ;  

import io.vertx.core.AsyncResult ;
import io.vertx.core.Handler ; 
import io.vertx.core.Promise ;   
import io.vertx.core.Future  ; 

import io.vertx.core.http.HttpServer ; 
import io.vertx.core.http.HttpClient ; 
import  io.vertx.core.http.HttpMethod ; 
import io.vertx.core.http.HttpClientRequest  ; 
import io.vertx.core.http.HttpClientResponse ;

import io.vertx.core.buffer.Buffer ; 
import io.vertx.core.json.JsonObject ; 
import io.vertx.core.json.Json ; 

import java.util.function.Consumer ; 
import java.util.function.Supplier  ;
import  java.util.function.Predicate  ; 
import java.util.List ;
import java.util.ArrayList ; 
import java.util.Set ; 


 public class AuthorTestVerticle extends AbstractVerticle{
 
    public HttpClient  client ;    //  sender ; 
    public static String  DEFAULT_HOST =  "localhost"  ; 
    public static int DEFAULT_PORT  =  8080 ; 
    public static String[] options = new String[]{"content/type","application/json"} ; 
    // asyncs   // pending   
    //  ,String places
    public void configureResponse( HttpClientResponse response){ 
        Future<Buffer> frames = response.body( ) ; 
        frames.onComplete( 
                new Handler<AsyncResult<Buffer>>( ){ 
                    @Override 
                    public void handle(AsyncResult<Buffer> determine ){
                        if(determine.succeeded()){
                            JsonObject jsons = determine.result( ).toJsonObject() ; 
                            String lines =  jsons.encode() ;
                        }else{ 
                             
                        }
                     }
                }
        ) ;   
        BaseVerticle.outer.println("Verse")  ; //BaseTestVerticle.outer.println("Mains")  ;
    }
    // Client 
     public void configureRequest(HttpClientRequest requests,String patterns){ 
            Handler<AsyncResult<HttpClientResponse>> handles =   
              new Handler<AsyncResult<HttpClientResponse>>( ){ 
                @Override 
                public void handle (AsyncResult<HttpClientResponse> asyncs){  
                    if(asyncs.succeeded()){
                         configureResponse(asyncs.result())  ; 
                    }
                } 
              } ;    
        requests.putHeader(options[0],options[1]) ; 
        requests.send(patterns,handles)      ; 
        requests.end () ;
      }  
        ///   static   // Request 
      public void  startRequest(HttpMethod methods,int port,String host,String requestUri,String parts){ 
         Handler<AsyncResult<HttpClientRequest>> handles  
          = new Handler<AsyncResult<HttpClientRequest>>(){
                @Override 
                public void handle (AsyncResult<HttpClientRequest> pending){ 
                    if( pending.succeeded()){
                        configureRequest(pending.result( ),parts) ;
                    }
                }
         }  ;    
        client.request(methods,port,host,requestUri,handles) ;
      }     
  
      // sender = vertx.createHttpClient()  ; 
    @Override 
    public void start(){
        vertx = Vertx.vertx()  ;
       client = vertx.createHttpClient()  ; 
        List[] buffer =  AuthorDataSource.computeTests ( ) ;  
        int spread = buffer[1].size( ) ; 
        for(int vt=0;vt<spread;vt++){
            String paths = (String)buffer[0].get (vt) ;
            String parts =  (String)buffer[1].get(vt) ;  
            HttpMethod methods = (HttpMethod)buffer[2].get(vt) ;
            startRequest(methods ,DEFAULT_PORT,DEFAULT_HOST,paths,parts) ;
        }
    }
 }