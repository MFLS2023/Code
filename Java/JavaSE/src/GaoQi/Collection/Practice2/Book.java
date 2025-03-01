package GaoQi.Collection.Practice2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Book {
    public static void main(String[] args) {
        Set<Books> set1 = new HashSet<>();
        set1.add(new Books("1001", 100, "古诗", "李白"));
        set1.add(new Books("1002", 200, "小说", "东野圭吾"));
        set1.add(new Books("1003", 150, "小说", "鲁迅"));
        set1.add(new Books("1004", 100, "散文", "史铁生"));

        Set<Books> set2 = new HashSet<>();
        set2.add(new Books("1001", 100, "古诗", "李白"));
        set2.add(new Books("1002", 100, "小说", "村上春树"));

        // 打印两个集合
        System.out.println("集合1的图书：");
        System.out.println(set1);
        System.out.println("集合2的图书：");
        System.out.println(set2);

        // 计算重复的图书数量
        int count = 0;
        for (Books b1 : set1) {
            for (Books b2 : set2) {
                if (b1.id.equals(b2.id)) {  // 使用equals比较String
                    count++;
                }
            }
        }
        System.out.println("\n重复的图书数量：" + count);

        // 使用迭代器遍历集合1
        System.out.println("\n使用迭代器遍历集合1：");
        Iterator<Books> iterator = set1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 使用增强for循环遍历集合2
        System.out.println("\n使用增强for循环遍历集合2：");
        for (Books book : set2) {
            System.out.println(book);
        }
    }
}

class Books {
    String id;
    int price;
    String type;
    String autor;

    public Books(String id, int price, String type, String autor) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "id:" + id + " price:" + price + " type:" + type + " autor:" + autor;
    }
}
