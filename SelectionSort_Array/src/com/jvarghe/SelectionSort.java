package com.jvarghe;


public class SelectionSort
{    
    private static int[] integerArray;

    // integerArray Setter
    public static void setIntegerArray(int[] array)
    {
        integerArray = array;
    } 
    
    
    // Selection Sort Algorithm
    public static int[] execute(int[] array) 
    {
        int smallestValue = 0;              // This variable is for the smallest value in the list.
        int indexOfSmallestValue = 0;       // This one is for the index of the smallest value.
        int swapVariable = 0;               // This variable will be used to swap elements around.


        // Copy the array from Main into the integerArray property. 
        SelectionSort.setIntegerArray(array);
        
        // In this loop an element i is selected, against which the second loop will 
        // compare elements i + 1, i + 2,... and so on. i ends on the second last element 
        // so that the second loop can compare it to the final element.
        for (int i = 0; (i < integerArray.length - 1); i++) 
        {
            smallestValue = integerArray[i];
            indexOfSmallestValue = i;

            
            // This loop continuously compares i to all elements latter to i, looking for 
            // the smallest value.
            for (int j = i + 1; (j < integerArray.length); j++)
            {
                // If the current element is smaller than the smallest known value, note 
                // the new value and its index.
                if (integerArray[j] < smallestValue) 
                {
                    smallestValue = integerArray[j];
                    indexOfSmallestValue = j;
                }
            }


            // If element i is greater than any other value in the list, swap positions.
            if (integerArray[i] > smallestValue) {
                swapVariable = integerArray[i];
                integerArray[i] = integerArray[indexOfSmallestValue];
                integerArray[indexOfSmallestValue] = swapVariable;
            }
        }
        
        return integerArray;
    }
}