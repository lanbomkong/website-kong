package september_17;

import org.springframework.util.Assert;

public class LeetCode_Number2Roma {

  public static void main(String[] args) {
    number2Roma(291);
  }

  public static void number2Roma(int num) {
	//力扣题库系统上限9999
	if (num > 9999) Assert.notNull(null, "num error");
	//力扣题目描述没给9000、5000的罗马字符，我自己破解出来了
	int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 0; i < 13; i++) {
	  while (num >= nums[i]) {
		stringBuilder.append(romans[i]);
		//罗马数字本质上就是个加法操作，把高位从低位依次枚举出来即可
		num -= nums[i];
	  }
	}
	System.out.println(stringBuilder.toString());
  }

}
