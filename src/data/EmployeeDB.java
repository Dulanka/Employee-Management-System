/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.employee;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.sql.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author dulanka
 */
public class EmployeeDB implements Iemployee {

   // private ArrayList<employee> employeeList;
    private final File myObj;
    
    public EmployeeDB() {
       // employeeList=new ArrayList<>();
        myObj=new File("c:\\details\\employee.txt");
    }

    @Override
    public boolean add(employee s) {
       try{
           FileWriter fw=new FileWriter(myObj, true);
           String line=s.getsID()+":"+s.getFirstName()+":"+s.getLastName()+":"+s.getGender()+":"+s.getDesignations()+":"+s.getDepartments()+":"+s.getDob()+"\n";
           fw.append(line);
           fw.close();
           return true;
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
        
      
    }

    @Override
    public ArrayList<employee> getAll() {
       ArrayList<employee> employeeList =new ArrayList<>();
       try{
           Scanner sc=new Scanner(myObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split(":");
               int sID=Integer.valueOf(arr[0]);
               String firstName=arr[1];
               String lastName=arr[2];
               String gender=arr[3];
               String designations=arr[4];
               String departments=arr[5];
               Date dob=Date.valueOf(arr[6]);
               employee s=new employee(sID, firstName, lastName, gender, designations,departments,dob);
               employeeList.add(s);
           }
           sc.close();
           return employeeList;
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
        
     
    }

    @Override
    public employee get(int employeeID) {
        ArrayList<employee> sList=getAll();
        for(employee s:sList){
            if(s.getsID()==employeeID){
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int employeeID) {
        try{
            ArrayList<employee> employeeList=getAll();
            FileWriter fw1=new FileWriter(myObj);
            fw1.write("");
            fw1.close();
            
            for(employee s: employeeList){
                if(s.getsID()==employeeID){
                    employeeList.remove(s);
                    break;
                }
            }
            
            for(employee s1:employeeList){
                add(s1);
            }
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(employee s) {
        try{
            ArrayList<employee> employeeList=getAll();
            FileWriter fw1=new FileWriter(myObj);
            fw1.write("");
            fw1.close();
             
            for(employee s1: employeeList){
                if(s1.getsID()==s.getsID()){
                    employeeList.remove(s1);
                    employeeList.add(s);
                    break;
                }               
                
            }
            
            for(employee s2:employeeList){
                add(s2);
            }
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
}
