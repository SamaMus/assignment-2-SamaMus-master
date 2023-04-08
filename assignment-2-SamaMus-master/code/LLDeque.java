package code;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  <Insert Student Name>
 * Class : LLDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the linked list yourself
 * Note that it should be a doubly linked list
 *
 * MODIFY 
 * 
 * */

import given.Util;
import given.iDeque;

import java.util.Iterator;

//If you have been following the class, it should be obvious by now how to implement a Deque wth a doubly linked list
public class LLDeque<E> implements iDeque<E> {
  
  //Use sentinel nodes. See slides if needed
  private Node<E> header;
  private Node<E> trailer;
  private int size;
  
  /*
   * ADD FIELDS IF NEEDED
   */

  // The nested node class, provided for your convenience. Feel free to modify
  private class Node<T> {
    private T element;
    private Node<T> next;
    private Node<T> prev;
    /*
     * ADD FIELDS IF NEEDED
     */
    
    Node(T d, Node<T> n, Node<T> p) {
      element = d;
      next = n;
      prev = p;
    }
    
    /*
     * ADD METHODS IF NEEDED
     */
  }
  
  public LLDeque() {
    //Remember how we initialized the sentinel nodes
    header  = new Node<E>(null, null, header);
    trailer = new Node<E>(null, trailer, header);
    header.next = trailer;
    size = 0;
    
    /*
     * ADD CODE IF NEEDED
     */
  }
  
  public String toString() {
    if(isEmpty())
      return "";
    StringBuilder sb = new StringBuilder(1000);
    sb.append("[");
    Node<E> tmp = header.next;
    while(tmp.next != trailer) {
      sb.append(tmp.element.toString());
      sb.append(", ");
      tmp = tmp.next;
    }
    sb.append(tmp.element.toString());
    sb.append("]");
    return sb.toString();
  }
  
  /*
   * ADD METHODS IF NEEDED
   */
  
  /*
   * Below are the interface methods to be overriden
   */

  @Override
  public int size() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    return size == 0;
  }

  @Override
  public void addFront(E o) {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    Node<E> newNode = new Node<>(o, header.next, header);
    header.next.prev = newNode;
    header.next = newNode;
    size++;
  }

  @Override
  public E removeFront() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty()) {
      return null;
    }
    Node<E> front = header.next;
    header.next = front.next;
    front.next.prev = header;
    size--;
    return front.element;
  }

  @Override
  public E front() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty()) {
      return null;
    }
    return header.next.element;
  }

  @Override
  public void addBehind(E o) {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    Node<E> newNode = new Node<>(o, trailer, trailer.prev);
    trailer.prev.next = newNode;
    trailer.prev = newNode;
    size++;
  }

  @Override
  public E removeBehind() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if(isEmpty()){
      return null;
  }
    Node<E> behind = trailer.prev;
    trailer.prev = behind.prev;
    behind.prev.next = trailer;
    size--;
    return behind.element;
  }


  @Override
  public E behind() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if(isEmpty()) {
      return null;
    }
    return trailer.prev.element;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    header.next = trailer;
    trailer.prev = header;
    size = 0;
    
  }
  
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    //Hint: Fill in the LLDequeIterator given below and return a new instance of it
    return new LLDequeIterator();
  }
  
  private final class LLDequeIterator implements Iterator<E> {
    private Node<E> current = header.next;
    /*
     * 
     * ADD A CONSTRUCTOR IF NEEDED
     * Note that you can freely access everything about the outer class!
     * 
     */

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      return current != trailer;
    }

    @Override
    public E next() {
      // TODO Auto-generated method stub
      if (!hasNext()) {
        return null;
      }
      E element = current.element;
      current = current.next;
      return element;
    }
  }
  
}
