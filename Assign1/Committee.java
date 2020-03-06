package Assign1;

/*  
    CIS 2168 003
    Steven Zhou venturi@temple.edu
    Assign1
    class Commitee
    Used as attributes for masters and phd students
*/

//Created a new class called Committee that is required for Master and PhD students
public class Committee {
    private String name;
    private String comment;
    private Boolean approve;

    //constructors
    public Committee(){

    }

    public Committee(String name, String comment, Boolean approve) {
        this.name = name;
        this.comment = comment;
        this.approve = approve;
    }

    //getters
    public String getname(){
        return name;
    }

    public String getcomment() {
        return comment;
    }

    public Boolean getapprove() {
        return approve;
    }

    //setters
    public void setname(String name){
        this.name = name;
    }

    public void setcomment(String comment) {
        this.comment = comment;
    }

    public void setapprove(Boolean approve) {
        this.approve = approve;
    }

    // toString method prints out name, comment about thesis/dissertation and true/false if member approved
    public String toString() {
        return "\nName: " + name + "\nComment: " + comment + "\nApproval: " + approve;
    }
}