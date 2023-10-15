package com.moderneinstein.web.vertx;

import io.vertx.core.http.HttpMethod ;
import io.vertx.core.http.HttpClient ;   
import  io.vertx.core.Handler ;  
 // import io.vertx.core.http.HttpClientRequest  ; 
import io.vertx.core.json.JsonObject ; 
import io.vertx.core.buffer.Buffer ; 

import java.util.Random ;
import java.util.List ;
import java.util.LinkedList ; 
import java.util.ArrayList ;  
import java.util.Set  ; 
import java.util.Vector ;


public class AuthorDataSource {
    
    public static  List[] resource ;   
    public static List<String> paths ; 
    public static List<HttpMethod> methods = new Vector<HttpMethod>() ;   // new Author(),new Author(),   // ,new Book("","")
 //   public static Author[] values =  new Author[] {new Author("Dan","Brown",List.of(new Book( "Angels and Demons","Fantasy"),new Book("The Da vinci code","Fantasy"),new Book("The Lost Symbol","Fantasy")))} ; //,  
 public static Author[] values =  new Author[] {new Author("Dan","Brown",List.of( "Angels and Demons","Fantasy","The Da vinci code","Fantasy","The Lost Symbol","Fantasy")), 
 new Author("Brandon","Sanderson",List.of("SkyWard","OathBringer")),new Author("Micheal","Grant",List.of("Plague","Fantasy","Fear","Fantasy","Lies","Fantasy")) } ;
    //new Author("Micheal","Grant",List.of(new Book("Plague","Fantasy"),new Book("Fear","Fantasy"),new Book("Lies","Fantasy"))) ,new Author("Brandon","Sanderson",List.of(new Book("SkyWard","Fantasy"),new Book("OathBringer","Fantasy")))} ; 
    public static Random reads  = new Random(System.currentTimeMillis ()) ; 

    public static  List[] computeTests(){
        resource = new List[3] ; 
        resource[0] = new Vector<String>() ; 
        resource[1] = new ArrayList<String>( ) ;
        resource[2] = new Vector<HttpMethod> () ; 
          insertions() ;
         updates( )   ; 
        searches() ;  
        return resource ; 
    }  

    public static void insertions() {
        int  brace = values.length ; 
        for(int ts=0;ts<brace;ts++) { 
            Author writer = values[ ts] ; 
            JsonObject forms = Utilities.serialiseAuthor(writer) ;  
            resource[2].add(HttpMethod.PUT) ; 
            resource[1].add (new String(forms.encode())) ; 
            resource[0].add(new String("/Library/authors/insert/")) ; 
        }
    }    
    // ,source.getBooks()  //  Author others   //  others.set
    public static  Author  reorder( Author source){ 
        Author writer = new Author(source.getFirstName( ),source.getLastName())  ;  
         List<String> forms =  source.getBooks()  ; //List<Book> forms = source.getBooks( ) ;  
         List<String> equiv = new ArrayList<String>() ; // List<Book> equiv =  new ArrayList<Book>( ) ;
        for(int rs=forms.size ()-1;rs>=0;rs--){ 
            equiv.add(forms.get(rs)) ; 
        }
        writer.setBooks(equiv) ; 
        return writer ;  
     }
    public static void updates(){ 
         int spans =  values.length ; 
         for(int nt =0;nt<spans;nt++) { 
            Author distinct =   reorder(values[nt])  ;
            JsonObject  evens =  Utilities.serialiseAuthor(distinct); 
            resource[2].add(HttpMethod.POST)  ; 
            resource[1].add(evens.encode())  ; 
            resource[0].add("/library/authors/update/".concat(values[nt].getFirstName())) ;
         }
    }  
    //         Author parts = values[vr] ; 
    public static void  searches( ){ 
         int height =  values.length ; 
         for(int vr=0;vr<height/2;vr++)  { 
            int point = reads.nextInt( height)  ;  
            Author partial =  values[vr]  ;
           resource[1].add(new String(""))  ; 
           resource[2].add(HttpMethod.GET)  ; 
           resource[0].add("/library/authors/find/firstname/".concat(partial.getFirstName())) ; 
         }
    }
}
