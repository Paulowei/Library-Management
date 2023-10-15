package com.moderneinstein.web.vertx;


import java.util.Date ;
import java.io.Serializable ; 
import  java.util.Set ;
import java.util.List ; 
import java.util.Random ; 
import java.util.function.Predicate  ; 
import  java.util.LinkedList ; 
import java.util.ArrayList ; 

public class Author implements Serializable {
    
    private String firstName   ;
    private String lastName ; 
    private Long identity ;
    private List<String> books  ; //List<Book> books ;  
    private String selfId ; 
    public  static  Random random = new Random (System.currentTimeMillis()); 
    public static Long  LIMIT_ID =  (long)50000   ;  
    public static final  String DEFAULT = new String("ABSENT") ;   
    public static final String  EMPTY  = new String("") ;
    public Author(String prior,String after ){ 
    this.lastName =    new String( after ) ; 
    this.firstName =  new String(prior) ; 
    this.identity = random.nextLong(10000 ) ; 
    this.books =  new LinkedList<String>() ;  /// new  LinkedList<Book>() ;   
    this.selfId =  new String( EMPTY ) ; ///new String(DEFAULT) ;
  }  
   //     this.identity = new Random(System.currentTimeMillis()).nextInt(10000 ) ;  
   // new Random(System.currentTimeMillis())
  public  Author(String prior,String after,long cases){
     this.identity = Long.valueOf(cases)  ; 
    this.lastName = new String(after)  ; 
    this.firstName =  new String(prior)  ;
    this.books =   new ArrayList<String>( ) ;  //new ArrayList<Book>() ;   
    this.selfId =    new String(EMPTY) ; // new String(DEFAULT)   ; 
  }

  public  Author (String begin,String verse,List<String> values){
  //List<Book> values ) {
     books =  new LinkedList<String>(values) ;   // new LinkedList<Book>(values) ; 
    lastName = new String(verse) ; 
    firstName =new String(begin) ; 
    this.identity =  random.nextLong(LIMIT_ID) ;  
    this.selfId =   new String(EMPTY) ; //new  String(DEFAULT) ; 
    }
    public Author(String before,String  nexts,long leads,List<String> traces){
    //List<Book> traces){
        this.identity =  Long.valueOf(leads) ; 
        this.lastName =new String(before) ;
        this.lastName = new String( nexts) ;
        this.books  = new ArrayList<String>(traces) ;  //new ArrayList<Book>(traces) ; 
    }     
    public Author(String initials,String finals,String vitals,List<String> items){
     //  List<Book> items){ 
       this.books = new LinkedList<String>(items) ;  // new LinkedList<Book>(items) ; 
       this.selfId = new String(vitals) ; 
       this.lastName =new String(finals) ; 
      this.firstName = new  String(initials) ; 
    }   
    public  List<String> // List<Book> 
    getBooks(){
   //  List<Book> listed = this.books ; 
    return  this.books  ;  
    }  
    public  long getMainId(){
       long equivs = this.identity  ; 
       return equivs ; 
    } 
    public String getLastName  (){
       String great = this.lastName  ; 
       return great ;  
    } 
    //   Predicate
    public String getFirstName  (){
      String patterns = new String (this.firstName) ; 
      return patterns ; 
    } 
    public void setMainId(long lines){
      long links = lines ; 
      this.identity = lines ; 
    }
    public void setBooks(List<String> serial){//(List<Book> serial){
      //List<Book> items =new LinkedList<Book> (serial) ;
       this.books =   new LinkedList<String>(serial) ; 
    }
    public void setLastName(String  source){
       String equiv = new String (source)  ;
     //  return  equiv   ;   
      this.lastName = equiv  ; 
    } 
    public void setFirstName( String  brace) {
       String  equiv =  new String(brace)  ;
    //   return equiv  ;  
    this.firstName = equiv ; 
    }   
    public void  setSelfId ( String trough){
      this.selfId = new String(trough) ; 
    }  
    /// String  crest
    public String getSelfId(){
        return this.selfId  ;
    }
}
