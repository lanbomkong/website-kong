package september_28;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintC extends BasePrint{

  @Override
  public void print() {
//    synchronized (super.getClass()) {
      while (account != 3);
	  System.out.println("three");
	  log.info("execute thread C");
//	}
  }

  @Override
  public void run() {
	print();
  }
}
