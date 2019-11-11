import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2019/9/18
 */
public class Java8 {

        public int trap(int[] height) {

            return 0;
        }

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

    public static List<List<Integer>> threeSumAnother(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<String> repeatList = new ArrayList<>();
        List<String> minusNum = new ArrayList<>();
        List<String> positiveNum = new ArrayList<>();
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                minusNum.add(new StringBuilder(String.valueOf(nums[i])).append(",").append(i).toString());
            } else {
                positiveNum.add(new StringBuilder(String.valueOf(nums[i])).append(",").append(i).toString());
            }

            intMap.put(nums[i], i);
        }

        minusNum.forEach(min->{
            String[] minArray = min.split(",");
            int minKey = Integer.valueOf(minArray[0]);
            int minVal =  Integer.valueOf(minArray[1]);

            positiveNum.forEach(pos->{
                String[] posArray = pos.split(",");
                int posKey =Integer.valueOf(posArray[0]);
                int posVal =Integer.valueOf(posArray[1]);


                int anoNum = 0-minKey-posKey;
                Integer anotherNum = intMap.get(anoNum);
                if (!StringUtils.isEmpty(anotherNum) && anotherNum != posVal && anotherNum != minVal) {
                    List list = new ArrayList<>();
                    list.add(minKey);
                    list.add(posKey);
                    list.add(anoNum);
                    Collections.sort(list);
                    String listStr = new StringBuilder(list.get(0).toString()).append(",").append(list.get(1)).append(",").append(list.get(2)).toString();
                    if (!repeatList.contains(listStr)) {
                        repeatList.add(listStr);
                        res.add(list);
                    }
                }
            });

        });

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSumAnother(new int[]{-1, 0, 1, 2, -1, -4});
        lists.forEach(list -> {
            list.forEach(num -> {
                System.out.print(num);
            });
            System.out.println("-----");
        });
        java8Forlambda();
    }
}
