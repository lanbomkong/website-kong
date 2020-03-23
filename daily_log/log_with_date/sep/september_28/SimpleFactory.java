package september_28;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFactory {

  /**
   * 简单工厂， 根据传入的参数创建响应的对象
   * @param num
   * @return print实例
   */
  public static BasePrint createPrint(int num) {
	BasePrint basePrint;
	switch (num) {
	  case 1:
		basePrint = new PrintA();
		break;
	  case 2:
		basePrint = new PrintB();
		break;
	  case 3:
		basePrint = new PrintC();
		break;
	  default:
		log.error(String.format("parameter num %s is error", num));
		throw new RuntimeException("num is error");
	}
	return basePrint;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
	for (int i = 1; i < nums.length+1; i++) {
	  Thread thread = new Thread(createPrint(i));
	  thread.start();
	}
  }

}
