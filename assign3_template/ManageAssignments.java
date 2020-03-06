package assign3_template;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Steven Zhou 
 * CIS 2168 
 * Assign 3 
 * 2/12/20
 */
public class ManageAssignments {

    public static void main(String[] args) {
        LinkedList<Assignment> Assign = new LinkedList<Assignment>();
        Scanner user = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Assignment Manager.");
        System.out.println();
        do {
            textMenu();
            choice = user.nextInt();
            switch (choice) {
            case 1:
                addAssignment(Assign, user);
                break;
            case 2:
                removeAssignment(Assign, user);
                break;
            case 3:
                printAssign(Assign);
                break;
            case 4:
                nextDue(Assign);
                break;
            default:
                continue;
            }
        } while (choice != -1);
        user.close();
    }

    // text menu for users
    public static void textMenu() {
        System.out.println("Please choose from the following menu.");
        System.out.println("");
        System.out.println("\t1. Add new assignment.");
        System.out.println("\t2. Remove assignment.");
        System.out.println("\t3. Order of assignments as entered.");
        System.out.println("\t4. Next assignment due.");
        System.out.println("\tOr enter -1 to exit.");
    }

    // takes in three user inputs to create assignment object then add to list
    public static void addAssignment(LinkedList<Assignment> Assign, Scanner user) {
        user.nextLine();
        System.out.println("Please enter courseid: ");
        String course = user.nextLine();
        System.out.println("Please enter assignment name: ");
        String assignment = user.nextLine();
        System.out.println("Please enter due date in the format: yyyy-mm-dd");
        LocalDate duedate = LocalDate.parse(user.nextLine());
        Assign.add(new Assignment(course, assignment, duedate));
    }

    // remove assignment at specified location, offset by 1 in case user is not
    // familiar with indexing
    public static void removeAssignment(LinkedList<Assignment> Assign, Scanner user) {
        if (Assign.size() == 0){
            System.out.println("No assignments.");
            return;
        }
        user.nextLine();
        System.out.println("Enter number of assignment you want removed (1 - " + Assign.size() + ")");
        int remove = user.nextInt();
        if (remove > 0 && remove - 1 <= Assign.size()) {
            Assign.remove(remove - 1);
        } else {
            System.out.println("Not a valid entry.");
        }
    }

    // iterates through the LinkedList and prints out seperate assignments on new
    // lines
    public static void printAssign(LinkedList<Assignment> Assign) {
        if (Assign.size() == 0){
            System.out.println("No assignments.");
            return;
        }
        String printOut = Assign.get(0).toString();
        for (int i = 1; i < Assign.size(); i++) {
            printOut += "\n" + "\n" + Assign.get(i).toString();
        }
        System.out.println(printOut);
    }

    // iterates through and uses ifBefore to find out the earliest due date item
    public static void nextDue(LinkedList<Assignment> Assign) {
        if (Assign.size() == 0){
            System.out.println("No Entries");
            return;
        }
        int index = 0;
        for (int i = 1; i < Assign.size(); ++i) {
            if (Assign.get(i).getduedate().isBefore(Assign.get(index).getduedate())) {
                index = i;
            }
        }
        System.out.println(Assign.get(index));
    }
}
