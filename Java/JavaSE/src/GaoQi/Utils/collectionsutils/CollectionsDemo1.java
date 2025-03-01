package GaoQi.Utils.collectionsutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("牛肉炒萝卜");
        list.add("牛肉炒四季豆");
        list.add("开锅肉丸");
        list.add("酸甜排骨");
        list.add("茄子炒肉");
        list.add("酿豆腐");
        list.add("葱炒鸡肉");
        list.add("玉米胡萝卜骨头汤/猪肚煲鸡");

        System.out.println("原始顺序: "+list);
        Collections.reverse(list);
        System.out.println("反转后:"+list);

        Collections.shuffle(list);
        System.out.println("洗牌后:"+list);

        Collections.sort(list);
        System.out.println("自然升序后:"+list);

        Collections.swap(list,2,4);
        System.out.println("交换后："+list);
        System.out.println(list);
        System.out.println("-----------------------------------");

        System.out.println("最大元素："+Collections.max(list));
        System.out.println("最小元素："+Collections.min(list));
        System.out.println("酸甜排骨 出现次数："+Collections.frequency(list,"酸甜排骨"));

        System.out.println("排序前的二分查找结果：茄子炒肉："+Collections.binarySearch(list,"茄子炒肉"));
        Collections.sort(list);
        System.out.println("排序后的二分查找结果：茄子炒肉："+Collections.binarySearch(list,"茄子炒肉"));




    }
}
