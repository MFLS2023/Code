package tech.gaoqilan.ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        //1.创建一个游戏的主界面
        JFrame gameJframe = new JFrame();
        gameJframe.setSize(603,680);
        //已过时的方法：gameJframe.show();
        gameJframe.setVisible(true);

        //2.创建一个登录界面
        //获取用户输入的用户名
        //获取用户输入的密码
        //生成一个验证码
        //获取用户输入的验证码
        //比较用户名，密码，验证码
        JFrame loginJframe = new JFrame();
        loginJframe.setSize(488,430);
        loginJframe.setVisible(true);

        //3.创建一个注册界面
        JFrame registerJframe = new JFrame();
        registerJframe.setSize(488,500);
        registerJframe.setVisible(true);
    }

}
