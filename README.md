# Polynomial-Calculator
This is a simple polynomial calculator written in Java.

Overall, this program works by storing the object Terms of each Polynomial object in a LinkedList and then storing each Polynomial object in a master HashMap, using the name of the polynomial as the key and the Polynomial object as the value.

Functions so far include:
  -Naming and storing polynomials
  -Adding two stored polynomials together
  -Multiplying two stored polynomials
  -Sorting a stored polynomial by order of descending degree
  
Functions to add:
  -Subtracting polynomials
  -Dividing polynomials?
  
Possible things to Debug/Do:
Program involves a lot of converting Strings into Term objects which make up each Polynomial object and converting those back into Strings for displaying. Testing different forms of polynomials needs to be done. Also, there are a couple places with many nested if blocks (the toString() method in the Polynomial class especially) that could be written more concisely.
