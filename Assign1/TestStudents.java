package Assign1;

/*  
    CIS 2168 003
    Steven Zhou venturi@temple.edu
    Assign1
    class TestStudents
*/

public class TestStudents {
    public static void main(String[] args) {
        
        //Created an array of Commitee to test if toString on Masters and PhD students worked properly

        Committee [] Test = new Committee [4];
        Test[0] = new Committee("Bob","Passed", true);
        Test[1] = new Committee("Robby", "Nice", true);
        Test[2] = new Committee("Sarah","Good Job", true);
        Test[3] = new Committee("Fiona", "Awesome", true);

        //1. create an array of Student objects.
        //2. Create and add at least 3 students, 
        //   including one undergraduate, one master, one phd student
        //   add these students to the array

        Student [] cisDept = new Student[3];
        cisDept[0] = new Undergraduate("1","Ricky","Bobby","IST","Bachelor",3.6,"John","Smith");
        cisDept[1] = new MasterStudent("2","Stan","Smith","CS","Masters",3.9,"Cartoons","Sarah",Test);
        cisDept[2] = new PhDStudent("3","Louis","Griffin","DS","Doctorate",3.8,true,"Inequality","Chris",Test);

        //3. Use a loop to print the information about these students on the screen.
        //   Must use the toString() methods

        for(int i=0;i<cisDept.length;i++){
            System.out.println(cisDept[i]);
            System.out.println();
        }
    }
}
