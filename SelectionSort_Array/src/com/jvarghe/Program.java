/* SELECTION SORT
 * 
 * 
 * HOW THE ALGORITHM WORKS
 * 
 * Selection Sort is a very inefficient sorting algorithm. It sorts the contents of 
 * a list in some kind of order, whether it be alphabetical, ascending, descending 
 * etc. For this explanation, I'll assume an array of integers that needs to be 
 * ordered in increasing order. Selection Sort will compare integers, and order them 
 * from the lowest value to highest.
 * 
 * When you run Selection Sort on a list or array, it will traverse the list, looking
 * for the smallest element. Once it finds this element, it will get swapped into 
 * the first index in the array. Then, the algorithm moves on to the second element 
 * in the list and compares it to all latter elements, looking for the second lowest 
 * value, which will get slotted into the second index. The algorithm will keep doing
 * this until it sorts the whole array.
 * 
 * Here is a snapshot of what the list will look like halfway through the sorting 
 * process: the algorithm will have separated the list into two parts. The first 
 * part of the list is now sorted in ascending order, and second part, which has not
 * yet been sorted. 
 * 
 * 
 * ANALYSIS: ALGORITHM PERFORMANCE CHARACTERISTICS
 * 
 * Selection Sort is a very inefficient algorithm, suited only for small data sets. 
 * At best, it takes O(n^2) time. Why does it run in exponential time? In an 
 * array with n elements, Selection will run two loops. The first loop selects a
 * comparison element, while the second loop compares it against n - 1 elements. 
 * 
 * Thus, the first loop must run n times. The second loop checks progressively
 * fewer elements with every iteration, declining by one element each round as 
 * the sorted portion of the array increases. So the number of times the second 
 * loop runs can be calculated by adding them together: (n - 1) + (n - 2) + 
 * (n - 3)... 1. Therefore, on average, the second loop runs (1/2)n.
 * 
 * To calculate the full time complexity of the algorithm, you multiply these two
 * variables together: (1/2)n * n = (1/2)(n^2). On average, this means that 
 * Selection Sort has to check (1/2n) * n elements. As Big-O Notation is concerned 
 * more with orders of magnitude than multiples, this is rounded up to n * n = n^2.
 * 
 * Selection Sort is also not a stable sort, which is to say, entities of equal value
 * are going to get re-arranged. It has constant space complexity because it is an 
 * in-place algorithm (It doesn't move elements to a new array during processing).
 * Selection Sort is not an adaptive algorithm, i.e., there is no way to determine if 
 * the array has been fully sorted early. The algorithm will execute to the end. This 
 * means that Selection Sort does not perform any better with nearly sorted lists than
 * it would with unsorted lists. Therefore, Selection Sort is a very naive sorting 
 * algorithm. Due to its simplicity, it is best used for teaching, but it is rarely
 * used in practice. 
 * 
 * 
 * PERFORMANCE CHARACTERISTICS: SUMMARY 
 *  
 * 
 *     Stable Algorithm: No
 *     Adpative Algorithm: No
 * 
 * 
 * Time Complexity
 * 
 *     Worst-Case Performance:	       О(n^2) comparisons, О(n) swaps
 *     Best-case Performance:	       О(n^2) comparisons, О(n) swaps
 *     Average performance: 	       О(n^2) comparisons, О(n) swaps
 * 
 * 
 * Space Complexity:
 * 
 *     Worst-case Space Complexity:    O(1) auxiliary
 * 
 * 
 * QUESTIONS
 * 
 * 1. In the first loop, the loop considers all elements in the array, including 
 *    the last one. Because i < array.length. 
 * 
 *    In an array of n elements, if i is pointing to the second last element in the 
 *    array, then j will be pointing to the last element. What I mean to say is that 
 *    if the first loop is considering the second last element, then second loop will 
 *    compare the the last element to the penultimate element. 
 * 
 *    Wouldn't this sort the list entirely? If so, why does the first loop go all 
 *    the way to the last element? What happens when index i = n and j = n + 1? Does 
 *    the loop terminate at this point or does it compare the last element to itself?
 *    
 *    Does this have an obvious solution? Or does it happen because this is a naive
 *    implementation? 
 */


package com.jvarghe;


public class Program
{
    public static void main(String[] args) 
    {
        // Declare the array to be sorted. 
        int[] integerArray = { 78, -23, 0, 14, 9843, 283, -76 };
        
        
        // Print the Unsorted Array to screen: 
        System.out.println();
        System.out.println("The Unsorted Array:");
        printArray(integerArray);
        System.out.println();
        

        // Run Selection Sort on the array.
	    int[] sortedArray = SelectionSort.sort(integerArray);
	    
	    
	    // Print the Sorted Array to screen: 
        System.out.println("The Sorted Array:"); 
	    printArray(sortedArray);
    }

    
    // Construct a string with the sorted array and print it to screen.
    public static void printArray(int[] array)
    {
        String printString = "{ ";
        for (int integer : array)
        {
            printString += String.format("%d, ", integer);
        }
        printString += "}";

        System.out.println(printString);
    }
}
