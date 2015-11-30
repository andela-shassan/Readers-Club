# Readers-Club

#### About  
This is a basic application for a reader's club.  
Members of this club are of two Categories: Staff and Student.  
Whenever a member want to borrow a book, they are placed on a queue for that book.  
This app arrange the queue(or organize the borrowing process) in such a way that Staff are given higher priority over Students. Also, older Staff or Student has higher priority over new Staff or Student.  

#### Member Class  
This is an abstract class that serve as the parent class to Staff and Student class.  
It sets the generic properties and methods that are common to both staff and student.  
The most important methods of this class are: borrowBook() and returnBook.  

#### Book Class  
This class as the name suggest maintains the list of books that are available in the club.  
It sets the properties of each book and keep the record of book that are currently available.  

#### Staff Class  
This class is a subclass of the member class.  
It contains only members that are of type staff.  
It inherited all the attributes and methods of the member class.  
Also, it has some extra attributes (such as staff-number and netpay) that are peculiar to this class only.  
Members of this class has higher precedence over members from student class.  

#### Student Class  
This class is also a subclass of the member class.  
It can perform any action performed by member of the Member Class,  
because it inherited all the properties of its parent class.  
Also, it has some extra properties(student-number and student class) that are peculiar to the member of this class only.  
When borrowing book, members of this class are considered only after the members of the Staff Class.

#### ComparatorInterface Class  
This class implements comparator used by the ReadersClubManagement Class to arrange the queue of the members borrowing book.  
It compare any member trying to borrow a particular book with those that are already on the queue for that book  
and place them on the queue based on their status and rank.  

#### TestSuite  
This package contain the JunitTest classes that confirms the functionality of this application.  
Note: Setters and Getters were not thoroughly tested. The reason been that they performs basic function and rarely failed.

## How To Use 
* Create book and add it to books list.
* Create member, staff or student.
* Register the member in the club. The member will be automatically added to the appropriate list.
* Call the borrowBook method (with argument book) on the member.
* The member will be automatically added to the queue of people trying to borrow book.
* The member getting the book depends on the copies of the book left, number and status of people already on the queue for that book. 