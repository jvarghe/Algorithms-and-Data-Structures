package com.jvarghe;

public class LinkedList<T extends Comparable<T>> implements Cloneable
{
    // This property refers to the Head of the Linked List, i.e., the first element.
    // Its initail value is set to NULL. When elements are added to the Linked List, the
    // first one will be denoted as the Head.
    private Node<T> head = null; 
}
