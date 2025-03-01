package com.test;

import com.test.collection.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();

        //末尾添加元素
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println("顺序表内容： "+ list);

        //指定位置插入元素
        list.insert(100,5);
        System.out.println("在位置5插入100后的顺序表: " +list);

        //删除指定位置元素
        list.remove(3);
        System.out.println("删除位置3的元素后的顺序表: " + list);

        // 获取指定位置的元素
        System.out.println("获取位置2的元素: " + list.get(2));

        // 更新指定位置的元素
        list.set(2, 999);
        System.out.println("将位置2的元素更新为999后的顺序表: " + list);

        // 输出当前顺序表的大小
        System.out.println("当前顺序表的大小: " + list.size());
    }


}
