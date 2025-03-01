package GaoQi.Collection;

public class GenericDemo1 {
    public static void main(String[] args) {
        MyCollection<String> mc=new MyCollection<String>();
        mc.set("abc",0);
//        mc.set(1111,1);

        String a=mc.get(0);
        String b=mc.get(1);

        System.out.println(a);
//        System.out.println(b);
    }
}

class MyCollection<E>{

    Object[]obj=new Object[10];

    public void set(Object e,int index){
        obj[index]=e;
    }

    public  E get(int index){
            return (E)obj[index];

    }
}
