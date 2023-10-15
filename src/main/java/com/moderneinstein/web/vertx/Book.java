package com.moderneinstein.web.vertx;


import com.moderneinstein.web.vertx.Author  ; 
 
import  java.io.Serializable ;
import java.util.List ;  
import java.util.ArrayList ;
import  java.util.Set ;
import java.util.Date;
import java.util.Random ; 


public class Book {
    
        private String title ; 
        private long creatorId ; 
        private long  identity ;
      //  private Date date ; 
        private String genre ;   
        public static long  LIMIT_ID  =  50000  ;   
        private String  selfId  ;
        private String  authorId ;   
        private String authorFirst ;    
        private String authorLast  ;
        public static final String  ABSENT  =  new  String( "ABSENT")  ; 
        public static final String CLEAR =  new String () ; // "CLEAR" 
        public static  long SpawnId(){
            Long  listed =  (long)(System.nanoTime()) ; 
            Random rates =  new  Random(listed) ; 
            long recents =  rates.nextLong(LIMIT_ID)  ;
            return   recents  ; 
        }
        public Book(String great ,Long created,long notice){
             this.title= new String(great) ; 
            this.creatorId = created ; 
            this.genre  = new String("") ; 
           // this.identity =  rands.nextLong( LIMIT_ID) ;  
           this.identity =   notice ;  
            this.authorId = new String(ABSENT) ; 
            this.selfId = new String(ABSENT);    }
           
        public Book(String  states,Long   credential,String types){
             this.creatorId =  credential ; 
            this.genre = new  String(types) ; 
            this.title =  new String(states) ; 
            this.identity = SpawnId() ; 
             this.authorId = new String(ABSENT) ; 
            this.selfId = new String(ABSENT); 
             }
        //         public static Random rands = 
        //  new  Random(System.currentTimeMillis()) ;   
        //  public  Book(String states,Long credential ,long reach,String notes){   
        public  Book(String states,long reach,String notes,long credential){
             this.creatorId =  credential ; 
             this.genre =  new String(notes) ;
            this.title = new String(states) ; 
             this.identity =  Long.valueOf(reach) ; 
              this.authorId = new String(ABSENT) ; 
            this.selfId = new String()  ;  // ABSENT);  
           // this.authorName = new String ()  ; 
        }
        public  Book(String bright,Long authentic){
            this.title = new String(bright) ;
            this.creatorId = authentic  ; 
            this.identity =SpawnId() ; 
            this.genre = new String(ABSENT) ;  
            this.authorId = new String(ABSENT) ; 
            this.selfId = new String()  ; //(ABSENT);  
            this.authorFirst = new String() ;//
        }   
        public Book(String names,String known,String types,String before,String after){
            this.genre = new String(types)  ;
          //  this.authorId =  new String(credential)  ;
            this.selfId = new String(known) ; 
            this.title = new String(names) ; 
             this.creatorId = SpawnId() ;   // new String(ABSENT) ;    //("absent" )  ;
            this.identity =SpawnId() ; // new String(ABSENT) ;   
            this.setAuthorLast(after) ;// 
            this.setAuthorFirst(before) ; 
        }  
        public Book(String names,String types ){
                this.selfId =  new String(CLEAR) ; 
                this.authorId =  new String( ABSENT) ;   
                this.genre = new String(types) ;  /// ( names  )  ; 
                this.title =  new String (names) ;      
                this.creatorId = SpawnId( ) ;  ///new String(ABSENT) ;    //("absent" )  ;
                this.identity = SpawnId() ;  //new String(ABSENT) ; 
                this.authorFirst = new String(CLEAR) ; 
                this.authorLast = new String(CLEAR) ; 
         }   
         public Book(String  impose,String varied ,String first,String last ){
           // this.authorId =  new String( notice )  ; 
            this.genre = new String( varied) ; 
            this.title =  new String( impose)  ;  
            this.selfId =   new  String(CLEAR) ; //new String( ABSENT  )  ;  
              this.creatorId = SpawnId() ; //new String(ABSENT) ;    //("absent" )  ;
                this.identity = SpawnId()  ; //  new String(ABSENT) ;   
                this.setAuthorLast(last) ;
                this.setAuthorFirst(first )  ;//
         }
        public  long  getCreatorId() {
            long leads =  this.creatorId ; 
            return leads ; 
        }
        public String getGenre(){
            String reach =  this.genre ; 
            return  reach    ; 
        }
        public long  getMainId(){
            long  noted = this.identity ; 
            return noted ; 
        } 
        public String getTitle(){
            String stripes = new String (this.title) ; // this.getTitle  ()  ;
            return stripes ; 
        }
        public  void setGenre( String  point){  
            String great = new String(point) ;
            this.genre  = point ; 
        } 
        public void  setMainId(long  lines){
            long known=  lines ; 
            this.identity = known ;     
        } 
        public void setCreatorId(long frames){
            Long   signs = Long.valueOf (frames) ;
            this.creatorId = signs ;  
        }  
        public void setSelfId(String manner){
            this.selfId = new String(manner) ; 
        }  
        public void setAuthorId(String pattern){
            this.authorId =  new String(pattern) ; 
        } 
        public String  getSelfId(){
            return  this.selfId ; 
        } 
        public String getAuthorId() {
            return   this.authorId ; 
        }   

        public String getAuthorFirst( ){
            return this.authorFirst ; 
        } 
        public String getAuthorLast() {
            return  this.authorLast ;
        }
        public void setAuthorLast( String names) {
                this.authorLast = new String(names) ;
        } 
        public void setAuthorFirst (String names){
            this.authorFirst= new String(names) ; //.concat(names) ;  
        }
            }
