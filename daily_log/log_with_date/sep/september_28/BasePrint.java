package september_28;

/**
 *
 */
public abstract class BasePrint implements Runnable{

  public volatile static int account = 1;

  abstract void print();


}
