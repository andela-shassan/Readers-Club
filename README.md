# Readers-Club

## About  
This is a basic application for a reader's club. Members of this club are of two Categories: Staff and Student. Whenever a member want to borrow a book, they are placed on a queue for that book. This app arranges the queue in such a way that Staff are given higher priority over Students. Also, older Staff or Student has higher priority over new Staff or Student.  

##### Member Class  
This is an abstract class that serves as the parent class to Staff and Student class. It sets the generic properties and methods that are common to both staff and student. 

##### Book Class  
This class maintains the list of books that are available in the club. It sets the properties of each book and keeps the record of books that are currently available.  

##### Staff Class  
This class is a subclass of the member class. It contains only members that are of type staff. It inherited all the attributes and methods of the member class. Also, it has some extra attributes (such as staff-number and netpay) that are peculiar to this class only. Members of this class has higher precedence over members from student class.  

##### Student Class  
This class is also a subclass of the member class. It  inherited all the properties of its parent class. Also, it has some extra properties(student-number and student class) that are peculiar to the member of this class only. When borrowing book, members of this class are considered only after the members of the staff class.

##### ComparatorInterface Class  
This class implements the comparator used by the QueueManager class to arrange the queue of the members borrowing book. It compares any member trying to borrow a particular book with those that are already on the queue for that book and place them on the queue based on their status and rank. 

##### QueueManager Class
Whenever two or more member request for a particular book at the same time, this class places the members on a queue based on their rank and status. It make use of ComparatorInterface class to sort the queue accordingly.

##### ClubManagement Class
This is basically the masterclass that controls the whole activities of the application.
* It creates the club.
* It registers member to the club.
* Manages the list of members.
* Adds book to the club library.
* Manages the list of books.
* Lends book to members. 
* Retreives book from members.

##### TestSuite  
This package contain the JunitTest classes that confirms the functionality of all the classes and the application as a whole.
Note: Setters and Getters were not thoroughly tested. The reason been that they performs basic function and rarely failed.

## How To Use 
* Instantiate a club from ClubManagement class.
* Create book and add it to the library.
* Create member, staff or student.
* Register the member in the club. The member will be automatically added to the appropriate list.
* Request to borrow book by calling requestToBorrowBook() method.
* The member getting the book depends on the number of available copies, number and status of people that are already on the queue for that book. 