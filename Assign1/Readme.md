For this assignment I mostly just made sure that all the subclasses of Student followed the same format. Setting up the data fields to be private, creating a constructor that took no parameters.

Created a committee class that had attributes as required by the assignment. I was not sure how to handle the scenario of creating a committee array longer than the minumum required (3 for masters and 4 for PhD) but the array list doesn't contain enough objects.

For example I create an array with length 5, but only put 2 objects inside. It would still pass my if statement in the toString. I was looking into raising a custom exception but wasn't sure how to implement the parameter. I wasn't satisfied with the nullcounter strategy of substracing the amount of nulls from length of the array. It seems a bit clunky but didn't think of a better method.

Other than making the code more efficient/clean. It runs fine and prints out the proper information. 