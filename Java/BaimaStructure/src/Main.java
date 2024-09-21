import datastructures.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int first = 1, second = 1;
        for (int i = 0; i < 10; i++) {
            list.add(first + second);
            first = second;
            second = first + second;
        }

        System.out.println("顺序表初始内容为：" + list);
        System.out.println("顺序表的容量为：" + list.getCapacity() + "  顺序表的实际size大小为" + list.getSize());

        list.update(5, 1999);
        System.out.println("顺序表更新后的内容" + list);

        for (int i = 0; i < 10; i++) {
            list.add(first + second);
            first = second;
            second = first + second;
        }

        System.out.println("顺序表扩容后内容为：" + list);

        list.remove(8);

        System.out.println("删除第8个元素后" + list);

        System.out.println("顺序表第3个元素为  " + list.getElement(3));

        System.out.println("顺序表是否存在元素  17  " + list.findElement(17));


    }
}