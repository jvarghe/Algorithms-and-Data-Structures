/* NODE CLASS
 * 
 * This class models an element in a Linked List. An element is called a Node. A node has
 * two parts, the Data value for this element, and the address to the next node. 
 */


package com.jvarghe;

public class Node<T extends Comparable<T>> 
{
    // PROPERTIES:
    // The Value of the Element Stored in the Current Node.
    private T element; 
    
    // The Address of the Next Node.
    private Node<T> nextNode;
    
    
    // METHODS:
    // Node Constructor
    public Node(T value)
    {
        this.element = value;
        setNextNode(null);
    }
    
    
    // Element Getter: Return the Current Node's Data Value. 
    public T getElement()
    {
        return this.element;
    }
    
    // Element Setter: Set the Current Node's Data Value.
    public void setElement(T value)
    {
        this.element = value; 
    }
    
    
    // Next Node Getter: Get the Address of the Next Node. 
    public Node<T> getNextNode()
    {
        return this.nextNode;
    }
    
    // Next Node Setter: Set the Address of the Next Node. 
    public void setNextNode(Node<T> Node)
    {
        this.nextNode = Node;
    }
    
    
    // Overrides Java's String method in the base Object class to print Node class's 
    // values to screen. 
    @Override
    public String toString() { return String.valueOf(this.element); }
}
