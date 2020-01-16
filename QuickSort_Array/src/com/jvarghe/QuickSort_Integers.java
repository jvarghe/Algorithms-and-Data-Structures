package com.jvarghe;

import java.util.Random;


// This implementation of Quick Sort is based on Code2Bits's implementation. See Source
// 6 in Quick Sort.txt.
public class QuickSort_Integers 
{
    // THE sortByAscendingOrder() METHOD
    // 
    // This is the method that sorts the array in Ascending Order by calling the 
    // Quick Sort algorithm. It tests the array to make sure it meets Quick Sort's
    // requirements.
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
    

    // THE quickSort() METHOD
    //
    // The quickSort() method does two things: it sends the array to get partitioned 
    // and then divides the newly partitioned array into two new arrays. quickSort() then 
    // recursively calls itself on the two new arrays, starting a process where arrays
    // are partitioned and then divided into smaller ones over and over. This is a short
    // description of the Quick Sort algorithm. This process will continue to divide the
    // array into sub-arrays until each sub-array has a minimum of two elements in it. 
    //
    // Note that Quick Sort does all its work in the original array. No new arrays are 
    // created. This is an important because elements are only swapped, which makes 
    // shifting all the other elements around unnecessary. This is what makes it faster 
    // than other sorting algorithms. For instance, Insertion Sort takes a brute force 
    // approach to sorting. It inserts and moves elements around, often multiple times. 
    // Quick Sort is much more efficient, requiring fewer swaps and no shifts.
    // 
    // Note that Quick Sort does not directly sort the array, to wit, the algorithm
    // does not directly search for the highest element, the second-highest element
    // etc. and then put them in order. Rather, the combination of these three processes, 
    // namely partitioning, array division and recursion, will produce a sorted array.
    // 
    // Suggestion: This is a complex algorithm. Use print statements to track what is 
    // happening. For example, after every call to the partition() method, print the 
    // array and variables like nextSwapIndex, currentIndex etc. 
    private void quickSort(int[] array, int startIndex, int endIndex)
    {
        // THE BASE CASE OF quickSort()
        // 
        // This if-statement triggers the end of the recursive loop. This occurs when an 
        // array or sub-array has less than two elements in it (one or fewer).
        // 
        // The rule is that the startIndex of the sort space should always be smaller 
        // than the endIndex. It does not make any sense otherwise. If startIndex is 
        // equal to endIndex, both indices are pointing to the same element; ergo, there 
        // is only one element in that list. This is too few to partition. If startIndex 
        // is less than endIndex, the sort space has a negative number of elements in it, 
        // which is quite meaningless. Therefore, we have to stop executing this method 
        // if either of these conditions occur. 
        if(startIndex >= endIndex) 
        { 
            return; 
        }
        // THE RECURSIVE CASE OF quickSort()
        // 
        // As long as startIndex < endIndex, the two indices are pointing to at least 
        // two separate elements. As long as this condition is true, it guarantees that 
        // the sort space has at least two elements in it. Two elements is the minimum 
        // size an array or sub-array needs in order to be partitioned. When the size 
        // of the array or sub-array drops below two, this condition check will fail and 
        // quickSort() will stop creating new partitions on that recursive branch.
        else if (startIndex < endIndex) 
        {
            // Call the partition() method to partition this array. partition() will 
            // select a new pivot element and use it to organize elements into two 
            // partitions. The pivot element will sit between the two partitions. It 
            // will also return the index of this new pivot value. 
            int pivotIndex = partition(array, startIndex, endIndex);
            
            
            // PARTITION CREATION
            // Now that the array has been partitioned into two blocks, the left 
            // partition should have all the elements less than the pivot and the right
            // partition should have all the elements greater than the pivot. 
            // 
            // This makes the array ready for division into smaller sub-arrays. The array
            // can now be formally demarcated into left and right partitions, with the
            // pivot serving as the point of division. 
            //
            // Note: The pivot does not fall into either partition. What happens to it?
            // It appears that the first partitioning pass puts the pivot into its final
            // position.
            
            
            // LEFT PARTITION: Designate all values between the startIndex and 
            // (pivotIndex - 1) to be part of the left partition. Recursively call 
            // quickSort() on the LEFT partition to partition it again. 
            quickSort(array, startIndex, pivotIndex - 1);

            // RIGHT PARTITION: Designate all values between (pivotIndex + 1) and 
            // endIndex to be part of the right partition. Recursively call quickSort() 
            // on the RIGHT partition to partition it again. 
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }

    
    /* THE partition() METHOD
     * 
     * This method kind of sorts the array, but not really. There is a reason why it is
     * called partition() instead of sort(). The partition() method will be given an 
     * array and two indices. partition() could be asked to work on the whole array or 
     * a part of it (sub-array). Therefore, the indices demarcate the boundaries of the 
     * space in which partition() should operate. 
     * 
     * The main purpose of this method is to compare an array or sub-array's elements 
     * to a specially selected element. Based on the outcome of this comparison, elements 
     * are filtered into one of two buckets. This process is called PARTITIONING and 
     * the buckets are called PARTITIONS. Understand that the partitions do not have to 
     * be of the same size. Therefore, the exact size of the partition is not known 
     * until after the winnowing process is done.  
     * 
     * To partition the array, an element called the PIVOT is selected from the array.
     * During partitioning, each element in the array will be compared to the pivot to 
     * determine if it is greater than or less than the pivot. Elements less than the 
     * pivot will get moved to first half of the array while elements greater than the 
     * pivot get moved to latter indices.
     * 
     * It's important to note that the process of partitioning does not create a 
     * perfectly sorted array/sub-array. It merely creates two partitions, separated by
     * the pivot value. Elements less than the pivot live at indices before the pivot
     * and elements greater than the pivot live at indices after the pivot. Once the 
     * array has been partitioned, control will return to the quickSort() method, which 
     * will formally divide the array into two separate arrays. 
     */
    private int partition(int[] array, int startIndex, int endIndex) 
    {
        // Pass in index values that demarcate the boundaries of the sort space to the 
        // getPivot() method. If they point to the first and last elements in the array, 
        // the sort space is the entire array. If the indices demarcate some subset of 
        // the array, then the sort space is a sub-array. getPivot() will randomly 
        // select an index from this sort space, including startIndex and endIndex, and 
        // return this value. The element at this index will serve as the pivot element.
        int pivotIndex = getPivot(startIndex, endIndex);

        // Call the swapElements() method which swaps the endIndex and pivotIndex
        // elements. This will move the pivot element to the rightmost position in the
        // array or sub-array, i.e. to the last index.
        swapElements(array, pivotIndex, endIndex);
        
        // Now that the pivot and last element has been swapped, the indexes need to be
        // updated as well. The pivotIndex is pointed to the last index in the array or 
        // sub-array, as this is the pivot element's new location.
        pivotIndex = endIndex;

        // nextSwapIndex will used to track elements that qualify to be swapped with 
        // the currentIndex element. Be aware that nextSwapIndex is an intrinsic cog in 
        // the partitioning process, but its role is probably the hardest thing to
        // understand in this algorithm. Pay close attention to it. More on this in 
        // the next comment.
        int nextSwapIndex = startIndex;
        
        
        /* THE SORTING LOOP: THE CORE MECHANICS OF QUICK SORT'S SORTING PROCESS
         * 
         * SHORT HIGH-LEVEL OVERVIEW
         * 
         * The quickSort() method is responsible for overseeing the full sorting of the 
         * array. As previously noted, it is the combination of partitioning, dividing of 
         * the array into smaller pieces and recursion that sorts the array. As such, 
         * quickSort() will repeatedly make recursive calls to itself, which in turn will 
         * result in the partition() method being called over and over.
         * 
         * Whenever the partition() method is called, quickSort() will give it an array 
         * or a subset of one. partition() will do ONE partitioning pass on it. This will
         * separate elements into two partitions. When the method ends, quickSort() can 
         * create two new sub-arrays and invoke partition() on both of them again.
         *
         * 
         * GENERAL OVERVIEW OF THE LOOP
         * 
         * This is the loop that does the partitioning in Quick Sort. It traverses the
         * array or sub-array and compares each element to the pivot value. The loop 
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
         * blocks of elements, ready for quickSort() demarcate the array into two 
         * new arrays.
         * 
         * So at the end of the sorting pass, the array should look like this: First the 
         * block of elements whose values are less than the pivot, followed by the pivot 
         * itself, and lastly, the block of elements that are greater than the pivot. 
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
         * partitioning. currentIndex will start at the beginning of the sort space 
         * (startIndex) and will be used to point to every element as the loop iterates 
         * through the array.
         * 
         * When the loop starts, it will run this check: (array[currentIndex] <= array[pivotIndex]). 
         * It asks: is the value of the current element (starting with the first element) 
         * less than or equal to the pivot element's value? 
         * 
         * If the value is GREATER, the body of the if-block is skipped, the loop moves 
         * on to checking the second element. Every time this happens, currentIndex is 
         * incremented by one.
         * 
         * However, if the current element's value is LOWER than the pivot's value, the
         * if-block's body is executed. This will swap the currentIndex and nextSwapIndex
         * elements. The nextSwapIndex will then be incremented by one and made to point 
         * to the next element in the list.
         * 
         * 
         * THE DYNAMICS OF THE LOOP
         * 
         * By testing for values less than or equal to the pivot, the if-check skips over
         * elements larger than the pivot, while swapping elements smaller than the pivot
         * into earlier indices. How is this done? 
         * 
         * Well, both currentIndex and nextSwapIndex start by pointing to the first index
         * in the array or partition and work their way (leftwards) to end of the array. 
         * While currentIndex is incremented frequently, nextSwapIndex is incremented 
         * only when a swap is done. Therefore, while both these variables start at 
         * startIndex, currentIndex quickly overtakes nextSwapIndex, and spends most of 
         * the loop pointing to indices later in the array.
         * 
         * The result of this dynamic is that currentIndex skips over values larger than 
         * the pivot that live earlier in the array while seeking out values lesser than
         * the pivot. These lesser elements are swapped into positions earlier in the 
         * array, starting at startIndex. This is nextSwapIndex's job. 
         * 
         * When currentIndex finds an element smaller than the pivot, it is swapped into 
         * the index that nextSwapIndex is pointing to. Then, nextSwapIndex is 
         * incremented by one to move past the swapped element and to mark the index 
         * where the next smaller element can be placed. Thus, if three elements have 
         * been swapped in an array thus far, nextSwapIndex will be pointing to index 3. 
         * If a fourth element smaller than the pivot is found, it will be swapped 
         * into index 3. 
         * 
         * The important thing to bear in mind is that partitioning does not sort the 
         * array, except if you get very lucky. Rather, it is partition()'s job to sort 
         * the array into two broad buckets separated at the pivot. This should result 
         * in three general blocks of elements: elements less than the pivot, the pivot, 
         * and elements greater than the pivot. So, if a swap should put a smaller 
         * element after a larger element in the first block, this does not matter very 
         * much as the only point of importance in partitioning is an element's value 
         * relative to the pivot's value. 
         * 
         * At the end of the partitioning, nextSwapIndex will be sitting between the 
         * block of elements whose values are less than the pivot and the block of 
         * elements greater than the pivot. Thus, this is where the new pivot for the 
         * array should be located. Therefore, when the loop ends, the last thing 
         * partition() does is swap the existing pivot element and nextSwapIndex element. 
         * The indices are also changed to match the swap. 
         */
        for(int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) 
        {
            // If the currentIndex element is LESS THAN the pivotIndex element...
            if(array[currentIndex] <= array[pivotIndex]) 
            {
                // ...Swap the current element with the nextSwapIndex element. 
                swapElements(array, currentIndex, nextSwapIndex);
                nextSwapIndex++;
            }
        }
        
        // SWAPPING THE PIVOT ELEMENT
        // When partitioning is complete, swap the pivot element and the nextSwapIndex
        // elements.
        swapElements(array, nextSwapIndex, pivotIndex);
        
        // Change the pivotIndex to point to the position of the new pivot element. 
        pivotIndex = nextSwapIndex;
        return pivotIndex;
    }


    // The getPivot() METHOD
    //
    // Returns a random pivot index between the low and high indices, inclusive. Note: 
    // Quick Sort has a tendency to have pathologically poor performance with very large
    // sets. If you want to prevent this from happening, replace this Pivot selection 
    // algorithm with a 'Median of Three Values' algorithm.
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


    // THE swapElements() METHOD
    // 
    // This method takes an array/sub-array and two indices. It swaps the elements at 
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
