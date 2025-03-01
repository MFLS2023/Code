package GaoQi.IO.serialization;

import java.io.*;

public class SerializbaleDemo1 {
    public static void main(String[] args) {
        // 初始化
        Wanger wanger = new Wanger();
        wanger.setName("王二");
        wanger.setAge(18);
        System.out.println(wanger);

// 把对象写到文件中
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chenmo"));) {
            oos.writeObject(wanger);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 改变 static 字段的值
        Wanger.pre = "不沉默";

// 从文件中读出对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("chenmo")));) {
            Wanger wanger1 = (Wanger) ois.readObject();
            System.out.println(wanger1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



class Wanger implements Serializable {
    private String name;
    private int age;

    public static String pre = "沉默";
    transient String meizi = "王三";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Wanger{" + "name=" + name + ",age=" + age + ",pre=" + pre + ",meizi=" + meizi + "}";
    }
}
