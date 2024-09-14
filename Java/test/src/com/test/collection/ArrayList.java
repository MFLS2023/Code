
package com.test.collection;

public class ArrayList<E> {
    private int capacity=10;
    private int size=0;
    private Object[] array=new Object[capacity];

    public void insert(E element,int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("插入的位置不合法，请重新选择");
        }
        for(int i =size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        size++;

    }


}


