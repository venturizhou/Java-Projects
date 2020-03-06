package Assign1;

/*  
    CIS 2168 003
    Steven Zhou venturi@temple.edu
    Assign1
    class Undergraduate
    inherit student and add two data fields
*/

public class Undergraduate extends Student {

    // add new data fields: generalEduAdvisor, majorAdvisor
    private String generalEduAdvisor;
    private String majorAdvisor;

    // add two required constructors
    public Undergraduate(){
        
    }
    
    public Undergraduate(String id, String firstName, String lastName, String major, String degree, double gpa,
            String generalEduAdvisor, String majorAdvisor) {

        super(id, firstName, lastName, major, degree, gpa);
        this.generalEduAdvisor = generalEduAdvisor;
        this.majorAdvisor = majorAdvisor;
    }

    // add getters for all new data fields
    public String getgeneralEduAdvisor() {
        return generalEduAdvisor;
    }

    public String getmajorAdvisor() {
        return majorAdvisor;
    }

    // add setters for all new data fields
    public void setgeneralEduAdvisor(String generalEduAdvisor) {
        this.generalEduAdvisor = generalEduAdvisor;
    }

    public void setmajorAdvisor(String majorAdvisor) {
        this.majorAdvisor = majorAdvisor;
    }

    // add new toString() method
    // called super to print out the information every student has and concatenate
    // with additional undergraduate student information
    public String toString() {
        return super.toString() + " generalEduAdvisor: " + generalEduAdvisor + " majorAdvisor: " + majorAdvisor;
    }
}
