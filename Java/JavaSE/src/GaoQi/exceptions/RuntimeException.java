package GaoQi.Exceptions;

public class RuntimeException {
    public static void main(String[] args) {

        int a=0;
        int b=1;

            System.out.println(b/a);


        String str=null;
        if(str!=null){
            System.out.println(str.length());
        }

        Animal d=new Dog();
        if(d instanceof Cat){
            Cat c= (Cat) d;
        }

        int[]arr=new int[3];
        int e=3;
        if(e<arr.length)
        {
            System.out.println(arr[e]);
        }
    }
}

class Animal{}
class Cat extends Animal{}
class Dog extends Animal{}