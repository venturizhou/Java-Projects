Person
    - Create three data fields
        - Name and Degree were Strings
        - Skils was an arraylist
    - Standard getter and setters
    - toString was one line having the data fields seperate by |

Hiring App
    - Used a while loop and user input to drive the menu, until user entered the symbol to exit it would keep running
    - Combined applicants and fired employees into on ArrayDeque, working employees in another
        - New applicants would be added at the rear of unemployed
        - Fired employees would be pushed to the top of unemployed
        - This was it maintains the logic where recently fired would get hired first and applicant order is maintained from earliest applicant to most recent
    - popun and popem  
        -two functions created to populated employed and unemployed lists in case the tester doesn't want to manually add several applicants first, can be commented out
    - hire and fire 
        - print out information if either of the ArrayDeques are empty
        - otherwise uses the poll method to grab the top element
        - returns either person object or null
    - return is stored in temp variable, if it's not null then the person object is either pushed onto employed or unemployed 

