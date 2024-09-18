import datastructures.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList<Integer> list=new ArrayList<>();
    int first=1,second=1;
    for(int i=0;i<10;i++){
        list.add(first+second);
        first=second;
        second=first+second;
    }

    System.out.println("顺序表初始内容为："+list);
    System.out.println("顺序表的容量为："+list.getCapacity()+"  顺序表的实际size大小为"+list.getSize());

    list.update(5,1999);
    System.out.println("顺序表更新后的内容"+list);

    list.delete(8);

    System.out.println(list);

    System.out.println("顺序表第3个元素为  "+list.get(3));

    System.out.println("顺序表是否存在元素  17  "+list.findelements(17));



    }
}