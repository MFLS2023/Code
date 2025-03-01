package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        //创建登录界面的时候，同时给这个界面去设置一些信息
        JFrame JFrame = new JFrame();
        JFrame.setSize(603,680);
        //设置标题
        JFrame.setTitle("事件演示");
        //设置游戏界面置顶
        JFrame.setAlwaysOnTop(true);
        //设置界面居中
        JFrame.setLocationRelativeTo(null);
        //设置程序随游戏界面的关闭而停止
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认居中,只有取消了才会按照xy的形式添加组件
        JFrame.setLayout(null);

        //创建一个按钮对象
        JButton jtb=new JButton("点我啊");
        //设置宽和高
        jtb.setBounds(0,0,100,50);
        //给按钮添加动作监听
        //jtb:组件对象:表示你要给哪个组件添加事件
        //addActionListener:表示我要给组件添加哪个事件监听(动作监听 鼠标左键点击 or 空格)
        //参数:表示事件被触发之后要执行的代码
        //jtb.addActionListener(new MyActionListener());

        jtb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("不要点我");
            }
        });

        //把按钮添加到界面中
        JFrame.getContentPane().add(jtb);

        JFrame.setVisible(true);
    }
}
