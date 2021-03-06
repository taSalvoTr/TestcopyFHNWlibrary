# ExplosivePomegranate

### Use Case diagram
https://lucid.app/lucidchart/4c7d5f12-b21d-4bff-988e-84bd686c2cd3/edit?viewport_loc=108%2C-247%2C1111%2C777%2C0_0&invitationId=inv_3a662d3c-c919-4256-8e0d-2f78abadef9b

![UML user stories](documentation-resources/UML-usecases.png?raw=true "Title")

### User Stories

####MVP

1. UC1: As a student of the FHNW, I want to use the web app on my different devices (i.e mobile devices, laptops, and desktop
   computers) so that I can access the web app everywhere.
2. UC2: As a student of the FHNW, I want to clear and simple UI so that I can navigate quickly and smoothly
3. UC3: As a student of the FHNW, I want to create an account so that I can access the web app.
4. UC4: As a student of the FHNW, I want to log-in so that I can authenticate myself.
5. UC5: As a student of the FHNW, I want to search for books within the library so that I can see if the library has them
6. UC6: As a student of the FHNW, I want to be able to see whether a book is currently available so that I can borrow it
7. UC7: As a student of the FHNW, I want to reserve/borrow books so that I can pick them up at the physical library
8. UC8: As a student of the FHNW, I want to see which books I'm currently borrowing and when I have to return them so that I
   always have an overview of which books are due
9. UC9: As a student of the FHNW, I want to stay logged in the webinterface when I close the browser window.
10. UC10: As a Librarian, I want to be able to add new books into the system so that students of the FHNW see what is newly
    available.
11. UC11: As a Librarian, I want to have an overview over books that are overdue to return so that I can remind them that they
    need to return the book.
12. UC12: As a Librarian, I want to see the dates of borrowed books
13. UC13: As a librarian, I want to add students accounts so that the students of the FHNW have access to the library. 

#### Nice to have
14. UC14: As a students of the FHNW, I want a shopping card like experience for books I want to lend so that I keep the overview over how many books I added already.
15. UC15: As a student of the FHNW, I want the possibility to register myself for access to the library so that I do not need to wait to be added by the Librarian. 
16. UC16: As a Libraran, I want a reporting functionality about all the borrowed books so that I can easily search for return dates for specific items and overdo books
17. UC17: As a Librarian, I want that the "return reminder" for borrowed books is send automatically so that I save time and can focus on keeping the library up to date. 
18. UC18: As a student of the FHNW, I want to add a comment about a book condition for everyone to see so that I do not get fined for mistreating the book when the librarian notices something wrong with the book.

### Class diagram
https://lucid.app/lucidchart/invitations/accept/inv_dc1b4624-c4b7-4b75-be56-0053b5493778?viewport_loc=-8%2C1248%2C2048%2C1085%2C0_0
![Class Diagram](documentation-resources/Class-Diagram.png?raw=true "Title")

##Mockup
### Mockup draft
Mockup draft from Sonja
![Class Diagram](documentation-resources/Mockup-draft.png?raw=true "Title")

### Mockup refined

## DB structure
https://lucid.app/lucidchart/7dc561be-ccba-475d-8fea-9955b0b630bb/edit?viewport_loc=-168%2C-223%2C2130%2C1129%2C0_0&invitationId=inv_95025269-9fc5-4c7f-b6da-3e6556c2a036
![DB Structure](documentation-resources/DB-Diagram.png?raw=true "Title")

### reinstall DB with IntelliJ
go into your project folder.
When you are in the folder explosivepomegranate/ then run 

mysql -u root -p library < src/main/resources/db/exposivePomegranate-db.sql

in the IntelliJ Terminal / Terminal

you will need to insert your mysql root password after you hit enter.
then the database should be installed on your local environment.
alternatively you can open the exposivePomegranate-db.sql file and just run it in the mysql interface

## API request documentation
| Use Case | Request type | Request      | Content |
|----------|--------------|--------------|---------|
| UC3      | POST         | /myNewUser     | firstname, lastname, email, password |
| UC4      | POST         | /login       | email, password |
| UC5      | GET          | /allCategories| categories |
| UC5      | GET          | /allAuthors  | authors |
| UC5/6    | GET          | /allBooks    | isbn, title, description, year, (image), category(ies), author(s), bookStatus |
| UC5      | GET          | /categoryBooks/<category_id>|  isbn, title, description, year, (image), category(ies), author(s), bookStatus |
| UC5      | GET          | /authorBooks/<author_id>|  isbn, title, description, year, (image), category(ies), author(s), bookStatus |
| UC6      | GET          | /bookInfo/<book_id>  | isbn, title, description, year, (image), category(ies), author(s), bookStatus, bookComment, startDate, initEndDate, (extendEndDate)|
| UC7      | POST         | /reserveBook/<book_id> | book_id, bookStatus |
| UC8      | GET          | /myBorrows   | isbn, title, description, year, (image), category(ies), author(s), bookStatus , initEndDate |
| UC10     | POST         | /newBook     | isbn, title, description, year, (image), category, author |
| UC11     | GET          | /allBorrowed |  isbn, title, description, year, (image), category(ies), author(s), bookStatus , startDate,initEndDate |
| UC12     | POST         | /addNewUser  | firstname, lastname, email, password, role |
| UC18     | POST         | /addComment/<book_id> | comment|

# Start developing
build you application by importing the maven dependencies

in the terminal it is
mvn clean install

then run your application over the interlliJ start option

## working with Postmen
make a post request
![Post Request](documentation-resources/postmen-post.png?raw=true "Title")
make a get request
![Get Request](documentation-resources/postmen-get.png?raw=true "Title")
