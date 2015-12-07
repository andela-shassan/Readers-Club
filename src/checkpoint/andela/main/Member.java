package checkpoint.andela.main;
import java.util.Date;

/**
 * Created by Semiu on 26/11/2015.
 * This Member class is an abstract class.
 * It serves as the parent class to the Staff and Student classes.
 * It contains two abstract methods which must be implemented by it's subclass.
 *
 */

public abstract class Member {
  private String fullName;
  private char sex;
  private String dateOfBirth;
  private String email;
  private String phoneNumber;
  private Date registrationDate;

  // Default Constructor
  public Member(){
    fullName = null;
    sex = '\u0000';
    dateOfBirth = null;
    email = null;
    phoneNumber = null;
    registrationDate = setRegistrationDate();
  }

  // Parameterize Constructor
  public Member(String fullName, char sex, String dateOfBirth, String email, String phoneNumber){
    setName(fullName);
    setSex(sex);
    setDateOfBirth(dateOfBirth);
    setEmail(email);
    setPhoneNumber(phoneNumber);
    registrationDate = setRegistrationDate();
  }

  // Setter and Getter for name
  public void setName(String fullName){
    this.fullName = fullName;
  }

  public String getName(){
    return fullName;
  }

  // Setter and Getter for Gender
  public void setSex(char sex){
    this.sex = sex;
  }

  public char getSex(){
    return sex;
  }

  // Setter and Getter for Date of Birth
  public void setDateOfBirth(String dateOfBirth){
    this.dateOfBirth = dateOfBirth;
  }

  public String getDateOfBirth(){
    return dateOfBirth;
  }

  // Setter and Getter for email
  public void setEmail(String email){
    this.email = email;
  }

  public String getEmail(){
    return email;
  }

  // Setter and Getter for Phone Number
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }

  // Setters and Getter for Date Of Registration
  // These kind of setters are refer to as overloaded method
  public Date setRegistrationDate(){
    this.registrationDate = new Date();
    return this.registrationDate;
  }

  public Date setRegistrationDate(Date registrationDate){
    this.registrationDate = registrationDate;
    return registrationDate;
  }

  public Date getRegistrationDate(){
    return registrationDate;
  }

  // Getter for Current date
  public Date getCurrentDate() {
    return new Date();
  }
}