package Assign1;

/*  
    CIS 2168 003
    Steven Zhou venturi@temple.edu
    Assign1
    class MasterStudent
    inherit student and add three data fields
*/

public class MasterStudent extends Student {
    // add new data fields: thesis, thesisAdvisor, theisCommittee
    private String thesis;
    private String thesisAdvisor;
    private Committee[] thesisCommittee;

    // add two required constructors
    public MasterStudent() {

    }

    public MasterStudent(String id, String firstName, String lastName, String major, String degree, double gpa,
            String thesis, String thesisAdvisor, Committee[] thesisCommittee) {

        super(id, firstName, lastName, major, degree, gpa);
        this.thesis = thesis;
        this.thesisAdvisor = thesisAdvisor;
        this.thesisCommittee = thesisCommittee;
    }

    // add getters for all new data fields
    public String getthesis() {
        return thesis;
    }

    public String getthesisAdvisor() {
        return thesisAdvisor;
    }

    public Committee[] getthesisCommitee() {
        return thesisCommittee;
    }

    // add setters for all new data fields
    public void setthesis(String thesis) {
        this.thesis = thesis;
    }

    public void setthesisAdvisor(String thesisAdvisor) {
        this.thesisAdvisor = thesisAdvisor;
    }

    public void setthesisCommittee(Committee[] thesisCommittee) {
        this.thesisCommittee = thesisCommittee;
    }

    // add new toString() method
    // If there are less than the required amount of commitee members, it will print
    // out a statement stating the requirement was not met.
    // Otherwise I loop through the committee array and cocatenate the information
    // for each committee member then add that information add the end after calling
    // Students toString and adding in the necessary information
    public String toString() {
        int nullCounter = 0;
        for (int i = 0; i < thesisCommittee.length; i++) {
            if (thesisCommittee[i] == null)
                nullCounter++;
        }
        if (thesisCommittee.length-nullCounter < 3)
            return "There must be at least three members on the committee.";
        else {
            String committee = "";
            for (int i = 0; i < thesisCommittee.length; i++) {
                committee += thesisCommittee[i] + "\n";
            }
            return super.toString() + "\nCommittee\n" + committee;
        }
    }
}