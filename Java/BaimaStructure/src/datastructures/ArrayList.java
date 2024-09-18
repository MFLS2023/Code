package datastructures;

public class ArrayList<E> {
    private int size;
    private int capacity;
    private Object[] array;

    public ArrayList(){
        this.size = 0;
        this.capacity=10;
        this.array=new Object[capacity];
    }

    public void insert(int index,E elements){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("插入位置非法");
        }

        if(size==capacity){
            expandCapacity();
        }

        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=elements;
        size++;

    }

    public void add(E elements){
        insert(size,elements);
    }


    public void delete(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("删除位置非法");
        }
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        array[size-1]=null;
        size--;
    }

    public void update(int index,E elements){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("更新位置非法");

        }
        array[index]=elements;
    }

    public int findelements(E elements){
        for(int i=0;i<size;i++){
            if(array[i].equals(elements)){
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("查找位置非法");
        }
        return (E) array[index];
    }

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void expandCapacity(){
        int newCapacity=capacity*2;
        Object[] newArray=new Object[newCapacity];
        capacity=newCapacity;
        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
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












