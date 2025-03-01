package GaoQi.Collection.Practice3;

import java.util.HashMap;
import java.util.Map;

public class Student_Score {
    public static void main(String[] args) {
        Student student = new Student();

        // 添加学生分数
        student.add("10001", 100);
        student.add("10002", 90);
        student.add("10003", 80);

        // 打印所有学生信息
        student.printAllScores();

        // 查询特定学生分数
        System.out.println("学生10001的分数：" + student.getScore("10001"));

        // 删除学生信息
        student.remove("10002");
        System.out.println("删除学生10002后：");
        student.printAllScores();
    }
}

class Student {
    private Map<String, Integer> student;

    // 构造方法
    public Student() {
        student = new HashMap<>();
    }

    // 添加学生分数
    public void add(String ID, int score) {
        if (score >= 0 && score <= 100) {
            student.put(ID, score);
            System.out.println("成功添加学生 " + ID + " 的分数：" + score);
        } else {
            System.out.println("分数必须在0-100之间");
        }
    }

    // 获取学生分数
    public int getScore(String ID) {
        // 直接使用Map的get方法
        return student.getOrDefault(ID, -1);
    }

    // 删除学生信息
    public boolean remove(String ID) {
        if (student.containsKey(ID)) {
            student.remove(ID);
            System.out.println("成功删除学生 " + ID + " 的信息");
            return true;
        }
        System.out.println("未找到学生 " + ID + " 的信息");
        return false;
    }

    // 打印所有学生信息
    public void printAllScores() {
        if (student.isEmpty()) {
            System.out.println("没有学生信息");
            return;
        }
        System.out.println("所有学生成绩信息：");
        for (Map.Entry<String, Integer> entry : student.entrySet()) {
            System.out.println("学生ID: " + entry.getKey() + ", 分数: " + entry.getValue());
        }
    }
}
