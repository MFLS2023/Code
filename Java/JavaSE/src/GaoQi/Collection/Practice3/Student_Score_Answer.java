package GaoQi.Collection.Practice3;

import java.util.HashMap;
import java.util.Map;

public class Student_Score_Answer {
    // 使用HashMap存储学生ID和分数
    private Map<String, Integer> scoreMap;

    // 构造方法
    public Student_Score_Answer() {
        scoreMap = new HashMap<>();
    }

    // 1. 添加学生分数信息
    public void addScore(String studentId, int score) {
        if (studentId != null && !studentId.trim().isEmpty()) {
            scoreMap.put(studentId, score);
            System.out.println("成功添加学生" + studentId + "的分数：" + score);
        } else {
            System.out.println("学生ID不能为空！");
        }
    }

    // 2. 查询学生分数信息
    public void queryScore(String studentId) {
        if (scoreMap.containsKey(studentId)) {
            System.out.println("学生" + studentId + "的分数为：" + scoreMap.get(studentId));
        } else {
            System.out.println("未找到学生" + studentId + "的信息");
        }
    }

    // 3. 删除学生分数信息
    public void deleteScore(String studentId) {
        if (scoreMap.containsKey(studentId)) {
            scoreMap.remove(studentId);
            System.out.println("成功删除学生" + studentId + "的分数信息");
        } else {
            System.out.println("未找到学生" + studentId + "的信息");
        }
    }

    // 4. 遍历并打印所有学生分数信息
    public void printAllScores() {
        if (scoreMap.isEmpty()) {
            System.out.println("当前没有学生分数信息");
            return;
        }
        System.out.println("所有学生分数信息如下：");
        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            System.out.println("学生ID：" + entry.getKey() + "，分数：" + entry.getValue());
        }
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        Student_Score_Answer manager = new Student_Score_Answer();

        // 测试添加分数
        manager.addScore("001", 85);
        manager.addScore("002", 92);
        manager.addScore("003", 78);

        // 测试查询分数
        manager.queryScore("002");
        manager.queryScore("004"); // 查询不存在的学生

        // 测试打印所有分数
        manager.printAllScores();

        // 测试删除分数
        manager.deleteScore("001");

        // 再次打印所有分数
        manager.printAllScores();
    }
}
