# ENSF694 Lab2 - Linear vs Interpolation Search

Question 1: 

Code is contained in the github /src folder. Run the main method in SearchImplementation.java.

Question 2: 

It is difficult to compare run-times of individual search methods, however in this program I ran a performance test which measured the average runtime of each search method over 100 iterations. The runtime is highly dependent on the specific elements in the array and the search key. 

On average, my Optimized Linear search is 30-60% faster than the Linear Search. 
Interpolation search ranges from faster to slower than Linear Search, depending on the key. This is likely only true for small array sizes such as n=10. As N increases, we expect the performance of Interpolation search (O(logN)) to become much better than Linear search (O(N)).

Question 3:

For improving the performance of Linear Search, I used the sentinel method. For each iteration of the for loop in the linear search, it must conduct a comparison of i to the array size. With the sentinel method, we check if the last element of the array is the key - if not, we replace it with the key. In this way, we can be sure that we will find the key before reaching the end of the array. We can then convert the loop to a while loop, saving the cost of the for-loop array-size comparison overhead. 