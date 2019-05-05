/*
  This is a classic example 
  - We have declare the getInstance() static so that we can call it without instantiating the class
  - Note that the singleton obj is not created untill we need it and call getInstance()
  - The classic implementation is not thread safe. i.e two threads can access the getInstance method at the same time and create objects
*/

class Singleton{
  private static Singleton obj;

  private Singleton() {}

  public static Singleton getInstance() {
    if(obj == null){
      System.out.println("New Singleton Object is created");
      obj = new Singleton();
    }
    System.out.println("Reusing the existing object");
    return obj;
  }
}

/*
  Make getInstance() method synchronized
  - Making the getInstance method synchronized
  - The main disadvantage is that using synchronized every time while creating singleton object is expensive 
  and may decrease the performance of the program.
*/

class Singleton{
  private static Singleton obj;

  private Singleton() {}

  public static synchronized Singleton getInstance() {
    if(obj == null){
      System.out.println("New Singleton Object is created");
      obj = new Singleton();
    }
    System.out.println("Reusing the existing object");
    return obj;
  }
}


/*
  Eager Instantiation
  - Here we have created instance of singleton in static initialized.
  - JVM executes static initializers when the class is loaded and hence is guaranteed to be thread safe
  - This method can be used only when the singleton class is light and is used throughout the execution of the program
*/

class Singleton {
  private static Singleton obj = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return obj;
  }
}


/*
  - As noticed once the object is created synchronization is no longer useful because now obj will not be null and any 
  seq of operation will return same result 
*/

class Singleton {

  private volatile static Singleton obj;

  private Singleton() {}

  public static Singleton getInstance() {

    if (obj == null) {
      synchronized (Singleton.class) {
        if (obj == null)
          obj = new Singleton();
      }
    }
    return obj;
  }
}