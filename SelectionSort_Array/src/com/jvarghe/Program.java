/* SELECTION SORT
 * 
 * Selection Sort is an inefficient sorting algorithm. It sorts the contents of a list in 
 * either increasing or decreasing order. For the sake of explanation, I'll use 
 * increasing order. Selection Sort will compare the element values of a list, and order 
 * them from the lowest value to highest.
 * 
 * When you run Selection Sort on a list or array, it selects the first element of a list 
 * and compares it to all subsequent elements, looking for the the lowest value. When the 
 * lowest value in the list is found, if it is the first element, nothing is changed. If
 * the lowest value is not the first element, it gets swapped with the value in the first 
 * index position. 
 * 
 * Then, the algorithm moves on to the second element in the list and compares it to all 
 * latter elements, looking for the second lowest value. After finding and swapping these 
 * values, Selection Sort does the same thing with the third place element and so on. 
 * Here is a snapshot of what the list will look like halfway through the sorting process: 
 * the algorithm will have separated the list into two parts. The first segment of the 
 * list is now sorted in ascending order, and second segment, which is still to be 
 * sorted. Selection sort will continue the sorting process until the entire list has 
 * been sorted.
 * 
 * Selection sort is an inefficient algorithm, suited only for small data sets. Its 
 * runtime is O(n^2). Why does it run in exponential time? Selection sort has to check n 
 * elements * (n - 1) elements * (n - 2) elements ... 3, 2, 1. On average, this means 
 * that selection sort has to check (1/2n) * n elements. As Big-O Notation is concerned 
 * more with orders of magnitude than multiples, this is rounded up to n * n.
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
