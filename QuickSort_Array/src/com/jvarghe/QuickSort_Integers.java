package com.jvarghe;

import java.util.Random;


// This implementation of Quick Sort is based on Code2Bits's implementation. See Source
// 5 in Quick Sort.txt.
public class QuickSort_Integers 
{
    // This is the method that sorts the array in Ascending Order by calling the 
    // Quick Sort algorithm.
    public void sortByAscendingOrder(int[] array) throws IllegalArgumentException
    {
        // If it is a null array, throw an exception.
        if(array == null)
        {
            throw new IllegalArgumentException("This is a null array! It can't be sorted.");
        }
        // If the array has zero elements, throw an exception.
        else if(array.length == 0)
        {
            throw new IllegalArgumentException("The Array is Empty!");
        }
        // If the array is not empty or null...
        else
        {
            // ...call the Quick Sort method and pass in the array, providing the first 
            // and last indices (to designate the sort space). 
            quickSort(array, 0, array.length - 1);
        }
    }
    

    // This method recursively calls itself over and over. The first thing it does is to
    // call the partition() method and ask it to sort the array. The partition() method 
    // will do this and also return a new pivot for the array. 
    // 
    // Then, provided that it is not too small, quickSort() will divide the array
    // (or sub-array), into two smaller sub-arrays called partitions (Left and Right 
    // partition). quickSort() will recursively call itself on each new sub-array and 
    // will continue this process of dividing the array into smaller fragments. This 
    // process stops when every sub-array has a minimum of two elements in it. 
    private void quickSort(int[] array, int startIndex, int endIndex)
    {
        // The startIndex of the sort space should always be smaller than the endIndex.
        // It does not make any sense otherwise. If startIndex is equal to endIndex, both
        // indices are pointing to the same element; ergo, there is only one element in 
        // that list. This is too few to sort. If startIndex > endIndex, the sort space 
        // has a negative number of elements in it; this is quite meaningless. Therefore, 
        // we have to stop executing this method if either of these conditions occur. 
        if(startIndex >= endIndex) 
        { 
            return; 
        }
        // As long as startIndex < endIndex, the two indices are pointing to at least 
        // two separate elements. This condition check guarantees that the sort space has
        // at least two elements in it. Two elements is the minimum size an array or 
        // sub-array needs in order to be sorted. This check will ensure that new 
        // sub-arrays will be created until sub-array sizes drop below two, at which 
        // point this condition check will fail and quickSort() will stop creating new 
        // partitions.
        else if (startIndex < endIndex) 
        {
            // Generate a new pivot for this array by calling the partition method...
            int pivotIndex = partition(array, startIndex, endIndex);
            
            // ...and then, designate all values between the startIndex and 
            // (pivotIndex - 1) to be part of the LEFT PARTITION. Recursively call 
            // quickSort() on the LEFT partition.
            quickSort(array, startIndex, pivotIndex - 1);
            
            // ...and then, designate all values between (pivotIndex + 1) and endIndex
            // to be part of the RIGHT PARTITION. Recursively call quickSort() on the 
            // RIGHT partition.
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }


    // The partition() Method
    // 
    // This method does most of the heavy lifting when it comes to sorting. When called, 
    // partition() will be given an array (or a partition/sub-array) and two indices. 
    // The indices designate the range of the sort space. If they point to the first and 
    // last elements in the array, the sort space is the entire array. If the indices 
    // point to some subset of the array, then the sort space is called a partition. 
    // partition() will do ONE PASS over the array or partition, sorting values from 
    // left to right. 
    //
    // Generally speaking, partition() will move all element values < pivot to an index
    // earlier in the list and all elements values > pivot to points later in the array. 
    // Finally, it returns a new pivot index.
    private int partition(int[] array, int startIndex, int endIndex) 
    {
        // Pass in index values that demarcate the boundaries of the sort space to the 
        // getPivot() method. getPivot() will randomly select an index from this sort 
        // space, including startIndex and endIndex, and return this value. The element 
        // at this index will serve as the pivot element.
        int pivotIndex = getPivot(startIndex, endIndex);

        // Call the swapElements() method which swaps the endIndex and pivotIndex
        // elements. This will move the pivot element to the rightmost position in the
        // array or partition, i.e. to the last index.
        swapElements(array, pivotIndex, endIndex);
        
        // Now that the pivot and last element has been swapped, the indexes need to be
        // reset as well. The pivotIndex is pointed to the last index in the array or 
        // partition, as this is the pivot element's new location.
        pivotIndex = endIndex;

        // nextSwapIndex will used to track elements that qualify to be swapped with 
        // the currentIndex element. Be aware that nextSwapIndex is an intrinsic cog in 
        // the sorting process, but its role is probably the hardest thing to understand 
        // in this algorithm. Pay close attention to it. More on this in the next 
        // comment.
        int nextSwapIndex = startIndex;
        
        
        /* THE SORTING LOOP: THE CORE MECHANICS OF QUICK SORT'S SORTING PROCESS
         * 
         * QUICK HIGH-LEVEL OVERVIEW
         * 
         * The quickSort() method is responsible for overseeing the full sorting of the 
         * array. As such, repeated recursive calls to quickSort() will be made, which 
         * will call the partition() method over and over.
         * 
         * Whenever the partition() method is called, quickSort() will give it an array 
         * or a subset of one. partition() will do one sorting pass on it. This will 
         * not fully sort the array, but will bring it one step closer to being fully 
         * sorted. quickSort() will create new sub-arrays and repeatedly invoke 
         * partition(). This process should fully sort the list. 
         *
         * 
         * GENERAL OVERVIEW OF THE LOOP
         * 
         * This is the loop that does the sorting for Quick Sort. It traverses the
         * array or partition and compares each element to the pivot value. The loop 
         * starts at the left and goes rightwards, beginning at startIndex and going all 
         * the way to the penultimate index in the array or partition. Note that at the 
         * start of the pass and throughout most of it, the pivot will be at the last 
         * index. This comment will discuss the loop below and the role of involved 
         * variables, with particular attention to nextSwapIndex.
         * 
         * When it traverses the array, the loop will be following this protocol: It will
         * search for element values that are LESS THAN OR EQUAL TO the pivot value.
         * These values are swapped to indices earlier in the array. Element values
         * greater than the pivot's value will be moved to indices later in the array.
         * At the end of sorting, the pivot will be swapped to sit between these two 
         * blocks of elements.
         * 
         * So at the end of the sorting pass, the array should look like this: First the 
         * block of elements whose values are less than the pivot, followed by the pivot 
         * itself, and lastly, the block of elements that are greater than the pivot. 
         * As noted, a single pass cannot sort all the elements in perfect order, but 
         * generally, you should have a list that is closer to a perfectly sorted state 
         * than it was before the pass. 
         * 
         * 
         * WALKING THROUGH THE LOOP
         * 
         * Let's talk about the mechanics of this process. There are three variables that
         * are important to the process: pivotIndex, nextSwapIndex & currentIndex. All 
         * elements will be compared to the pivot element. pivotIndex will be last 
         * element in the array until the final step of the sorting process. 
         * 
         * currentIndex and nextSwapIndex are the two pointers that will be active during 
         * sorting. currentIndex will start at the beginning of the sort space 
         * (startIndex) and will be used to point to every element as the loop iterates 
         * through the array.
         * 
         * When the loop starts, it will run this check: (array[currentIndex] <= array[pivotIndex]). 
         * It asks: is the value of the current element (starting with the first element) 
         * less than or equal to the pivot element's value? 
         * 
         * If the value is greater, the body of the if-block is skipped, the loop moves 
         * on to checking the second element. Every time this happens, currentIndex is 
         * incremented by one.
         * 
         * However, if the current element's value is lower than the pivot's value, the
         * if-block's body is executed. This will swap the currentIndex and nextSwapIndex
         * elements. The nextSwapIndex will then be incremented by one and made to point 
         * to the next element in the list.
         * 
         * 
         * THE DYNAMIC OF THE LOOP
         * 
         * By testing for values less than or equal to the pivot, the if-check swaps 
         * smaller values to earlier indices in the array/partition, but leaves larger 
         * values in place, at least initially. However, this process brings nextSwapIndex 
         * into play. At the start of the loop, nextSwapIndex will be pointing to 
         * startIndex. 
         * 
         * Whenever the loop finds a smaller value later in the list, it will have to be
         * swapped with a value earlier in the list. nextSwapIndex will be ready and 
         * waiting, pointing to a larger value with which the smaller one can be 
         * exchanged. This is the role of nextSwapIndex: it starts at startindex and 
         * every time a element swap is effected, it moves to the right, tracking the 
         * index of the next position available for a swap. 
         * 
         * At the end of the sorting iteration, nextSwapIndex will be sitting between
         * the block of elements that less than the pivot and the block of elements 
         * greater than the pivot. Thus, this is where the new pivot for the array 
         * should be located. 
         * 
         * Therefore, when the loop ends, the last thing partition() does is swap the
         * existing pivot element and nextSwapIndex element. The indices are also changed
         * to reflect this. 
         */
        for(int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) 
        {
            // Compares currentIndex element with pivotIndex element.
            if(array[currentIndex] <= array[pivotIndex]) 
            {
                swapElements(array, currentIndex, nextSwapIndex);
                nextSwapIndex++;
            }
        }
        
        // Swap the current pivot element into the position of the nextSwapIndex.
        swapElements(array, nextSwapIndex, pivotIndex);
        
        // Change the pivotIndex to point to the position of the new pivot element. 
        pivotIndex = nextSwapIndex;
        return pivotIndex;
    }


    // Returns a random pivot index between the low and high indices, inclusive. Note: 
    // Quick Sort has a tendency to have pathologically poor performance with very large
    // sets. If you want to prevent this from happening, replace this Pivot selection 
    // algorithm with a 'Median of Three Integers' algorithm.
    private int getPivot(int low, int high)
    {
        // GENERATING RANDOM NUMBERS BETWEEN AND WITHIN A RANGE
        //
        // randInt() accepts an integer argument and returns a random integer between
        // the maximum and minimum values. But why do we need this expression: 
        // ((high - low) + 1) + low? Apparently, this is a standard formula for 
        // generating random numbers in a range, INCLUSIVE of the high and low values: 
        // 
        //     (max - min) + 1) + min
        // 
        // What's happening here? This expression will generate a number between max and
        // min, including max and min. (max - min) + 1) generates a number between 0 and
        // (max - min). If you add min to this, it will result in a random integer 
        // between min and max. 
        // [Source: https://www.techiedelight.com/generate-random-integers-specified-range-java/]
        // 
        // If you want the formula for generating a random number between the given min
        // and max values, here it is:
        //
        //     (max - min) + min
        //
        // This formula appears to EXCLUDE min and max values. 
        // [Source: https://stackoverflow.com/a/11923174]
        //
        // Normally, if you just pass an integer value to nextInt(), for example the 
        // integer 50, it will return a random number between 0 and 49. It appears that 
        // using the first formula will return a value between 0 and 50, making it 
        // possible that both 0 and 50 may be returned as a value. 
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }


    // This method takes an array/partition and two indices. It swaps the elements at 
    // these indices. 
    private void swapElements(int[] array, int index1, int index2)
    {
        // Optimization Check: If the indexes (currentIndex and nextSwapIndex) are the 
        // same, both indices are pointing to the same element. In this case, there is 
        // no point in executing the meat of this method, as swapping an element into
        // the index it currently occupies is a waste of computing resources. 
        if(index1 == index2)
        {
            return;
        }
        else 
        {    
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }
}
