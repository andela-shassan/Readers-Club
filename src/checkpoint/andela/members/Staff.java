package checkpoint.andela.members;

import checkpoint.andela.main.*;

/**
 * Created by Semiu on 26/11/2015.
 * This class inherit Member class
 * It also declare two additional properties:
 * Staff-number and net-pay.
 * Members of this class are given precedence over
 * members of Student class
 */
public class Staff extends Member {
  private int staffNumber;
  private double netPay;

  // Default constructor
  public Staff() {
    super();
    staffNumber = 0;
    netPay = 0.0d;
  }

  // Parameterize constructor
  public Staff(String names, char sex, String dateOfBirth, String email, String phoneNumber, int staffNumber, double netPay) {
    super(names, sex, dateOfBirth, email, phoneNumber);
    setStaffNumber(staffNumber);
    setStaffNetpay(netPay);
  }

  // Setter and Getter for Staff Number
  public void setStaffNumber(int staffNumber) {
    this.staffNumber = staffNumber;
  }

  public int getStaffNumber() {
    return staffNumber;
  }

  // Setter  and Getter for Staff Net-Pay
  public void setStaffNetpay(double netPay) {
    this.netPay = netPay;
  }

  public double getStaffNetpay() {
    return netPay;
  }
}
