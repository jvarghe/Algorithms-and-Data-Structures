/* SELECTION SORT
 * 
 * Selection Sort is an inefficient sorting algorithm. It sorts the contents of a list in either
 * increasing or decreasing order. For the sake of explanation, I'll use increasing order:
 * 
 * Selection sort selects the first element of a list and compares it to all subsequent elements,
 * looking for the the lowest value. When it finds the lowest value, it swaps this value into the 
 * first index position. Ignoring the sorted element in the first index, the algorithm moves to the 
 * second element in the list and compares it to all latter elements, looking for the second lowest
 * value. Then, selection sort does the same thing with the third place element and so on. Halfway 
 * through this process, the algorithm will have separated the list into two portions: the first 
 * segment of the list, which is now sorted in ascending order, and second segment, which is still 
 * to be sorted. Selection sort continues this process until the entire list has been sorted.
 * 
 * Selection sort is an inefficient algorithm, suited only for small data sets. Its runtime is 
 * O(n^2). Why does it run in exponential time? Selection sort has to check n elements * (n - 1)
 * elements * (n - 2) elements ... 3, 2, 1. On average, this means that selection sort has to check
 * (1/2n) * n elements. As Big-O Notation is concerned more with orders of magnitude than multiples, 
 * this is rounded up to n * n.
 */


package com.jvarghe;

public class SelectionSort_Array
{
    private static int[] integerArray = { 78, -23, 0, 14, 9843, 283, -76 };
    
    public static void main(String[] args) 
    {
	    selectionSort();
	    printResults();
    }
    
    
    public static void selectionSort()
    {
        int smallestValue = 0;              // This variable is for the smallest value in the list.
        int indexOfSmallestValue = 0;       // This one is for the index of the smallest value.
        int swapVariable = 0;               // This variable will be used to swap elements around.


        // In this loop an element i is selected, against which the second loop will compare 
        // elements i + 1, i + 2 ... . i ends on the second last element so that the second loop can 
        // compare it to the final element.
        for(int i = 0; (i < integerArray.length - 1); i++)
        {
            smallestValue = integerArray[i];
            indexOfSmallestValue = i;

            // This loop continuously compares i to all elements latter to i, looking for the 
            // smallest value.
            for(int j = i + 1; (j < integerArray.length); j++)
            {
                if(integerArray[j] < smallestValue)
                {
                    // If the current element is smaller than the smallest known value, note the 
                    // new value and its index.
                    smallestValue = integerArray[j];
                    indexOfSmallestValue = j;
                }
            }

            
            // If element i is greater than any other value in the list, swap positions.
            if(integerArray[i] > smallestValue)
            {
                swapVariable = integerArray[i];
                integerArray[i] = integerArray[indexOfSmallestValue];
                integerArray[indexOfSmallestValue] = swapVariable;
            }
        }
    }
    
    
    // Construct a string with the sorted array and print it to screen.
    public static void printResults()
    {
        String printString = "{ ";
        for (int integer : integerArray)
        {
            printString += String.format("%d, ", integer);
        }
        printString += "}";
        
        System.out.println(printString);
    }
}
