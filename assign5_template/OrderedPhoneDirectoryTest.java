package assign5_template;

/**
 * This class tests the implementation of OrderedPhoneDirectory. Sample Output
 * is given.
 */
public class OrderedPhoneDirectoryTest {

    public static void main(String[] args) {
        // create an empty ordered phone directory and test the constructor
        OrderedPhoneDirectory Philadelphia = new OrderedPhoneDirectory();
        // add 2 people
        System.out.println("Initial phone directory.");
        Philadelphia.addInOrder("Spongebob", "Squarepants", "123-453-5464");
        Philadelphia.addInOrder("Patrick", "Star", "143-543-3838");
        // test toString()
        System.out.println();
        System.out.println(Philadelphia);
        // test addInOrder: both success and failure
        System.out.println("Test addInOrder.");
        Philadelphia.addInOrder("Mr", "Krabs", "999-543-3838");
        Philadelphia.addInOrder("Spongebob", "Squarepants", "123-453-0000");
        System.out.println();
        System.out.println(Philadelphia);
        // test each search by name
        System.out.println("Returns phone number if first and last name match.");
        System.out.println(Philadelphia.search("Patrick", "Star"));
        System.out.println(Philadelphia.search("James", "Smith"));
        System.out.println();
        // test area code search
        System.out.println("Returns if area code matches.");
        System.out.println(Philadelphia.search(123));
        System.out.println(Philadelphia.search(215));
        System.out.println();
        // test set method: both success and failure
        System.out.println(Philadelphia.set("Spongebob", "Squarepants", "255-544-8588"));
        System.out.println(Philadelphia.set("Plank", "ton", "999-999-9999"));
        System.out.println();
        // test remove method: both success and failure
        Philadelphia.remove("Patrick", "Star");
        Philadelphia.remove("Bobby", "Fisher");
        System.out.println(Philadelphia);
    }
}
