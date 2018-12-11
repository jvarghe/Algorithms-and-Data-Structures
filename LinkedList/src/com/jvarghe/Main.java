 /* LINKED LIST DATA STRUCTURE
 * 
 * 
 * A Linked List is a linear data structure, similar to an Array. Linked Lists exist to 
 * mitigate some of the drawbacks of an Array. 
 * 
 * 
 * DRAWBACKS OF ARRAYS 
 * 
 * One drawback is that an array cannot be resized. This means that a programmer must 
 * know the number of elements to be stored within an array ahead of time, or at least 
 * she must have a approximate idea. The other other main drawback to an array is that,
 * in memory, its elements are stored in a contiguous block, which can cause problems if 
 * the array is very large. The third, and possibly worst drawback, is that inserting an
 * element in the middle of existing array is computationally expensive. Behind the 
 * scenes, the Java Runtime might have to create a new array and break up the the old one 
 * into two blocks. The JRE will have to insert the first block from the old array into 
 * the new array, after which it will insert the new element and then finally add the 
 * second block after the new element. The same process applies to the deletion an 
 * element.  
 * 
 * 
 * FEATURES OF A LINKED LIST
 * 
 * A Linked List is not a single, contiguous block of data. It is designed to be broken 
 * up into individual elements, which can be stored separately in memory. Each element 
 * is made up of two parts, a data element and a reference pointing to the address of the 
 * next element in the list. The first element is called HEAD. It contains a reference to
 * the second element, which contains both the data value and a reference to the third 
 * and so on, until the final element. The last element has a NULL value for its 
 * reference; this is how you know you have reached the final element in a Linked List. 
 * 
 * A Linked List brings two advantages over an Array: First, a Linked List has dynamic 
 * size. It can be re-sized with much greater ease than an Array. If you want to add 50%
 * more elements to the Linked List, simply append them to the last existing element. The 
 * second benefit is just the ease of adding and deleting elements. To add an element to 
 * a Linked List, simply find the point where you want to insert the element, insert it 
 * and update the references of the new element and the previous one. Deleting an element 
 * is just as easy.
 * 
 * Nevertheless, swapping an array for a linked list comes with certain drawbacks. These
 * are some of them:
 * 
 *     1. No Random Access: With an array, you can simply skip to the 54th element and 
 *        access its value. This is not as easy in a Linked List. Finding an element 
 *        requires starting at the head and following the references until you find the
 *        element you are looking for. 
 *        
 *        This makes algorithms like Binary Search are much more inefficient when using a 
 *        Singly Linked List. Binary Search uses the Divide-and-Conquer strategy of
 *        cutting the search space in half to find the search value. This involves finding
 *        the middle value in an ordered lists of values. In an array, finding the middle
 *        value is an O(1) operation when it comes to time complexity. In an Linked List, 
 *        finding the middle value requires traversing the thread of references through 
 *        the elements until you find the one you want. In terms of time complexity, this
 *        is much more expensive: Binary Search implemented with an Array takes log time,
  *       (O(log N)), whereas the same algorithm implemented on a Linked List would take
  *       linear time (O(N)), which is on the same order as a sequential search algorithm
  *       on average.
  *       
  *    2. Data Elements Take Up More Memory: than in an array due to references. 
  *    
  *    3. Not Cache Friendly: Due to the fact that Arrays are contiguous blocks and Linked
  *       Lists are not, Linked Lists are not cache friendly. 
  *       
  *       
  * PERFORMANCE CHARACTERISTICS OF A LINKED LIST
  * 
  * 1. Adding a New Element to the End of a Linked List: O(N). With a simple 
  *    implementation, adding a new element would entail first traversing the Linked List
  *    to find the last element. This is what makes it a linear operation. There are 
  *    implementation tricks to get around this. You can add a property to track the last
  *    element, thereby cutting the time complexity of this operation to O(1).  
  *    
  * 2. Adding a New Element to the Beginning of a Linked List: This is an easy operation 
  *    as Linked Lists normally track the Head element. The Head property merely needs to
  *    be pointed to the new element. That makes this is an O(1) operation.
  *    
  * 3. Searching for an Element in a Linked List: is an O(N) operation. As the 
  *    architecture of a Linked List fundamentally resists faster search algorithms like 
  *    Binary Search, you are normally limited to a Linear search algorithms. This means 
  *    that the algorithm must find each element and compare it to the search term, which 
  *    on average requires iterating through the whole list. 
  *    
  * 4. Deleting the First Element in a Linked List: O(1). Once again, having a reference
  *    to the Head element makes it super easy to locate and delete the first element. 
  *    This is a constant time operation.
  *    
  * 5. Deleting a Random Element in a Linked List: O(N). This is linear time operation on
  *    average due to the search time. See point 3. 
  */    
 
 
package com.jvarghe;

public class Main 
{

    public static void main(String[] args) 
    {
        
    }
}
