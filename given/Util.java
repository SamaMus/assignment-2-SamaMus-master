package given;

import java.util.Random;

/*
 * DO NOT MODIFY
 *
 * */

public class Util {
  public static void NotImplementedYet()
  {
    String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
      String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
      String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
      int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        
      String message = "Not implemented yet:" + System.lineSeparator() + className + "." + methodName + "():" + lineNumber;
        
      throw new UnsupportedOperationException(message);
  }
  
  public static void NotImplementedYetSoft()
  {
    String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
      String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
      String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
      int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        
      String message = "Not implemented yet:" + System.lineSeparator() + className + "." + methodName + "():" + lineNumber;
        
      System.out.println(message);
  }
  
  public static class myVector {
    
    float [] holder;
    int size;
    
    static Random r = new Random(System.currentTimeMillis());
    
    public myVector(int size) {
      holder = new float[size];
      if(size < 1)
        throw new IllegalArgumentException("Size must be a positive integer");
      this.size = size;
    }
    
    public float sum() {
      float sum = 0;
      for(int i = 0; i < size; i++) {
        sum += holder[i];  
      }
      
      return sum;
    }
    
    public float[] cumsum() {
      float[] csum = new float[size];
      csum[0] = holder[0];
      for(int i = 1; i < size; i++) {
        csum[i] = csum[i-1]+holder[i];  
      }
      
      return csum;
    }
    
    public void normalize() {
      float sum = sum();
      for(int i = 0; i < size; i++) {
        holder[i] /= sum;   
      }
    }
    
    private void checkIndex(int i) {
      if(i > size || i < 0)
        throw new ArrayIndexOutOfBoundsException("Trying to access " + i + " in a vector of size " + size);
    }
    
    public void set(int i, float x) {
      checkIndex(i);
      holder[i] = x;
    }
    
    public float get(int i) {
      checkIndex(i);
      return holder[i];
    }
    
    
    public int sampleIndex() {
      float[] csum = cumsum();
      float f = r.nextFloat()*csum[size-1];
      int i;
      for(i = 0; i < size-1; i++) {
        if(csum[i] >= f)
          break;
      }
      return i;
    }
    
    public void setSeed(long seed) {
      r.setSeed(seed); 
    }
  }
  
  

}
