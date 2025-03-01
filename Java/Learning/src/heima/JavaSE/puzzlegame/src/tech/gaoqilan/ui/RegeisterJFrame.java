package tech.gaoqilan.ui;

import javax.swing.*;

public class RegeisterJFrame extends JFrame {
    //JFrame 界面，窗体
    //子类呢？也表示界面，窗体
    //以后游戏界面都在这里了

    public RegeisterJFrame() {
        this.setSize(488,500);
        //设置标题
        this.setTitle("注册界面");
        //设置游戏界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置程序随游戏界面的关闭而停止
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
