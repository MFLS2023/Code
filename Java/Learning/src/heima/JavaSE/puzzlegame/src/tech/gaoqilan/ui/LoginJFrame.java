package heima.JavaSE.puzzlegame.src.tech.gaoqilan.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //JFrame 界面，窗体
    //子类呢？也表示界面，窗体
    //以后登录界面都在这里了

    public LoginJFrame() {
        //创建登录界面的时候，同时给这个界面去设置一些信息
        this.setSize(488,430);
        //设置标题
        this.setTitle("登录界面");
        //设置游戏界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置程序随游戏界面的关闭而停止
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}
