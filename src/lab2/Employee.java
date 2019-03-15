package lab2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 *
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public void orientation(String cubeID)
    {
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeID);
    }

    private String orientationDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);
        return fmtDate;
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
        System.out.println(firstName + " " + lastName + " met with Hr on "
                + orientationDate());
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.:
    private void meetDepartmentStaff() {
        metDeptStaff = true;
        System.out.println(firstName + " " + lastName + " met with Dept. Staff on "
                + orientationDate());
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called
    // independently from other classes.
    private void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        System.out.println(firstName + " " + lastName + " reviewed Dept policies on "
                + orientationDate());
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called
    // independently from other classes.
    private void moveIntoCubicle(String cubeId) {
        if(Integer.parseInt(cubeId)<1||Integer.parseInt(cubeId)>100) {System.out.println("Not Valid Cube Id");}
        this.cubeId = cubeId;
        this.movedIn = true;
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + orientationDate());
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if(ssn.replace("-","").length()!=9)
        {
            System.out.println("Not Vaild SSN");
        }
        this.ssn = ssn;
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }


    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(Date orientationDate) {
        Date today = new Date();
        if(orientationDate.before(today)){
            System.out.println("Not Valid Orientation Date");
        }
        this.orientationDate = orientationDate;
    }
}