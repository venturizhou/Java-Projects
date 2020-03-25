package assign6_template;

/*
Steven Zhou
CIS 2168 Sec 003
Assignment 6
 */

import java.util.ArrayList;

public class Person {
    protected String name;
    protected String degree;
    protected ArrayList<String> skills;

    //define data fields: name, degree, skill list
    public Person(String name, String degree, ArrayList<String>skills){
        this.name = name;
        this.degree = degree;
        this.skills = skills;
    }
    //define the constructor with given name, degree, and skill list
    public String getname(){
        return name;
    }
    public String getdegree(){
        return degree;
    }
    public ArrayList<String> getskills(){
        return skills;
    }
    //define getters
    public void setname(String name){
        this.name = name;
    }
    public void setdegree(String degree){
        this.degree = degree;
    }
    public void setskills(ArrayList<String> skills){
        this.skills = skills;
    }
    //define setters
    public String toString(){
        return "Name: " + name + " | " + "Degree: " + degree + " | " + "Skills: " + skills + "\n";
    }
    //define toString()

}

