package GaoQi.IO.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;  // 导入正确的ObjectInputStream
import java.io.IOException;

public class ObjectInputStreamDemo {  // 改名为Demo避免冲突
    public static void main(String[] args) {
        // 使用与序列化时相同的文件路径
        String filename = "D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\serializable\\person.txt";

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // 从文件中读取对象
            Person p = (Person) in.readObject();

            // 打印反序列化后的对象信息
            System.out.println("反序列化的对象: " + p);
            System.out.println("姓名: " + p.getName());
            System.out.println("年龄: " + p.getAge());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
