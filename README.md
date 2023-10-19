# Library-Management
A Backend API for a Library Mangement system  : Created with the Vertx Polygot Framework  

- The web app replies on vertx-web ,vertx-core , and vertx-mongo-client  dependencies ;   
- Inorder to run the applicaton  ; 
- Change directory to the base directory of the project ; 
- Compile the project with the following command ; 
- mvn package ; 
- Run the following command ; 
- mvn  package ; 
- To start the server,run the following commands ;
- mvn vertx:initialize
- mvn vertx:run  
- mvn  exec:java  

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
- https://www.mongodb.com/try/download/community
- AuthorFirst : String ;
- AuthorLast : String ;
- SelfId : String ;
- Genre :String ;
- Title : String  ;

- To use the TestClient.java file in the Test Folder -- 
 - Enter the following command  ;   
 - Compile TestClient with Javac TestClient.java ; 
 - Send A HttpRequest With -- 
- java TestClient METHOD PATH  REQUESTBODY ;
- Do not forget to escape all  double quotes  with a back-slash(\") ;
- This is very important to represent JSON Objects in POST and PUT API requests ;
- Install MongoDB and Run MongoD in the background with this command  ;
-   mongod.exe --dbpath="path/to/database"  ;
-   https://www.mongodb.com/try/download/community 
-  java TestClient  PUT http://localhost:8060/library/authors/insert  {\"FirstName\":\"Micheal\",\"LastName\":\"Grant\",\"Books\":[\"BZRK\",\"Plague\",\"Fear\"]}
-  java TestClient  PUT http://localhost:8040/library/books/insert  {\"Genre\":\"Sci-Fi\",\"Title\":\"Fear\",\"AuthorFirst\":\"Micheal\",\"AuthorLast\":\"Grant\"}
-  java TestClient  GET http://localhost:8040/library/books/find/all  {\"Genre\":\"Sci-Fi\",\"Title\":\"Fear\",\"AuthorFirst\":\"Micheal\",\"AuthorLast\":\"Grant\"}
-  java TestClient  GET http://localhost:8060/library/authors/find/all {\"FirstName\":\"Micheal\",\"LastName\":\"Grant\",\"Books\":[\"BZRK\",\"Plague\",\"Fear\",\"Light\"]}
- java TestClient  POST http://localhost:8060/library/authors/update/lastname/Grant  {\"FirstName\":\"Micheal\",\"LastName\":\"Grant\",\"Books\":[\"BZRK\",\"Plague\",\"Fear\",\"Light\"]}
-  java TestClient  POST http://localhost:8040/library/books/update/title/Fear  {\"Genre\":\"Escapism\",\"Title\":\"Fear\",\"AuthorFirst\":\"Micheal\",\"AuthorLast\":\"Grant\"}
-   java TestClient  GET http://localhost:8040/library/books/find/all  {\"Genre\":\"Sci-Fi\",\"Title\":\"Fear\",\"AuthorFirst\":\"Micheal\",\"AuthorLast\":\"Grant\"}
-  java TestClient  GET http://localhost:8060/library/authors/find/all {\"FirstName\":\"Micheal\",\"LastName\":\"Grant\",\"Books\":[\"BZRK\",\"Plague\",\"Fear\",\"Light\"]}

