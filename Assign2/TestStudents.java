package Assign2;

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

        Student [] cisDept = new Student[4];
        cisDept[0] = new Undergraduate("1","Ricky","Bobby","IST","Bachelor",3.6,120,"John","Smith");
        cisDept[1] = new MasterStudent("2","Stan","Smith","CS","Masters",3.9,30,"Cartoons","Sarah",Test);
        cisDept[2] = new PhDStudent("3","Louis","Griffin","DS","Doctorate",3.8,40,true,"Inequality","Chris",Test);
        cisDept[3] = new Undergraduate("4","Licky","Bobby","IST","Bachelor",3.6,100,"John","Smith");

        //loops through student list and checks if they have passed the graduation checks

        for(int i=0;i<cisDept.length;i++){
            System.out.println(cisDept[i].graduationCheck());
            System.out.println();
        }

        //min should produce index 3 and max should produce index 1

        System.out.println(indexOfMin(cisDept));
        System.out.println(indexOfMax(cisDept));
        Student Bob = new Undergraduate("1","Ricky","Bobby","IST","Bachelor",3.6,120,"John","Smith");
        System.out.println(Bob.toString());
    }
        //return index of last student when sorted

        public static int indexOfMin(Student[] myDept){
            int min = 0;
            for (int i = 1; i<myDept.length; i++){
                if (myDept[min].compareTo(myDept[i])>0){
                    min = i;
                }
            }
            return min;

        }
        //return index of first student when sorted
        
        public static int indexOfMax(Student[] myDept){
            int max = 0;
            for (int i = 1; i<myDept.length; i++){
                if (myDept[max].compareTo(myDept[i])<0){
                    max = i;
                }
            }
            return max;
        }
    
}
