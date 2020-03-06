package assign4_template;

/**
 * CIS 2168 Section 003
 * Steven Zhou venturi@temple.edu
 * Assign 4
 * SimpleLinkedList.java
 * Added in the requested functions plus the bonus various ways to add, remove, get value of nodes in a linked list
 */
public class SimpleLinkedList {

    //-------Start of Assign 4  --------/  
    //You can call other methods to complete a method.
    //You can also add private methods, and then call these methods 
    //  to complete a method required in Assign 4.  
    
    //-----Required ---------------//    
    
    //Remove the specified item from the linked list. 
    // If success, return true. Otherwise, return false.
    public boolean removeByValue(int item) {
        Node current = head;
        Node previous = null;
        while (current.next != null && current.data != item){
            previous = current;
            current = current.next;
        }if (current.data == item){
            previous.next = current.next;
            return true;
        }
        return false;
    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    public void add(int index, int item) {
        if (index < 0 || index > this.size + 1){
            System.out.println("Index out of bounds");
        }
        else if (index == this.size+1){
            add(item);
        }
        else{
            Node current = this.head;
            for(int i = 0; i < index-1; i++){
                current = current.next;
            }Node temp = current.next;
            current.next = new Node(item);
            current.next.next = temp;
        }
    }

    //get the item at [index]
    public int get(int index) {
        if (index < size){
            Node current = this.head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            return current.data;
        }System.out.println("Index out of bounds!");
        return Integer.MIN_VALUE;
    }

    //get the location of item
    public int indexOf(int item) {
        Node current = this.head;
        int count = 0;
        while (current != null && current.data != item){
            current = current.next;
            count++;
            }
        if (current == null){
            return -1;
        }
        return count;
    }

    //checks if contains
    public boolean contains(int item) {
        Node current = this.head;
        while (current != null){
            if (current.data == item){
                return true;
            }current = current.next;
        }
        return false;
    }

    //return how many integers are in this list
    public int size() {
        // Node current = this.head;
        // int count = 0;
        // while (current != null){
        //     count++;
        //     current = current.next;
        // }
        // //add your own code
        // return count;
        return this.size;
    }

    //-----Bonus ---------------//
    
    //Remove the item at the specified position from the linked list. 
    //  Return the removed item if success, Integer.MIN_VALUE otherwise.
    public int removeByIndex(int index) {
        Node current = head;
        Node previous = null;
        if (index < size){
            for(int i = 0; i < index; i++){
                previous = current;
                current = current.next;
            }
            if (previous != null){
                previous.next = current.next;
            }
            Node temp = current;
            return temp.data;
        }return Integer.MIN_VALUE;
    }      
    
    
    //-------End of Assign 4 --------/    
    
    
    //Following code were covered in Lec#7. 
    //Don't change them.
    
    //Nested class Node, enclosing class: SimpleLinkedList
    //static: class Node can not access other members in the enclosing class SimpleLinkedList
    //private: only the enclosing class SimpleLinkedList can directly use class Node
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
        String result = "";     //result string

        //solution 1:
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
