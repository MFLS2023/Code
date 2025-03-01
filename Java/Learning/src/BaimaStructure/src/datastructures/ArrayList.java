package datastructures;

public class ArrayList<E>{
     int size;
     int capacity;
     Object[] array;
    public ArrayList(){
        size = 0;
        capacity = 10;
        array=new Object[this.capacity];

    }

    @SuppressWarnings("unchecked")
    public void insert(int index,E element){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("插入位置非法");
        }
        if(size==capacity){
            ExpandCapacity();
        }
        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        size++;
    }

    public void add(E element){
        insert(size,element);
    }

    @SuppressWarnings("unchecked")
    public void remove(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("删除位置非法");
        }
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
    }

    @SuppressWarnings("unchecked")
    public void update(int index,E element){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("更新位置非法");
        }
        array[index]=element;
    }

    @SuppressWarnings("unchecked")
    public int findElement(E element){
        for(int i=0;i<size;i++){
            if(array[i]==element){
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public E getElement(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("查找位置非法");
        }
        return (E)array[index];
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public void ExpandCapacity(){
        int newcapacity=capacity+(capacity>>1);
        Object [] newArray = new Object[newcapacity];
        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        array=newArray;
        capacity=newcapacity;

    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
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









