package Assign1;

/*  
    CIS 2168 003
    Steven Zhou venturi@temple.edu
    Assign1
    class Student
    parent class for other types of students
*/

public class Student{

    private String id;
    private String firstName;
    private String lastName;
    private String major;
    private String degree;
    private double gpa;

    // constructors
    public Student() {
    }

    public Student(String id, String firstName, String lastName, String major, String degree, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.degree = degree;
        this.gpa = gpa;
    }

    // setters

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // getters

    public String getDegree() {
        return degree;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    // add your definition of toString() here

    public String toString() {
        return "ID: " + id + " First Name: " + firstName + " Last Name: " + lastName + " major: " 
        + major + " degree: " + degree + " gpa: " + gpa;
    }
}
