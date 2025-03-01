package GaoQi.Collection.List.ArrayList;

public class MyArrayList3<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList3() {
        elementData =new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList3(int capacity){
        elementData =new Object[capacity];
        size=0;
    }
    public void add(E e){
        if(size==elementData.length){
            Object[]newArray=new Object[elementData.length<<1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);;
            elementData=newArray;
        }
        elementData[size++]=e;
    }

    public void add(E e,int index){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }

    public E get(int index){
        if(index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException("Index"+index+",Size"+size);
        }
        return (E)elementData[index];
    }

    public boolean remove(int index){
        if(index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException("Index"+index+",Size"+size);
        }else{
//            for(int i=index;i<size-1;i++){
//                elementData[i]=elementData[i+1];
//            }
            System.arraycopy(elementData,index+1,elementData,index,size-index+1);
            size--;
            return true;
        }

    }

    public boolean remove(E element){
        for(int i=0;i<size;i++){
            if(elementData[i].equals(element)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean set(int index,E element){
        if(index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException("Index"+index+",Size"+size);
        }
        elementData[index]=element;
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
//        sb.append("[");
//        for(Object e:elementData){
//            sb.append(e+",");
//        }
//        sb.append("]");

        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList3 list1=new MyArrayList3(20);
        list1.add("a");
        list1.add("b");
        list1.add("c");
        for(int i=0;i<40;i++){
            list1.add(i);
        }
        System.out.println(list1);
        System.out.println("***************************");

        System.out.println(list1.set(10,"aa"));
        System.out.println(list1.get(20));
        System.out.println("list1.size()="+list1.size());
        System.out.println(list1);

        System.out.println(list1.remove(3));
        System.out.println(list1);
        System.out.println(list1.remove(0));
        System.out.println("list1.size()="+list1.size());
        System.out.println(list1.size());
        System.out.println(list1.remove(list1.size-1));
        System.out.println(list1.remove(list1.size-1));
        System.out.println(list1.remove(list1.size-1));
        System.out.println(list1.remove(list1.size-1));
        System.out.println("list1.size()="+list1.size());
        System.out.println(list1);
        list1.remove(0);
        System.out.println("list1.size()="+list1.size());
        System.out.println(list1);
        list1.remove("c");
        System.out.println("list1.size()="+list1.size());
        System.out.println(list1);

    }

}
