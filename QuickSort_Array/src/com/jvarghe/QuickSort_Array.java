/* QUICKSORT
 *
 *
 * The quicksort (QS) algorithm is a moderately fast one, but one that could take exponential time
 * inthe worst case. Nevertheless, it is one of the most commonly used sorting algorithms.
 *
 * QS is a recursive algorithm that uses the Divide and Conquer strategy to break down the main
 * problem into sub-problems. The sub-problems are recursively solved and their solutions are added
 * up to produce the full solution to the problem. "Because divide-and-conquer creates at least two
 * subproblems, a divide-and-conquer algorithm makes multiple recursive calls." [1] In QS, all the
 * work happens in the DIVIDE step and no work happens in the COMBINE step.
 *
 * ANALYSIS
 *
 * In QS, the starting array is broken up into two sub-arrays, and their values are lightly sorted.
 * Each of these sub-arrays are further split up into sub-arrays by recursively calling the
 * quickSort() method. These sub-arrays will have their values sorted again and again until the
 * sub-arrays are so small that
 *
 * Stage 1: Split Up the Problem Into Sub-problems
 *
 * To split up the array, first select the PIVOT value. The pivot value can be any in the array, but
 * usually, a value in the middle or at one end of the array is chosen to be the pivot. With the
 * pivot selected, the values of the array can be partitioned, which is to say, they can sorted in
 * an order relative to the pivot value. Values that are LESS THAN OR EQUAL TO THE PIVOT are moved
 * to the LEFT of the array and values that are GREATER THAN THE PIVOT are moved to the RIGHT of the
 * pivot. The relative order between elements is not important at this stage, only the weight of
 * each value relative to the pivot. When all elements have been moved to the correct side of the
 * pivot, the array is said to have been partitioned.
 *
 *
 * "In practice, quicksort outperforms merge sort, and it significantly outperforms selection sort and
 * insertion sort." [2]
 *
 *
 * SOURCES
 * 1. Divide and Conquer Algorithms: https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/divide-and-conquer-algorithms
 * 2. Overview of Quicksort: https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/overview-of-quicksort
 *
 */

package com.jvarghe;

public class QuickSort_Array
{
    public static int[] array = { 73, 20, -12, 83, 292, -3891, 92384, 85, 0, 83 };
    
    
    public static void main(String[] args) 
    {
        int startingIndex = 0;
        int endingIndex = (array.length - 1);
        
        quickSort(startingIndex, endingIndex);
    }

    
    public static void quickSort(int startingIndex, int endingIndex)
    {
        // Why are there 4 index variables? When the quickSort() method is called, startingIndex and
        // endingIndex serve as boundaries of the search space. The first time quickSort() is called,
        // the search space is the entire array. Later in this algorithm, when this method is called
        // recursively, these two variables may denote parts of the original array.
        //
        // leftIndex and rightIndex will vary during partitioning. leftIndex and rightIndex will
        // be set to startingIndex and endingIndex respectively at first, but during partitioning,
        // these two indices will slowly collapse inwards towards each other until the search space
        // has been fully partitioned.
        int leftIndex = startingIndex;
        int rightIndex = endingIndex;
        
        // The midpoint index of the array is calculated. The value at this index is made the pivot.
        int pivot = array[startingIndex + (endingIndex - startingIndex) / 2];
        
        
        // The large while-loop partitions the array i.e. it sorts the values in ascending order.
        // There are two while-loops within this while-loop. One of them operates on leftIndex and
        // the other on rightIndex. In the array, the left and right indices serve as the boundaries
        // of the search space. The first time this algorithm runs, the indices start at the
        // extremities and are moved inwards. The pivot bisects the array at the midpoint into two
        // sub-arrays.
        //
        // The two inner while-loops move leftIndex and rightIndex inwards from their starting
        // positions, searching for values that meet the criteria for partitioning. The larger loop
        // is designed to terminate when the indices meet.
        //
        // The leftIndex while-loop will increment itself, moving right, looking for a value that is
        // LESS than the pivot. The rightIndex while-loop will decrement itself, moving left,
        // searching for a value GREATER than the pivot.
        //
        // If two different values are found, they are swapped. It's possible for both loops to
        // point to the same value. This is a algorithmic dead end. Still, these values are also
        // "swapped", which changes nothing at all.
        while(leftIndex <= rightIndex)
        {
            // This while-loop moves leftIndex to the right in the array, incrementing it by 1 for
            // every value less than the pivot. It will terminate when it finds a value GREATER than
            // the pivot.
            // Note that if all values on the LHS of the array are less than the pivot, this loop
            // will move into the RHS sub-array until it meets rightIndex.
            while(array[leftIndex] < pivot) { leftIndex++; }

            // This while-loop moves rightIndex to the left in the array, decrementing it by 1 for
            // every value greater than the pivot. It will terminate when it finds a value LESS than
            // the pivot.
            // Note that if all values on the RHS of the array are less than the pivot, this loop
            // will cross into the LHS sub-array until it meets leftIndex.
            while(array[rightIndex] > pivot) { rightIndex--; }
            
            // If the algorithm reaches this line, it has either found values on both sides that 
            // have to be swapped OR one or both while loops above left their segments and crossed 
            // into the other one. The first possibility mandates swaps be made between segments, 
            // such that all values less the pivot are moved to the LHS array segment, and all 
            // greater values to the RHS segment. The second possibility means that no swaps are 
            // necessary right now; later recursive calls will take care of it.
            if(leftIndex <= rightIndex)
            {
                int tempSwapValue = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tempSwapValue;
                
                // The swap is complete. Increment the indices to find the next values that need to 
                // be swapped.
                leftIndex++;
                rightIndex--;
            }
            
            // Recursively call the quickSort method if the startingIndex is less than the 
            // rightIndex or if the leftIndex is less than the endingIndex. If these conditions are
            // true, segments of the array are as yet unsorted. 
            if(startingIndex < rightIndex) { quickSort(startingIndex, rightIndex); }
            if(leftIndex < endingIndex) { quickSort(leftIndex, endingIndex); }
        }
    }
}
