package GaoQi.IO.filestream;


import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApacheFileUtilsDemo {
    public static void main(String[] args) {
        // 定义源文件路径
        String sourcePath = "D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test.txt";
        // 定义目标文件路径（用于复制和移动操作）
        String destPath = "D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test_copy.txt";

        try {
            // 1. 复制文件
            copyFileDemo(sourcePath, destPath);

            // 2. 获取文件信息
            getFileInfo(sourcePath);

            // 3. 移动文件
            moveFileDemo(destPath, sourcePath + ".moved");

            // 4. 删除文件
            deleteFileDemo(sourcePath + ".moved");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. 复制文件
    public static void copyFileDemo(String sourcePath, String destPath) throws IOException {
        System.out.println("开始复制文件...");
        Files.copy(Paths.get(sourcePath), Paths.get(destPath),
                StandardCopyOption.REPLACE_EXISTING);
        System.out.println("文件复制完成！");
    }

    // 2. 获取文件信息
    public static void getFileInfo(String filePath) throws IOException {
        File file = new File(filePath);

        // 获取最后修改时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date modifyTime = new Date(file.lastModified());
        System.out.println("文件最后修改时间: " + sdf.format(modifyTime));

        // 获取文件大小
        long size = file.length();
        System.out.println("文件大小: " + size + " 字节");

        // 获取文件扩展名
        String fileName = file.getName();
        String extension = fileName.contains(".") ?
                fileName.substring(fileName.lastIndexOf(".") + 1) : "";
        System.out.println("文件扩展名: " + extension);
    }

    // 3. 移动文件
    public static void moveFileDemo(String sourcePath, String destPath) throws IOException {
        System.out.println("开始移动文件...");
        Files.move(Paths.get(sourcePath), Paths.get(destPath),
                StandardCopyOption.REPLACE_EXISTING);
        System.out.println("文件移动完成！");
    }

    // 4. 删除文件
    public static void deleteFileDemo(String filePath) throws IOException {
        System.out.println("开始删除文件...");
        Files.deleteIfExists(Paths.get(filePath));
        System.out.println("文件删除完成！");
    }
}


