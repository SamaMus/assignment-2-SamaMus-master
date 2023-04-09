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

import given.iDeque;
import java.util.Iterator;
import given.Util;

//If you have been following the class, it should be obvious by now how to implement a Deque wth a doubly linked list
public class LLDeque<E> implements iDeque<E> {

  //Use sentinel nodes. See slides if needed
  private Node<E> header;
  private Node<E> trailer;

//  public abstract void addLast(Playlist.Song obj);
//
//  public abstract <E2> E2 removeFirst();
//
//  public abstract <E2> E2 peekFirst();
//
//  public abstract <E2> E2 peekFront();

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
    header = new Node<E>(null, null, null);
    trailer = new Node<E>(null, null, header);
    header.next = trailer;

    /*
     * ADD CODE IF NEEDED
     */
  }

  public String toString() {
    if (isEmpty())
      return "";
    StringBuilder sb = new StringBuilder(1000);
    sb.append("[");
    Node<E> tmp = header.next;
    while (tmp.next != trailer) {
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
    int count = 0;
    Node<E> curr = header.next;
    while (curr != trailer) {
      count++;
      curr = curr.next;
    }
    return count;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    return header.next == trailer;
  }

  @Override
  public void addFront(E o) {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    Node<E> newNode = new Node<E>(o, header.next, header);
    header.next.prev = newNode;
    header.next = newNode;
  }

  @Override
  public E removeFront() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty())
      return null;
    Node<E> nodeToRemove = header.next;
    header.next = nodeToRemove.next;
    header.next.prev = header;
    return nodeToRemove.element;
  }

  @Override
  public E front() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty())
      return null;
    return header.next.element;
  }

  @Override
  public void addBehind(E o) {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    Node<E> newNode = new Node<E>(o, trailer, trailer.prev);
    trailer.prev.next = newNode;
    trailer.prev = newNode;
  }

  @Override
  public E removeBehind() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty())
      return null;
    Node<E> nodeToRemove = trailer.prev;
    trailer.prev = nodeToRemove.prev;
    trailer.prev.next = trailer;
    return nodeToRemove.element;
  }

  @Override
  public E behind() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty()) {
      return null;
    }
    return null;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    header.next = trailer;
    trailer.prev = header;
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
        throw new NoSuchElementException();
      }
      E element = current.element;
      current = current.next;
      return element;
    }
  }
}
