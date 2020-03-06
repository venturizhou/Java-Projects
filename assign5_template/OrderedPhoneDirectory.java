package assign5_template;

import java.util.LinkedList;

/*
Steven Zhou
CIS 2168 Sec 003
Assignment 5
 */
public class OrderedPhoneDirectory {
    LinkedList<PhoneDirectoryEntry> directory;

    // Initializes an empty linked list
    public OrderedPhoneDirectory() {
        this.directory = new LinkedList<PhoneDirectoryEntry>();
    }

    // Creates a phone directory entry then calls compareTo, if same then exit and
    // return false, if it's less than the current value insert at current index and move values down
    public boolean addInOrder(String firstName, String lastName, String phoneNumber) {
        PhoneDirectoryEntry temp = new PhoneDirectoryEntry(firstName, lastName, phoneNumber);
        for (int i = 0; i < directory.size(); i++) {
            if (temp.compareTo(directory.get(i)) == 0) {
                return false;
            }
            if (temp.compareTo(directory.get(i)) <= -1) {
                directory.add(i, temp);
                return true;
            }
        }
        directory.addLast(temp);
        return true;
    }


    //Prints firstname, lastname, and phonenumber and uses newline for each iteration through the loop
    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < directory.size(); i++) {
            temp += directory.get(i).getFirstName() + " " + directory.get(i).getLastName() + " "
                    + directory.get(i).getPhoneNumber() + "\n";
        }
        return temp;
    }

    // return the phone number of a given person.
    // return null if the person does not exist.
    public String search(String firstName, String lastName) {
        for (int i = 0; i < directory.size(); i++) {
            if (firstName == directory.get(i).getFirstName() && lastName == directory.get(i).getLastName()) {
                return directory.get(i).getPhoneNumber();
            }
        }
        return null;
    }

    // For simplicity, assume: no two people in the directory have the same phone
    // number.
    // search by given phone number, return the name in the format: firstname
    // lastname
    // return null if the given phone number does not exist.
    public String search(String phoneNumber) {
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i).getPhoneNumber() == phoneNumber) {
                return directory.get(i).getFirstName() + directory.get(i).getLastName();
            }
        }
        return null;
    }

    // return the list of names of people whose phone numbers have the given area
    // code.
    // return null if the area code does not exist in the phone directory.
    // Use the same format for all names found: firstname lastname or lastname,
    // firstname
    public LinkedList<String> search(int areaCode) {
        String area = String.valueOf(areaCode);
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i).getPhoneNumber().startsWith(area)) {
                String temp = directory.get(i).getFirstName() + " " + directory.get(i).getLastName();
                list.add(temp);
            }
        }
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    // change the phone number of the given person, return the old phone number.
    // return null if the given person does not exist.
    public String set(String firstName, String lastName, String newPhoneNumber) {
        for (int i = 0; i < directory.size(); i++) {
            if (firstName == directory.get(i).getFirstName() && lastName == directory.get(i).getLastName()) {
                String OldNumber = directory.get(i).getPhoneNumber();
                directory.get(i).setPhoneNumber(newPhoneNumber);
                return OldNumber;
            }
        }
        return null;
    }

    // remove the given person with the given name.
    // return true if the person exists and is removed, false otherwise.
    public boolean remove(String firstName, String lastName) {
        for (int i = 0; i < directory.size(); i++) {
            if (firstName == directory.get(i).getFirstName() && lastName == directory.get(i).getLastName()) {
                directory.remove(i);
                return true;
            }
        }
        return false;
    }
}
