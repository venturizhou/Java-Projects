package midtermprep;

/**
 * Generic Single Linked List. 
 * Content is revised a little bit for accommodating the practice questions for the midterm test.
 * The generic type parameter E is specified to implement the Comparable interface.
 */
//Add more restriction about the type parameter E. E must implement the Comparable interface.
public class SingleLinkedList<E extends Comparable<E>> { 

    //-------Midterm Prep, Practice Q3--------// 
    //Big-O: O(n)
    public E getMax(){
        if (head == null) {
            return null;
        }
        E max = head.data;
        Node<E> current = head.next;
        while (current != null) {
            if (current.data.compareTo(max) > 0) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }    
    //-------Midterm Prep End--------//
        
    
    
    
    //---The rest is the same as what's lectured for Chapter 2---//
    
    
    //---------------Private Node<E> Class Implementation START ------------------//
    /*<listing chapter="2" number="1">*/
    /**
     * A Node is the building block for the SingleLinkedList.
     * It's a Static nested Class.
     */
    private static class Node<E> { //mark the class as generic using <E>

        //Data Fields of Node<E> class
        /**
         * The reference to the data.
         */
        private E data;
        /**
         * The reference to the next node
         */
        private Node<E> next = null;

        //Constructors
        /**
         * Creates a new standalone node where next data field is null.
         *
         * @param dataItem - The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Create a new node that is singly linked to another node.
         *
         * @param dataItem - The data stored
         * @param successorNodeRef - The reference to the successor node of the new node
         */
        private Node(E dataItem, Node<E> successorNodeRef) {
            data = dataItem;
            next = successorNodeRef;
        }

    }
    /*</listing>*/
    //---------------Private Node<E> Class Implementation END------------------//
    
    
    //---------------Use Node<E> class Directly START -------------------------//
    //demo: how to connect nodes directly inside class SingleLinkedList<E>.
    public static void main(String[] args) {
        //create 4 Node<String> objects with given data values.
        //Have 4 reference variables pointing to them respectively.
        Node<String> tom = new Node<String>("Tom");
        Node<String> dick = new Node<String>("Dick");
        Node<String> harry = new Node<String>("Harry");
        Node<String> sam = new Node<String>("Sam");

        //create a friend list.
        //connect Node<String> objects directly
        tom.next = dick;
        dick.next = harry;
        harry.next = sam;

        //add Bill before Tom
        //Method 1:
        //Node<String> bill = new Node<String>("Bill");
        //bill.next = tom;
        //Method 2
        Node<String> bill = new Node<String>("Bill", tom);

        //add Sue in between Harry and Sam
        Node<String> sue = new Node<String>("Sue", sam);
        //make Sue right after Harry, Method 1:
        harry.next = sue; 
        //make Sue right after Harry, Method 2:
        //  dick.next.next = sue;
        //make Sue right after Harry, Method 3:
        //  tom.next.next.next = sue;

        //Remove Dick
        //Method 1:
        tom.next = harry;        
        //Method 2:
        //  tom.next = dick.next;
        //Method 3:
        //  tom.next = tom.next.next;        
        
        
        //connect Node<Integer> objects directly
        //Run these lines and check the list yourself.
        Node<Integer> number1 = new Node<Integer>(10);
        Node<Integer> number2 = new Node<Integer>(20);
        number1.next = number2;

    }
    //---------------Use Node<E> class Directly END -------------------------//
    
    
    //--------------SingleLinkedList<E> Implementation START-----------------//
    
    // Data fields of SingleLinkedList<E> class
    
    /**
     * A reference to the first node in the list
     */
    private Node<E> head = null;
    /**
     * The number of items in the list
     */
    private int size = 0;
    
    
    /**
     * Add an item to the front of the list.
     *
     * @param item The item to be added
     */
    public void addFirst(E item) {
        //create a new Node (data: item, next: pointing to current first node)
        //make head point to this new Node
        head = new Node<E>(item, head);
        size++;
        
        //Soln 2:
        //Node<E> newFirst = new Node<E>(item, head);
        //head = newFirst;
        //size++;
    }

    //--------- Private Helper Methods: Begin -------------------//
    /**
     * Add an item after a given node in the parameter
     *
     * @param node The given node preceding the new item after the operation is completed.
     *             (Assume node is not null when entering the method).
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item) {
        //The given node: the node referenced by the parameter: node.
        //create a new Node (data: item, next: pointing to the given node's current successor node)
        // and make the given node's next data field point to this new Node        
        node.next = new Node<E>(item, node.next);
        size++;
        
        //Solution 2:
            //create a new Node (data: item, next: pointing to the given node's current successor node)        
        //Node<E> newNode = new Node<E>(item, node.next);
            //make the given node's next data field point to this new Node 
        //node.next = newNode;
    }

    /**
     * Remove the first node from the list
     *
     * @returns The removed node's data or null if the list is empty
     */
    private E removeFirst() {
        Node<E> temp = head;    //save the reference to the first node in this single linked list
        if (head != null) {     //this list is not empty.
            head = head.next;   //make head point to the old 2nd node in this list
        }
        //return data at old first node or null if this list is empty
        if (temp != null) {     //if this list is not empty
            size--;
            return temp.data;   //return the data in the old first node
        } else {
            return null;
        }
        
        //Solution 2:
        /*
        if (head != null) {             //this list is not empty
            Node<E> oldFirst = head;    //save a reference to old first node
            head = head.next;           //make head point to old 2nd node
            size--;
            return oldFirst.data;
        }
        return null; 
        */
    }

    /**
     * Remove the item after a given node
     *
     * @param node The node preceding the one to be removed. 
     *             (Assume node is not null when entering the method).
     * @returns The data at the removed node, or null if there is no node to remove.
     */
    private E removeAfter(Node<E> node) { //Given node: the node referenced by the parameter: node
        Node<E> temp = node.next;         //save a reference to the given node's successor node.
        if (temp != null) {               //if given node is not last node on this linked list
            node.next = temp.next;        //make the given node's data field next point to its successor's successor.
            size--;
            return temp.data;
        } else {
            return null;
        }
        
        //Solution 2:
        /*
        Node<E> successor = node.next;     //save a reference to the sucessor node
        if (node.next != null) {           //if the sucessor exists
            node.next = node.next.next;    //make given node's data field next point to its sucessor's sucessor
            size--;
            return successor.data;
        }
        else {
            return null;
        }
        */
    }

    /**
     * Get the node at the specified position (i.e. index)
     *
     * @param index The position (i.e. index) of the node sought.
     * @returns The node at index or null if it does not exist
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;                //make the first node the current node to check
        for (int i = 0;                     //initialize index counter i to first position 0
                i < index && node != null; //if counter i has not reached target index, and there are still nodes to check.
                i++) {                      //increament counter i
            node = node.next;               //move on to the next node in this linked list
        }
        return node;
        
        //Solution 2:
        /*
        int i = 0;                      //initialize index counter i to 0
        Node<E> current = head;         //initialize current node reference to head
        while (i < index && current != null) { //not reached the target index and not checked all nodes yet
            current = current.next;     //move on to the next node.
            i++;
        }
        */
    }
    //--------- Private Helper Methods: End-------------------//
    
    
    //--------- Public Methods: More ------------------------//
    /**
     * Get the data item at the specific position (i.e. index)
     *
     * @param index The position(i.e. index) of the data item to return
     * @returns The data item at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {  //invalid index
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> targetNode = getNode(index);     //call private method getNode(..) to get the desired node
        return targetNode.data;
    }

    /**
     * Change the data item at the given position (index). 
     * Store a reference to the new value in the element at the given position (index)
     *
     * @param index The position(index) of the item to change
     * @param newValue The new value
     * @returns The data value previously at the same index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {   //invalid index
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> targetNode = getNode(index);  //call private method getNode(..) to get the desired node
        E result = targetNode.data;
        targetNode.data = newValue;
        return result;
    }

    /**
     * Insert the specified item at the specified index. 
     * If insertion is successful, the indices of any subsequent elements will be increased by 1. 
     *
     * @param index The position where the given item is to be inserted
     * @param item The given item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {        //invalid index
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {                       //Given index is first position
            addFirst(item);                     //call public method: addFirst(....) to do the insertion
        } else {
            //call private getNode(...) to get the predecessor node
            Node<E> predecessorNodeRef = getNode(index - 1);
            //call private addAfter(..) to add the given item after the precedessor.
            addAfter(predecessorNodeRef, item);
        }
    }

    /**
     * Append the given item to the end of this list
     *
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        //call add(int index, E item) to complete the task, passing this list's current size as target position
        add(size, item);
        return true;
    }

    /**
     * Obtain a string representation of the list
     *
     * @return A String representation of the list
     */
    @Override
    public String toString() {
        //Create a StringBuilding object with initial string value "[".
        StringBuilder sbListInfo = new StringBuilder("[");
        //current point to the current node being processed
        //make current point to the first node.
        Node<E> current = head;
        while (current != null) { //if haven't checked all nodes on this linked list
            sbListInfo.append(current.data.toString());   //append the current node's data value String to the result string
            if (current.next != null) {   //add this condition if don't want to display , after the last item
                sbListInfo.append(", ");
            }
            current = current.next;       //move on the next Node<E> on this linked list
        }
        sbListInfo.append("]");
        return sbListInfo.toString();     //place the result string into a String object, return the String object
    }

    //-------Following are section exercises to be completed by you. ----------//
    //get the current size
    public int size() {
        // to be completed by you
        return 0;
    }

    //locate a given item by value
    public int indexOf(E item) {
        // to be completed by you        
        return 0;
    }

    //remove by location
    public E remove(int index) {
        // to be completed by you        
        return null;
    }

    //remove by value
    public boolean remove(E item) {
        // to be completed by you    
        return false;
    }

    //implementation without calling helper methods      
    public void add2(int index, E item) {
        // to be completed by you 
      
    }
}
/*</listing>*/
