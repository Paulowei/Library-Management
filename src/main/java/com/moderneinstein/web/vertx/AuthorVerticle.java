package com.moderneinstein.web.vertx ;


import io.vertx.ext.web.Router  ;
import io.vertx.ext.web.RoutingContext ;
import io.vertx.ext.web.Route ;

import  io.vertx.core.AbstractVerticle ;
import io.vertx.core.Vertx ;
import io.vertx.core.AsyncResult ;
import io.vertx.core.Handler ;
import io.vertx.core.Future ;


import io.vertx.core.http.HttpServer ;
import io.vertx.core.buffer.Buffer ;
import io.vertx.core.http.HttpServerOptions  ;

import io.vertx.core.http.HttpMethod ;
import io.vertx.core.http.HttpServerRequest ;
import io.vertx.core.http.HttpServerResponse ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.json.JsonArray ;

import com.moderneinstein.web.vertx.Author ;
import com. moderneinstein.web.vertx.Book ;
import  com.moderneinstein.web.vertx.AuthorServices ;


import  io.vertx.sqlclient.SqlConnection ;
import io.vertx.jdbcclient.JDBCPool  ;
import  io.vertx.sqlclient.Pool ;
import io.vertx.ext.mongo.MongoClient ;

 import java.util.Set ;
 import java.util.List ;
 import java.util.ArrayList ;
 import java.util.Arrays ;
 import java.util.Map ;
 import  java.util.TreeMap ;

public class AuthorVerticle extends AbstractVerticle  {


    public HttpServer server ;
    public   Router router  ;
    private  AuthorServices services ;
    private  static String host =  new String("http://localhost") ;
    private  static int  port =  8060 ;
    public  static String[] routes =  new  String[]{}  ;

    public static int  NOT_FOUND = 404  ;
    public static int  DECLINED = 500 ;
    public static int   ACCEPTED = 200 ;
   public static String[] replies =  new String[] {"This request was not successful","This request was successful"}  ;
    public  HttpServerOptions  createOptions(){
        HttpServerOptions options = new HttpServerOptions() ;
        options.setPort(port)  ;
        options.setUseAlpn(true) ;
        options.setHost(host)  ;
        return  options ;
    }
 /**                    HttpServerRequest requests = context.request( ) ;
                    HttpServerResponse response =  context.response( ) ;   */
        //       long ideal = Long.parseLong(context.pathParam("id")) ;
    /* JsonObject[] arena = new JsonObject[3] ;
      boolean[] cases  =  new boolean[4] ; */  /// ,arena,cases
    public void serveRoutes4( ) {
        Route voltage = router.route( ) ;
        voltage.method(HttpMethod.POST) ;
        voltage.path("/library/authors/update/identity/:id") ;
        voltage.handler(
            new Handler<RoutingContext>(){
                @Override
                public void handle(RoutingContext context){
                    String ideal =   context.pathParam("id") ;
                    Future<Buffer> ahead = context.request().body( )  ;
                    ahead.onSuccess(
                        new Handler<Buffer>(){
                            @Override
                            public void handle(Buffer holder) {
                                JsonObject jsons = holder.toJsonObject() ;
                                Author authors = Utilities.deserialiseAuthor(jsons) ;
                               Future<JsonObject> spheres =  services.updateAuthorById2( ideal,authors) ;
                               spheres.onSuccess(
                                new Handler<JsonObject>(){
                                    @Override
                                    public void handle (JsonObject after){
                                        jsons.put("Response",after) ;
                                      //  Utilities.writeResponse(context.response(),after.encode(),200,false,true) ;  
                                      Utilities.resolve(context.response( ),replies[1],after,ACCEPTED,true,true,true) ;
                                    }  }   ) ;
                              spheres.onFailure(
                                new Handler<Throwable>(){
                                    @Override
                                    public void handle(Throwable express){
                                     //   Utilities.writeResponse(context.response(),express.toString(),200,false,true) ;  
                                        Utilities.resolve(context.response(), express.toString (),new JsonObject(), ACCEPTED,true,true,false ) ; 
                                    }
                                }  ) ;   }   }  )  ;
                    }
                }
        ) ;
    }
    /*  if (cases[0]==true){
                      Utilities.writeResponse(context.response( ),arena[0].encode( ),200,true,true) ;   } */
    /*  JsonObject[] arena = new JsonObject[3] ;
                                boolean[] cases  =  new boolean[4] ; */
    public void linkServices() {
       // JsonObject
    //   SqlConnection connected = ConnectionSource.connection(vertx) ;
        MongoClient clients =  ConnectionSource.MongoClient(vertx) ;
       // services = new AuthorServices(vertx,connected)  ;
       Utilities.LogEntry(clients.toString()) ;
        services = new  AuthorServices(vertx,clients ) ;
    }

    public void placeRoutes(){
        new Thread(){
            @Override
            public void run(){
        serveRoutes1( ) ;
        serveRoutes2 () ;
        serveRoutes3( ) ;
        serveRoutes4() ;
        serveRoutes5() ;
        serveRoutes6() ; 
        serveRoutes7( ) ; 
        serveRoutes8( )  ;
        serveRoutes9()  ;  }}.start() ;
    }

    public void configure(){
        HttpServerOptions options =  createOptions() ;
        server = vertx.createHttpServer(options) ;
        router = Router.router(vertx) ;
       // services =  new BookServices(vertx,) ;
       // placeRoutes ()  ;
        server.exceptionHandler(
            new Handler<Throwable>(){
                @Override
                public void handle(Throwable thrown){
                    String notice = thrown.toString() ;
                    Utilities.LogEntry(notice) ;
                }
            }
        ) ;
        server.requestHandler(router) ;
    }
    public static JsonArray collectAuthors(List<Author>  brace){
        JsonArray linear = new JsonArray() ;
        for (int nt=0;nt<brace.size();nt++){
            Author auths =  brace.get(nt) ;
            JsonObject objects = Utilities.serialiseAuthor(auths) ;
            linear.add(objects) ;
        }
        return linear ;
    }
    //    services.findAuthorByFirstName2(firstName,holders) ;
    /*   if(holders[0]!=null){
                        JsonArray arrays =  collectAuthors(holders[0]) ;
                        Utilities.writeResponse(routectx.response(),arrays.encode(),200,true,true) ;
                    }*/
     public void serveRoutes3( ){
        Route reach = router.route() ;
        reach.path(new String("/library/authors/find/firstname/:title")) ;
        reach.method(HttpMethod.GET)  ;
        reach.handler(
            new Handler<RoutingContext>( ){
                @Override
                public void handle(RoutingContext routectx){
                    String firstName =  routectx.pathParams().get("title") ;
                 //   Long lines = Long.parseLong(firstName) ;
                    List<Author>[]  holders = new List[2] ;
                     Future<List<Author>>  fronts = services.findAuthorByFirstName2(firstName ) ;
                  fronts.onComplete(
                    new Handler<AsyncResult<List<Author>>>(){
                        @Override
                        public void handle(AsyncResult<List<Author>> listed){
                            if(listed.succeeded()){
                             JsonArray  composite =  collectAuthors(listed.result ()) ;
                           Utilities.resolve(routectx.response(),replies[1],composite,ACCEPTED,true,true,true)   ;
                            }else{
                                String patterns = listed.cause().toString( )  ;
                              Utilities.resolve(routectx.response(), patterns,  new JsonObject(),ACCEPTED,true,false,false ) ;
                            }
                        } } ) ;
                    }}) ;
                }
           // }
      //   ) ;
    // }       //    Utilities.writeResponse(routectx.response(),new String(""),NOT_FOUND,false,true) ;
     /*     long params = Long.parseLong(context.pathParam(":id")) ;
                    boolean lanes[]  =new boolean[4] ;
                    JsonObject[] access = new JsonObject[3] ; */
              //      ,JsonObject[] returns ,boolean[] notice  //  }  //  if( lanes[0]==true){
                //  if( lanes[0]==true){  // else{
                    //   Utilities.writeResponse(context.response(),jsons.encodePrettily(),200,true,true) ;
     public void serveRoutes2( ) {
        Route  roads = router.route( ) ;
        roads.path(new String("/library/authors/delete/identity/:id"))  ;
        roads.method(HttpMethod.DELETE) ;
        roads.handler(
            new Handler<RoutingContext>( ){
                @Override
                public  void  handle(RoutingContext context){
                   Map<String,String> lines  =  context.pathParams() ;
                   String params =  lines.get(new String("id")) ;
                    Future<JsonObject>  subscribe =  services.deleteAuthorById2(params) ;
                    subscribe.onSuccess(
                        new Handler<JsonObject>(){
                            @Override
                            public void handle(JsonObject jsons){
                            Utilities.resolve(context.response( ),replies[1],jsons,ACCEPTED,true,true,true)  ;
                }}) ;
                 subscribe.onFailure(
                    new Handler<Throwable>(){
                        @Override
                        public void handle(Throwable thrown){
                        Utilities.resolve(context.response(),thrown.toString(),new JsonObject(),ACCEPTED,true,true,false)  ;
                }
            }
        ) ;
     } }      ) ; }
     //  Utilities.writeResponse(context.response(),new String(""),404,false,false) ; } } ) ;
     //  services.deleteAuthor2(params,access,lanes) ;
     /*     boolean lanes[]  =new boolean[4] ;
                    JsonObject[] access = new JsonObject[3] ; */
     //     Future<JsonObject> needs = services.insertAuthor2(current,indicator) ;
     //              long[]  indicator = new long[]{-4l,-3l}  ;   ,indicator
     //       if(indicator[0]!=-4l){     }   // }  }   // String patterns =  String.valueOf(indicator[0]) ;
       //   Utilities.writeResponse(frames.response(),means.cause().toString(),DECLINED,true,true) ;
    public void serveRoutes1() {
        Route paths  = router.route() ;
        paths.method(HttpMethod.PUT) ;
        paths.path("/library/authors/insert") ;
        paths.handler(
            new Handler<RoutingContext>(){
                @Override
                public void handle(RoutingContext frames){
                     HttpServerRequest needs =   frames.request() ;
                     needs.body(
                        new Handler<AsyncResult<Buffer>>(){
                            @Override
                            public void handle(AsyncResult<Buffer> yield){
                                if(yield.succeeded()){
                                JsonObject resource = yield.result().toJsonObject() ;
                                Author current = Utilities.deserialiseAuthor(resource) ;
                                Future<String> needs = services.insertAuthor2(current) ;
                                needs.onComplete(
                                    new Handler<AsyncResult<String>>(){
                                        @Override
                                        public void handle(AsyncResult<String> means){
                                    if(means.succeeded()){
                                  resource.put("SelfId",means.result()) ;
                                   Utilities.resolve (frames.response(),replies[1],resource,ACCEPTED,true,true,true) ;
                          } else {   Utilities.resolve (frames.response(),means.cause( ).toString( ),new JsonObject( ),ACCEPTED,true,true,false) ;
                            Utilities.DefaultHandler(means.cause()) ;    } }} ) ;
                            } }
                        }
                     ) ;
                } }   ) ; }
          //  }
    //    ) ;    //    Utilities.writeResponse(frames.response(),resource.encode(),ACCEPTED,true,true) ;
  //  }  
      //  ,JsonObject[] returns ,boolean[] notice   // ,patterns,
      //     Author[]  trays = new Author[]{null,null,null} ;
      //           if(trays[0]!=null){            }
      // trays[0]
      /*<select name ="trials">
      <option value =  ""> </option>
      <option value = ""> </option>
      <option value = ""> </option>
      </select>   */
     public void serveRoutes5(){
        Route voltage = router.route() ;
        voltage.method(HttpMethod.GET) ;
        voltage.path("/library/authors/find/identity/:digit") ;
        voltage.handler(
            new Handler<RoutingContext>() {
                @Override
                public void handle(RoutingContext current){
                    String gains =  current.pathParams().get("digit") ;
                 ///   long lanes = Long.parseLong(gains)  ;
                    Future<Author> inFront =  services.findAuthorById2(gains) ;
                    inFront.onSuccess(
                    new Handler<Author>(){
                        @Override
                        public void handle(Author frames){
                    String patterns= Utilities.serialiseAuthor(frames).encodePrettily() ;   JsonObject justify = Utilities.serialiseAuthor(frames) ;
                     Utilities.resolve( current.response(), replies[ 1], justify,ACCEPTED,true,true,true ) ;
                        }  }
                    ) ;
                inFront.onFailure(
                    new Handler<Throwable>() {
                        @Override
                        public void handle(Throwable thrown ){
                    Utilities.DefaultHandler(  thrown  ) ;
                    Utilities.resolve(current.response(),thrown.toString(),new JsonObject(),NOT_FOUND,true,true,false) ;
                }
            }
        ) ;  }  }  ) ;
     }
     //  Utilities.writeResponse(current.response(),patterns,ACCEPTED,true,true) ;   }  } ) ;
     //   Utilities.writeResponse(current.response(),thrown.toString(),NOT_FOUND,true,true) ; } } ) ;
     public void serveRoutes6(){
        Route lines  = router.route( ) ;
        lines.method( HttpMethod.GET) ;
        lines. path(new String("/library/authors/find/all")) ;
        lines.handler( new Handler<RoutingContext>( ){
            @Override
            public void handle(RoutingContext   realms) {
                 Future<List<Author>> unravel = services.findAll();
                 unravel.onComplete(
                    new Handler<AsyncResult<List<Author>>>(){
                        @Override
                        public void  handle(AsyncResult<List<Author>> determine) {
                            if(!determine.succeeded( )){
                                String plots =  determine.cause( ).toString() ;
                                Utilities.resolve(realms.response(),plots,new JsonObject(),ACCEPTED,true,false,false) ;  }
                            if( determine.succeeded( )){
                                JsonArray queries = collectAuthors(determine.result()) ;
                                Utilities .resolve(realms.response(),replies[1],queries,ACCEPTED,true ,true,true) ;
                            }
                        }
                    }
                 );
            }
        }
        ) ;
     }
     //    services.findAuthorByFirstName2(firstName,holders) 
     //  ;  // syncs  //  context.response().body(   // context.request()
    public void serveRoutes7() { 
         Route  route = router.route( ) ; 
        route.method(HttpMethod.POST); 
        route.path("/library/authors/update/firstname/:clone") ;   
        route.handler( 
            new Handler<RoutingContext>( ){
                @Override 
                public void  handle( RoutingContext context){
                    String kinds = context.pathParam("clone") ; 
                    context.request().body( 
                         new Handler<AsyncResult<Buffer>>(){
                            @Override 
                            public void handle( AsyncResult<Buffer> permit ){
                                if(!permit.failed( )){
                                    JsonObject jsons =  permit.result().toJsonObject() ;   
                                    Author writer = Utilities.deserialiseAuthor (jsons) ;  
                                    Future<JsonObject> claims = services.updateAuthorByFirstName(kinds,writer) ;  
                                     claims.onSuccess( new Handler<JsonObject>( ){ 
                                        @Override 
                                        public void handle(JsonObject  objects){
                                            Utilities.resolve(context.response(),replies[1],objects,ACCEPTED,true,true,true) ;
                                        }
                                     }) ;  
                                     claims.onFailure(new Handler<Throwable>(){
                                        @Override 
                                        public void handle(Throwable  thresh){
                                            Utilities.resolve (context.response( ),thresh.toString(),new JsonObject(),ACCEPTED,true,true,false) ;  
                                         }
                                     })   ; 
 ;                                }
                            }
                         }
                    ) ; 
                }
            }
        ) ;
    }  
    public void serveRoutes8 ( ){
        Route leads =  router.route( ) ; 
        leads.method(HttpMethod.GET) ;  
        leads.path("/library/authors/find/lastname/:data") ; 
         leads.handler (
            new Handler<RoutingContext>( ){
                @Override 
                public void handle(RoutingContext  domain){
                    String alias = domain.pathParams().get("data") ; 
                     Future<List<Author>> points = services.findAuthorByLastName(alias) ; 
                    points.onSuccess( 
                        new Handler<List<Author>>( ){
                            @Override 
                            public void handle(List<Author> listed){
                                JsonArray serial = collectAuthors(listed) ; 
                                 Utilities.resolve(domain.response(),replies[1],serial, ACCEPTED,true,true,true) ;
                            }   }  ) ; 
                    points.onFailure(
                        new Handler<Throwable>( ){
                            @Override 
                            public void handle(Throwable thrown) {
                                Utilities.resolve( domain.response(),thrown.toString( ),new JsonObject() ,ACCEPTED,true,true,false )  ;
                            }
                        }
                    ) ; 
                }
            }
          ) ;
    }  
    public  void serveRoutes9(){
            Route lanes = router.route( ) ;
            lanes.method(HttpMethod.POST) ; 
            lanes.path( "/library/authors/update/lastname/:sample") ; 
            lanes.handler( 
                new Handler<RoutingContext>(){
                @Override 
                 public void handle( RoutingContext range){
                    String patterns = range.pathParam("sample") ;
                    range.request().body( ).onSuccess (
                        new Handler<Buffer>( ){
                            @Override 
                            public void handle( Buffer bytes){
                                Author coded  =   Utilities.deserialiseAuthor(bytes.toJsonObject())  ;  // JsonObject coded =   bytes.toJsonObject() ; 
                                Future<JsonObject> plans =  services.updateAuthorByLastName(patterns,coded) ; 
                                plans.onComplete(
                                    new Handler<AsyncResult<JsonObject>>( ){
                                        @Override 
                                        public void handle(AsyncResult<JsonObject> possible){
                                            if(possible.failed()){ 
                                                Utilities.resolve(range.response( ),possible.cause( ).toString(),new JsonObject(), ACCEPTED,true,true,false) ;
                                            }else{
                                                Utilities.resolve(range.response( ),replies[1],possible.result(),ACCEPTED,true ,true,true  )  ; 
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
    public void initiate(){
        server.exceptionHandler( Utilities::DefaultHandler) ; 
        server.listen( port,
        new Handler<AsyncResult<HttpServer>>(){
            @Override 
            public void handle(AsyncResult<HttpServer>  confirms){
                if( confirms.succeeded( )){
                     Utilities.LogEntry( confirms.result().toString()) ;
                }
            }   
        }) ;
    }
    @Override
    public void start(){
        vertx = Vertx.vertx() ;
     //   SqlConnection connections  =   ConnectionSource.connection(vertx) ;
     //   services = new  AuthorServices(connections) ;
     linkServices() ;
        configure( ) ;
        placeRoutes() ;   
        initiate() ; 
    }
}
