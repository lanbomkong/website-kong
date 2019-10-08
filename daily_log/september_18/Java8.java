import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2019/9/18
 */
public class Java8 {

    /**
     * 1、lambda表达式
     * 2、stream 流（过滤, 排序, 聚合）
     * 3、optional 空指针处理
     * 4、函数式编程（默认方法， 静态方法）
     * 5、方法引用  ::直接调用方法
     */
    public static void java8Forlambda() {

        List<Integer> res = Arrays.asList(1, 2, 22, 228, 3);

        // 过滤
        List<Integer> collect = res.stream().filter(o -> o > 3).collect(Collectors.toList());
        System.out.println("大于3的元素：" + collect);

        // 排序
        List<Integer> collect1 = res.stream().sorted().collect(Collectors.toList());
        System.out.println("排序后的集合：" + collect1);

        List<Person> peoples = Arrays
                .asList(new Person("张三", 12, "beijing"), new Person("李四", 22, "shijiazhuang"),
                        new Person("王老五", 23, "beijing"));

        // 聚合
        Map<String, List<Person>> collect2 = peoples.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        System.out.println(collect2);


    }

    public static void main(String[] args) {
        java8Forlambda();
    }
}
