//File: TestDateJava8.java
//* This file is for demo how to use the new Java 8 API.
//*   for handling dates related to Lab 4 - Assign 3.
//* Simple examples of using Java classes: 
//*   java.time.LocalDate, java.time.Month, java.time.format.DateTimeFormatter, java.time.format.FormatStyle.
//* For Lab 4 - Assign 3, you only need the 4 classes above if your operating system date and time is in USA format.

//* Note about Format Styles and Locales
    //  Sample date format styles in 2 sample locales
    //  Style 	U.S. Locale             French Locale
    //  SHORT 	6/30/09                 30/06/09
    //  MEDIUM 	Jun 30, 2009            30 june 2009
    //  LONG 	June 30, 2009           30 june 2009
    //  FULL 	Tuesday, June 30, 2009 	mardi 30 june 2009

package assign3_template;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Cindy Li
 */
public class TestDateJava8 {

    public static void main(String[] args) {
        //1. create LocalDate objects
        
        //1.1 public static LocalDate now()
        //Get the LocalDate object for today when the program is executed.
        LocalDate date1 = LocalDate.now();  
        
        //1.2 static LocalDate 	of(int year, int month, int dayOfMonth)
        //Get a LocalDate object based on the given year, month, and dayOfMonth.
        
        //Example 1:         
        //For the date in US format: 9/30/2018 (Sep. 30, 2018)
        //   call static method of(int year, int month, int dayOfMonth), where the parameters mean:
        //      year in the local date value
        //      month in the local date value, 1 for January, 2 for February, etc.
        //      dayOfMonth: the day of the month in the local date value.
        LocalDate date2 = LocalDate.of(2018, 9, 30);
        
        //Example 2:          
        //for the same local date in US format: 9/30/2018 (Sep. 30, 2018),
        //   call the same static method of(int year, int month, int dayOfMonth)
        //     but use the constant Month.SEPTEMBER, instead of an int value.
        LocalDate date3 = LocalDate.of(2018, Month.SEPTEMBER, 30);   
        
        //1.3 public static LocalDate parse(CharSequence text)
        //Get a LocalDate object from a text string in the form: 
        //   YYYY-MM-DD like 2020-02-14 for February 14, 2020.         
        
        //Example: 
        //For the date in US format: 9/30/2018 (Sep. 30, 2018)
        //   call static method LocalDate parse(CharSequence text)
        //NOTE: 
        //   MUSE use exactly 2 digits for the month, and 2 digits for the day.
        //   Using "2018-9-30" will cause a runtime error.
        LocalDate date4 = LocalDate.parse("2018-09-30");
        
        System.out.println("d1: " + date1);
        System.out.println("d2: " + date2);
        System.out.println("d3: " + date3);  
        System.out.println("d4: " + date4);               
        
        //2. Compare two Date values
        
        //2.1 use different methods: isBefore(...), isAfter(...), equals(...)
        if (date1.isAfter(date2)) {
            System.out.println("\n" + date1 + " is after " + date2);
        }
        
        if (date1.equals(date2)) {
            System.out.println(date1 + " is on same date as " + date2);            
        }
        
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        }
        
        //2.2 use one method: compareTo(...)
        if (date1.compareTo(date2) > 0) {
            System.out.println(date1 + " is after " + date2);
        }        
        else if (date1.compareTo(date2) == 0) {
            System.out.println(date1 + " is on same date as " + date2);            
        }       
        else {
            System.out.println(date1 + " is before " + date2);
        }
        
        //3. Format local date values      
        
        //3.1 format the local date value in LONG style
        
        LocalDate todayIn = LocalDate.now();   //local date value before the formatting
        String todayOut;                       //local date value as string after being formatted
        DateTimeFormatter myDateFormatter;     //a formatter for formatting the local date values
        //get a DateTimeFormatter that uses LONG style for local date values.
        //The LONG style for local US date values: June 30, 2018 for 6/30/2018.
        myDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        //call format(...) method in DateTimeFormatter class to format the date value 
        //   in the style and locale associated with the DateTimeFormatter object: myDateFormatter.
        todayOut = myDateFormatter.format(todayIn);
        System.out.println("\ntoday in LONG style in my local system: \n" + todayOut);
        
        //3.2 format the local date value in SHORT style        
        
        //To display the date value in US as: 6/30/2018 for June 30, 2018
        //This is what is required in Lab 4 - Assign 3
        myDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        todayOut = myDateFormatter.format(todayIn);
        System.out.println("\ntoday in SHORT style in my local system: \n" + todayOut);       
               
    }
}

/*-----Program Output
d1: 2020-02-05
d2: 2018-09-30
d3: 2018-09-30
d4: 2018-09-30

2020-02-05 is after 2018-09-30
2020-02-05 is after 2018-09-30

today in LONG style in my local system: 
February 5, 2020

today in SHORT style in my local system: 
2/5/20
*/