/* INSERTION SORT
 * 
 * INTRODUCTION
 *
 * Insertion Sort is a rather simple sorting algorithm, but one that's inefficient on anything
 * but the smallest of data sets. It runs in quadratic time, much like other simple sorting
 * algorithms like Bubble Sort and Selection Sort, but in practice, it is the most efficient
 * of the three. Insertion Sort is both stable and adaptive. It is also an in-place algorithm.
 * 
 * The fact that Insertion Sort is adaptive - i.e., it sorts nearly sorted lists much faster 
 * than it does unsorted lists - gives it a performance advantage over Selection Sort, which
 * is not an adaptive algorithm. 
 * 
 * Insertion Sort is superior to Bubble Sort is several ways: After sorting the list, Bubble 
 * Sort requires a final pass to ensure that the list is sorted. Insertion Sort does not
 * need such a pass. Bubble Sort has to do N comparisons for each element, whereas Insertion
 * Sort can stop doing comparisons when the element finds its correct order in the list. Thus,
 * in the average case, Insertion Sort is more efficient. Bubble Sort also requires a 
 * relatively high number of writes and swaps - behaviour which results in a lot of cache 
 * misses. Insertion swap does fewer writes and swaps in general, making it more cache 
 * friendly.
 * 
 * As the most efficient of the small data set algorithms, Insertion Sort is often employed 
 * as part of other, faster algorithms. Algorithms that use the Divide-and-Conquer strategy, 
 * such as Merge Sort and Quick Sort, use Insertion Sort to sort sub-lists in recursive 
 * branches.
 * 
 * Insertion Sort's worst case performance occurs in the event that the list is sorted in 
 * reverse order (О(n^2)). When this situation happens, the algorithm will have to move every 
 * single element in the list in order to insert elements at the beginning of the list. 
 * 
 * 
 * THE ALGORITHM
 * 
 * Insertion Sort traverses a list, usually from left to right, while comparing elements. As
 * it does this, it splits the list into two sections: Sorted and Unsorted. The sorted section 
 * usually starts at the left of the list and the unsorted section on the right. 
 * 
 * The sorting process occurs at the junction of the sorted and unsorted sections. At the 
 * start of Insertion Sort, the algorithm essentially takes the first element in the list and
 * declares it to be sorted. (Because any list with only a single element is sorted by 
 * default). Thus, at the end of the first iteration, the sorted set consists of only one 
 * element, while the rest of the list makes up the unsorted section. 
 * 
 * During the second iteration, the first element (in the sorted set) and the second element
 * (which is part of the unsorted set) are compared. If they are in the correct order, the
 * sorted set expands, completing the second iteration. If they are not in the correct order,
 * the elements are made to swap positions. At the end of the second iteration, the sorted 
 * set consists of two elements.
 * 
 * During the third iteration, the second and the third elements are the new meeting point 
 * between the unsorted and sorted sets. The two elements are compared; if they are in the
 * correct order, the sorted set expands again. If they are not in the correct sequence, 
 * the third element gets swapped with the second element. However, the sorting process does
 * not stop here. To ensure the (formerly) third element is in its correct final position,
 * it gets compared to earlier elements in the list, one at a time, in reverse order. By 
 * doing this, the element gets inserted into its correct position in the list. (Thus the
 * name Insertion Sort).
 * 
 * This process continues, sorting more and more of the list. As the list gets sorted, the 
 * sorted section iteratively expands, crowding out the unsorted section. Sorting will 
 * continue until the last element gets sorted, rendering the list fully sorted. 
 * 
 * 
 * INSERTION SORT PERFORMANCE CHARACTERISTICS
 * 
 *     Stable Algorithm:               Yes
 *     Adaptive Algorithm:             Yes
 *
 *
 * Time Complexity
 *
 *     Worst-Case Performance:	       О(n^2) comparisons and swaps
 *     Best-case Performance:	       O(n) comparisons, O(1) swaps
 *     Average performance: 	       О(n^2) comparisons and swaps
 *
 *
 * Space Complexity:
 *
 *     Worst-case Space Complexity:    О(n) total, O(1) auxiliary
 */


package com.jvarghe;

public class Main 
{

    public static void main(String[] args) 
    {
        
    }
}
