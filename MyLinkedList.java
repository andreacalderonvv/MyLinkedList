/* Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources used: Zybooks, Write-Up
 */

import java.util.AbstractList;

/*
 * Implements a doubly link list and all the methods
 */

public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class
    public MyLinkedList() {
        /* Add your implementation here */
        // TODO
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    /**
     * returns the size of the list
     * @param
     */

    @Override
    public int size() {
        // need to implement the size method
        return size; // TODO
    }

    /**
     * returns the data of the node at the wanted index
     * @param index
     */

    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp = getNth(index);
        E other = temp.data;

        return (E) other;  // TODO
    }
    /**
     * adds the element at the wanted index
     * @param index
     */
    @Override
    public void add(int index, E data) {
        if (data == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if (size == 0){
            Node temp = new Node(data);
            head.next = temp;
            tail.prev = temp;
            temp.prev = head;
            temp.next = tail;
            size++;
        }
        else{
            Node temp = new Node(data);
            Node nRight = getNth(index);
            Node nLeft = getNth(index).prev;
            temp.prev = nLeft;
            temp.next = nRight;
            nRight.prev = temp;
            nLeft.next =  temp;
            size++;
        }
    }

    /**
     * adds data to the end of the list
     * @param data
     */
    @Override
    public boolean add(E data) {
        if (data == null){
            throw new NullPointerException();
        }
        if( size == 0){
            Node temp = new Node(data);
            head.next = temp;
            tail.prev = temp;
            temp.prev = head;
            temp.next = tail;
            size++;
        }
        else{
            Node temp = new Node(data);
            temp.next = tail;
            tail.prev = temp;
            getNth(size-1).next = temp;
            temp.prev = getNth(size-1);
            size++;
        }
        return true; // TODO
    }
    /**
     * sets old data to the new data of the node at the wanted index
     * @param index
     */
    @Override
    public E set(int index, E data) {
        if (data == null){
            throw new NullPointerException();
        }
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node temp = getNth(index);

        E other = temp.data;

        temp.data = data;

        return (E) other; // TODO
    }
    /**
     * removes node at wanted index
     * @param index
     */
    @Override
    public E remove(int index) {
        if( index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp = getNth(index);
        E other = temp.data;
        Node nRight = getNth(index).next;
        Node nLeft = getNth(index).prev;
        nRight.prev = nLeft;
        nLeft.next = nRight;
        size--;
        return (E) other; // TODO
    }
    /**
     * clears list of every non-sentinel node
     * @param
     */
    @Override
    public void clear() {
        /* Add your implementation here */
        if (size==0){
            size=0;
        }
        else{
        getNth(0).prev= null;
        getNth(size-1).next=null;
        head.next = tail;
        tail.prev = head;
        size=0;
        }
    }

    /**
     * checks if list is empty or not
     * @param
     */
    @Override
    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        }
        return false;  // TODO
    }

    /**
     * @returns returns node, not the data
     * @param index
     */
    protected Node getNth(int index) {
        if(index < 0 || index >= size){// may not be size.
            throw new IndexOutOfBoundsException();
        }
        Node temp= head;
        for ( int i = 0; i <= index; i++){

            temp = temp.next;
        }
        return (Node) temp;  // TODO
    }
}
