package com.moderneinstein.web.vertx;


import io.vertx.core.Handler  ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.json.JsonArray ;
import io.vertx.ext.web.RoutingContext ;
//import io.vertx.ext.web.BodyHandler ;
import io.vertx.core.http.HttpServer ;
import io.vertx.core.http.HttpMethod ;
import io.vertx.core.http.HttpServerRequest ;
import io.vertx.core.http.HttpServerResponse ;
 // import io.vertx.core.http


import com.moderneinstein.web.vertx.BookServices  ;
import com.moderneinstein.web.vertx.Book ;

import  io.vertx.core.AbstractVerticle ;
import io.vertx.core.Vertx  ;
import io.vertx.core.AsyncResult ;
import io.vertx.ext.web.Router ;
import io.vertx.core.http.HttpServerOptions ;

import io.vertx.ext.web.Route ;
import io.vertx.core.buffer.Buffer ;
import io.vertx.core.Future ;
import io.vertx.ext.mongo.MongoClient ;

import   io.vertx.jdbcclient.JDBCPool ;
import io.vertx.jdbcclient.JDBCConnectOptions ;
import   io.vertx.sqlclient.SqlClient ;
import  io.vertx.sqlclient.SqlConnection ;

import java.util.List ;
import java.util.ArrayList ;
import java.util.Set ;
import java.util.Arrays ;
import java.util.Queue  ;

public class BookVerticle extends  AbstractVerticle {

    private BookServices services ;
    private HttpServer  server  ;
    private   Router router ;
    public static String routes[] = new String[]{} ;
    public  static  Integer ports = 8040 ;
    public static String  hosts = new String("localhost") ;
    public  static boolean states  = true  ;
    public static int ACCEPTED = 200 ;
    public static int DECLINED = 500 ;
    public static int NOT_FOUND = 404 ;
    public static String[] messages = new String[ ]{"This request was not successful" ,"This request was successful"} ;
    public HttpServerOptions  synthensiseOptions(){
        HttpServerOptions options = new HttpServerOptions() ;
      //  options.setUseAlpn (states) ;
        options.setPort(ports) ;
        options.setHost(hosts) ;
        return options ;
    }

    public  void initialise(){
        server = vertx.createHttpServer(synthensiseOptions()) ;
        router =   Router.router(vertx) ;
        server.exceptionHandler(Utilities::DefaultHandler) ;
         server.requestHandler (router) ;
    }
    public void appendRoutes(){
        new Thread( ){
        @Override
        public void run(){
        serveRoutes5()  ;
        serveRoutes4() ;
        serveRoutes3( ) ;
        serveRoutes2() ;
        serveRoutes1()  ;
        serveRoutes7() ;  
        serveRoutes8( ) ; 
        serveRoutes6( ) ;  } }.start() ;
    }
    // // List<JsonObject>[] buffers = new List<>[2] ; //List<JsonObject>[2] ;
    //services.findBookByName(params, buffers)  ;  //context.getParam(":id")) ;
    //if(verses!=null){  // =buffers[0].encode() ;  //    if(buffers[0]!=null){
        ///  services.findBookById2(params,buffers) ;
        //    long params =Long.valueOf(context.pathParam(":id") ) ;
    public void serveRoutes1(){
         Route route1 = router.route() ;
        route1.method(HttpMethod.GET)  ;
        route1.path("/library/books/find/identity/:id")  ;  //("/authors/:id")  ;
        route1.handler(
            new Handler<RoutingContext>(){
                @Override
                public void handle(RoutingContext context){
                    HttpServerRequest requests = context.request() ;
                    String params =   context.pathParam("id")  ;
                      Book[] buffers = new Book[2] ;
                     Future<Book> times = services.findBookById2(params) ;
                     times.onComplete(
                        new Handler<AsyncResult<Book>>(){
                            @Override
                            public void handle(AsyncResult<Book> attempt){
                            if(attempt.succeeded()){
                    String  verses = Utilities.serialiseBook(attempt.result()).encode() ; JsonObject points = Utilities.serialiseBook(attempt.result()) ;
                   Utilities.resolve( context.response( ) ,messages[1],points,ACCEPTED,true,true,true) ; }else{
                    String saves =   attempt.cause().toString() ;
                       Utilities.resolve(context.response(),saves,new JsonObject(),NOT_FOUND,true,true,true) ; }
                }
                //   context.response().end() ;  //,new String("")
                }  ) ;
            } }
        ) ;
    }
       // String  verses = Utilities.serialiseBook(buffers[0]).encode() ;
      /* context().response( ).setStatusCode(200) ;
                    context.response().setChunked(true) ;
                    context.response().write(verses) ; */
   // public void setRoutes2
    public static JsonArray receive(List<Book> books ){
         int width = books.size()  ;
        JsonArray arrays = new JsonArray()  ;
        for(int vs=0;vs<width;vs++){
            Book parts = books.get( vs) ;
            JsonObject versions = Utilities.serialiseBook(parts) ;
            arrays.add(versions)  ;
        }
       /// receive(books )  ;
         return arrays ;
    }
  //   if(buffers[0]!=null){    }  // JsonArray arrays = receive(buffers[0]);
   public void serveRoutes2() {
    Route route2 =  router.route ()  ;
    route2.method(HttpMethod.GET)  ;
    route2.path("/library/books/find/title/:portion")  ;
     route2.handler(
        new Handler<RoutingContext>(){
            @Override
            public void handle(RoutingContext context){
                HttpServerResponse response = context.response() ;
                String title = context.pathParam("portion") ;
             //   List<Book>[] buffers = new List[2]  ;
                Future<List<Book>> passes = services.findBookByName2(title) ;
            passes.onFailure (new
            Handler<Throwable>(){
                @Override
                public void handle (Throwable thrown ){
              Utilities.resolve(context.response(),thrown.toString(), new JsonObject(),NOT_FOUND,true,true,false) ;
                } })  ;
             passes.onSuccess(
                new Handler<List<Book>>( ){
                    @Override
                    public  void handle(List<Book> samples){
                    JsonArray arrays = receive(samples);
                    Utilities.resolve(response,messages[1],arrays,ACCEPTED,true,true,true) ;
                }  } ) ;
        }  }
     ) ;
    }

    //        long[]  temps = new long[]{-1l  } ;
    /*
            HttpServerRequest requests = context.request() ;
                    HttpServerResponse response =  context.response( )  ;  */
                /* if(temps[0]!=-1l){
                                    JsonObject sent = new JsonObject().put("Identity",temps[0]) ;
                                      Utilities.writeResponse(response,sent.encode(),200,true,true);
                                }else{
                                    Utilities.writeResponse(response,"",200,true,true) ;
                                }  */


    public void   serveRoutes3(){
        Route route3 =  router.route( )  ;
        route3.method(HttpMethod.PUT) ;
        route3.path("/library/books/insert") ; 
        //route3.consumes("application/json") ;
        route3.handler(
            new Handler<RoutingContext> (){
                @Override
                public void handle(RoutingContext context){
                    Future<Buffer> plans  =  context.request().body() ;
                    plans.onSuccess(
                       new Handler<Buffer>(){
                            @Override
                            public void handle(Buffer collect){ 
                                System.out.println(collect.toString( )) ; 
                                   JsonObject voltage = collect.toJsonObject() ;
                                Book equivs = Utilities.deserialiseBook(voltage) ;
                                Future<String> foward =  services.insertBook2(equivs)  ;
                                foward.onComplete(
                                    new Handler<AsyncResult<String>>(){
                                        @Override
                                        public void handle(AsyncResult<String> frames){
                                            if(frames.succeeded()){
                                                String notes = frames.result() ;
                                                voltage.put("SelfId",notes) ;
                                                Utilities.resolve(context.response(),messages[1],voltage,ACCEPTED,true,true,true) ;
                                            }else{   //new String()  ;
                                                Utilities.DefaultHandler(frames.cause()) ;
                                                Utilities.resolve(context.response(),frames.cause().toString(),new JsonObject(),DECLINED,true,true,false) ;
                                            }
                                        }
                                    }
                                ) ;
                        }
                    }
                    ) ;
                }
            }
        ) ;
    }
    /*       JsonObject jsons = collect.toJsonObject() ;
                                 Book books = Utilities.deserialiseBook(jsons) ;
                                long[] holder = new long[]{-4l} ;
                                services.insertBook2(books,holder) ;
                                if( holder[0]!=-1l){
                                }else{
                                } */
    /*    HttpServerRequest request = context.request() ;
                    HttpServerResponse response = context.response()  ;
                     JsonObject[]  styles = new JsonObject[3] ; boolean[]  truce = new boolean[2] ;
                     ,styles,truce   Long leads =  Long.parseLong(context.pathParam(":id")) ; */
                    // "/library/books/update/default/:id"
    public void serveRoutes4(){
        Route route4 = router.route() ;
        route4.method(HttpMethod.POST)  ;
         route4.path("/library/books/update/identity/:id") ;
        route4.handler(
            new Handler<RoutingContext> (){
                @Override
                public void handle(RoutingContext context){
                    String leads =  context.pathParam("id") ;
                    context.request().body(
                        new Handler<AsyncResult<Buffer>>(){
                            @Override
                            public void handle(AsyncResult<Buffer> async){
                                if(async.succeeded()){
                                    Buffer buffs= async.result () ;
                                    JsonObject objects = buffs.toJsonObject() ;
                                    Book  books = Utilities.deserialiseBook(objects) ;
                                    services.updateBookById2(leads,books).onSuccess(
                                        new Handler<JsonObject>(){
                                            @Override
                                            public void handle(JsonObject present){
                                      Utilities.resolve(context.response(),messages[1],present,ACCEPTED,true,true,true) ;
                                             }
                                        }
                                    ).onFailure(
                                        new Handler<Throwable>(){
                                        @Override
                                        public void  handle(Throwable thrown){
                                            Utilities.DefaultHandler(thrown) ;
                                            Utilities.resolve(context.response(),thrown.toString(),new JsonObject(),DECLINED,false,true,false) ;
                                        }
                                        }
                                    ) ;

                                } // else{writeReponse(response,patterns,200,true,true ) ; }
                            }
                        }
                    ) ;
                }
            }
        ) ;
    }
    /* if(styles[0]!=null){
                                        String patterns = styles[0].encode( ) ;
                                        Utilities.writeResponse(response,patterns,200,true,true) ;
                                    }  */
    /*  response.setChunked(true) ;
                    response.setStatusCode(200) ;
                    response.write(arrays.encode())  ;
                    response.end() ; */
                    //          List<Book>[] binders = new List[3] ;
        //   Future<List<JsonObject>> invest = services.findBookByGenre2( powers,binders) ;
    public void serveRoutes5 () {
        Route roots = router.route() ;
        roots.path (new String("/library/books/find/genre/:cores")) ;
        roots.method(HttpMethod.GET) ;
        roots.handler(
            new Handler<RoutingContext>(){
                @Override
                public void handle(RoutingContext routectx){
                    String powers =routectx.pathParams().get("cores") ;
                    Future<List<Book>> invest = services.findBookByGenre2( powers ) ;
                    invest.onComplete(
                        new  Handler<AsyncResult<List<Book>>>(){
                            @Override
                            public void handle(AsyncResult<List<Book>> align){
                                if(!align.succeeded()){
                                    Throwable trials =  align.cause() ;  Utilities.DefaultHandler(trials) ;
                                    Utilities.resolve(routectx.response(),trials.toString(),new JsonObject(),ACCEPTED,true,true, false) ;
                                  }
                                else   {
                                    JsonArray  linear =  receive(align.result()) ;
                                    Utilities.resolve(routectx.response(),messages[1],linear,ACCEPTED,true,true,true) ;
                                  }
                            }
                        }
                    ) ;
                }
            }
        ) ;
    }
    //  Utilities.resolve(agents.response(),"The request was not Successful",new JsonObject(),ACCEPTED,false,true,false) ;
    //    Utilities.writeResponse(routectx.response(),linear.encode(),ACCEPTED,true,true) ;
    //    Utilities.writeResponse(routectx.response(),new String(),NOT_FOUND,false,true) ;
    public void serveRoutes6(){
        Route patterns = router.route () ;
        patterns.method(HttpMethod.DELETE)  ;
        patterns.path("/library/books/delete/:links") ;
        patterns.handler(
            new Handler<RoutingContext>(){
                @Override
                public void handle(RoutingContext agents){
                     String  point = agents.pathParams().get("links") ;
                      Future<JsonObject> pauses =  services.deleteBookById2(point) ;
                    pauses.onSuccess(
                        new Handler<JsonObject>(){
                            @Override
                            public  void handle(JsonObject  jsons){
                                 Utilities.resolve(agents.response(),messages[1],jsons,ACCEPTED,true,true,true) ;
                            }   }  )  ;
                    pauses.onFailure(
                        new Handler<Throwable>(){
                            @Override
                            public void handle(Throwable thrown){
                                Utilities.DefaultHandler(thrown) ;
                                Utilities.resolve(agents.response(),thrown.toString(),new JsonObject(),ACCEPTED,true,true,false) ;
                            }   }   ) ;    }   } ) ;
            }  //  Utilities.writeResponse( agents.response(),thrown.toString(),DECLINED,false,true) ;
            //   Utilities.writeResponse(agents.response(),jsons.encode(),ACCEPTED,false,true) ;
       //  ) ;
   //  }
    /*  if(binders[0]!=null){
                        JsonArray streams =  receive(binders[0]) ;
                        Utilities.writeResponse(routectx.response(),streams.encode(),200,true,true);
                    } */
    // String  yield = Utilities.serialiseBook(binders[0]).encode() ;
    //                //List<JsonObject> objects =
    public void serveRoutes7() {
        Route reach = router.route() ;
        reach.path("/library/books/find/all")  ;     
        reach.method (HttpMethod.GET)  ;
        reach.handler(
            new Handler<RoutingContext>(){
                @Override
                public void handle(RoutingContext fields) {
                    Future<List<Book>> items = services.findAll() ;  
                    // fields.response().end("This is a string")  ;
                    items.onSuccess(
                        new Handler<List<Book>>(){
                            @Override
                            public void handle(List<Book> listed){
                                JsonArray sequence = receive( listed) ;  
                                System.out.println(sequence.toString()) ; 
                         Utilities.resolve ( fields.response() , messages[1],sequence,ACCEPTED,true,true, true ) ;    }    }     )  ;
                    items.onFailure(
                        new Handler<Throwable>(){
                            @Override
                             public void handle(Throwable thrown){
                                Utilities.resolve(fields.response(),thrown.toString(),new JsonObject(),ACCEPTED,true,true,false) ;   }   }     ) ;
                        }
            }
        ) ;
    }
    public  void  linkServices(){
     ///   SqlConnection connection =   ConnectionSource.connection(vertx) ;
        MongoClient client =  ConnectionSource.MongoClient(vertx) ;
       // services = new BookServices(vertx,connection) ;
        services = new BookServices( vertx,client) ;
        Utilities.LogEntry(client.toString()) ; System.out.println(55)  ;
    }  
    public   void serveRoutes8() { 
         Route notes = router.route( )  ; 
        notes.path("/library/books/update/title/:cores"); 
        notes.method(HttpMethod.POST) ; 
         notes.handler( 
             new Handler<RoutingContext>(){ 
                @Override
                public void handle(RoutingContext rounds){  
                     String given =  rounds.pathParams().get("cores") ;
                     Future<Buffer> fronts =  rounds.request().body() ;  
                     fronts.onSuccess ( 
                        new Handler<Buffer>() { 
                            @Override 
                            public void handle(Buffer study){
                                JsonObject types =  study.toJsonObject( ) ; 
                                Book  readable = Utilities.deserialiseBook(types) ;  
                                Future<JsonObject> needs = services.updateBookByName2 (given,readable) ;  
                                needs.onComplete( 
                                     new Handler<AsyncResult<JsonObject >>(){ 
                                        @Override 
                                        public void  handle(AsyncResult<JsonObject> asyncs){  
                                            if(asyncs.succeeded()){
                                            Utilities.resolve(rounds.response(),messages[1], asyncs.result(),ACCEPTED,true,true,true) ; }
                                            else{
                                                Utilities.resolve(rounds.response( ),asyncs.cause().toString( ),new JsonObject(),ACCEPTED,true,true,false) ;
                                            }
                                        }
                                     }
                                ) ;
                            }
                        }
                     );
                }
             }
         ) ; 
    }  
    public void resolve(){
        server.exceptionHandler( 
            new Handler<Throwable>(){
                @Override 
                public void handle(Throwable thrown){
                     Utilities.DefaultHandler(thrown) ;
                }
            }
        ) ; 
        server.requestHandler(router ) ; 
        server.listen(ports,
            new Handler<AsyncResult<HttpServer>>(){
                @Override 
                public void handle(AsyncResult<HttpServer> pending){
                    HttpServer serves = pending.result( ) ; 
                    Utilities.LogEntry( serves.toString( )) ; 
                //   System.out.println("ewiudhweadihowhupojwealcwhioqjd\nghicguyiwohuwoje\nduwiguyuhweiorohjr") ;
                }
            }
        ) ;
    }  
    public   void UpdateCheck(String grains,Book trials) {
        Future<JsonObject> needs  =  services.updateBookById2(grains,trials) ;
        needs.onSuccess(
            new Handler<JsonObject>  (){
                @Override
                public void handle(JsonObject  reach ){
        JsonObject fruit  = needs.result() ;
        BaseVerticle.outer.println("The match has been found ")  ;
        Utilities.LogEntry (reach.encode()) ;  }
            }
        ) ;
        needs.onFailure(
            new Handler<Throwable> (){
                @Override
                public void handle(Throwable thrown){
                    String plains = thrown.toString() ;
                    BaseVerticle.outer.println(plains) ;
                }
            }
        ) ;
    }
    @Override
    public void start(){
         vertx =  Vertx.vertx( ) ;
            initialise() ;
         linkServices () ;
        //  serveRoutes1() ;
          appendRoutes()  ;  
        resolve( ) ;   //  "543454"
       // Book trials = new Book("SkyWard","Fantasy","Brandon","Sanderson") ;  
      Book   trials = new Book("Plague", "Escapism","Micheal","Grant") ;
        long[] lines=new long[2] ;
        Future<String> plans =  services.insertBook2(trials)  ;
        plans.onComplete(
            new Handler<AsyncResult<String>>(){
            @Override
            public void handle(AsyncResult<String>  quest){
                if(quest.succeeded()){
             //   lines[1] = quest.result( )  ;  
            trials.setGenre("Fiction") ;
          //   UpdateCheck(quest.result(),trials)  ;   
      //    Utilities.LogEntry(Arrays.toString(lines)) ;
        }
             else{
            Utilities.DefaultHandler(quest.cause( ))  ;
             } }  }
        ) ;
        String grains = plans.result() ;
        Utilities.LogEntry(grains) ;
      

    }
}
