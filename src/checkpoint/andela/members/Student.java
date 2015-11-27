package checkpoint.andela.members;

import checkpoint.andela.main.Member;

/**
 * Created by Semiu on 26/11/2015.
 */
public class Student extends Member {
  private int studentNumber;
  private int studentClass;

  // Default constructor
  public Student() {
    super();
    this.studentNumber = 0;
    this.studentClass = 0;
  }

  // Parameterize constructor
  public Student(String names, char sex, String DOB, String email, String phoneNo, int studentNumber, int studentClass) {
    super(names, sex, DOB, email, phoneNo);
    setStudentNumber(studentNumber);
    setStudentClass(studentClass);
  }

  // Setter and Getter for Student Number
  public void setStudentNumber(int studentNumber) {
    this.studentNumber = studentNumber;
  }

  public int getStudentNumber() {
    return studentNumber;
  }

  // Setter and Getter for Student Class
  public void setStudentClass(int studentClass) {
    this.studentClass = studentClass;
  }

  public int gerStaffNetpay() {
    return studentClass;
  }
}
