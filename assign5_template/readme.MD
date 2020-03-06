Used a bunch of if else statements to first return 1 or -1 if last name matched. If those parameters were not met then it would proceed down to comparing the first names. If those still didn't result in a return statement then it would default return 0 and the number would not be added. 

The orderphoned directory intilized an empty linked list using the phone directory entry object. 

Add in order called the compareTO method as it iterated through the list. If the name matched then it would return false and not add the number. Otherwise it would test if the compareTo valute was less than the next value in the list in order to determine where it was ordered. As default if it was not able to evaluate to less than another entry it would be added to the end of the list. 

The search by methods iterated through the linked list checking if the first and last name matched for one method. 

For area code, I converted the int to a String then checked if the phone number started with the substring created by the area code. 