package GaoQi.Java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {

        String[]arr=new String[]{"12sdfsd","1sdfasfas","jhouihj2"};
        Stream<String>stream= Arrays.stream(arr);

        stream=Stream.of("12sdfsd","1sdfasfas","jhouihj2");

        List<String>list=new ArrayList<>();
        list.add("12sdfsd");
        list.add("1sdfasfas");
        list.add("jhouihj2");
        Stream<String>stream2=list.stream();

        List<String> list1 = new ArrayList<>();
        list1.add("周杰伦");
        list1.add("王力宏");
        list1.add("陶喆");
        list1.add("林俊杰");
        System.out.println("11111111111111111111111111111");
        Stream<String> stream1 = list1.stream().filter(element -> element.contains("王"));
        stream1.forEach(System.out::println);

        System.out.println("22222222222222222222222222");
        Stream<Integer> stream3 = list1.stream().map(String::length);
        stream3.forEach(System.out::println);

        System.out.println("3333333333333333333333333");
        boolean  anyMatchFlag = list1.stream().anyMatch(element -> element.contains("王"));
        boolean  allMatchFlag = list1.stream().allMatch(element -> element.length() > 1);
        boolean  noneMatchFlag = list1.stream().noneMatch(element -> element.endsWith("沉"));
        System.out.println(anyMatchFlag);
        System.out.println(allMatchFlag);
        System.out.println(noneMatchFlag);


        System.out.println("-----------------------------");
        Integer[] ints = {0, 1, 2, 3};
        List<Integer> list4 = Arrays.asList(ints);

        Optional<Integer> optional = list4.stream().reduce((a, b) -> a + b);
        Optional<Integer> optional1 = list4.stream().reduce(Integer::sum);
        System.out.println(optional.orElse(0));
        System.out.println(optional1.orElse(0));

        int reduce = list4.stream().reduce(6, (a, b) -> a + b);
        System.out.println(reduce);
        int reduce1 = list4.stream().reduce(6, Integer::sum);
        System.out.println(reduce1);



    }
}
