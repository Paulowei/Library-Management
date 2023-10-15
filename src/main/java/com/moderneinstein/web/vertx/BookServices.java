package com.moderneinstein.web.vertx;

import  io.vertx.sqlclient.SqlConnection  ;
import   io.vertx.sqlclient.RowSet ; 
import   io.vertx.sqlclient.Row ; 
import io.vertx.core.Vertx ; 
import  io.vertx.sqlclient.Query ; 
import  io.vertx.jdbcclient.JDBCConnectOptions  ;
import io.vertx.jdbcclient.JDBCPool ; 

import com.moderneinstein.web.vertx.Book  ; 
import com.moderneinstein.web.vertx.Author ; 

import  io.vertx.core.Handler ; 
import io.vertx.core.AsyncResult ; 
import io.vertx.core.Future ;
import io.vertx.core.json.JsonArray  ; 
import io.vertx.core.json.JsonObject ;
import io.vertx.core.Promise ; 

import io.vertx.ext.mongo.MongoClient ; 
import io.vertx.ext.mongo.MongoClientUpdateResult ;    
import io.vertx.ext.mongo.MongoClientDeleteResult ; 

import io.vertx.sqlclient.Tuple; 
import io.vertx.sqlclient.PreparedStatement ; 
import io.vertx.sqlclient.PreparedQuery ;  
import java.util.ArrayList ; 


import java.util.Objects ; 
import java.util.List ; 

public class BookServices {
    
    public SqlConnection connection = null  ;  
    public Vertx  shell  = null ;  
     public  static String  query7 = new String("") ; 
    public static String query6 = new String("") ; 
    public static String  query5 =  new String ("") ; 
    public static String  ERROR_STRING = new String("The given value was NULL ") ;
    public static String question = new String("?");  
    public MongoClient client ;  
    public String collection = new String("Books_6") ; 
    public BookServices(Vertx context,SqlConnection reserve) {
        this.connection = reserve ;   
        JsonObject jsons = new JsonObject()  ; 
        client = MongoClient.createShared(context,jsons) ;
    }

    public  BookServices(Vertx  centre,SqlConnection  links,JsonObject configs){
        this.connection = links ; 
        this.shell =  centre ;    
         client = MongoClient.createShared(centre,configs) ;  
    }   
    public BookServices(Vertx cores,MongoClient sorted){
            this.client =  sorted ; 
            this.shell = cores ; 
            Future<Void> futures  = client.createCollection(collection) ; 
            futures.onComplete(
                new Handler<AsyncResult<Void>>( ){
                @Override 
                public void handle(AsyncResult<Void>  present) {
                    if(present.succeeded()){ 
                        Void voided = present.result( ) ;
                     //   Utilities.LogEntry (voided.toString()) ; 
                        Utilities.LogEntry("Collection was created") ;
                    }else{
                        Utilities.LogEntry("Could not Create Collection") ;
                    }
                }
                }
            ) ;
    } 
    public BookServices(Vertx mains, JsonObject objects){
        this.shell =  mains ; 
        this.client = MongoClient.create(mains,objects) ;
    }
              // AbstractInterruptibleChannel
    //    starts.addLong(Long.toString(source.identity)) ;

    public  Query<RowSet<Row>>  createQuery(String  essential){
        Future<PreparedStatement>  predict =  connection.prepare(essential) ; 
        PreparedStatement  compiled =  predict.result( ) ;  
        Objects.requireNonNull(essential) ;
        PreparedQuery<RowSet<Row>>  release = compiled.query( ) ;  
        return  release  ; 
    }
    public void  findBook(Book verses){
        String  potential =  query6.replace(question,Long.toString(verses.getMainId())) ;
        Query<RowSet<Row>>  given =  connection.query(potential) ; 
        given.execute(new Handler<AsyncResult<RowSet<Row>>>(){
            @Override 
            public void handle(AsyncResult<RowSet<Row>> syncs ){
               if(syncs.succeeded()){
                 RowSet<Row>  trials = syncs.result() ;  
                  }    
            }   }) ;   }  
    public void  deleteBook (Book brackets){
        Future<PreparedStatement> futures  =  connection.prepare(query7) ;
        PreparedStatement  prepared  =  futures.result() ;
        PreparedQuery<RowSet<Row>> queries =  prepared.query () ;
        Tuple tuples = Tuple.tuple().addLong(brackets.getMainId())  ;
        queries.execute(tuples); 
    }
    public void  insertBook(Book  notify){
        Future<PreparedStatement> futures =  connection.prepare(query5) ;
        PreparedStatement stated = futures.result() ;
        Objects.requireNonNull(notify,ERROR_STRING)  ;  
        PreparedQuery<RowSet<Row>>  attempt   = stated.query( ) ; 
        Tuple tuples =   Utilities.convertBook(notify) ; 
        attempt.execute(tuples); 
    } 
    public  void updateBook(Book source){
        Future<PreparedStatement>  predict =  connection.prepare(query6) ; 
     //   PreparedStatement prepared  = predict.  
        predict.onSuccess(
            new Handler<PreparedStatement>(){
                @Override 
                public void handle (PreparedStatement prepared){
                    PreparedQuery<RowSet<Row>> queries  = prepared.query() ; 
                    Tuple tuples  =  Utilities.convertBook(source ) ; 
                    queries.execute(tuples).onComplete(new Handler<AsyncResult<RowSet<Row>>>(){
                        @Override 
                        public void handle(AsyncResult<RowSet<Row>> asyncs){
                            if(asyncs.succeeded( )){
                                RowSet<Row> rows = asyncs.result ( ) ; 
                            }
                        }
                    }) ;
                }
            }
        )  ; 
    }   
    /*Utilities.LogEntry(voltage.encodePrettily( ))  ; 
        String leads =  brilliant.getSelfId() ; 
           long lines= Long.parseLong("56567") ;  
           ,long[] buffer          buffer[0]= lines  ;   */  
    public Future<String> insertBook2(Book brilliant){
        JsonObject  voltage =   Utilities.serialiseBook (brilliant) ; 
        Promise<String> promises = Promise.promise( ) ; 
        client.insert(collection,voltage,    
        new Handler<AsyncResult<String>>(){
             @Override 
             public void  handle (AsyncResult<String> async){
                if( async.succeeded()){
                    String  yield = async.result( ) ;
                 JsonObject changes =  new JsonObject().put("$set",new JsonObject().put("SelfId",yield))  ;  
                JsonObject  jsons = new JsonObject().put("_id",yield) ;  
              //  System.out.println("dtfuyghoiryugiojftuygiojpfgyuoijp  gipfygiojyguiojyguij") ; 
                client.updateCollection(collection,jsons,changes).onSuccess(
                    new Handler<MongoClientUpdateResult>( ){
                        @Override 
                        public void  handle(MongoClientUpdateResult mongo){
                            promises.complete(yield) ;   
                        System.out.println(yield) ;  }  }   ).onFailure( 
                            new Handler<Throwable>(){
                                @Override 
                                public void handle (Throwable theory){
                                    Utilities.DefaultHandler(theory) ; 
                                }
                            }
        );     }else{
                    Throwable casual = async.cause()  ;  
                    Utilities.LogEntry("Insertion Unsuccessful")  ;
                    Utilities.DefaultHandler( casual)  ; promises.fail(casual) ;
                }
               //     return lines ; 
               // }else{return  -2.0l  ; }   
               //  Utilities.LogEntry(yield) ;// Utilities.LogEntry("Insertion Successful" ) ;
             }
        }) ;   
        return   promises.future() ; //leads ; 
    }    
    /*  new Thread(){
            @Override 
            public void run(){
                long current = System.nanoTime() ; 
                while(System.nanoTime( )-current<1000*1000){}  
         //   promises.complete(400l) ;
            }
        }.start() ;   */
    //  JsonObject.of("MainId",(Object)
    //Long.valueOf(mainId)) ;  boolean 
    // ,JsonObject[] stores,boolean[] arrays  // Long.valueOf(mainId)   
    /*           //  return true  ; 
               // }else{return false  ; } */
    public Future<JsonObject> updateBookById2(String mainId,Book presets){ 
        JsonObject  theory = new JsonObject() ;   
        theory =  new JsonObject().put("SelfId",mainId) ;  //JsonObject.of("MainId",(Object)Long.valueOf(mainId)) ; 
         JsonObject  alternate =  Utilities.serialiseBook(presets) ;   
         JsonObject outer = new JsonObject().put("$set",alternate) ;  
         Promise<JsonObject>  possible =  Promise.promise() ; 
        client.updateCollection(collection,theory,outer,
        new Handler<AsyncResult<MongoClientUpdateResult>>(){
            @Override 
            public void handle(AsyncResult<MongoClientUpdateResult> syncs){
                if(syncs.succeeded()){
                    MongoClientUpdateResult cores = syncs.result() ;
                    JsonObject  forms = cores.toJson () ;  
                     possible.complete(forms) ; 
              }else{
                possible.fail(syncs.cause()) ;   }   }   }) ;  
        return  possible.future()  ;  
    }   
    /*  arrays[0] = true ; 
            stores[0] =   forms  ;  */
    // long mainId,
    //        JsonObject jsons =  braces.get(vr) ;    
    // JsonObject verse = JsonObject.of ("Genre",(Object)genre) ;  
    // "Genre",(Object)genre 
    //List<Book>    // List<Book> stores,  //   List<Book> serial = new ArrayList<Book>() ; 
    public Future<List<Book>> findBookByGenre2 (String genre){
        JsonObject verse =  new  JsonObject().put("Genre",genre) ; 
        Future<List<JsonObject>> ahead= client.find(collection,verse)  ;  
        Promise<List<Book>> account = Promise.promise() ; 
        ahead.onComplete(new Handler<AsyncResult<List<JsonObject>>>(){
            @Override 
            public void handle(AsyncResult<List<JsonObject>> determine){
                if(!determine.succeeded()){
               //     return serial ;   
               account.fail(determine.cause()) ;   
                 }
                else{List<JsonObject> braces = determine.result() ;
                 account.complete(collectBooks(braces)) ; 
            }
            }   
        }) ;  
        return account.future() ;   //  return serial ;  
     }     
      //    booking[0]   =   collectBooks( braces) ; 
       //Utilities.deserialiseBook(braces) ;  //return serial ; 
     // ,List<Book>[] booking
     /*
      * for(int vr=0;vr<braces.size();vr++){
                   Book versions =  Utilities.deserialiseBook(braces.get(vr)) ;
                    serial.add(versions) ; 
                } booking[0] =serial  ;
     */
     public List<Book> collectBooks(List<JsonObject> serial) {
        List<Book> kinds = new ArrayList<Book>( ) ;
        int shift = serial.size( ) ;
        for(int fr=shift-1;fr>=0;fr--){
            JsonObject jsons  = serial.get(fr) ; 
            Book booking = Utilities.deserialiseBook(jsons) ; 
            kinds.add(0,booking) ; 
        }  
        return kinds ; 
     }
     // Book  // ,List<Book>[] point  //   point[0] = holders ; 
    public Future<List<Book>>  findBookByName2(String title) {
         JsonObject query =  new JsonObject() ;
        query.put(new String("Title"),title) ; 
        Future<List<JsonObject>> futures =  client.find(collection,query) ;  
        Promise<List<Book>> premise =  Promise.promise() ; 
        futures.onSuccess(
            new Handler<List<JsonObject>>(){
                @Override 
                public void handle(List<JsonObject> listed){
                    List<Book> holders = collectBooks( listed) ; 
                    premise.complete(holders) ; 
                }  }   ) ; 
        futures.onFailure(new Handler<Throwable>(){
            @Override 
            public void  handle(Throwable boomerang ){
                premise.fail(boomerang) ;
            }
        } ) ;  
        return premise.future() ;  }  
                /*  client.delete(collection,query,
        new Handler<AsyncResult<MongoClientUpdateResult>>(){ */
        // ,JsonObject[] stores,boolean[ ] cases  //          cases[0] = true ;
    public Future<JsonObject> deleteBookById2(String MainId) {
        JsonObject query = new JsonObject().put("SelfId",MainId) ;   
        Promise<JsonObject> fortune = Promise.promise() ; 
        client.removeDocument(collection,query,
        new Handler<AsyncResult<MongoClientDeleteResult>>(){
            @Override 
            public void handle(AsyncResult<MongoClientDeleteResult> updated){
                if(updated.succeeded()){ 
                    MongoClientDeleteResult results=  updated.result() ;  
                     JsonObject virtual =  results.toJson () ;    
                    fortune.complete(virtual) ;
                }else{ 
                    Throwable frisbee = updated.cause()  ;
                    fortune.fail (frisbee) ;
                }
            }
        }) ;  
        return  fortune.future() ; 
    }   
    // public Future<JsonObject> deleteBook2(long MainId) {
   // JsonObject[]  aside   // ,Book[]  aside
    //  new  Handler<AsyncResult<List<>>> // JsonObject jsons  
    ///   aside[0] = listed.get(0)  ;   //long   // Long.valueOf(identity)
public Future<Book> findBookById2(String identity){
    JsonObject jsons = new JsonObject().put("SelfId", identity) ; 
    Future<List<JsonObject>> plans =  client.find(collection,jsons) ;   
    Promise<Book> study =  Promise.promise() ;
    plans.onSuccess(   
        new  Handler<List<JsonObject>>(){
            @Override 
            public void handle(List<JsonObject> items){
                List<Book> listed =  collectBooks(items) ;  
                 study.complete(listed.get(0)) ;
                 }    }  
                   ) ;    
        plans.onFailure(
            new Handler<Throwable>(){
                @Override 
                public void handle(Throwable verses){
                    study.fail(verses) ; 
                }  }  ) ;
        return study.future() ; 
          }   
        public Future<List<Book>> findAll( ){
            JsonObject  emplaced = new JsonObject()  ; 
            Promise<List<Book>> promises = Promise.promise() ;
           Handler<AsyncResult<List<JsonObject>>> handles = new Handler<AsyncResult<List<JsonObject>>>(){
                @Override 
                public void handle(AsyncResult<List<JsonObject>> fronts){
                    if(fronts.succeeded()){
                        List<JsonObject> listed =   fronts.result( )  ;   
                        BaseVerticle.outer.println(listed.toString( ))  ;  
                        List<Book>  mixed  = collectBooks( listed) ;   
                     promises.complete(mixed) ; 
                    }else{
                        promises.fail(fronts.cause())  ;     }   }    } ;  
        client.find(collection, emplaced,handles) ; 
         return    promises.future() ;     }     
         // new JsonObject().put("$set",objects) ;   // Author edits  
         // new JsonObject().put("FirstName",titles)  ;   //  Utilities.serialiseAuthor(edits) ; 
        public Future<JsonObject> updateBookByName2(String titles,Book edits) {
            JsonObject objects = Utilities.serialiseBook(edits) ;   
            JsonObject changes =   new JsonObject().put("$set",objects ) ;
            JsonObject initial =  new JsonObject().put("Title",titles)  ;  
            Promise<JsonObject> promises = Promise.promise() ;
            client.updateCollection(collection,initial,changes, 
            new Handler<AsyncResult<MongoClientUpdateResult>>( ) { 
                    @Override 
                    public void handle(AsyncResult<MongoClientUpdateResult> determine) { 
                        if(!determine.succeeded()){  promises.fail(determine.cause( )) ;  } 
                        else{ promises.complete(determine.result( ).toJson())  ;  }
                    }
                })  ;  
                return   promises.future( )   ;
        }
      }
    /**
     *     public  Tuple  toTuple(Book source ){
       /*  Tuple starts = Tuple.tuple() ; 
        starts.addLong(source.identity) ;
        start.addString( source.title) ; 
      //   start.addValue(source) ;
        start.addString(source.genre) ; 
        return starts ;  */
  //  }  
     //*/
