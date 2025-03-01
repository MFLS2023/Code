package GaoQi.Utils.objectutils;

import java.util.Objects;
public class ObjectsDemo1 {
    public static void main(String[] args) {
        Integer integer=new Integer(1);
        if(Objects.isNull(integer)){
            System.out.println("integer is null");
        }else{
            System.out.println("integer is not null");
        }
        Integer integer1=new Integer(1);
        Objects.requireNonNull(integer1);
        Objects.requireNonNull(integer1,"integer1 is null");
        Objects.requireNonNull(integer1,()->"integer1 is null");
//        Integer integer2 = new Integer(null);
//        Objects.requireNonNull(integer2, "integer2 is null");
        System.out.println("-------------------------------------");
        Integer integer3 = new Integer(1);
        Integer integer4 = new Integer(1);

        System.out.println(Objects.equals(integer3, integer4));

        Long integer2 = new Long(1);

        System.out.println(Objects.equals(integer1, integer2));

        Person person1 = new Person("沉默王二", 18);
        Person person2 = new Person("沉默王二", 18);

        System.out.println(Objects.equals(person1, person2));

        String str = new String("沉默王二");
        System.out.println(Objects.hashCode(str));


        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};

        System.out.println("-------------------------------------");
        System.out.println(Objects.deepEquals(array1, array2)); // 输出：true（因为 array1 和 array2 的内容相同）
        System.out.println(Objects.deepEquals(array1, array3)); // 输出：false（因为 array1 和 array3 的内容不同）

// 对于非数组对象，deepEquals() 的行为与 equals() 相同
        String string1 = "hello";
        String string2 = "hello";
        String string3 = "world";

        System.out.println(Objects.deepEquals(string1, string2)); // 输出：true（因为 string1 和 string2 相同）
        System.out.println(Objects.deepEquals(string1, string3)); // 输出：false（因为 string1 和 string3 不同）


        System.out.println("-----------------------------------------");
        String[][]nestedArray1={{"A","B"},{"C","D"}};
        String[][]nestedArray2={{"A","B"},{"C","D"}};
        String[][]nestedArray3={{"A","B"},{"E","F"}};
        System.out.println(Objects.deepEquals(nestedArray3,nestedArray2));
        System.out.println(Objects.deepEquals(nestedArray1,nestedArray2));

    }

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null||getClass()!=obj.getClass()){
            return false;
        }
        Person person =(Person)obj;
        return age==person.age&&name.equals(person.name);
    }
}





