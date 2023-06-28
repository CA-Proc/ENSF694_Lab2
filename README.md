# ENSF694 Lab2 - Linear vs Interpolation Search

Question 1: 

Code is contained in the github src folder. Run the main method in SearchImplementation.java.


Question 2:

Linear search had a much shorter run time for small 10-element arrays (6000 ns) versus the interpolation search (300,000ns). This is due to the high overhead of the Math.ceil() function dominating the runtime for the interpolation search. 