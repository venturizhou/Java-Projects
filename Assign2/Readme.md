For assignment 2 I included the extra credit portion as well as the required compareto implement.

The extra credit required added an abstract method from the parent class of Student that needed to be implemented in master, undergradute, and PHD. It was a boolean method that had at least a credit and GPA requirement from all of the subclasses. 

Since I create a committee object for the masters and PHD student I had to loop through them and if any committee member did not approve then it would make the approval component of my graduation check false. 

For the compareTo method in the Student class, I simply used the built in compareTO provided by the String class and it would lexicographically compare them. It wasn't necessary to create my out if else statements because they would return -1, 0, 1 by themselves and I could use those values in my control flow. 