package code;

/*
 * ASSIGNMENT 2
 * AUTHOR:  <Sama Mustafazada >
 * Class : ArrayDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the Array Deque yourself
 *
 * MODIFY
 *
 * */

//import given.Util;
//import given.iDeque;

import given.Util;
import given.iDeque;

import java.util.Arrays;
import java.util.Iterator;


/*
 * You must have a circular implementation.
 *
 * WARNING: Modulo operator (%) might create issues with negative numbers.
 * Use Math.floorMod instead if you are having issues
 */
public class ArrayDeque<E> implements iDeque<E> {

  private E[] A; //Do not change this name!
  protected int front; //private
  protected int back; //private
  protected int size; //private
  /*
   * ADD FIELDS IF NEEDED
   */

  public ArrayDeque() {
    this(1000);
    /*
     * ADD CODE IF NEEDED
     */
  }

  public ArrayDeque(int initialCapacity) {
    if (initialCapacity < 1)
      throw new IllegalArgumentException();
    A = createNewArrayWithSize(initialCapacity);
    front = 0;
    back = 0;
    size = 0;
    /*
     * ADD CODE IF NEEDED
     */
  }

  // This is given to you for your convenience since creating arrays of generics is not straightforward in Java
  @SuppressWarnings({"unchecked"})
  private E[] createNewArrayWithSize(int size) {
    return (E[]) new Object[size];
  }

  //Modify this such that the dequeue prints from front to back!
  //Hint, after you implement the iterator, use that!
  public String toString() {

    /*
     * MODIFY THE BELOW CODE
     */

    StringBuilder sb = new StringBuilder(1000);
    sb.append("[");
    Iterator<E> iter = iterator(); //Arrays.asList(A).iterator();
    while (iter.hasNext()) {
      E e = iter.next();
      // if (e == null)
      // continue;
      sb.append(e);
      if (!iter.hasNext())
        sb.append("]");
      else
        sb.append(", ");
    }
    return sb.toString();
  }

  /*
   * ADD METHODS IF NEEDED
   */

  /*
   * Below are the interface methods to be overriden
   */
  public void resize(){
    E[] B = createNewArrayWithSize(A.length * 2);
    int i = 0;
    for(E e: this) {
      B[i++] = e;
    }
    front = 0;
    back = size -1;
    A = B;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
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
    if (size == A.length)
      resize();
    front = Math.floorMod(front - 1, A.length);
    A[front] = o;
    size++;

  }

  @Override
  public E removeFront() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty())
      return null;
    E removed = A[front];
    A[front] = null;
    front = Math.floorMod(front + 1, A.length);
    size--;
    return removed;
  }

  @Override
  public E front() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty())
      return null;
    return A[front];
  }

  @Override
  public void addBehind(E o) {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (size == A.length)
      resize();
    A[back] = o;
    back = Math.floorMod(back + 1, A.length);
    size++;
  }

  @Override
  public E removeBehind() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if (isEmpty())
      return null;
    back = Math.floorMod(back - 1, A.length);
    E removed = A[back];
    A[back] = null;
    size--;
    return removed;
  }

  @Override
  public E behind() {
    // TODO Auto-generated method stub
    Util.NotImplementedYetSoft();
    if ((isEmpty()))
      return null;
    return A[Math.floorMod(back - 1, A.length)];
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    Arrays.fill(A, null);
    front = 0;
    back = 0;
    size = 0;
  }

  //Must print from front to back
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    //Hint: Fill in the ArrayDequeIterator given below and return a new instance of it
    return new ArrayDequeIterator();
  }

  private final class ArrayDequeIterator implements Iterator<E> {
    private int index;
    private int count;

    public ArrayDequeIterator() {
      index = front;
      count = 0;
    }
    /*
     *
     * ADD A CONSTRUCTOR IF NEEDED
     * Note that you can freely access everything about the outer class!
     *
     */

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      return count < size;

    }

    @Override
    public E next() {
      // TODO Auto-generated method stub
      if (!hasNext())
        return null;
      E element = A[index];
      index = Math.floorMod(index + 1, A.length);
      count++;
      return element;
    }

//    private void resize() {
//      E[] B = createNewArrayWithSize(A.length * 2);
//      int i = 0;
//      for (E e : this) {
//        B[i++] = e;
//      }
//      A = B;
//      front = 0;
//      back = size;
//    }
  }
}
