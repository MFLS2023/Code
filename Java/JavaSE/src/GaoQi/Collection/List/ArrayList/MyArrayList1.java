package GaoQi.Collection.List.ArrayList;

public class MyArrayList1 {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList1() {
        elementData =new Object[DEFAULT_CAPACITY];

    }

    public MyArrayList1(int capacity){
        elementData =new Object[capacity];
    }

    public void add(Object e){
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
        MyArrayList1 list1=new MyArrayList1(20);
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1);
    }

}
