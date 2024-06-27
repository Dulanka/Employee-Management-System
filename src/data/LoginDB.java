/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Login;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dulanka
 */
public class LoginDB implements ILogin {
    private File myObj;
    
    public LoginDB() {
        myObj=new File("c:\\details\\login.txt"); 
    }
    
    @Override
    public boolean add(Login log) {
       try{
           FileWriter fw=new FileWriter(myObj, true);
           String line=log.getUserID()+":"+log.getPassword()+"\n";
           fw.append(line);
           fw.close();
           return true;
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public ArrayList<Login> getAll() {
     ArrayList<Login> logList =new ArrayList<>();
       try{
           Scanner sc=new Scanner(myObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split(":");               
               String userID=arr[0];
               String password=arr[1];              
               Login login=new Login(userID, password);
               logList.add(login);
           }
           sc.close();
           return logList;
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
        
    }

    @Override
    public Login get(String userID) {
       ArrayList<Login> lList=getAll();
        for(Login l:lList){
            if(l.getUserID().equals(userID)){
                return l;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String userID) {
        try{
            ArrayList<Login> logList=getAll();
            try (FileWriter fw1 = new FileWriter(myObj)) {
                fw1.write("");
            }
            
            for(Login l: logList){
                if(l.getUserID().equals(userID)){
                    logList.remove(l);
                    break;
                }
            }
            
            logList.forEach((l1) -> {
                add(l1);
            });
            return true;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Login log) {
       try{
            ArrayList<Login> logList=getAll();
           try (FileWriter fw1 = new FileWriter(myObj)) {
               fw1.write("");
           }
             
            for(Login l1: logList){
                if(l1.getUserID().equals(log.getUserID())){
                    logList.remove(l1);
                    logList.add(log);
                    break;
                }               
                
            }
            
            logList.forEach((l2) -> {
                add(l2);
           });
            return true;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    } 
    
    
}
