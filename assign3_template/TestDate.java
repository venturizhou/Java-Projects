//File: TestDate.java
//* This file is for demo how to use the old Java 7 API.
//*   for handling dates related to Lab 4 - Assign 3.
//* Simple examples of using Java classes: java.util.Date, java.text.DateFormat, and java.util.Locale.
//* For Lab 4 - Assign 3, you only need java.util.Date and java.text.DateFormat if your operating system date and time is USA format.
//* Note about using the constructor of java.util.Date class.
    // In all methods of class Date that accept or return year, month, date (day in a month), hours, minutes, and seconds values, the following representations are used:
    //    A year y is represented by the integer y - 1900.
    //    A month is represented by an integer from 0 to 11; 0 is January, 1 is February, and so forth; thus 11 is December.
    //    A date (day in a month) is represented by an integer from 1 to 31 in the usual manner. 
//* Note about Date format styles and Locales
    //  Sample Date format styles in 2 sample locales
    //  Style 	U.S. Locale             French Locale
    //  DEFAULT Jun 30, 2009            30 june 2009
    //  SHORT 	6/30/09                 30/06/09
    //  MEDIUM 	Jun 30, 2009            30 june 2009
    //  LONG 	June 30, 2009           30 june 2009
    //  FULL 	Tuesday, June 30, 2009 	mardi 30 june 2009

package assign3_template;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

/**
 *
 * @author cindy
 */
public class TestDate {

    public static void main(String[] args) {
        //1. Create Date objects       
        
        Date date1 = new Date();       //the Date value for today when the program is executed.
        //For the date in US format: 9/30/2018 (Sep. 30, 2018)
        //   call constructor: Date(int year, int month, int date), where the parameters mean:
        //      year: the value of (yearInTheDate - 1900)
        //      month: the value of (monthInTheDate - 1)
        //      date: the dayOfMonth in the Date value.
        Date date2 = new Date(2018 - 1900, 9 - 1, 30);
        //call toString() in Date class to get and print the date and time values.
        System.out.println("date1: \n" + date1);
        System.out.println("date2: \n" + date2);

        //2. Compare two Date values
        
        //2.1 use different methods: before(...), after(...), equals(...)
        if (date1.after(date2)) {
            System.out.println("\n" + date1 + " is after " + date2);
        }
        
        if (date1.equals(date2)) {
            System.out.println(date1 + " is on same date as " + date2);            
        }
        
        if (date1.before(date2)) {
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
        
        //3. Format Date values
        
        //3.1 Format Date values in US format
        
        Date todayIn = new Date();      //Date value before the formatting
        String todayOut;                //Date value as string after being formatted
        DateFormat myDateFormatter;     //a formatter for formatting Date values
        //get a Date Formatter that uses DEFAULT style of Date format
        //      and the default FORMAT locale (i.e. the locale for formatting date, time values)
        //The DEFAULT style for Date values in US format: Jun 30, 2018 for June 30, 2018.
        myDateFormatter = DateFormat.getDateInstance(); 
        //call format(...) method in DateFormat class to format the Date value 
        //   in the style and locale associated with the DateFormat object: myDateFormatter.
        todayOut = myDateFormatter.format(todayIn);
        System.out.println("\ntoday in DEFAULT style in my local system: \n" + todayOut);
        
        //To display the Date value in US as: 6/30/2018 for June 30, 2018
        //This is what is required in Lab 4 - Assign 2
        myDateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        todayOut = myDateFormatter.format(todayIn);
        System.out.println("\ntoday in SHORT style in my local system: \n" + todayOut);        

        //3.2 Format Date values in the format associated with a given local tyle
        
        Locale currentLocale = Locale.FRANCE;  //set current Locale to FRANCE style
        //get a Date formatter that uses the DEFAULT style for Date value and the given Locale for formatting date and time values.
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);  
        todayOut = dateFormatter.format(todayIn);
        System.out.println("\ntoday in DEFAULT style in the " + currentLocale.toString() + " system: \n" + todayOut);
        
        
    }
}

/*-----Sample Program Output
date1: 
Mon Feb 03 11:47:00 EST 2020
date2: 
Sun Sep 30 00:00:00 EDT 2018

Mon Feb 03 11:47:00 EST 2020 is after Sun Sep 30 00:00:00 EDT 2018
Mon Feb 03 11:47:00 EST 2020 is after Sun Sep 30 00:00:00 EDT 2018

today in DEFAULT style in my local system: 
Feb 3, 2020

today in SHORT style in my local system: 
2/3/20

today in DEFAULT style in the fr_FR system: 
3 févr. 2020
*/