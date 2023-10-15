package com.moderneinstein.web.vertx;


import com.moderneinstein.web.vertx.Author ;
import com.moderneinstein.web.vertx.Book  ;

import java.util.Arrays ;
import  java.util.LinkedList ;
import java.util.Set ;
import  java.util.Queue ;
import java.util.Objects  ;
import java.util.List ;    
import java.util.Vector  ; 

import  io.vertx.core.json.JsonArray ;
import io.vertx.core.json.JsonObject ;
import  io.vertx.core.Handler ;
import io.vertx.core.buffer.Buffer  ;

import io.vertx.sqlclient.Tuple ;
import io.vertx.sqlclient.RowSet ;
import  io.vertx.sqlclient.Row ;

import io.vertx.core.http.HttpServerResponse ;
import io.vertx.core.http.HttpServerRequest ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.buffer.Buffer  ;

import java.util.logging.Logger  ;
import java.io.PrintStream ;


public class Utilities {

      public static Logger logger =  Logger.getLogger("Logger") ;
      public static PrintStream mains = System.out ;
    /**
     *    brace.setLastName(source.getString ("LastName")) ;
        brace.setIdentity(source.getLong("Identity"))  ;
        brace.setFirstName(source.getString("FirstName")) ;
        List<Book> listed = (List<Book>)brace.getObject("Books") ;
     */  // List<Book> linear     
     public static List<String>  expand(JsonArray input){
         int length = input.size () ; 
        List<String> patterns = new Vector<String>() ;
        for(int vt=0;vt<length;vt++){   // new String()
            String yield =  input.getString(vt)  ;   
            patterns.add(yield)  ;     }     
        return patterns  ;     
     }    
     //  (List<String>)source.getValue("Books",new Vector<String>()) ;   //(List<Book>)source.getValue("Books") ;
    public static Author deserialiseAuthor(JsonObject source) throws ClassCastException {
        List<String> linear   =  expand ((JsonArray)source.getValue("Books",new JsonArray())) ;  
      //    long great= source.getLong("SelfId") ;
        String  last = source.getString("LastName",Author.EMPTY)  ;
        String  first = source.getString("FirstName",Author.EMPTY) ;  
        String great = source.getString("SelfId",Author.EMPTY ) ;
          Author brace = new Author(first,last,great ,linear) ;
        return  brace ;
        // return null  ;
    }
    //   List<Book> linear =  (List<Book>)source.getObject("Books") ;
     /**         lanes.setId(source.getLong("Title")) ;
        lanes.setGenre(source.getString( "Genre")) ;
        lanes.setTitle(source.getString( "Title"))  ;
        lanes.setAuthorId(source.getLong("AuthorId")) ; */
    public static Book  deserialiseBook(JsonObject source){
        //String kinds =  source.getString("AuthorId") ;  //  long   //getLong("AuthorId") ;
        String beams = source.getString("Genre",Book.CLEAR) ;
        String  lanes = source.getString("Title",Book.CLEAR) ;
        String leads = source.getString("SelfId",Book.CLEAR) ;  // long //getLong("SelfId") ;  
        String  last = source.getString("AuthorLast",Book.CLEAR)  ; 
         String first = source.getString("AuthorFirst",Book.CLEAR) ;   
         Book  reader =new Book(lanes,leads,beams,first,last) ;// ,leads  //,beams,kinds) ;    
        // if(kinds==null) { BaseVerticle.outer.print( kinds ) ; }
        return  reader  ;
    }
    public static Tuple convertBook(Book  begin ){
        Tuple starts = Tuple.tuple() ;
        starts.addLong(begin.getMainId( )) ;
        starts.addString( begin.getTitle()) ;
      //   start.addValue(source) ;
        starts.addString(begin.getGenre( )) ;
        return  starts ;
    }
    public static Tuple ConvertAuthor(Author credits){
        Tuple tuples  =  Tuple.tuple() ;
        tuples= Tuple.wrap(credits.getBooks()) ;
        tuples.addLong(credits.getMainId( )) ;
        tuples.addString(credits.getFirstName()) ;
        tuples.addString(credits.getLastName())  ;
        return tuples ;
    }
    public static JsonObject  serialiseBook(Book input){
        JsonObject jsons = new JsonObject()  ;
      //  jsons.put("AuthorFirst",input.getAuthorId()) ;    // Long.toString(input.getAuthorId()) 
      if(input.getGenre()!=null&&input.getGenre().length()>0){
        jsons.put("Genre",input.getGenre()) ;  }
       // if(input.getSelfId().length()>0){
        if(input.getSelfId()!=null&&input.getSelfId().length()>0){
        jsons.put("SelfId",input.getSelfId()) ; } //  } //Long.toString(input.getId())
        if(input.getTitle()!=null&&input.getTitle().length()>0){
        jsons.put("Title",input.getTitle().toString())  ;  }
        if(input.getAuthorFirst()!=null&&input.getAuthorFirst().length()>0){ 
        jsons.put("AuthorFirst", input.getAuthorFirst( ))  ;    }
        if(input.getAuthorLast()!=null&&input.getAuthorLast().length()>0){
        jsons.put("AuthorLast",input.getAuthorLast()) ;  }
        return jsons ;
    }
    public static JsonObject serialiseAuthor (Author authentic){
        JsonObject created = new JsonObject() ;  
        if(authentic.getSelfId()!=null&&authentic.getSelfId().length()>0){
        created.put("SelfId",authentic.getSelfId()) ; } // String.valueOf(authentic.getId())  
        if(authentic.getLastName()!=null&&authentic.getLastName().length()>0){
        created.put("LastName",authentic.getLastName()) ;  }
        if(authentic.getFirstName()!=null&&authentic.getFirstName().length()>0){
        created.put("FirstName",authentic.getFirstName( )) ;  }
     // created.put("Books",encodeParse(authentic.getBooks())) ;   // new JsonArray(authentic.getBooks()) ; 
       if(authentic.getBooks()!=null&&authentic.getBooks ().size()>0){
        created.put("Books",expressList(authentic.getBooks())) ;  }
     //   System.out.println(authentic.getBooks().size ( )) ;
        return created ;   //  {
    }   
    // List<JsonObject>
    public static  <V> JsonArray encodeList(List<V> serial ){
        JsonArray mains = new JsonArray( ) ; 
        int width = serial.size() ; 
        for( int  vt=0;vt<width;vt++){
            V temps = serial.get(vt) ;
            mains.add((Object)temps) ;     }     
        Book lines =  (Book)(serial.get(width-1)) ; 
       // mains.add(Utilities.serialiseBook(lines)) ;    // serial.get(width-1)
         return mains ; 
    }   
    public static JsonArray  expressList(List<String> kinds){
         JsonArray  frames = new JsonArray()  ;
        for(int yt=0;yt<kinds.size();yt++ ){
          String verse =   kinds.get(yt) ; 
          frames.add(verse) ;    }
        return frames ;
    }
    public static  JsonArray  encodeParse(List<Book> items ) {
        int height = items.size( ) ; 
        JsonArray  lexer = new JsonArray( ) ;  // adder = new JsonArray( ) ;
        for( int vt=0;vt<height;vt++) {
            Book banes = items.get(vt) ; 
            JsonObject equivs =Utilities.serialiseBook(banes) ; 
            lexer.add(equivs) ;   // adder.add(equivs) ;
         }  
         return lexer ;  //adder  ;
    }
    public static void writeResponse (HttpServerResponse response,String message ,int code
    ,boolean chunked,boolean terminate){    //aa
         response.setChunked(true)  ;
        response.setStatusCode(code) ;
        if(message.length()>=1){
            response.write(message) ;
        }
        if(terminate==true){
        response.end()   ; }
    }     // Json
    public static void  resolve(HttpServerResponse response,String message,Object payload,
    int code,boolean chunked,boolean terminate,boolean  succeeded){
        response.setChunked(chunked) ;
        response.setStatusCode(code) ;
        JsonObject wrapper = new JsonObject().put("success",succeeded).put("payload",payload).put("message",message)   ;
        response.write(wrapper.encode()) ;
        if(terminate==true){
            response.end( ) ;    }
    }
    public static void  LogEntry(String names){
        Thread trials = Thread.currentThread() ;
        String tiers  = Integer.toString(trials.getPriority()) ;
        String content = trials.getName().concat(tiers) ;
        logger.info("\nStart Line") ;
        logger.info(content) ;// mains.println("Versions Indicator ".concat(content));
        logger.info(names) ;
        logger.info("End Line\n")  ;  
     }
    public static void DefaultHandler(Throwable liable){
          String crease = liable.toString() ;
          StackTraceElement[] arrays = liable.getStackTrace() ;
          LogEntry(crease) ;     
          LogEntry(Arrays.deepToString(arrays)) ;
    }

    // JsonObject.iterator()  //java.util.Iterator<Map.Entry<String,Object>>
    //JsonObject.readFromBuffer(int reach,Buffer buffer)  // JsonObject ;
    //JsonObject.getJsonArray("String keys",JsonArray cases)  //JsonArray ;
    //JsonObject.stream( ) ;   //java.util.stream.Stream<Map.Entry<String,Object>>  ;
    // JsonObject.MapTo(Class<N> classes)  //<N> ;
    // JsonObject.MapFrom(Object sources) //JsonObject ;
    //JsonObject.clone(java.util.function.Function<Object,?> cloner )  JsonObject;
     //JsonObject.MergeIn(JsonObject other,int depth) JsonObject;
    //JsonObject.MergeIn (JsonObject equivs,boolean deep) JsonObject;
    //JsonObject.toBuffer()  //Buffer ;
    //JsonObject.writeToBuffer(int post,Buffer buffer) ;
    //JsonObject.readFromBuffer(int post,Buffer buffer ) ;
    //  public static void  serialiseAuthor2(){

   // }
}
