package tech.gaoqilan.main;

import javax.swing.*;

public class MainFrame_Gaoqilan{

    public static void main(String[] args){

        //创建一个名称为frm的JFrame的实例
        JFrame frm=new JFrame();
        //创建实例的格式：类名 实例名 = new 类的构造方法();

        //设置窗口的大小
        frm.setSize(400,500);

        //设置窗口居中
        frm.setLocationRelativeTo(null);

        //设置点击关闭按钮同时结束虚拟机，每个Java程序都是一个虚拟机
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //将游戏面板添加到窗口中
       frm.add(new GamePanel_Gaoqilan());

        //设置窗口可见，建议放到后面
        frm.setVisible(true);

    }
}
