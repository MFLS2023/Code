package com.koudinglang.demo;

import java.io.File;
import java.io.IOException;

/**
 * @Author: duan
 * @Date: Create in 14:13 2021/3/24
 */
public class FileDemo {
    /*  File：表示一个文件或文件夹类，不具备文件读取能力
                构造方法
                    File(String path);
                常用方法
                    createNewFile()：创建一个新的文件
                    delete()：删除一个文件
                    exists()：判断文件是否存在
                    getName()：获取文件名称，包括后缀名
                    getPath()：获取文件路径
                    isDirectory()：是否为文件夹
                    length()：文件内容的长度
                    list()：列举文件夹中的所有文件或文件夹
                    getParent()：获取当前文件的目录String类型
                    getParentFile()：获取当前文件的目录File类型
            输入流：将文件内容读取到电脑内存中
            输出流：写入内容到文件中
         */

    public static void main(String[] args) {
        File file = new File("D:\\1.txt");
        System.out.println(file.exists());
        if (!file.exists()) {
            try {
                System.out.println(file.createNewFile() ? "创建成功" : "创建失败");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getName());
    }
}
