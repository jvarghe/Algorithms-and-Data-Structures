package com.jvarghe;

import java.util.Random;


// This implementation of Quick Sort is based on Code2Bits's implementation. See Source
// 5 in Quick Sort.txt.
public class QuickSort_Integers 
{
    // This is the method that sorts the array in Ascending Order by calling the 
    // Quick Sort algorithm.
    public void sortByAscendingOrder(int[] array) 
    {
        // If the array is not empty...
        if(array != null) 
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
        // Checks if there is more than one item in the given range. This is done by 
        // checking if the distance between the startIndex and endIndex indices is 
        // greater than 2. As long as this is true, it means that there are more than 
        // two elements in the given array (or sub-array), which means, it must be
        // broken up into smaller sub-arrays.
        if(startIndex >= endIndex) 
        { 
            return; 
        }
        else if (startIndex < endIndex + 1) 
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


    // This method does most of the heavy lifting. When called, partition() will be given 
    // an array (or a partition) and two indices. The indices designate the range of the 
    // sort space. If they point to the first and last elements in the array, the sort 
    // space is the entire array. If the indices point to some subset of the array, then 
    // the sort space is called a partition. partition() will do ONE PASS over the array 
    // or partition, sorting values from left to right. 

    // Generally speaking, partition() will move all element values < pivot to an index
    // earlier in the list and all elements values > pivot to points later in the array. 
    // Finally, it returns the new pivot index.
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
        // reset as well. The pivotIndex is set to the last index in the array/partition,
        // as this is the pivot element's new location.
        pivotIndex = endIndex;

        int nextSwapIndex = startIndex;
        /* THE CORE MECHANICS OF QUICK SORT'S SORTING PROCESS
         * 
         * nextSwapIndex is a variable whose role probably the hardest to understand in 
         * this algorithm. It is intrinsic cog in the sorting process, but its role is 
         * quite tricky to understand. Therefore, it seems like a good place to comment
         * on this algorithm's sorting process. This section will discuss the sorting 
         * loop below and the role of various variables, in particular nextSwapIndex.
         *
         * 
         * GENERAL OVERVIEW OF THE LOOP
         * 
         * Every time the quickSort() method is called, the loop below will traverse the 
         * array ONCE. It will start from the left and go right, from the startIndex to 
         * the second last index. The pivot will be the final index. As it does this, the 
         * loop will be following this protocol: It will search for element values that 
         * are LESS THAN OR EQUAL TO the pivot value. These values are swapped to indices 
         * earlier in the array. Element values greater than the pivot's value will be 
         * moved to indices later in the array. 
         * 
         * 
         * WALKING THROUGH THE LOOP
         * 
         * Let's talk about the mechanics of this process. At the start of the loop, 
         * nextSwapIndex will be pointing to startIndex. When the loop starts, it will 
         * run this check: (array[currentIndex] <= array[pivotIndex]). It asks: is the 
         * value of the current element (the first element) less than or equal to the 
         * pivot element's value? If the value is greater, the body of the if-block is 
         * skipped and the loop moves on to checking the second element. 
         * 
         * However, if the current element's value is lower than the pivot's value, the
         * if-block's body is executed. This will swap the currentIndex and nextSwapIndex
         * elements. The nextSwapIndex will then be incremented by one and made to point 
         * to the next element in the list.
         * 
         * 
         * THE DYNAMICS OF THE LOOP
         * 
         * By testing for values less than or equal to the pivot, the if-check swaps 
         * smaller values to the left of the array/partition, but leaves larger values
         * in place, at least initially. However, barring the occasional false positive,
         * nextSwapIndex tends to end up pointing at these larger values. 
         * 
         * Whenever the loop finds a smaller value later in the list, it will have to be
         * swapped with a value earlier in the list. That is the role of nextSwapIndex, 
         * which will be ready and waiting, pointing to a larger value with which the 
         * smaller one can be exchanged.
         */


        // This loop traverses the array/partition and compares each element to the pivot 
        // value. Thus, the loop begins at the startIndex and goes all the way to the
        // penultimate index in the array or partition. It specifically excludes the 
        // element at the last index, as that is the pivot value. 
        for(int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) 
        {
            // Compares currentIndex element with pivotIndex element.
            if(array[currentIndex] <= array[pivotIndex]) 
            {
                swapElements(array, currentIndex, nextSwapIndex);
                nextSwapIndex++;
            }
        }
        swapElements(array, nextSwapIndex, pivotIndex);
        
        // TODO: Figure out why pivotIndex is set to the last nextSwapIndex.
        pivotIndex = nextSwapIndex;
        return pivotIndex;
    }


    // Returns a random pivot index between the low and high indices, inclusive.
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
        
        // TODO: Consider including an median of three integers implementation pivot
        // selection.
    }


    // This method takes an array/partition and two indices. It swaps the elements at 
    // these indices. 
    private void swapElements(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
