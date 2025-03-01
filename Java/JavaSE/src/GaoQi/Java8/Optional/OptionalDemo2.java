package GaoQi.Java8.Optional;

import java.util.Optional;
import java.util.function.Predicate;

public class OptionalDemo2 {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty); // 输出：Optional.empty

        Optional<String>opt=Optional.of("太惨了");
        System.out.println(opt);

//        String name=null;
//        Optional<String>optnull=Optional.of(name);

        String name1 = null;
        Optional<String> optOrNull = Optional.ofNullable(name1);
        System.out.println(optOrNull); // 输出：Optional.empty

        System.out.println(opt.isPresent());
        System.out.println(optOrNull.isPresent());
        if (optOrNull.isPresent()) {
            System.out.println(optOrNull.get().length());
        }
        opt.ifPresent(str -> System.out.println(str.length()));

        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("沉默王二");
        System.out.println(name); // 输出：沉默王二

        String nullName1 = null;
        String name2 = Optional.ofNullable(nullName1).orElseGet(()->"沉默王二");
        System.out.println(name2); // 输出：沉默王二

        String name3 = "沉默王三";
        System.out.println("orElse");
        String name4 = Optional.ofNullable(name3).orElse(getDefaultValue());

        System.out.println("orElseGet");
        String name5 = Optional.ofNullable(name3).orElseGet(OptionalDemo2::getDefaultValue);



        System.out.println(optOrNull.get());
        String password = "12345";
        Optional<String> opt1 = Optional.ofNullable(password);
        System.out.println(opt1.filter(pwd -> pwd.length() > 6).isPresent());

        Optional<String> nameOptional = Optional.of(name);
        Optional<Integer> intOpt = nameOptional
                .map(String::length);

        System.out.println( intOpt.orElse(0));



        Predicate<String> len6 = pwd -> pwd.length() > 6;
        Predicate<String> len10 = pwd -> pwd.length() < 10;
        Predicate<String> eq = pwd -> pwd.equals("password");

        boolean result = opt1.map(String::toLowerCase).filter(len6.and(len10 ).and(eq)).isPresent();
        System.out.println(result);

    }
    public static String getDefaultValue() {
        System.out.println("获取默认值");
        return "默认值";
    }
}
