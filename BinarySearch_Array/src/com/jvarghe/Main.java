/* BINARY SEARCH ALGORITHM
 * 
 * Binary Search is an search algorithm that is also called half-interval search, 
 * logarithmic search, or binary chop. Binary Search requires an ordered list or array. 
 * The elements in the list must be ordered in ascending/descending order (for numbers) 
 * or alphabetical order for strings. This algorithm will search an ordered list for a 
 * value (the search value) by bisecting the list in half and discarding the half that 
 * does not contain the search value. This process is repeated until the search value is 
 * found.
 * 
 * Let's consider an array/list of numbers ordered in ascending order. Binary Search 
 * first compares the search value to the midpoint value of the ordered list. Note that 
 * doing this bisects the search space into two halves, not including the midpoint value. 
 * The search value must either be the midpoint value or in one of the two halves of the 
 * list. 
 * 
 * If the search value is less than the guessed value (which is the midpoint value in the 
 * list), the algorithm discards the second half of the search domain, which contains 
 * values larger than the search value. If the search value is greater than the midpoint 
 * value, the algorithm discards the first half of the search domain because the search 
 * value cannot be located there. This is why having an ordered list is necessary to the
 * Binary Search algorithm. 
 * 
 * This is how binary search finds the search value: it will iterate over the now reduced 
 * search space, bisecting it over and over, comparing the search value to the midpoint 
 * value and discarding one-half of the search area until it finds the data element.
 * 
 * A sequential search algorithm would take linear time (O(n)), but binary search takes 
 * log time (O(log n)). 
 */


package com.jvarghe;

public class Main
{
    public static void main(String[] args)
    {
        // This is the list of sorted items.
        int[] integerArray = { 1, 19, 58, 293, 823, 854, 900, 927, 999 };

        // Edit this number to change the value being searched for. 
        int searchValue = 999;


        PrintResults(searchValue, valueIndex);
    }



}
