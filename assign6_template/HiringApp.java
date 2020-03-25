package assign6_template;

/*
Steven Zhou
CIS 2168 Sec 003
Assignment 6
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class HiringApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayDeque<Person> unemployed = new ArrayDeque<>();
        ArrayDeque<Person> employed = new ArrayDeque<>();

        Scanner input = new Scanner(System.in);
        int choice = 0;
        Person temp;
        //These methods populate the ArrayDeque with generic entries so don't have to manually put it in
        popem(employed);
        popun(unemployed);

        //Allows user to do mulitple actions until 3 is entered in to exit
        while (choice != 3) {
            System.out.println("\t0. Enter a new applicant.");
            System.out.println("\t1. Hire a new employee.");
            System.out.println("\t2. Fire a current employee.");
            System.out.println("\t3. Quit.");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 0) {
                newapplicant(unemployed, input);
            } else if (choice == 1) {
                temp = hire(unemployed);
                if (temp!=null){
                    System.out.println(temp.name + " has been hired.");
                    employed.push(temp);
                }
            } else if (choice == 2) {
                temp = fire(employed);
                if (temp!=null){
                    System.out.println(temp.name + " has been fired.");
                    unemployed.push(temp);
                }
            }
        }
        input.close();
        System.out.println();
        System.out.println("EMPLOYED");
        System.out.println(employed);
        System.out.println();
        System.out.println("UNEMPLOYED");
        System.out.println(unemployed);
    }

    // other methods for code modularization
    public static void newapplicant(ArrayDeque<Person> pool, Scanner input) {
        String name, degree;
        String choice = null;
        ArrayList<String> skills = new ArrayList<>();

        System.out.println("\tEnter applicant's name: ");
        name = input.nextLine();
        System.out.println("\tEnter applicant's degree:");
        degree = input.nextLine();

        System.out.println("\tPlease enter skills (at least one must be entered)");
        System.out.println("\tType Exit when finished.");

        while (skills.isEmpty() || !choice.equals("Exit")) {
            choice = input.nextLine();
            if (!choice.equals("Exit")) {
                skills.add(choice);
            }
        }
        Person temp = new Person(name, degree, skills);
        pool.addLast(temp);
    }

    public static Person hire(ArrayDeque<Person> unemployed){
        if(unemployed.isEmpty()){
            System.out.println("There are no employees to hire.");
        }return unemployed.poll();
    }

    public static Person fire(ArrayDeque<Person> employed){
        if(employed.isEmpty()){
            System.out.println("There are no employees to fire.");
        }return employed.poll();
    }

    public static void popun(ArrayDeque<Person> employed){
        ArrayList<String> skills = new ArrayList<>();
            skills.add("Python");
            skills.add("Java");
            skills.add("C++");
        Person first = new Person("Spongebob", "Bachelor", skills);
        Person second = new Person("Patrick", "MAsters", skills);
        Person third = new Person("Plankton", "PhD", skills);
        employed.add(first);
        employed.add(second);
        employed.add(third);
    }
    public static void popem(ArrayDeque<Person> unemployed){
        ArrayList<String> skills = new ArrayList<>();
            skills.add("Kotlin");
        Person first = new Person("Cyril", "Bachelor", skills);
        Person second = new Person("Pam", "MAsters", skills);
        Person third = new Person("Lana", "Bachelor", skills);
        unemployed.add(first);
        unemployed.add(second);
        unemployed.add(third);
    }
}
