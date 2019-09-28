package september_28;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintA extends BasePrint {



  @Override
  public void print() {

//    synchronized (super.getClass()){
	  System.out.println("one");
	  log.info("execute thread A");
	  account++;
//	}

  }

  @Override
  public void run() {
	print();
  }
}
