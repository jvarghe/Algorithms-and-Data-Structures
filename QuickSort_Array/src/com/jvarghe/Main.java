/* QUICK SORT: INTRODUCTION
 *
 * The Quick Sort (QS) algorithm is a moderately fast sorting algorithm, but one that 
 * could take exponential time in the worst case. Despite theoretically poor performance 
 * in the worst case, in practice, Quick Sort is considered a fast and efficient sorting 
 * algorithm. This is because there is an implementation trick that helps Quick Sort 
 * avoid the theoretical worst case scenario. If you can (mostly) constrain Quick Sort's 
 * time complexity performance to logarithmic levels, Quick Sort becomes one of the most 
 * practical sorting algorithms. In fact, most language libraries use Quick Sort to power
 * the standard sort methods. Quick Sort is very efficient at sorting large data sets. 
 *
 * Quick Sort is a fairly complex algorithm, so see the 'Quick Sort.txt' file for more
 * information. After that, you can proceed to 'QuickSort_Integers.java'. 
 */


package com.jvarghe;

import java.util.Arrays;


public class Main
{
    public static void main(String[] args) 
    {
        // This is the sample array: 
        int[] array = { 73, 20, -12, 83, 292, -3891, 92384, 85, 0, 83 };
        
        // Create a QuickSort_Integers object.
        QuickSort_Integers qsObject = new QuickSort_Integers();

        // Print out the unsorted array first:
        System.out.println("This is the UNSORTED array:");
        System.out.println(Arrays.toString(array));
        System.out.println();
        
        // Sort the array.
        try
        {
            qsObject.sortByAscendingOrder(array);
        }
        catch (IllegalArgumentException exceptionObject)
        {
            System.out.println(exceptionObject.getMessage());
        }
        

        // Print out the sorted array.
        System.out.println("This is the SORTED array:");
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
