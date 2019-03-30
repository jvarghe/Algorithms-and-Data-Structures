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
 * One of the main drawbacks of an array is that it cannot be resized. This means that a 
 * programmer must know the number of elements to be stored within the array ahead of 
 * time, or at least she must have a approximate idea. The other other main drawback to 
 * an array is that, in memory, its elements are stored in a contiguous block, which can 
 * cause problems if the array is very large. 
 * 
 * The third, and possibly worst drawback, is that inserting an element in the middle of 
 * existing array is computationally expensive. If the array overflows, behind the scenes, 
 * the Java Runtime may have to create a new, larger array just to contain the new 
 * element. Then, the runtime will have to copy three different blocks of elements from 
 * the old array into the new array: the first being the block of elements that occur 
 * before the new element, followed by the new element itself, and finally, the block of 
 * elements that occur after the new element. This process must also be applied to an 
 * array when an element is deleted. Thus, inserting or deleting elements from an array 
 * is a very taxing operation. 
 * 
 * 
 * FEATURES OF A LINKED LIST
 * 
 * A Linked List is not a single, contiguous block of data. It is designed to be broken 
 * up into individual elements which are stored separately in memory. Each element in a 
 * Linked List is called a NODE. Nodes have two parts: the actual data element and a 
 * reference pointing to the address of the next node in the list. 
 * 
 * The first element in a Linked List is called the HEAD. The head contains a reference 
 * that points to the second node, which contains both a data value and a reference to 
 * the third node and so on, creating a chain of elements and references that extend to 
 * the final node in the Linked List. The last element has a NULL value for its reference, 
 * which is how you know you have reached the final element in a Linked List. 
 * 
 * A Linked List brings two advantages over an Array: First, a Linked List has dynamic 
 * size. It can be re-sized with much greater ease than an Array. This ameliorates one of
 * biggest drawbacks of arrays, namely, the addition and deletion of elements. If you 
 * want to add 50% more elements to the Linked List, simply append them to the last 
 * existing element. If you wish to add an element to a Linked List a specific index, the
 * Linked Lists can skip the gymnastics of having the runtime create new arrays. Simply 
 * specify the point where you want to insert the element, and the runtime will add a new
 * node there. The only cost to doing this is updating the references of the node 
 * immediately before the new node (to point to the new node) and the new node (to point
 * to the next node). Deleting an element is just as easy.
 * 
 * Nevertheless, swapping an array for a linked list comes with certain drawbacks. These
 * are some of them:
 * 
 *    1. No Random Access: With an array, you can simply skip to the 54th element and 
 *       access its value. This is not as easy in a Linked List. Finding an element 
 *       value requires starting at the head and following the chain of references until 
 *       you find the node you are looking for. This mean that if you are doing lots of 
 *       random access operations on a linked list, it will perform poorly. Use an Array 
 *       instead, for they can do extremely fast element lookup (O(1)).
 *        
 *       No random access makes algorithms like Binary Search much more inefficient when 
 *       executed on a Singly Linked List. Binary Search uses the Divide-and-Conquer 
 *       strategy of cutting the search space in half to find the search value. This 
 *       involves finding the middle value in an ordered lists of values. In an array, 
 *       finding the middle value is an O(1) operation when it comes to time complexity. 
 *        
 *       In an Linked List, finding the middle value requires traversing the thread of 
 *       references through the elements until you find the one you want. In terms of 
 *       time complexity, this is much more expensive than an array: it's a linear 
 *       operation (O(N)) on average. Binary Search implemented on an Array takes log 
 *       time, (O(log N)), whereas the same algorithm implemented on a Linked List would 
 *       take linear time (O(N)). In other words, the lack of random access in a Linked
 *       List slows down the Binary Search algorithm to the point where it has the same 
 *       time complexity as the sequential search algorithm on average. Remember that 
 *       the sequential search algorithm is one of the slowest and least efficient 
 *       search algorithms. 
 * 
 *       Clearly, you should not use Linked Lists if you intend to do lots of random
 *       access operations. 
 * 
 *       
 *    2. Data Elements Take Up More Memory: than in an array due to references. If you 
 *       are working in a memory-limited environment, such as embedded devices, consider
 *       the use of Linked Lists carefully.
 *    
 * 
 *    3. Not Cache Friendly: A processor usually stores commonly used data in a special 
 *       super-fast on-CPU memory called a CPU CACHE. This lets the processor quickly 
 *       look up data without making calls to the disk or memory. As such, such look-up 
 *       operations are lightning fast.
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
 *       However, as Linked Lists are typically not stored as contiguous blocks on disk 
 *       or in memory, the processor cannot load entire Linked Lists into a CPU's cache.
 *       Thus, Linked Lists cannot take advantage of spatial locality by the cache due to 
 *       the fact that a Linked List's elements may live anywhere in memory. 
 * 
 *       Thus, Linked Lists are not cache-friendly. This makes reading from a Linked List 
 *       many times slower than reading from an Array. As Linked Lists's have a dual 
 *       combination of cache-unfriendliness and inefficiency at random access operations 
 *       means that arrays perform better than Linked Lists at read operations. 
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
 *    
 *    2. Adding a New Element to the Beginning of a Linked List: This is an easy 
 *       operation as Linked Lists normally track the Head element. The Head property 
 *       merely needs to be pointed to the new element. That makes this is an O(1)
 *       operation.
 * 
 *    
 *    3. Searching for an Element in a Linked List: is an O(N) operation. As the 
 *       architecture of a Linked List fundamentally resists faster search algorithms 
 *       like Binary Search, you are normally limited to a Linear search algorithms. 
 *       This means that the algorithm must find each element and compare it to the 
 *       search term, which on average requires iterating through the whole list. 
 *    
 * 
 *    4. Deleting the First Element in a Linked List: O(1). Once again, having a 
 *       reference to the Head element makes it super easy to locate and delete the 
 *       first element. This is a constant time operation.
 * 
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
 *       advance, or if you know you will need to drastically and/or repeatedly change 
 *       the size of your linear data structure.  
 *     
 *     * If you plan to perform many element insertions and deletions on your list.
 *     
 *     
 * Choose Arrays:
 * 
 *     * When you need to make many random access operations. 
 *     
 *     * If you need to make lots of read operations on your list and comparatively 
 *       fewer update operations.
 */    

 
package com.jvarghe;


public class Main 
{

    public static void main(String[] args) 
    {
        // 1. Create a Linked List. 
        LinkedList<String> marvelCharacters = new LinkedList<String>();
        
        // 2. Add elements to it. 
        marvelCharacters.addNode("Hulk");
        marvelCharacters.addNode("Spider-Man");
        marvelCharacters.addNode("Thor");
        marvelCharacters.addNode("Deadpool");
        marvelCharacters.addNode("Dr. Strange");
        
        // Print the full list.
        System.out.println();
        System.out.println("Using the printNodes() method to print all the original " +
                "nodes in this list:");
        marvelCharacters.printNodes();
        System.out.println();
        
        
        // 3. Add new nodes to the list.
        marvelCharacters.addNode("Storm");
        marvelCharacters.addNode("Rogue");
        marvelCharacters.addNode("Jean Grey");
        marvelCharacters.addNode("Professor X");
        marvelCharacters.addNode("Star-Lord");
        
        // Print out modified list.
        System.out. println("Added five new nodes to the list.");
        System.out.println("Printing out new list...");
        marvelCharacters.printNodes();
        System.out.println();
        
        
        // 4. Calculate the size of the linked list.
        System.out.println("The current size of the linked list is: " 
                + marvelCharacters.countNodes());
        System.out.println();
        
        
        // Pop first element off the linked list. 
        String firstElement = marvelCharacters.popFirstNode();
        System.out.println("The first element was popped off the list. It's value is: " 
                + firstElement);
        
        System.out.println("Printing list again...");
        marvelCharacters.printNodes();
        System.out.println();
        
        
        // 5. Inserting a node at a specific index.
        marvelCharacters.insertNodeAtIndex("Captain America", 5);
        System.out.println("Inserted a new node, Captain America, at the fifth index in the list.");

        System.out.println("Printing list again...");
        marvelCharacters.printNodes();
        System.out.println();
        
        
        // 6. Deleting all nodes.
        marvelCharacters.deleteAllNodes();
        System.out.println("Called the deleteAllNodes() method on this linked list.");
        System.out.println("Attempting to call printNodes() on this list...");
        System.out.print("Response: ");
        marvelCharacters.printNodes();
    }
}
