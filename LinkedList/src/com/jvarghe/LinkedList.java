/* LINKED LIST IMPLEMENTATION
 * 
 * TRACKING THE SIZE OF A LINKED LIST
 * 
 * Under normal circumstances, if you want to know how many nodes there are in a Linked
 * List, you would have to traverse the list and count elements along the way. This is 
 * usually a linear time operation. This is the approach taken in this implementation.
 * 
 * However, note that you can use implementation tricks to track the number of nodes as 
 * they are added or removed from a list. For example, with the help of a nodeCount 
 * property (which is has not been done in this implementation) you can track elements as 
 * they enter or exit the Linked List. This way, you can avoid traversing the Linked List 
 * when you need to know its size. By using this implementation trick, you can turn this 
 * from a linear operation into a constant time operation. 
 */


package com.jvarghe;


public class LinkedList<T extends Comparable<T>> implements Cloneable
{
    // PROPERTIES:
    // This property refers to the Head of the Linked List, i.e., the first node. Its 
    // initial value is set to NULL. When elements are added to the Linked List, the 
    // first one will be denoted as the Head.
    private Node<T> head = null; 
    
    
    // METHODS:
    // LinkedList Constructor
    public LinkedList()
    {
        
    }
    
    
    // CALCULATING THE LINKED LIST'S SIZE
    // This operation has the following time complexity: O(N).
    public int countNodes()
    {
        // If the Head is Null, then the Linked List is empty.
        if(head == null) 
        {
            return 0;
        }
        // If Head is not Null, then it contains nodes. To obtain an element count, the 
        // while-loop will traverse the list until the last node is hit. The last 
        // node's getNextNode value will be null, which will end the loop. 
        else
        {
            // Note that because Node class's nextNode property is private, you cannot 
            // use it obtain the next node's address. Instead, a variable called 
            // 'currentNode' is used to track nodes as the Linked List is traversed.
            int nodeCount = 0;
            Node<T> currentNode = head;
            
            // Iterate through nodes until the next node is null, i.e. until the end of 
            // the Linked List. Keep a count of the number of elements.
            while(currentNode != null)
            {
                currentNode = currentNode.getNextNode();
                nodeCount++;
            }
            
            return nodeCount;
        }
    }
    
    
    // RETURN THE FIRST ELEMENT OF THE LINKED LIST
    // Accesses the first node and pops it off the list. The Linked List will shrink by 
    // one node and the second node will become the new first node. When the head is
    // popped off, its data element is extracted and returned to the caller.
    public T popFirstNode()
    {
        // This variable will contain the data from the first element. 
        T firstElement = null;
        
        // If the Linked List is empty, return null. 
        if(head == null)
        {
            return firstElement;
        }
        // Otherwise, extract and return the data element from the first node and set the
        // second node to be the new first node. 
        else if(head != null)
        {
            firstElement = head.getElement();
            head = head.getNextNode();
        }
        
        return firstElement;
    }


    // ADD A NEW NODE
    // Appends a new node to the end of the Linked List.
    public void addNode(T elementValue)
    {
        // If the Linked List is empty, just add the new element...
        if(head == null)
        {
            head = new Node<T>(elementValue);
        }
        // ...if its not empty, find the last node and add the new element after it.
        else
        {
            // Set the current node to the head of this Linked List.
            Node<T> currentNode = head;
            Node<T> lastNode;

            // Iterate through the list to find the final node. The while loop checks
            // whether the next node is null while iterating through the list. When the
            // loop reaches the end of the list, currentNode should be pointing to the
            // last node. 
            while(currentNode.getNextNode() != null)
            {
                currentNode = currentNode.getNextNode();
            }

            // Transfer the value of 'currentNode', which, at the end of the loop, should 
            // be the last node, into the new variable called 'lastNode'.
            lastNode = currentNode;
            // Add the new node.
            lastNode.setNextNode(new Node<T>(elementValue));
        }
    }
    
    
    // INSERT AN ELEMENT AT A SPECIFIC INDEX
    // This method will create a new node and insert an element at a user-specified index 
    // called N. 
    // 
    // Note that due to the fact that linear data structure indices start count at 0, for 
    // any index N, the actual position of the new element in the list will be at position 
    // N + 1. E.g. If the specified index is 5, the new node will be sixth node in the 
    // list. 
    public void insertNodeAtIndex(T elementValue, int index)
    {
        // If the provided index number is larger than the size of the Linked List or 
        // smaller than 0, exit without doing anything.
        if((index > countNodes()) || (index < 1))
        {
            System.out.println("The index is outside the of bounds of this Linked List!");
        }
        
        // If index is 0, make the new node the head. 
        if(index == 0)
        {
            // First, the existing head is made into the second node. Then, a new node
            // is created, loaded with its element and formally declared to be the new 
            // head. Lastly, the head's nextNode property is set to point to the second 
            // node.
            Node<T> secondNode = head;
            head = new Node<T>(elementValue);
            head.setNextNode(secondNode);
        }
        // If the index is greater than 0, find the node at index N - 1. Create and add a 
        // new node after index N - 1. Load the new element into it and connect the new 
        // node to 'nodeAtNMinusOne' and the old node that used to be at N. 
        else
        {
            int i = 0;
            Node<T> currentNode = head;
            
            // Traverse the list to the node immediately before N, so that we can add the
            // new node right after it.
            while(i < (index - 1))
            {
                currentNode = currentNode.getNextNode();
                i++;
            }
            
            // Add variables for the nodes that point to elements N - 1 and N. In the 
            // next step, a node will be added between these two elements. 
            Node<T> nodeAtNMinusOne = currentNode;
            Node<T> nodeAtOldN = nodeAtNMinusOne.getNextNode();

            // Create the new node and load data into it. 
            Node<T> nodeAtIndexN = new Node<T>(elementValue);
            
            // Connect nodeAtNMinusOne to the new node, then connect the new node to the 
            // old node at N. 
            nodeAtNMinusOne.setNextNode(nodeAtIndexN);
            nodeAtIndexN.setNextNode(nodeAtOldN);
        }
    }


    // DELETE ALL NODES
    public void deleteAllNodes()
    {
        // Setting Head to null will wipe out first reference in the chain of node 
        // references in an existing Linked List. Once executed, the rest of the Linked
        // List's elements will become inaccessible in memory and will probably will get
        // garbage collected.
        head = null;
    }


    // PRINT THE NODE VALUES TO SCREEN
    public void printNodes()
    {
        if(head == null)
        {
            System.out.println("The Linked List is Empty.");
        }
        else
        {
            Node<T> currentNode = head;
            
            int i = 1; 
            while(currentNode != null)
            {
                System.out.println("Node Number " + i + ": " + currentNode.toString());
                currentNode = currentNode.getNextNode();
                i++;
            }
        }
    }
}
