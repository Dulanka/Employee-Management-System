/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import business.Login;
import java.util.ArrayList;
/**
 *
 * @author dulanka
 */
public interface ILogin {
     boolean add(Login log); 
     ArrayList<Login> getAll();
     Login get(String userID);
     boolean delete(String usertID);
     boolean update(Login log);
}
