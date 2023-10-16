# Library-Management
A Backend API for a Library Mangement system  : Created with the Vertx Polygot Framework  

-The web app replies on vertx-web ,vertx-core , and vertx-mongo-client  dependencies ;   
-Inorder to run the applicaton  ; 
-Change directory to the base directory of the project ; 
-Compile the project with the following command ; 
-mvn package ; 
-Run the following command ; 
-mvn  package ; 
-To start the server,run the following commands ;
-mvn vertx:initialize
-mvn vertx:run  
-mvn  exec:java  

-The source files remain in the src/main/java/com/moderneinstein/web/vertx folder ; 
-Send an API request to any of the following rest endpoints to  make changes to the underlying database ; 
- Inorder to update a Book document , send a GET request to  ;
- The base route for the API is http://localhost:8060 or http://localhost:8040  ;
- The port for the BookServices server is 8040  ,while the port or the AuthorServices server  is 8060 ; 
- /library/books/update/title/:cores GET
-  /library/books/find/all POST ; 
-  /library/books/delete/:links DELETE ;
-  /library/books/find/genre/:cores  GET ;   
-  /library/books/update/identity/:id  POST ;
-  /library/books/insert  PUT ;
-  /library/books/find/title/:portion  GET ;
-  /library/books/find/identity/:id  GET ;

-  /library/authors/update/lastname/:sample  POST  ;
 -  /library/authors/find/lastname/:data  GET  ; 
 -  /library/authors/update/firstname/:clone  POST ;
 -  /library/authors/find/all  GET  ;
 -   /library/authors/find/identity/:digit  GET  ;
 -   /library/authors/insert POST  ;
 -   /library/authors/delete/identity/:id DELETE ;
 -   /library/authors/find/firstname/:title   GET ;
 -   /library/authors/update/identity/:id  POST ;
 - The Author Model is described As Follows ;
 - FirstName : String ;
- LastName : String  ;
- SelfId : String ;
- Books : List<String> ;
- The Book Model is described as follows ;
  -AuthorFirst : String ;
  -AuthorLast : String ;
  -SelfId : String ;
  -Genre :String ;
  -Title : String  ;
  
