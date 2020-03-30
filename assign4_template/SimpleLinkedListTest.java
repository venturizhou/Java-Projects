package assign4_template;

/**
 * CIS 2168 Section 003
 * Steven Zhou venturi@temple.edu
 * Assign4
 * Testing different methods (successful and failed calls)
 * The methods are tested to be True the first time and False the second
 */
public class SimpleLinkedListTest {

    public static void main(String[] args) {
        //--Following code were given in Lec#7 --//
        
        //create an empty list
        SimpleLinkedList numbers = new SimpleLinkedList();
        
        //append 3 integers
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        //dump the contents in the list in the original order
        System.out.println(numbers.toString());
        System.out.println(numbers.size());
        System.out.println();
        //or use:
        //System.out.println(numbers);
        
        //add
        System.out.println("Add Function");
        numbers.add(25,1); 
        System.out.println(numbers.toString());
        numbers.add(0,5);
        numbers.add(1,25); 
        numbers.add(4,50);
        System.out.println(numbers.toString());
        System.out.println();
        //get
        System.out.println("Get Function");
        System.out.println(numbers.get(2));
        System.out.println(numbers.get(5));
        System.out.println();
        //indexOf
        System.out.println("IndexOf Function");
        System.out.println(numbers.indexOf(20));
        System.out.println(numbers.indexOf(39));
        System.out.println();
        //contains
        System.out.println("Contains Function");
        System.out.println(numbers.contains(25));
        System.out.println(numbers.contains(21));
        System.out.println();
        //remove by value
        System.out.println("Remove by Value Function");
        System.out.println(numbers.removeByValue(25));
        System.out.println(numbers.removeByValue(19));
        System.out.println(numbers.toString());
        System.out.println();
        //remove by index
        System.out.println("Remove by Index Function - Bonus");
        System.out.println(numbers.toString());
        System.out.println(numbers.removeByIndex(0));
        System.out.println(numbers.removeByIndex(5));
        System.out.println(numbers.toString());
    }   
    
}
