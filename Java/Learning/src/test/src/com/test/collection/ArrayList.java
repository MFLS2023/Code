
package com.test.collection;

public class ArrayList<E> {
    private int capacity;
    private int size;
    private Object[] array;

    public ArrayList(){
        this.capacity = 10;
        this.size = 0;
        this.array=new Object[capacity];
    }

    public void insert(E element,int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("插入位置非法");
        }
        if(size==capacity){
            expandCapacity();
        }
        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        size++;
    }
    public void add(E element){
        insert(element,size);
    }

    //删除指定位置元素
    @SuppressWarnings("unchecked")
    public E remove(int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("删除位置非法");
        }
        E removeElment=(E)array[index];
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        array[size-1]=null;
        size--;
        return removeElment;
    }

    //获取指定位置的元素
    @SuppressWarnings("unchecked")
    public E get(int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("获取位置非法");
        }
        return (E)array[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index,E element){
        if(index<0 || index>size){
            throw new  IndexOutOfBoundsException("更新位置非法");
        }
        E oldElement=(E)array[index];
        array[index]=element;
        return oldElement;
    }

    private void expandCapacity(){
        capacity =capacity+(capacity>>1);
        Object[] newArray=new Object[capacity];
        System.arraycopy(array,0,newArray,0,size);
        array=newArray;
    }

    public int size(){
        return size;
    }

    //重写 toString方法，打印顺序表内容
    @Override
    public String toString() {
        StringBuilder builder =new StringBuilder();
        builder.append("[");
        for(int i=0;i<size;i++){
            builder.append(array[i]);
            if(i!=size-1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}


