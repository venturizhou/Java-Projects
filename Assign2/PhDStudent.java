package Assign2;

/*  
    CIS 2168 003
    Steven Zhou venturi@temple.edu
    Assign2
    class PhDStudent
    inherit student and adds four data fields, check for graduation
*/

public class PhDStudent extends Student {
    private Boolean passedQualifyingExam;
    private String dissertation;
    private String dissertationAdvisor;
    private Committee[] dissertationCommittee;
    // add new data fields: passedQualifyingExam, dissertation, dissertationAdvisor,
    // disserationCommittee

    // add two required constructors
    public PhDStudent() {

    }

    public PhDStudent(String id, String firstName, String lastName, String major, String degree, double gpa, int numberOfCreditsEarned,
            Boolean passedQualifyingExam, String dissertation, String dissertationAdvisor,
            Committee[] dissertationCommittee) {
        super(id, firstName, lastName, major, degree, gpa, numberOfCreditsEarned);
        this.passedQualifyingExam = passedQualifyingExam;
        this.dissertation = dissertation;
        this.dissertationAdvisor = dissertationAdvisor;
        this.dissertationCommittee = dissertationCommittee;
    }

    // add getters for all new data fields
    public Boolean getpassedQualifyingExam() {
        return passedQualifyingExam;
    }

    public String getdissertation() {
        return dissertation;
    }

    public String getdissertationAdvisor() {
        return dissertationAdvisor;
    }

    public Committee[] getdisserationCommittee() {
        return dissertationCommittee;
    }

    // add setters for all new data fields
    public void setpassedQualifyingExam(Boolean passedQualifyingExam) {
        this.passedQualifyingExam = passedQualifyingExam;
    }

    public void setdissertation(String dissertation) {
        this.dissertation = dissertation;
    }

    public void setdissertationAdvisor(String disserationAdvisor) {
        this.dissertationAdvisor = disserationAdvisor;
    }

    public void setdissertationCommittee(Committee[] dissertationCommittee) {
        this.dissertationCommittee = dissertationCommittee;
    }

    //check if student has 40 credits, GPA is 3.0, and if all committee members approved
    public boolean graduationCheck(){

        Boolean approve = true;

        for (Committee C: dissertationCommittee){
            if (C.getapprove() == false){
                approve = false;
                break;
            }
        }

        if (this.getGpa() >= 3.0 && this.getnumberOfCreditsEarned() >= 40 && approve && this.getpassedQualifyingExam())
            return true;
        return false;
    }

    // add new toString() method
    // If there are less than the required amount of commitee members, it will print
    // out a statement stating the requirement was not met.
    // Otherwise I loop through the committee array and cocatenate the information
    // for each committee member then add that information add the end after calling
    // Students toString and adding in the necessary information
    // I'm not sure how to handle the edge case of creating a Committee longer than
    // 4 but with less than 4 objects better than using a for loop and nullcounter
    public String toString() {
        int nullCounter = 0;
        for (int i = 0; i < dissertationCommittee.length; i++) {
            if (dissertationCommittee[i] == null)
                nullCounter++;
        }
        if (dissertationCommittee.length - nullCounter < 4)
            return "There must be at least four members on the committee.";
        else {
            String committee = "";
            for (int i = 0; i < dissertationCommittee.length; i++) {
                committee += dissertationCommittee[i] + "\n";
            }
            return super.toString() + "\nPassed Qualifying Exam: " + passedQualifyingExam + "\nDissertation Title; "
                    + dissertation + "\nDissertation Advisor: " + dissertationAdvisor + "\nCommittee\n" + committee;
        }
    }
}
