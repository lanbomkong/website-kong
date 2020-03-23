package september_28;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintB extends BasePrint {

  @Override
  public void print() {
//	synchronized (super.getClass()) {

	  while (account != 2) ;
	  System.out.println("two");
	  log.info("execute thread B");
	  account++;
//	}
  }

  @Override
  public void run() {
	print();
  }
}
