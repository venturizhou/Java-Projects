package assign3_template;

import java.time.LocalDate;

/**
 * Steven Zhou 
 * CIS 2168 
 * Assign 3 
 * 2/12/20
 */
public class Assignment {
    private String courseid;
    private String assignmentname;
    private LocalDate duedate;

    public Assignment() {

    }

    public Assignment(String courseid, String assignmentname, LocalDate duedate) {
        this.courseid = courseid;
        this.assignmentname = assignmentname;
        this.duedate = duedate;
    }

    public String getcourseid() {
        return courseid;
    }

    public String getassignmentname() {
        return assignmentname;
    }

    public LocalDate getduedate() {
        return duedate;
    }

    public void setcourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setassignmentname(String assingmentname) {
        this.assignmentname = assingmentname;
    }

    public void setduedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public String toString() {
        return "Course: " + courseid + "\nAssignment: " + assignmentname + "\nDue: " + duedate;
    }
}
