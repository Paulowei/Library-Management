package com.moderneinstein.web.vertx ;

import  io.vertx.core.Handler ;
import  io.vertx.core.Future ;  
import io.vertx.core.AsyncResult ;   
import io.vertx.core.Vertx ; 
import io.vertx.core.Verticle ; 
import io.vertx.core.AbstractVerticle ; 

import io.vertx.core.json.JsonArray ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.buffer.Buffer  ;  

import io.vertx.core.http.HttpServer ;
import io.vertx.core.http.HttpClient ;
 import io.vertx.core.http.HttpClientRequest ;
 import io.vertx.core.http.HttpClientResponse ;
import io.vertx.core.http.HttpMethod ;

import java.util.Objects ;
import java.util.Arrays ;
import java.util.function.Predicate ;
import java.util.function.Function ;
import java.util.List ; 
import java.util.Set  ; 


public class BookTestVerticle extends AbstractVerticle {

    public  HttpClient sender ;
    public static String[] notice = new String[]{"content/type","application/json"}  ;
    public static int  Default_Port = 8020 ; // http://
    public static String Default_Host = "localhost"  ;
    public static String connect = " "  ;  //"http://localhost"  ;
    public void promptResponse(HttpClientResponse replies){
        if(replies==null){return  ;  }
        Future<Buffer> assist =  replies.body() ;
        assist.onSuccess(
            new Handler<Buffer>( ){
                @Override
                public void handle(Buffer buffer){
                    JsonObject  points = buffer.toJsonObject() ;
                    String palace = buffer.toString( ) ;  
                    Utilities.LogEntry(palace ) ; 
                    ///
                }  }  ) ;
        assist.onFailure(
            new Handler<Throwable>(){
                @Override
                public void handle(Throwable thrown){
                    String lanes = thrown.toString( ) ; 
                    Utilities.LogEntry(lanes) ; 
                }
            }
        ) ;
    }
   //  responded
    public void  sendRequest(String trials,HttpClientRequest requests){
        Handler<AsyncResult<HttpClientResponse>> responded
        = new  Handler<AsyncResult<HttpClientResponse>>(){
            @Override
            public void  handle(AsyncResult<HttpClientResponse> inclined ){
                if(inclined.succeeded()){
                    promptResponse(inclined.result()) ;
                }
            }
        }  ;
        requests.putHeader(notice[0],notice[1]) ;
        requests.send( trials,responded ) ;
      //  requests.end(new Handler<AsyncResult<Void>>(){}) ;
      requests.end() ;
    }  //  responded   //  requests  // requests
     public void planRequest(HttpMethod types,int port ,String host,String URI,String values) {
        Handler<AsyncResult<HttpClientRequest>> handlers =   
        new Handler<AsyncResult<HttpClientRequest>>( ){    
            @Override      
            public void handle(AsyncResult<HttpClientRequest>  pending){    
                if(pending.succeeded()){
                        sendRequest(values ,pending.result ())  ;  
                }
            }
        } ; 
        sender.request(types,port,host,URI,handlers ) ;
    }
    //    sender = vertx.createHttpServer()  ;
    @Override
    public void start() {
         vertx =Vertx.vertx() ;
         sender =  vertx.createHttpClient()  ;  
        List[] linear  = BookDataSource.deriveValues( )  ;
        int spans = linear[2].size() ;
        for(int  vc=0;vc<spans;vc++){
            HttpMethod methods =   (HttpMethod)linear[2].get(vc) ;
            String paths = (String)linear[0].get(vc) ;
             String items =   (String)linear[1].get (vc ) ;
           planRequest(methods,Default_Port,Default_Host, paths,items);
        }
    }
}
