package com.moderneinstein.web.vertx ;

import io.vertx.core.buffer.Buffer ;
import io.vertx.core.json.Json ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.json.JsonArray ;
import io.vertx.core.http.HttpMethod  ;


import java.util.function.Supplier ;
import java.util.function.Consumer ;
import java.util.function.Predicate ;
import java.util.List ;
import  java.util.ArrayList ;
import  java.util.Vector ;
import java.util.Set  ;
import java.util.Random ;


public class BookDataSource {
    public static Book[] items =  new Book[]{ new Book("The C++ Programming Language","Bjarne Strastroup"),new Book("The C programming Language","Dennis Ritchie"),new Book("Data Structures and Algorithms in Java","Programming"),
    new Book("The intelligent Investor","Benjamin Graham") ,new Book("Light","Fiction"), new Book("Skyward","Fiction") } ;
   // public static HttpMethod[] methods = new HttpMethod[]{} ;
   public static List<HttpMethod> methods = new ArrayList<HttpMethod>();
    public static List<String> paths = new ArrayList<String>() ;
    public static List[] buffers  ;
    public static Random random =  new Random(System.nanoTime( )) ;
    public BookDataSource( ){

    }
    // List<Object>   //  List[] buffers =
    public static List[] deriveValues(){
          buffers = new List[]{new ArrayList<String>(),new ArrayList<String>( ),new Vector<HttpMethod>( )} ;
        buffers[2] =  methods   ;  buffers[1] =  paths ;
        insertion() ;
        updates() ;
        searches()  ;
        return buffers ;    
     }
    public  static  void insertion( ){
        int width = items.length ;
        for(int ny=0 ;ny<width;ny++){
            Book parts  =  items[ny] ;
            JsonObject jsons =  Utilities.serialiseBook(parts) ; 
            System.out.println(jsons.encode( )) ;  
            buffers[1].add(jsons.encode())  ;
            buffers[2].add(HttpMethod.PUT) ;
            buffers[0].add(new String("library/books/insert")) ;
        }
    }
    public static Book alternate(Book current){
        String types  = current.getGenre( ) ;
         String append = new String( );
        for(int vc=0;vc<types.length();vc++){
            char checks =  types.charAt(types.length()-vc-1) ;
            append = append.concat(Character.toString(checks)) ;
        }
        Book lanes = new Book(current.getTitle( ),append)  ;
        return lanes ;
    }
    public static void  updates( ){
        int width = items.length ;
        for(int tr =0;tr<width;tr++){
        Book portion = items[tr] ;
        Book edited = alternate (portion) ;
        JsonObject orders =  Utilities.serialiseBook(edited) ;
        buffers[2].add(HttpMethod.POST) ;
        buffers[1].add (orders.encode ()) ;
        buffers [0].add(new String("library/books/update/title/").concat(portion.getTitle())) ;
        }
    }   //  buffers [0].add<String>   
    public static void searches(){
        int width = items.length ;
        for(int vc=0;vc<width/2;vc++ ){
        int reach = random.nextInt(width) ;
        Book voltage = items[vc] ;
        buffers[2].add(HttpMethod.GET);
        buffers[1].add(new String(""))  ;
        buffers[0].add(new String("library/books/find/genre/").concat(voltage.getGenre())) ;
        }

    }
}
