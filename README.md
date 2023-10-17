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
- http://localhost:8040/library/books/update/title/:cores GET
- http://localhost:8040/library/books/find/all POST ; 
- http://localhost:8040/library/books/delete/:links DELETE ;
- http://localhost:8040/library/books/find/genre/:cores  GET ;   
- http://localhost:8040/library/books/update/identity/:id  POST ;
-  http://localhost:8040/library/books/insert  PUT ;
- http://localhost:8040/library/books/find/title/:portion  GET ;
- http://localhost:8040/library/books/find/identity/:id  GET ;

-    http://localhost:8060/library/authors/update/lastname/:sample  POST  ;
 -    http://localhost:8060/library/authors/find/lastname/:data  GET  ; 
 -    http://localhost:8060/library/authors/update/firstname/:clone  POST ;
 -    http://localhost:8060/library/authors/find/all  GET  ;
 -     http://localhost:8060/library/authors/find/identity/:digit  GET  ;
 -   http://localhost:8060/library/authors/insert POST  ;
 -     http://localhost:8060/library/authors/delete/identity/:id DELETE ;
 -     http://localhost:8060/library/authors/find/firstname/:title   GET ;
 -     http://localhost:8060/library/authors/update/identity/:id  POST ;
 - The Author Model is described As Follows ;
 - FirstName : String ;
- LastName : String  ;
- SelfId : String ;
- Books : List<String> ;
- The Book Model is described as follows ;
- 
- AuthorFirst : String ;
- AuthorLast : String ;
- SelfId : String ;
- Genre :String ;
- Title : String  ;
  
