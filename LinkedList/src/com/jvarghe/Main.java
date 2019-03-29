/* LINKED LIST DATA STRUCTURE
 * 
 * 
 * A Linked List is a linear data structure, similar to an Array. Linked Lists exist to 
 * mitigate some of the drawbacks of an Array. 
 * 
 * This implementation is based on Loony Corn Studios' Linked List. 
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
 * scenes, the Java Runtime may have to create a new, larger array. It then has to copy
 * the first block of elements from the old array, the ones that occur earlier than the
 * index of the new element. Then the new element can be be added, followed by the second
 * block of elements whose indices are greater than that of the new element. The same 
 * process applies to the deletion an element. Thus, inserting or deleting elements from 
 * an array is a taxing operation. 
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
 *        element you are looking for. If you are doing lots of random access operations
 *        on a linked list, it will perform poorly. Use an Array instead, for they can
 *        do extremely fast element lookup (O(1)).
 *        
 *        This also makes algorithms like Binary Search much more inefficient when using 
 *        a Singly Linked List. Binary Search uses the Divide-and-Conquer strategy of
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
 *    2. Data Elements Take Up More Memory: than in an array due to references. If you 
 *       are working in a memory-limited environment, such as embedded devices, consider
 *       the use of Linked Lists carefully.
 *    
 *    3. Not Cache Friendly: A processor usually stores commonly used data in special 
 *       super-fast memory called a Cache. This lets the processor quickly look up data
 *       without making calls to the disk or memory. As such, such look-up operations 
 *       are lightning fast.
 *       
 *       When the processor starts using a certain piece of data, it may decide that the 
 *       entire block of data in and around this piece, whether it sits on disk or in 
 *       memory, will be needed in the immediate future. If this happens, the processor
 *       may load this entire block into the cache. This is related to a concept called
 *      'Spatial Locality'. 
 *       
 *       When the processor starts accessing elements in an array, it may decide to load
 *       the entire array into the cache for future use. This is helped by the fact that
 *       arrays are typically stored as contiguous blocks. 
 *       
 *       However, Linked Lists cannot take advantage of spatial locality by the cache 
 *       due to the fact that a Linked Lists elements may live anywhere in memory. This 
 *       makes reading from a Linked List many times slower than reading from an Array.
 *       A combination of caching and random access means that arrays are built for read
 *       operations. 
 *    
 *       
 * PERFORMANCE CHARACTERISTICS OF A LINKED LIST
 * 
 *    1. Adding a New Element to the End of a Linked List: O(N). With a simple 
 *       implementation, adding a new element would entail first traversing the Linked 
 *       List to find the last element. This is what makes it a linear operation. There 
 *       are implementation tricks to get around this. You can add a property to track 
 *       the last element, thereby cutting the time complexity of this operation to 
 *       O(1).  
 *    
 *    2. Adding a New Element to the Beginning of a Linked List: This is an easy 
 *       operation as Linked Lists normally track the Head element. The Head property 
 *       merely needs to be pointed to the new element. That makes this is an O(1)
 *      operation.
 *    
 *    3. Searching for an Element in a Linked List: is an O(N) operation. As the 
 *       architecture of a Linked List fundamentally resists faster search algorithms 
 *       like Binary Search, you are normally limited to a Linear search algorithms. 
 *       This means that the algorithm must find each element and compare it to the 
 *       search term, which on average requires iterating through the whole list. 
 *    
 *    4. Deleting the First Element in a Linked List: O(1). Once again, having a 
 *       reference to the Head element makes it super easy to locate and delete the 
 *       first element. This is a constant time operation.
 *    
 *    5. Deleting a Random Element in a Linked List: O(N). This is linear time operation 
 *       on average due to the search time. See point 3. 
 *    
 *    
 * QUICK SUMMARY OF TRADE OFFS
 * 
 * Choose Linked Links:
 * 
 *     * If you have a large number of elements whose size you cannot determine in 
 *       advance, or if you need to drastically change the size of your list. 
 *     
 *     * If you plan to perform many insertions and deletions on your list.
 *     
 *     
 * Choose Arrays:
 * 
 *     * When you need to make many random access operations. 
 *     
 *     * If you need to make lots of read operations on your list and comparatively 
 *       few update ops.
 */    

 
package com.jvarghe;


public class Main 
{

    public static void main(String[] args) 
    {
        // Create a Linked List. 
        LinkedList<String> marvelCharacters = new LinkedList<String>();
        
        // Add elements to it. 
        marvelCharacters.addNode("Hulk");
        marvelCharacters.addNode("Spider-Man");
        marvelCharacters.addNode("Thor");
        marvelCharacters.addNode("Deadpool");
        marvelCharacters.addNode("Dr. Strange");
        
        // Print the full list.
        System.out.println("Using the printElements() method to print all the original nodes in " +
                "this list:");
        marvelCharacters.printElements();
        System.out.println();
        
        
        // Add new nodes to the list.
        marvelCharacters.addNode("Storm");
        marvelCharacters.addNode("Rogue");
        marvelCharacters.addNode("Jean Grey");
        marvelCharacters.addNode("Professor X");
        marvelCharacters.addNode("Star-Lord");
        
        // Print out modified list.
        System.out. println("Added five new nodes to the list.");
        System.out.println("Printing out new list...");
        marvelCharacters.printElements();
        
        
        // Calculate the size of the linked list.
        System.out.println("The current size of the linked list is: " 
                + marvelCharacters.countElements());
        System.out.println();
        
        
        // Pop first element off the linked list. 
        String firstElement = marvelCharacters.popFirstElement();
        System.out.println("The first element was popped off the list. It's value is: " 
                + firstElement);
        
        System.out.println("Printing list again...");
        marvelCharacters.printElements();
        System.out.println();
        
        
        // Inserting a node at a specific index.
        marvelCharacters.insertElementAtIndexN("Captain America", 5);
        System.out.println("Inserted a new node, Captain America, at the fifth index in the list.");

        System.out.println("Printing list again...");
        marvelCharacters.printElements();
        System.out.println();
        
        
        // Deleting all nodes.
        marvelCharacters.deleteAllElements();
        System.out.println("Called the deleteAllElements() method on this linked list.");
        System.out.println("Attempting to call printElements() on this list...");
        System.out.print("Response: ");
        marvelCharacters.printElements();
    }
}
