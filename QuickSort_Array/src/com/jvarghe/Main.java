/* 1. QUICK SORT: INTRODUCTION
 *
 * The Quick Sort (QS) algorithm is a moderately fast sorting algorithm, but one that 
 * could take exponential time in the worst case. Despite theoretically poor performance 
 * in the worst case, in practice, Quick Sort is considered a fast and efficient sorting 
 * algorithm. This is because there is an implementation trick that helps Quick Sort 
 * avoid the theoretical worst case scenario. If you can (mostly) constrain Quick Sort's 
 * time complexity performance to logarithmic levels, Quick Sort becomes one of the most 
 * practical sorting algorithms. In fact, most language libraries use Quick Sort to power
 * the standard sorting method. Note that Quick Sort is very efficient at sorting large 
 * data sets. 
 *
 * 
 * 2. DIVIDE-AND-CONQUER STRATEGY
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
 * problems of the same or a similar type. Therefore, during the Divide phase, the big 
 * problem is iteratively divided into smaller chunks, which are then sub-divided into 
 * even smaller fragments. At this point, the big problem has been reapportioned into 
 * numerous sub-problems. 
 * 
 * Moving on to the Conquer phase, recall that each chunk of the problem has the same 
 * solution as the original, larger problem. During the second phase, the algorithm is 
 * applied to each fragment of the original problem. By applying the same process to each 
 * chunk of the main problem, one by one, you can solve the problem with all the chunks. 
 * This leaves you multiple pieces of the original data set, each of which has had their 
 * problem resolved. 
 * 
 * This takes us to the last phase of the Divide-and-Conquer strategy: Combine. In this 
 * phase, the separated parts of the data set are combined to form the whole again. As 
 * each chunk is in a "correct" state, the newly combined whole should also have had its 
 * problem resolved, provided that you put the chunks back together in the correct 
 * sequence.
 * 
 * 
 * 3.1 QUICK SORT: THE ALGORITHM
 * 
 * Quick Sort is a sorting algorithm. Provided that two elements (of the same type) can 
 * be compared, Quick Sort will compare them and organize them in some order, such as
 * ascending or descending order, alphabetical order etc. 
 *
 * Between Divide-and-Conquer and Recursion, Quick Sort is a complicated algorithm, so I
 * will walk through it step by step. 
 * 
 * When you call Quick Sort on an array, it calls several private methods:
 * 
 * 
 *     1. sortByAscendingOrder(int[] array) : This is the only public method in the 
 *        QuickSort_Integers class. It receives an array which it passes on to 
 *        segmentArray() method, along with its first and last indices. 
 * 
 *     2. segmentArray(int[] array, int low, int high): This method is in charge of 
 *        creating and tracking new sub-arrays. segmentArray() does this by recursively 
 *        calling itself, 
 * 
 * Note that sortByAscendingOrder does not create and
 *        populate new arrays; it just uses pointers to refer to the boundaries of 
 *        sub-arrays. 
 *        
 *     3. private int getPivot(int low, int high):
 *     4. private int partition(int[] array, int low, int high):
 *     5. private void swap(int[] array, int index1, int index2)
 * 
 * 
 * Quick Sort will iterate over this array multiple times, sorting its elements. On the
 * first iteration, it will sort the entire array. After the first iteration, it will 
 * divide the array into two or more segments. Following this step, Quick Sort will sort 
 * each sub-array of the array. Quick Sort will enter into a cycle of creating smaller 
 * sub-arrays and sorting them. Array segments will become smaller and smaller until they 
 * have less than two elements. 
 * 
 * You need at least two elements in a sub-array in order to sort it, so once sub-arrays 
 * reach this size, there is no point is further dividing them. Quick Sort will complete
 * 
 *  cutting it up into smaller and
 * smaller segments. Each time, the algorithm will sort the elements, bringing it closer
 * to a fully sorted state. 
 *
 * 
 * 3.2 THE FIRST ITERATION: INTRODUCING PIVOTS & ARRAY BORDER TRACKING VARIABLES
 * 
 * Here's the array that will be used in this example:
 *
 *
 *                              0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 7 | 2 | 5 | 6 | 8 | 1 | 3 | 4 |
 *                            +---+---+---+---+---+---+---+---+
 * 
 * To sort elements, Quick Sort needs something called a PIVOT. A pivot is an element 
 * chosen from the array. It can be any element, though some choices are more efficient 
 * than others. During sorting, other elements from the array will be compared to the 
 * pivot's value. If an element's value is LESS THAN OR EQUAL TO the pivot, it will be 
 * moved to a position to the LEFT of the pivot. If the element value is GREATER than 
 * the pivot, it will be moved to an index position to the RIGHT of the pivot. This is 
 * the main sorting process in Quick Sort. 
 * 
 * In addition to a pivot, the Quick Sort algorithm will need two variables to track the
 * sort space: LEFT BORDER and RIGHT BORDER. These two values are references to indices
 * that delimit the sort space. leftBorder starts at left most element in the sort space,
 * and rightBorder starts at the right most element. Note that if the pivot is the first
 * or last element in the sort space, they are ignored. The left/right border value will
 * bypass the pivot and move inwards by one. The border variables start at ends of the
 * sort space and move towards each other until they meet. 
 * 
 * When you call the sort method on an array, QuickSort will select a pivot, and go 
 * through the array, comparing elements to the pivot. By the end of the first pass
 * through the array, Quick Sort will have moved elements to the left or right of the 
 * pivot, based on their value relative to the pivot. Note that the sorting process is 
 * not complete after a single iteration, though the elements are closer to being in 
 * fully sorted order. 
 * 
 * Let's select a pivot in this array: the last element (element 4 at index 7). Now 
 * let's sortByAscendingOrder one Quick Sort iteration on this array and see what happens. Note that
 * the algorithm will be trying to sort elements in ascending order. 
 * 
 * 
 *     STEP 1:                  0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 7 | 2 | 5 | 6 | 8 | 1 | 3 | 4 |
 *                            +---+---+---+---+---+---+---+---+
 *                              ^                       ^   ^
 *                           LEFTBORDER        RIGHTBORDER  PIVOT
 * 
 * 
 * leftBorder asks the question: "Is element 0 (7) > the pivot (4)?" Yes. rightBorder
 * asks a similar question: "Is element 6 (3) < the pivot (4)?" Yes. Since the answer to
 * both questions is "Yes", the elements at these indices need to be swapped. 
 * 
 * If the answer to either question is "Yes", the element needs to be swapped. If the 
 * answer is "No", it is on the correct side of the pivot. 
 * 
 * 
 *     STEP 2:                  0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 3 | 2 | 5 | 6 | 8 | 1 | 7 | 4 |
 *                            +---+---+---+---+---+---+---+---+
 *                                  ^               ^       
 *                              LEFTBORDER    RIGHTBORDER
 * 
 * 
 * Once the swap is done, the elements at indices 0 and 6 have been sorted. This shrinks
 * the sort space. leftBorder and rightBorder need to be moved inwards by one index each 
 * so that they point to unsorted elements. This is where the Step 2 diagram starts.
 * 
 * Let's compare the new elements to the pivot. Is the leftBorder element (2) > the pivot?
 * No. Is the rightBorder element (1) < the pivot? Yes. Therefore, we have one element 
 * that needs to be swapped (rightBorder) and one element (leftBorder) that does not. 
 * What happens now? 
 * 
 * As the leftBorder element (2) does not need to be swapped, it is on the correct side
 * of the pivot. The leftBorder element will move inwards by one index. The rightBorder
 * element (1) needs to be swapped, but as there is no available position on the left 
 * side of the array to swap in a value, a swap is not currently possible. rightBorder 
 * will remain pointing to index 5.
 * 
 * 
 *     STEP 3:                  0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 3 | 2 | 5 | 6 | 8 | 1 | 7 | 4 |
 *                            +---+---+---+---+---+---+---+---+
 *                                      ^           ^       
 *                                LEFTBORDER    RIGHTBORDER
 * 
 * 
 * This time, only one border variable moved inwards (leftBorder). Is the leftBorder 
 * element (5) > the pivot? Yes. Is rightBorder element (1) < the pivot? Yes. Now, we
 * can finally swap elements again. 
 * 
 *
 *     STEP 4:                  0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 3 | 2 | 1 | 6 | 8 | 5 | 7 | 4 |
 *                            +---+---+---+---+---+---+---+---+
 *                                          ^   ^
 *                                  LEFTBORDER  RIGHTBORDER
 * 
 * 
 * Is leftBorder (6) > the pivot? Yes. Is rightBorder (8) < the pivot? Yes. Once again,
 * we can effect a swap.
 * 
 *
 *     STEP 5:                  0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 3 | 2 | 1 | 8 | 6 | 5 | 7 | 4 |
 *                            +---+---+---+---+---+---+---+---+
 *                                          ^   ^
 *                                  LEFTBORDER  RIGHTBORDER
 * 
 * 
 * The border pointers meet in the middle, exhausting the sort space. As the leftBorder
 * element is greater than the pivot, the last thing you have to do is swap leftBorder 
 * and the pivot elements, like this: 
 * 
 *
 *     STEP 6:                  0   1   2   3   4   5   6   7
 *                            +---+---+---+---+---+---+---+---+
 *                            | 3 | 2 | 1 | 4 | 6 | 5 | 7 | 8 |
 *                            +---+---+---+---+---+---+---+---+
 *                                          ^
 *                                        PIVOT
 * 
 * This is the end of the first iteration. As you can see, elements less than the pivot
 * now live to its left, while elements larger than the pivot have been moved to its 
 * right. If you compare this array to the original, you can see that the elements are 
 * closer to being sorted in ascending order. 
 * 
 * 
 * 3.3 RECURSION
 * 
 * After the first iteration, the array has three algorithmically important segments:
 * 
 *     1. SEGMENT OF VALUES LESS THAN THE PIVOT (LESSERSEG)
 *     2. SEGMENT OF VALUES EQUAL TO AND INCLUDING THE PIVOT (EQUALSEG)
 *     3. SEGMENT OF VALUES GREATER THAN THE PIVOT (GREATERSEG)
 * 
 * 
 * END OF FIRST ITERATION:
 * 
 * 
 *                        0   1   2        3        4   5   6   7
 *                      +---+---+---+    +----    ----+---+---+---+
 *                      | 3 | 2 | 1 |    | 4 |    | 6 | 5 | 7 | 8 |
 *                      +---+---+---+    +----    ----+---+---+---+
 * 
 *                        LESSERSEG     EQUALSEG      GREATERSEG
 * 
 * 
 * 
 * QUICK SORT PERFORMANCE OPTIMIZATION: PIVOT SELECTION
 * 
 * Quick Sort's performance depends largely on Pivot selection. A well-selected pivot
 * will let the algorithm sortByAscendingOrder in logarithmic time, but a poor choice for a pivot may
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
 *     STEP 1:        { 73, -12, 83, 292, -3891, 92384, 83 };
 * 
 * 
 * 
 *  * "Because divide-and-conquer creates at least two sub-problems, a divide-and-conquer
 * algorithm makes multiple recursive calls."[2] In Quick Sort, all the work happens in
 * the DIVIDE step and no work happens in the COMBINE step.
 * 
 *  * to break
 * down the main problem into sub-problems. Then, the Quick Sort method recursively calls
 * itself over and over to break these sub-problems into yet smaller sub-problems. Once
 * the sub-problems have been broken down into their smallest possible size, the process
 * of solving them starts. Starting with the newest and smallest sub-problems and working
 * back to the biggest sub-problems, Quick Sort begins to sortByAscendingOrder the sorting phase of
 * the algorithm.
 *
 * Quicksort begins by breaking up the starting array into two sub-arrays. Quicksort does
 * a pass over the sub-array's, lightly sorting its contents. After the first pass, each 
 * of these sub-arrays are further split up into more sub-arrays by recursively calling 
 * the sortByAscendingOrder() method. The Quicksort algorithm will continue to divide sub-arrays 
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
 * "In practice, sortByAscendingOrder outperforms merge sort, and it significantly outperforms
 * selection sort and insertion sort."[3]  Quick Sort can sort a data set in O(n log n)
 * time in the average case (logarithmic time) and O(n^2) in the worst case scenario
 * (exponential time). 
 * 
 * 
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
        qs.sortByAscendingOrder(array);

        // Print out the sorted array.
        System.out.println("This is the SORTED array:");
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
