package GaoQi.Java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Demo2 {
    public static void main(String[] args) {
        MathOperation add=getOperation("+");
        MathOperation subtract=getOperation("-");

        System.out.println(add.operate(2,1));
        System.out.println(subtract.operate(10,2));

        System.out.println("--------------------------------------------");
        StringProcessor upperCase=getStringProcessor("upper");
        StringProcessor lowerCase=getStringProcessor("lower");
        String text="hello world";
        System.out.println(upperCase.process(text));
        System.out.println(lowerCase.process(text));

        System.out.println("-----------------------------------------------");
        Validator emailValidator=getValidator("email");
        Validator phoneValidator=getValidator("phone");

        System.out.println(emailValidator.validate("test@example.com"));
        System.out.println(phoneValidator.validate("12345678900"));


        System.out.println("------------------------------------------------");
        List<Person> people= Arrays.asList(
                new Person("Tom",20),
                new Person("Jerry",21),
                new Person("Jack",18)
        );
        Comparator<Person> byName=getComparator("name");
        Comparator<Person>byAge=getComparator("age");

        people.sort(byName);
        people.forEach(p->System.out.println(p.name));

        people.sort(byAge);
        people.forEach(p->System.out.println(p.age));

    }

    public static MathOperation getOperation(String operator){
        switch(operator){
            case "+":return (a,b)->a+b;
            case "-":return (a,b)->a-b;
            case "*":return (a,b)->a*b;
            case "/":return (a,b)->a/b;
            default: return (a,b)->0;
        }
    }

    public static StringProcessor getStringProcessor(String type){
        switch(type){
            case"upper":return str->str.toUpperCase();
            case"lower":return str->str.toLowerCase();
            case "trim":return str->str.trim();
            default: return str->str;
        }
    }

    public static Validator getValidator(String type){
        switch(type){
            case "emalil":
                return str->str.matches("^[A-Za-z0-9+_·-]+@(.+)$");
            case "phone":
                return str->str.matches("\\d{11}");
            case "number":
                return str -> str.matches("\\d+");
            default:
                return str->true;
        }
    }

    public static Comparator<Person> getComparator(String type){
        switch(type){
            case "name": return (p1,p2)->p1.name.compareTo(p2.name);
            case"age": return (p1,p2)->p1.age-p2.age;
            default: return (p1,p2)->0;
        }
    }

}
@FunctionalInterface
interface MathOperation{
    int operate(int a,int b);
}

@FunctionalInterface
interface StringProcessor{
    String process(String str);
}

@FunctionalInterface
interface Validator{
    boolean validate(String str);

}

class Person{
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
