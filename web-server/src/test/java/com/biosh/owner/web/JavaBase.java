package com.biosh.owner.web;

import org.junit.Test;

/**
 * @description java 基础
 * @date 2019/7/4
 */
public class JavaBase {

    /**
     *  1、JRE和JDK的区别
     */
    // JDK(Java Development Kit,Java开发工具包)，包含JRE(Java Runtime Environment, Java运行环境)，和调试器、java包等.

    /**
     * 2、equals() 和 == 的区别
     */
    // == 若比较的是基本数据类型，则比较值，否则比较对象
    // String的equals() 首先会通过==判断一下是否是同一个对象，然后比较类型,最后在比较值
    @Test
    public void testEquals() {
        int a = 1;
        double b = 1.0;
        Integer c = new Integer(1);
        String d = "string";
        String e = "string";
        String f = new String("string");
        StringBuilder g = new StringBuilder("string");
        System.out.println(a == b); // true,此时比较的是值
        System.out.println(b == c); // true,此时比较值，基本数据类型的包装类会自动拆箱
        System.out.println(d == e); // true,此时比较的是对象，但是d,e 都是指向的是常量池的同一个对象
        System.out.println(e == f); // false,比较的是对象，e指向的是常量池的对象。f指向的是堆内的对象
        System.out.println(f.equals(g)); // false,StringBuilder不是String类型
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    /**
     * 3、hashcode()相同，equals()不一定为true,equals()先判断hashcode()是否相同，进一步再判断值，
     * 不同值也可能会出现相同的hashcode，被称为hash碰撞
     */
    @Test
    public final void testHashCode() {
        JavaBase javaBase = new JavaBase();
        JavaBase javaBase1 = new JavaBase();
        System.out.println(javaBase.equals(javaBase1));
    }

    /**
     *  4、final在java中的作用
     *  final是个修饰符，可以修饰类、方法、变量
     */
    // 1、被final修饰的类不可被继承，所以接口和抽象类不可以被final修饰
    // 2、被final修饰的方法不可被重写
    // 3、被final修饰的变量为常量，不可修改

    /**
     * 5、Math.round(-1.5)的值 -1, 四舍五入
     */
    @Test
    public void testMath() {
        System.out.println(Math.round(-1.5));
    }

    /**
     * 6、String不属于基本数据类型，byte、short、int、long、float、double、boolean、char这八个基本数据类型，其他的都是引用类型
     */

    /**
     *  7、字符串操作类
     *  String,字符串常量
     *  StringBuilder，字符串变量
     *  StringBuffer，StringBuilder的安全版本
     */

    /**
     *  8、String str="i"与 String str=new String(“i”)一样吗？
     */
    // 不一样，前者在常量池中创建一个对象，后者在常量池和堆内都会创建对象

    /**
     * 9 、反串字符串 从两端往中间递归交换，
     */
    @Test
    public void testReverse() throws Exception {
        String str = "hello world !";
        char[] charArray = str.toCharArray();
        for (int i = 0, mid = charArray.length >> 1, j = charArray.length - 1; i < mid; i++, j--) {
            set(charArray, i, set(charArray,j,charArray[i]));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            stringBuilder.append(charArray[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    public char set(char[] charArray, int index, char newChar) throws Exception {
        if (index < 0 || index > charArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char temp = charArray[index];
        charArray[index] = newChar;
        return temp;
    }

    /**
     *  10、String类的常用方法
     */
    // valueOf() 转换成String类型
    // indexOf() 返回字符串出现的位置
    // subString() 截取字符串
    // split() 分割字符串
    // toCharArray() 将字符串转换成字符数组
    // equals() 比较两个字符串是否相等
    // format() 替代特殊字符
    // toLowerCase/toUpperCase 转换大小写
    // startWith/endWith 以xx开头/结尾
    // intern 加入常量池

    /**
     *  抽象类可以不包含抽象方法，但是抽象方法必须在抽象类或者接口中，而接口中只能有抽象方法和常量，不能有普通方法
     *  而抽象方法没有具体实现。所以得靠子类实现。所以不能用final修饰静态方法，final也不能修饰静态类和接口
     */

}
