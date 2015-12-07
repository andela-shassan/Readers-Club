package checkpoint.andela.main;

/**
 * Created by Semiu on 26/11/2015.
 * This Book class is basically the blueprint for a book
 * in Reader's Club library.
 */

public class Book {
  private String bookTitle;
  private String bookAuthor;
  private  int numberOfCopies;
  private String isbnNumber;

  public Book(){
    bookTitle = null;
    bookAuthor = null;
    numberOfCopies = 0;
    isbnNumber = null;
  }

  public Book(String bookTitle, String bookAuthor, int numberOfCopies, String isbnNumber) {
    setBookTitle(bookTitle);
    setBookAuthor(bookAuthor);
    setNumberOfCopies(numberOfCopies);
    setIsbnNumber(isbnNumber);
  }

  // Setter and Getter for Book Title
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getBookTitle(){
    return bookTitle;
  }

  // Setter and Getter for Book Author
  public void setBookAuthor(String bookAuthor){
    this.bookAuthor = bookAuthor;
  }

  public String getBookAuthor(){
    return bookAuthor;
  }

  // Setter and Getter for Number of Copies
  public  void setNumberOfCopies(int numberOfCopies) {
    this.numberOfCopies = numberOfCopies;
  }

  public int getNumberOfCopies() {
    return numberOfCopies;
  }

  // Setter and Getter for ISBN Number
  public void setIsbnNumber(String isbnNumber){
    this.isbnNumber = isbnNumber;
  }

  public String getIsbnNumber(){
    return isbnNumber;
  }

  // Decrease the number of book when member borrow book.
  public void decrementBook(){
    if (numberOfCopies < 1) {
      return;
    }
    numberOfCopies--;
  }

  // Increase number of book when then return book.
  public void incrementBook(){
    numberOfCopies++;
  }

  public void incrementBookByNoOfCopies(int copies){
    this.setNumberOfCopies(copies + this.getNumberOfCopies());
  }
}