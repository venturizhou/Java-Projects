package midtermprep;

/**
 *  * Implement a single linked list of integers of int type,
 *     using a private Node class.
 * Code not in the textbook.
 * 
 * @author cindy
 */
public class SimpleLinkedList {

    //-------Midterm Prep, Practice Q2--------//
    //Big O: O(n)
    public int getMax(){
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    } 
    //-------Midterm Prep End--------//     
    
    
    //---The rest is the same as what's lectured for Chapter 2---//
    
    //Nested class Node, enclosing class (parent class): SimpleLinkedList.
    //static: class Node can not access other members in the enclosing class SimpleLinkedList.
    //private: only the enclosing class SimpleLinkedList can directly use class Node.
    private static class Node {  
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //the reference to the first Node in the linked list.
    private Node head;
    //the size of the linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }
   
    //append newItem
    public void add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
    }

    //return a string that contains all integers (in the original sequence) in the linked list.
    @Override
    public String toString() {
        String listInfo = "";     //listInfo string

        //solution 1:
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            listInfo += current.data; //add the integer in current Node to the listInfo string
            listInfo += "-->";        
            current = current.next; //move on to the next Node
        }
        return listInfo;
    }
}
