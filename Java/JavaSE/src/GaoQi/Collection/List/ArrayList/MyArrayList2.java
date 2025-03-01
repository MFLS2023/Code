package GaoQi.Collection.List.ArrayList;

public class MyArrayList2<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList2() {
        elementData =new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList2(int capacity){
        elementData =new Object[capacity];
    }
    public void add(E e){
        elementData[size++]=e;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(Object e:elementData){
            sb.append(e+",");
        }
        sb.append("]");

        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList2 list1=new MyArrayList2(20);
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1);
    }

}
