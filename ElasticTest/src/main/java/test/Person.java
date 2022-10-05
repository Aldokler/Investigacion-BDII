/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Aldokler
 */
public class Person {

    public Person() {
    }
    
    public int id;
    public String name;
    public String lastname;
    public String marital;
    public String nation;
    public int[] birthdate;
    public int[] deathdate;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setBirthdate(int[] birthdate) {
        this.birthdate = birthdate;
    }

    public void setDeathdate(int[] deathdate) {
        this.deathdate = deathdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMarital() {
        return marital;
    }

    public String getNation() {
        return nation;
    }

    public int[] getBirthdate() {
        return birthdate;
    }

    public int[] getDeathdate() {
        return deathdate;
    }
    
    
}
