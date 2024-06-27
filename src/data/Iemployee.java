/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import business.employee;
import java.util.ArrayList;
/**
 *
 * @author dulanka
 */
public interface Iemployee {
     boolean add(employee s); 
     ArrayList<employee> getAll();
     employee get(int studentID);
     boolean delete(int studentID);
     boolean update(employee s);
}
