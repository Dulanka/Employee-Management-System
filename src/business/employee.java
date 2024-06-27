/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.sql.Date;
/**
 *
 * @author dulanka
 */
public class employee {
    private int sID;
    private String firstName;
    private String lastName;
    private String gender;
    private String designations;
    private String departments;
    private Date dob;
   

    public employee() {
    }

    public employee(int sID, String firstName, String lastName, String gender, String designations,String departments,Date dob) {
        this.sID = sID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.designations = designations;
        this.departments = departments;
        this.dob=dob;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignations() {
        return designations;
    }

    public void setDesignations(String designations) {
        this.designations = designations;
    }
    
    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    
    
}
