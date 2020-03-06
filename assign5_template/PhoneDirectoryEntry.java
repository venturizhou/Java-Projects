package assign5_template;

/*
Steven Zhou
CIS 2168 003
Assignment 5
*/
//This class represents any entry in an ordered phone directory.
public class PhoneDirectoryEntry implements Comparable<PhoneDirectoryEntry>{
    
    //---------Assign 5 Begin --------------//
    //return
    //  0 if the name in this entry has same first name and last name as the other entry in the parameter
    //  1 if the name in this entry is alphabetically after the other entry in the parameter
    // -1 if the name in this entry is alphabetically before the other entry in the parameter
    public int compareTo(PhoneDirectoryEntry other) {
        if (this.lastName.compareTo(other.lastName) < 0)
            return -1;
        if (this.lastName.compareTo(other.lastName) > 0)
            return 1;
        if (this.firstName.compareTo(other.firstName) < 0)
            return -1;
        if (this.firstName.compareTo(other.firstName) > 0)
            return 1;
        return 0;
    }    
    
    //---------Assign 5 End --------------//
    
    //Following code is given to you. Don't need to change it.
    
    // Data Fields
    private String firstName;       
    private String lastName;    
    private String phoneNumber;      //phoneNumber format: 215-204-2940

    // Constructor
    public PhoneDirectoryEntry(String firstName, String lastName,
            String phoneNumber) {
        this.firstName = firstName;        
        this.lastName = lastName;        
        this.phoneNumber = phoneNumber;
    }

    //Methods: getters
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }    

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //Methods: Setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
