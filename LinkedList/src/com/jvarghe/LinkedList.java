/* LINKED LIST IMPLEMENTATION
 * 
 * TRACKING THE SIZE OF A LINKED LIST
 * 
 * Under normal circumstances, if you want to know how many elements there are in a Linked
 * List, you would have to traverse the list and count elements along the way. This is 
 * typically a linear time operation. This is the approach taken in this implementation.
 * 
 * However, you can use implementation tricks to track the number of elements as they are 
 * added or removed from a list. See the countNodes() method below. By tracking elements
 * as they enter or exit the Linked List, you can avoid traversing the Linked List when 
 * you need to know its size. By using an counter, you can turn this into a constant time
 * operation. 
 */


package com.jvarghe;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LinkedList<T extends Comparable<T>> implements Cloneable
{
    // This property refers to the Head of the Linked List, i.e., the first element.
    // Its initial value is set to NULL. When elements are added to the Linked List, the
    // first one will be denoted as the Head.
    private Node<T> head = null; 
    
    
    // METHODS:
    // LinkedList Constructor
    public LinkedList()
    {
        
    }
    
    
    // CALCULATING THE LINKED LIST'S SIZE
    // This operation has the following time complexity: O(N).
    public int countElements()
    {
        // If the Head is Null, then the Linked List is empty.
        if(head == null) 
        {
            return 0;
        }
        // If Head is not Null, then it contains elements. To obtain an element count,
        // the while-loop would traverse the list until the last element is hit. The last 
        // element's getNextNode value will be null, which will end the loop. 
        else
        {
            // Note that 'currentNodeReference' is functioning both as 'currentNode' and
            // 'currentNodeReference'. 
            Node<T> currentNodeReference = head;
            int elementCount = 0;
            
            // Iterate through node addresses until you hit the end of the array. Keep a
            // count of the number of elements.
            while(currentNodeReference != null)
            {
                currentNodeReference = currentNodeReference.getNextNode();
                elementCount++;
            }
            
            return elementCount;
        }
    }
    
    
    // RETURN THE FIRST ELEMENT OF THE LINKED LIST
    // Accesses the first element and pops it off the list. Extract its data and return 
    // it to the caller.
    public T popFirstElement()
    {
        // This variable will contain the data from the first element. 
        T firstElement = null;
        
        if(head == null)
        {
            return firstElement;
        }
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
        // ... if its not empty, find the last element and add the new element after it.
        else
        {
            // Set the current node to the head of this Linked List.
            Node<T> currentNode = head;
            Node<T> lastNode;

            // Iterate through the list to find the final element.
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
    // This method will insert an element at a user-specified index, called N. 
    public void insertElementAtIndexN(T elementValue, int index)
    {
        // If the provided index point is larger than the size of the Linked List, exit
        // without doing anything.
        if(index > countElements())
        {
            System.out.println("The index is larger than this Linked List!");
        }
        
        // If index is 0, make the new element the head. 
        if(index == 0)
        {
            // First, the existing head is made into the second node. Then, the new head
            // is created, loaded with its new element and formally declared to be the 
            // new head. Lastly, the head's nextNodeAddress property is set to point to 
            // the second node.
            Node<T> secondNode = head;
            head = new Node<T>(elementValue);
            head.setNextNode(secondNode);
        }
        // Find node (N - 1) and create and add a new node after it. Then, connect the 
        // new node to the old node that used to be at N. 
        else
        {
            int i = 0;
            Node<T> currentNode = head;
            
            // Traverse the list to the node immediately before N (the index of the 
            // new element).
            while(i < (index - 1))
            {
                currentNode = currentNode.getNextNode();
                i++;
            }
            
            // Add handles for the nodes that point to elements (N - 1) and N. In the 
            // next step, a node will be added between these two elements. 
            Node<T> nodeAtNMinusOne = currentNode;
            Node<T> nodeAtOldN = nodeAtNMinusOne.getNextNode();

            // Create the new node and load data into it. 
            Node<T> nodeAtNewN = new Node<T>(elementValue);
            
            // Connect node (N - 1) to the new node, then connect the new node to the old
            // node at N. 
            nodeAtNMinusOne.setNextNode(nodeAtNewN);
            nodeAtNewN.setNextNode(nodeAtOldN);
        }
    }


    // DELETE ALL ELEMENTS
    public void deleteAllElements()
    {
        // Setting Head to null will wipe out first reference in the chain of node 
        // references in an existing Linked List. Once executed, the rest of the Linked
        // List's elements will become inaccessible in memory and will probably will get
        // garbage collected.
        head = null;
    }


    // PRINT THE NODE VALUES TO SCREEN
    public void printElements()
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
