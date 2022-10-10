/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import database.Elastic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logic.Person;
import view.lineas;
import static test.test.findByName;

/**
 *
 * @author Sharon
 */
public class Controller {
    
    Elastic database;
   
    public Controller() {
        database = new Elastic();
    }
    
    public Person findById (String id){
         List<Person> person = database.findById(id);
         System.out.println("SS " + person.size());
         return person.get(0);
    }
    
    
    
}


