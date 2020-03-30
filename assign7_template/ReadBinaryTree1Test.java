/** ReadBinaryTree1Test.java
* To be modified by you
* 
* Read a text file that contains the preorder traversal sequence of the data items in a binary tree
*    The preorder traversal sequence also shows the structure of the tree.
* Construct the binary tree accordingly.
* Display the preorder traversal sequence of the data items in the constructed binary tree,
*     which is the same as what is in the text file when the tree is constructed correctly.
*/

package assign7_template;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 *
 * @author Cindy
 */
public class ReadBinaryTree1Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree1<String> binaryTree1 = new BinaryTree1<>();

        try {
            
            //---Assign 7 Start -------//
            
            //Create a Scanner for reading from the data file WordBT_Data.txt
            //call the static method readBinaryTree1 to 
            //   create the binary tree using data read from file: WordBT_InStoredFormat.txt
            
            //call each method you implemented and verify the result.
            
            //---Assign 7 End -------//
            
            //the code below was given in the lectures and will be helpful for you.
            
            //create a Scanner object that is associated with the file Fig_6_12.txt.
            Scanner input = new Scanner(new File("Fig_6_12.txt"));
            //call the static method readBinaryTree1 to read data in Fig_6_12.txt
            //   and construct the corresponding binary tree
            //   and assign the reference to this tree to binaryTree1.
            binaryTree1 = BinaryTree1.readBinaryTree1(input);
            //close the scanner object.
            input.close();
            //print the string, which is the preorder traversal sequence of data stored in binaryTree1.
            System.out.println(binaryTree1.toString());
        }catch (FileNotFoundException e) { //handle the case when Fig_6_12.txt is not found.
            e.printStackTrace();    //Print the error stack: this exception, and its backtrace for the cause of this exception.
            System.exit(1);         //terminate this program with the status code 1, indicating abnormal termination.
        }
    }

}

