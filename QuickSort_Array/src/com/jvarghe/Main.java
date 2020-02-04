/* QUICK SORT: INTRODUCTION
 *
 * Theoretically speaking, the Quick Sort (QS) algorithm is a moderately fast sorting 
 * algorithm, but one that could take exponential time in the worst case. Despite 
 * theoretically poor performance in the worst case, in practice, Quick Sort is 
 * considered a fast and efficient sorting algorithm. It is often used when time is a
 * constraint. 
 * 
 * This is because there is an implementation trick that helps Quick Sort avoid the 
 * theoretical worst case scenario. If you can (mostly) constrain Quick Sort's 
 * time complexity performance to logarithmic levels, Quick Sort becomes one of the 
 * most practical sorting algorithms. In fact, most language libraries, including 
 * many C and C++ standard libraries use Quick Sort to power the standard sort 
 * methods. Quick Sort is very efficient at sorting large data sets. 
 *
 * Quick Sort is a fairly complex algorithm, so I recommend looking at 'Quick Sort.txt' 
 * file for more information first. After that, you can proceed to 
 * 'QuickSort_Integers.java'. 
 * 
 * 
 * PERFORMANCE CHARACTERISTICS SUMMARY 
 * 
 *     Stable Algorithm:               No
 *     Adpative Algorithm:             Not as it is typically implemented, but you can
 *                                     write implementations that are stable.
 *
 * Time Complexity
 * 
 *     Worst-Case Performance:	       O(n^2) 
 *     Best-case Performance:	       O(n log n) (simple partition), OR
 *                                     O(n)       (three-way partition and equal keys) 
 *     Average performance: 	       O(n log n)
 * 
 * 
 * Space Complexity:
 * 
 *     Worst-case Space Complexity:    O(n)       auxiliary (naive),
 *                                     O(log n)   auxiliary 
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
