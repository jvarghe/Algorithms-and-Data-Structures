/* QUICK SORT
 *
 * The Quick Sort (QS) algorithm is a moderately fast sorting algorithm, but one that 
 * could take exponential time in the worst case. Nevertheless, it is one of the most 
 * commonly used sorting algorithms because it is very efficient at sorting large data 
 * sets. 
 *
 * 
 * DIVIDE-AND-CONQUER STRATEGY
 * 
 * Quick Sort is a recursive algorithm that uses the Divide-and-Conquer strategy. 
 * Here is Wikipedia's explanation[1]:
 * 
 * 
 *     In computer science, divide and conquer is an algorithm design paradigm based on 
 *     multi-branched recursion. A divide-and-conquer algorithm works by recursively 
 *     breaking down a problem into two or more sub-problems of the same or related type, 
 *     until these become simple enough to be solved directly. The solutions to the 
 *     sub-problems are then combined to give a solution to the original problem.
 * 
 * 
 * Divide-and-Conquer usually has three phases: 
 * 
 *     * DIVIDE: Carve the problem into sub-problems of the same type. 
 *     * CONQUER: Recursively solve the smaller problems.  
 *     * COMBINE: Combine the small chunks into the original data set, which should now
 *       be problem free. 
 * 
 * This strategy can only be applied to problems that can be broken up into smaller
 * problems of the same or similar type. Therefore, during the Divide phase, the big 
 * problem is iteratively divided  into smaller chunks, which are then sub-divided into 
 * even smaller fragments. At this point, the big problem has been reapportioned into 
 * numerous sub-problems. 
 * 
 * Moving on to the Conquer phase, recall that each chunk of the problem has the same 
 * solution as the original, larger problem. During the second phase, the algorithm is 
 * applied to each fragment of the original problem. By applying the same process to each 
 * chunk of the main problem, one by one, you can solve the problem with all of them. 
 * This leaves you multiple pieces of the original data set, each of which has had their 
 * problem resolved. 
 * 
 * This takes us to the last phase of the Divide-and-Conquer strategy: Combine. In this 
 * phase, the separated parts of the data set are combined to form the whole again. As 
 * each chunk is in a "correct" state, the newly combined whole should also have had its 
 * problem resolved. 
 * 
 * 
 * QUICK SORT EXAMPLE
 * 
 * Quick Sort is rather complicated, so here is a short example: 
 * 
 * 
 *  * "Because divide-and-conquer creates at least two sub-problems, a divide-and-conquer
 * algorithm makes multiple recursive calls."[2] In Quicksort, all the work happens in
 * the DIVIDE step and no work happens in the COMBINE step.
 * 
 *  * to break
 * down the main problem into sub-problems. Then, the Quick Sort method recursively calls
 * itself over and over to break these sub-problems into yet smaller sub-problems. Once
 * the sub-problems have been broken down into their smallest possible size, the process
 * of solving them starts. Starting with the newest and smallest sub-problems and working
 * back to the biggest sub-problems, Quick Sort begins to execute the sorting phase of
 * the algorithm.
 *
 * Quicksort begins by breaking up the starting array into two sub-arrays. Quicksort does
 * a pass over the sub-array's, lightly sorting its contents. After the first pass, each 
 * of these sub-arrays are further split up into more sub-arrays by recursively calling 
 * the quickSort() method. The Quicksort algorithm will continue to divide sub-arrays 
 * into smaller sub-arrays and sorting their values again and again until the sub-arrays 
 * are so small that they have only one element left.
 *
 * Stage 1: Split Up the Problem Into Sub-problems
 *
 * To split up the array as described above, you need to choose a PIVOT value. The pivot 
 * value can be any in the array, but usually, a value in the middle or at one end of the 
 * array is chosen to be the pivot. With the pivot selected, the values of the array can 
 * be partitioned, which is to say, they can sorted in an order relative to the pivot 
 * value. 
 * 
 * Values that are LESS THAN OR EQUAL TO THE PIVOT are moved to the LEFT side of the 
 * array and values that are GREATER THAN THE PIVOT are moved to the RIGHT of the pivot. 
 * The relative order between elements is not important at this stage, only the weight of 
 * each value relative to the pivot. When all elements have been moved to the correct 
 * side of the pivot, the array is said to have been partitioned.
 *
 * "In practice, quicksort outperforms merge sort, and it significantly outperforms
 * selection sort and insertion sort."[3]  Quick Sort can sort a data set in O(n log n)
 * time in the average case (logarithmic time) and O(n^2) in the worst case scenario
 * (exponential time). 
 * 
 * Quick Sort's performance depends largely on Pivot selection. A well-selected pivot 
 * will let the algorithm execute in logarithmic time, but a poor choice for a pivot may 
 * result in exponential time. How do you select a pivot? The common choices for a pivot 
 * are the first, last and middle elements in an array. Under certain circumstances, 
 * choosing the first or last elements as a pivot could result in worst case performance.
 * (E.g. If you want to forward sort or reverse sort a list that is already sorted, you
 * could get exponential time complexity if you choose the first or last elements as the
 * pivot.) The middle element is usually a better choice, as is the median element (use 
 * the first, last and middle items to calculate the median element.). However, for large
 * lists, randomly chosen pivots ensure O(n log n) time complexity.
 *
 *
 * SOURCES
 * 1. https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm
 * 2. Divide and Conquer Algorithms: https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/divide-and-conquer-algorithms
 * 3. Overview of Quicksort: https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/overview-of-quicksort
 * 4. Joe James Youtube Channel: https://www.youtube.com/user/joejamesusa
 * 5. Joe James GitHub: https://github.com/joeyajames/Java
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
        QuickSort_Integers qs = new QuickSort_Integers();

        // Print out the unsorted array first:
        System.out.println("This is the UNSORTED array:");
        System.out.println(Arrays.toString(array));
        System.out.println();
        
        // Sort the array.
        qs.execute(array);

        // Print out the sorted array.
        System.out.println("This is the SORTED array:");
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
