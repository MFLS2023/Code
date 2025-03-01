package GaoQi.IO.filestream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileDemo1 {
    public static void main(String[] args) {
        // 文件路径
        String filePath = "D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test.txt";

        try {
            // 演示不同的构造方法
            demoConstructors(filePath);

            // 演示基本的读写操作
            demoBasicReadWrite(filePath);

            // 演示文件指针操作
            demoFilePointer(filePath);

            // 演示 UTF 字符串操作
            demoUTFStrings(filePath);

            // 演示在文件中间插入内容
            demoInsertContent(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 演示不同的构造方法
    private static void demoConstructors(String filePath) throws IOException {
        System.out.println("\n=== 演示构造方法 ===");

        // 使用文件名构造
        try (RandomAccessFile raf1 = new RandomAccessFile(filePath, "rws")) {
            raf1.writeUTF("使用文件名构造");
        }

        // 使用File对象构造
        File file = new File(filePath);
        try (RandomAccessFile raf2 = new RandomAccessFile(file, "rws")) {
            raf2.seek(raf2.length());
            raf2.writeUTF("使用File对象构造");
        }
    }

    // 演示基本的读写操作
    private static void demoBasicReadWrite(String filePath) throws IOException {
        System.out.println("\n=== 演示基本读写操作 ===");

        // 写入操作
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // 清空文件
            raf.setLength(0);
            // 写入单个字节
            raf.write(65); // 写入字母 'A'
            // 写入字节数组
            byte[] bytes = "Hello, World!".getBytes();
            raf.write(bytes);

            // 写入字节数组的一部分
            raf.write(bytes, 0, 5); // 只写入 "Hello"
        }

        // 读取操作
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            // 读取单个字节
            System.out.println("第一个字符: " + (char)raf.read());

            // 读取到字节数组
            byte[] buffer = new byte[20];
            int bytesRead = raf.read(buffer);
            System.out.println("读取的内容: " + new String(buffer, 0, bytesRead));
        }
    }

    // 演示文件指针操作
    private static void demoFilePointer(String filePath) throws IOException {
        System.out.println("\n=== 演示文件指针操作 ===");

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // 清空文件
            raf.setLength(0);

            // 写入一些数据
            raf.writeBytes("1234567890");

            // 获取当前文件指针位置
            System.out.println("当前指针位置: " + raf.getFilePointer());

            // 将指针移到开始位置
            raf.seek(0);
            System.out.println("移动指针到开始位置后的指针位置: " + raf.getFilePointer());

            // 读取一部分内容
            byte[] buffer = new byte[5];
            raf.read(buffer);
            System.out.println("读取的前5个字符: " + new String(buffer));

            // 获取文件长度
            System.out.println("文件总长度: " + raf.length());
        }
    }

    // 演示 UTF 字符串操作
    private static void demoUTFStrings(String filePath) throws IOException {
        System.out.println("\n=== 演示 UTF 字符串操作 ===");

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // 清空文件
            raf.setLength(0);

            // 写入 UTF 字符串
            raf.writeUTF("Hello, 世界!");

            // 将指针移回开始位置
            raf.seek(0);

            // 读取 UTF 字符串
            String content = raf.readUTF();
            System.out.println("读取的 UTF 字符串: " + content);
        }
    }

    // 演示在文件中间插入内容
    private static void demoInsertContent(String filePath) throws IOException {
        System.out.println("\n=== 演示插入内容 ===");

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // 清空文件并写入初始内容
            raf.setLength(0);
            raf.writeBytes("Hello World");

            // 在 "Hello" 和 "World" 之间插入内容
            // 首先读取 "World"
            raf.seek(5);
            byte[] latter = new byte[6];
            raf.read(latter);

            // 移回插入位置
            raf.seek(5);

            // 写入要插入的内容
            raf.writeBytes(" Beautiful ");

            // 写回后半部分
            raf.write(latter);

            // 读取整个文件内容
            raf.seek(0);
            byte[] allContent = new byte[(int)raf.length()];
            raf.read(allContent);
            System.out.println("插入内容后的结果: " + new String(allContent));
        }
    }
}
