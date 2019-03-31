package com.jvarghe;


// This class is designed to execute the Binary Search algorithm on an array, searching
// it for an integer. 
public class BinarySearch_Integers
{
    // This is the Binary Search method.
    public static int findValue(int[] integerArray, int searchValue)
    {
        // This is the index of the search value. It is set to an out of bounds value by 
        // default.
        int searchValueIndex = -1;

        // These two values refer to indexes in the array. They serve as the search 
        // boundaries during the process of bisection. (Starting Range: 0 to the end of 
        // the array).
        int lowerBound = 0;
        int upperBound = (integerArray.length - 1);


        // Binary Search will be executed on the Array:
        // While the search space has not been narrowed down to 1 element...
        while (lowerBound <= upperBound)
        {
            // Calculate the midpoint index of the search space.
            int midPointIndex = (lowerBound + upperBound) / 2;
            // Make the midpoint data element the current guess. 
            int midPointElement = integerArray[midPointIndex];


            // Check if the midPointElement is the searchValue, and if not, eliminate 
            // half the search space.
            if (midPointElement == searchValue)
            {
                searchValueIndex = midPointIndex;
                break;
            }

            // If the midPointElement is greater than the desired searchValue, the 
            // searchValue cannot be located in the larger half of the search space. Cut 
            // the search space in half by eliminating the part of the search domain that 
            // contains all the values larger than the midPointIndex element.
            if (midPointElement > searchValue)
            {
                // Modify the search space: Set the upperBound to an index position one 
                // less than the current midPointIndex. By doing this, the algorithm 
                // will no longer consider all index values equal to or greater than 
                // the current midPointIndex.
                upperBound = midPointIndex - 1;
            }

            // If the midPointElement is smaller than the desired searchValue, cut the 
            // search space in half by eliminating all the values smaller than the 
            // midPointIndex element.
            if (midPointElement < searchValue)
            {
                // Modify the search space: Set the lowerBound to an index position one 
                // greater than the current midPointIndex. If you do this, Binary Search
                // will not consider index values lesser than or equal to the current 
                // midPointIndex.
                lowerBound = midPointIndex + 1;
            }
            // If the searchValue is not found in the array, make the searchValueIndex 
            // negative. This will indicate the value was not found.
            else
            {
                searchValueIndex = -99;
            }
        }
        
        return searchValueIndex;
    }


    // This method will print the results to screen.
    public static void PrintResults(int searchValue, int searchValueIndex)
    {
        String printString;

        // If the searchValue was NOT found.
        if (searchValueIndex == -99)
        {
            printString = String.format("The search value %d was not found in the list!",
                    searchValue);
        }
        else
        {
            // If the searchValue was found.
            printString = String.format("The search value %d was found at index %d.",
                    searchValue, searchValueIndex);
        }

        System.out.println(printString);
    }
}
