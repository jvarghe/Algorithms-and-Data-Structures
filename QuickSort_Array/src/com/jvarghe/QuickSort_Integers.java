package com.jvarghe;

import java.util.Random;


// This implementation of Quick Sort is based on Joe James's implementation. See Sources
// 4 and 5 in Main.java.
public class QuickSort_Integers 
{
    // This is the method that begins the Quick Sort algorithm.
    public void execute(int[] array) 
    {
        // Calling the Quick Sort method and passing in the array, with the first and 
        // last indices of the starting array. 
        quickSort(array, 0, array.length - 1);
    }
    

    // 
    private void quickSort(int[] array, int low, int high)
    {
        // If the distance between the low and high indices is greater than 1, then it
        // means that the given (sub-)array has more than one element in it, which makes
        // sorting it necessary. 
        if (low < high+1) 
        {
            // Generate a new pivot by calling the partition method... 
            int pivot = partition(array, low, high);
            
            // ...and then, recursively call quickSort( on the LEFT partition.
            quickSort(array, low, pivot - 1);
            
            // ...and then, recursively call quickSort() on the RIGHT partition.
            quickSort(array, pivot + 1, high);
        }
    }
    

    // Returns a random pivot index between the low and high indices, inclusive.
    private int getPivot(int low, int high) 
    {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
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
        // Call the swap method which in turn, calls the getPivot() method. getPivot() 
        // returns a random pivot index within the designated sort space. swap() swaps
        // this pivot value into the left most position. 
        swap(array, low, getPivot(low, high));
        
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
                swap(array, i, border++);
            }
        }
        
        // When the partitioning process is complete, the final step is to swap the pivot
        // value into its proper position. 
        swap(array, low, border-1);
        
        // The last step is to return the pivot's index. 
        return border - 1;
    }


    // This method takes an array/partition and two indices. It swaps the elements at 
    // these indices. 
    private void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
