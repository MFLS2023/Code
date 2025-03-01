package GaoQi.IO.HomeWork;

import java.io.*;

public class Test2Answer {
    public static void main(String[] args) {
        // 1. 使用节点流拷贝
        copyWithNodeStream();

        // 2. 使用处理流拷贝
        copyWithProcessingStream();
    }

    // 方式1：使用节点流
    public static void copyWithNodeStream() {
        // 定义文件输入输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 创建流对象
            fis = new FileInputStream("D:\\Photograph\\Blog_inages\\downloadAll\\360floralflaves-Ja8BXlezFYs-unsplash.jpg");
            fos = new FileOutputStream("D:\\Photograph\\Screenshots\\test2.jpg");

            // 读写数据
            int len;
            byte[] buffer = new byte[1024];

            // 开始计时
            long startTime = System.currentTimeMillis();

            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // 计算耗时
            long endTime = System.currentTimeMillis();
            System.out.println("节点流拷贝完成，耗时：" + (endTime - startTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 方式2：使用处理流
    public static void copyWithProcessingStream() {
        // 定义缓冲流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 创建流对象
            bis = new BufferedInputStream(
                    new FileInputStream("D:\\Photograph\\Blog_inages\\downloadAll\\360floralflaves-Ja8BXlezFYs-unsplash.jpg")
            );
            bos = new BufferedOutputStream(
                    new FileOutputStream("D:\\Photograph\\Screenshots\\test.jpg")
            );

            // 读写数据
            int len;
            byte[] buffer = new byte[1024];

            // 开始计时
            long startTime = System.currentTimeMillis();

            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            // 计算耗时
            long endTime = System.currentTimeMillis();
            System.out.println("处理流拷贝完成，耗时：" + (endTime - startTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
