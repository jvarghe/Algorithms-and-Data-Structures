/* BINARY SEARCH ALGORITHM
 * 
 * Binary Search is an search algorithm that is also called half-interval search, logarithmic 
 * search, or binary chop. This algorithm searches an ordered list for a value (the search value)
 * by bisecting the list in half and discarding the half that does not contain the search value.
 * This process is repeated until the search value is found.
 * 
 * Binary Search first compares the search value to the midpoint value of the ordered list. Note  
 * that doing this bisects the search space into two halves. The search value is either the midpoint 
 * value or in one of the two halves. If the search value is less than the guessed value (which is 
 * the midpoint value in the list), the algorithm discards the second half of the search domain, 
 * which contains values larger than the search value. If the search value is greater 
 * than the midpoint value, the algorithm discards the first half of the search domain because the
 * search value cannot be located there. The algorithm continues this process of bisecting the 
 * search domain, comparing the search value to the midpoint value and discarding one-half of the 
 * search area until it finds the data element and its index position.
 * 
 * A sequential search algorithm would take linear time (O(n)), but binary search takes log time 
 * (O(log n)). 
 */


package com.jvarghe;

public class BinarySearch_Array
{
    public static void main(String[] args)
    {
        // This is the list of sorted items.
        int[] integerArray = { 1, 19, 58, 293, 823, 854, 900, 927, 999 };
        // Edit this number to change the value being searched for. 
        int searchValue = 999;
        // This is the index of the value.
        int valueIndex = -1;
        
        // These two values refer to indexes in the array. They serve as the search boundaries 
        // (Starting Range: 0 to the End of the Array).
        int lowerBound = 0;
        int upperBound = (integerArray.length - 1);


        // Binary Search will be executed on the Array:
        // While the search space has not been narrowed down to 1 element...
        while (lowerBound <= upperBound)
        {
            // Calculate the midpoint of the search space.
            int listMidPoint = (lowerBound + upperBound) / 2;
            // Make the midpoint data element the current guess. 
            int guessValue = integerArray[listMidPoint];

            
            // Check if the guessValue is the searchValue, or if not, eliminate the half the search
            // space.
            if (guessValue == searchValue)
            {
                valueIndex = listMidPoint;
                break;
            }
            
            // If the guessValue is greater than the desired searchValue, cut the search space in
            // half by eliminating all the values larger than the listMidPoint.
            if (guessValue > searchValue)
            {
                // Modify the search space; Set the upperBound to an index position one less than  
                // the previous listMidPoint. This eliminates index values greater than the mid 
                // point value.
                upperBound = listMidPoint - 1;
            }
            
            // If the guessValues is smaller than the desired searchValue, cut the search space in
            // half by eliminating all the values smaller than the listMidPoint.
            if (guessValue < searchValue)
            {
                // Modify the search space; Set the lowerBound to an index position one less than 
                // the previous listMidPoint. This eliminates index values lesser than the mid 
                // point value.
                lowerBound = listMidPoint + 1;
            }
            // If the searchValue is not found in the array, make the valueIndex negative. This
            // will indicate the value was not found.
            else
            {
                valueIndex = -99;
            }
        }


        PrintResults(searchValue, valueIndex);
    }


    // This method will print the results.
    private static void PrintResults(int searchValue, int valueIndex)
    {
        String printString;
        
        // If the searchValue was NOT found.
        if (valueIndex == -99)
        {
            printString = String.format("The search value %d was not found in the list!",
                                        searchValue);
        }
        else
        {
            // If the searchValue was found.
            printString = String.format("The search value %d was found at index %d.",
                                        searchValue, valueIndex);
        }

        System.out.println(printString);
    }
}
