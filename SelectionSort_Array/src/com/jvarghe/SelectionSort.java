package com.jvarghe;


public class SelectionSort 
{
    // SELECTION SORT
    // 
    // This is the main method in this file, and one where the Selection Sort 
    // algorithm is implemented. It consists of two loops. The first one will select 
    // an element i, starting with the first element in the array. The second loop 
    // will compare all elements later than i in the array to element i. Then, the 
    // first loop will switch to the second element. The second loop will once again 
    // compare all subsequent elements to the new element i.
    //
    // The goal of the algorithm is to sort the array in ascending order, by moving 
    // smaller elements to the front of the array and larger elements to the end of 
    // the array. If a latter element is smaller than i, these two elements will be 
    // swapped. If a latter element is greater than i, no swap occurs. 
    public static int[] sort(int[] array)
    {
        // THE FIRST LOOP
        // 
        // This is the first for-loop. The sole responsibility of this loop is to select
        // an element i, for the purpose of comparing it to all subsequent elements of 
        // the list. Thus, the first loop will run n - 1 times.
        // 
        // During the first iteration, the first loop will select the first element of 
        // the list, after which, control will switch to the second loop, which will 
        // proceed to compare all subsequent elements to i, and perform any necessary 
        // swaps.
        //
        // At the end of the first iteration of the entire method, the smallest element
        // in the array would have been found and moved to the first index. In the 
        // second iteration, element i will be the second element and so on. 
        //
        // This process will continue until element i points to the second last element 
        // in the list. What happens hear is not clear. See the `Questions` section in
        // `Program.java`. 
        for (int i = 0; i < array.length; i++)
        {
            // THE SECOND LOOP
            //
            // This is the second loop. It will select elements for comparison  to 
            // element i. One element is selected for comparison at the start of each 
            // iteration, called j. 
            // 
            // In the first iteration, this loop will point element j to element i + 1 
            // (the second element in the array), and compare it to element i, followed 
            // by all subsequent elements. In the second iteration of this loop, it will 
            // compare element i to element i + 2, followed by all subsequent elements, 
            // and so on.
            for(int j = i + 1; j < array.length; j++)
            {
                // ELEMENT COMPARISON AND SWAPPING
                //
                // Element i is the element to which other elements are compared. Element 
                // j is the current element being compared to element i. What is the goal 
                // of these comparisons? In the process of comparing element i to all 
                // subsequent elements in the array, the goal is the find the element with
                // the smallest value and swap it into the index currently occupied by 
                // element i. 
                //
                // Therefore, if element i is LESS THAN the current element, no swap is 
                // required. However, if element i is GREATER THAN element j, then the 
                // two elements will be swapped. 
                if(array[i] > array[j])
                {
                    swapElements(array, i, j);
                } 
            }
        }

        return array;
    }


    // This method swaps elements.
    public static void swapElements(int[] listToSort, int iIndex, int jIndex) 
    {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

}