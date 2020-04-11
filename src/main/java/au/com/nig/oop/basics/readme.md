This exercise's goal is to look into OOP basic principles

*For each of these instructions do them first in Java then in Kotlin.*

* Create a class Employee 
* Add a few fields: firstName, lastName (as strings), create the associated constructor for it. In the Main class 
print the result of an instanciation of am employee. If the result is un-readable make it readable. 
* These fields can be accessible from outside the class. Print them in the main. **But they cannot be set. They must stay immutable** 
* For the fun propose two ways to do it: with fields firstName, lastName and  firstName2, lastName2.
* Add a new field date of birth (an instant should work fine for now). This field does not have to be passed in each 
of the instanciation and can be null by default.
* Provide the capacity to get the date of birth as well as the capacity of setting the value
* Propose a function that gives us the age of the employee
* Add an address field to the employee. This field can be passed with the date of birth or just set. 
* In a unit test: Create two employees with the exact same attibutes for each fields. See the difference between employee1.getName.equals(employee2.getName) and employee1.getName == employee2.getName   
* In a unit test: Create two employees with the exact same attibutes for each fields. See the difference between employee1.equals(employee2) and employee1 == employee2 
* Re-define equals and hashcode and re-do the same comparison: employee1.equals(employee2) and employee1 == employee2. (For the sake of the exercise create another Employee class)   
 What can we deduct from that ? 


Once you have finished or if you are blocked: you can read these articles
* https://www.geeksforgeeks.org/difference-equals-method-java/
