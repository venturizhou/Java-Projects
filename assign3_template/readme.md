Creating the Assignment class was simliar to previous ones except we used a new data type known as LocalDate.

Main class I broke it down into several functions

- Print text interface
- Add assignment to list
- Remove assignment from list
- Print list
- Print earliest due date

For main I create a while loop that would always print out the text interface at least once and print out verytime the user completed an action. I create a switch depending on what the user entered 1-4, -1, and if it was not any of those it just runs the while loop again. 

Add assignment asked for three user inputs, course, assignment, and localdate. I specified a format for the user, if they did not follow that it will output a localdate time parse error and stop the program. 

Remove assignment gave the user a list of integers to choose from. I offset by one in case user was not familiar with now computer indexing work and called .remove() to remove the assignment at that number. 

Print list simply runs a loop and prints out the toString for every object. 

Print earliest due compares the LocalDate with isBefore and prints out the object with the earliest localdate. 