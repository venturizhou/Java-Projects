//Note to Students: 
//  This file is provided for you to your implementation
//    of comparedTo method in PhoneDirectoryEntry.

package assign5_template;

/**
 *
 * @author cindy
 */
public class PhoneDirectoryEntryTest {
    
    //used to test implementation of compareTo() methods
    public static void main(String[] args) {
        PhoneDirectoryEntry bill = new PhoneDirectoryEntry("Bill", "Gates", "111-111-1111");
        PhoneDirectoryEntry melinda = new PhoneDirectoryEntry("Melinda", "Gates", "111-111-2222");
        PhoneDirectoryEntry mark = new PhoneDirectoryEntry("Mark", "Zuckburg", "222-222-2222");
        PhoneDirectoryEntry larry = new PhoneDirectoryEntry("Larry", "Elison", "333-333-3333");
        
        System.out.println(bill.compareTo(bill));           
        System.out.println(bill.compareTo(melinda));
        System.out.println(bill.compareTo(mark));     
        System.out.println(mark.compareTo(larry));          
    }    
}

/* Program Output if your implementation is correct.
0
-1
-1
1
*/