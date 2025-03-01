package GaoQi.Collection.Practice2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Book类保持不变
class book {
    int id;
    double price;
    String type;
    String author;

    public book(int id, double price, String type, String author) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", price=" + price + ", type=" + type + ", author=" + author + "]";
    }
}

// 将类名从BookTest改为Book_Answer
public class Book_Answer {    // 修改这里的类名
    public static void main(String[] args) {
        // 代码内容保持不变
        Set<book> set1 = new HashSet<>();
        set1.add(new book(1, 29.9, "小说", "张三"));
        set1.add(new book(2, 39.9, "科技", "李四"));
        set1.add(new book(3, 49.9, "文学", "王五"));
        set1.add(new book(4, 59.9, "历史", "赵六"));

        Set<book> set2 = new HashSet<>();
        set2.add(new book(1, 29.9, "小说", "张三"));
        set2.add(new book(5, 69.9, "艺术", "钱七"));

        int count = 0;
        for(book b1 : set1) {
            for(book b2 : set2) {
                if(b1.id == b2.id) {
                    count++;
                }
            }
        }
        System.out.println("重复的图书数量：" + count);

        System.out.println("\n集合1的图书：");
        Iterator<book> it = set1.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\n集合2的图书：");
        for(book b : set2) {
            System.out.println(b);
        }
    }
}
