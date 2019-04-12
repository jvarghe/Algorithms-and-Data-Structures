package com.jvarghe;

import java.util.Random;


// This implementation of Quick Sort is based on Joe James's implementation. See Sources
// 4 and 5 in Main.java.
public class QuickSort_Integers 
{
    // This is the method that begins the Quick Sort algorithm.
    public void sortByAscendingOrder(int[] array) 
    {
        // Calling the Quick Sort method and passing in the array, with the first and 
        // last indices of the starting array. 
        segmentArray(array, 0, array.length - 1);
    }
    

    // This method recursively calls itself over and over. The first thing it does is to
    // call the partition() method on the array to sort it. The partition() method will
    // return a new pivot for the array. 
    // 
    // dividing arrays into sub-arrays, and 
    // sub-arrays into smaller sub-arrays. This division of the array into segments 
    // continues until sub-arrays have only one element left. 
    private void segmentArray(int[] array, int low, int high)
    {
        // Checks if there is more than one item in the given range. This is done by 
        // checking if the distance between the low and high indices is greater than 1. 
        // If there are two or more elements in the given array (or sub-array), you have
        // to sort it. 
        if (low < high+1) 
        {
            // Generate a new pivot by calling the partition method... 
            int pivot = partition(array, low, high);
            
            // ...and then, recursively call segmentArray( on the LEFT partition.
            segmentArray(array, low, pivot - 1);
            
            // ...and then, recursively call segmentArray() on the RIGHT partition.
            segmentArray(array, pivot + 1, high);
        }
    }


    // This method does most of the heavy lifting. When called, partition() will be given 
    // an array (or a partition) and two indices. The indices designate the range of the 
    // sort space. If they point to the first and elements in the array, the sort space 
    // is the entire array. If the indices point to some subset of the array, then the 
    // sort space is called a partition.  
    // 
    // partition() will move all element values < pivot to the left of the pivot and all 
    // elements values > pivot to the right of the pivot. Finally, it returns the pivot 
    // index.
    private int partition(int[] array, int low, int high) 
    {
        // Call the swapElements() method which in turn, calls the getPivot() method. 
        // Pass in index values that bookend the sort space and getPivot() will return a 
        // random pivot index within this sort space, including the low and high indexes. 
        // swapElements() swaps this pivot value into the left most position. 
        swapElements(array, low, getPivot(low, high));
        
        // Create a left border value that points to the value to the right of the pivot
        // location. 
        int border = low + 1;
        
        // This loop iterates over the array/partition and compares each element to the 
        // pivot value. 
        for (int i = border; i <= high; i++) 
        {
            // The pivot value is array[low]. If the current element value is less than
            // array[low], it will be swapped with the border value. 
            if (array[i] < array[low]) 
            {
                swapElements(array, i, border++);
            }
        }
        
        // When the partitioning process is complete, the final step is to swap the pivot
        // value into its proper position. 
        swapElements(array, low, border-1);
        
        // The last step is to return the pivot's index. 
        return border - 1;
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
