package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
        //创建登录界面的时候，同时给这个界面去设置一些信息

        this.setSize(603, 680);
        //设置标题
        this.setTitle("事件演示");
        //设置游戏界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认居中,只有取消了才会按照xy的形式添加组件
        this.setLayout(null);

        //给震哥哥窗体添加键盘监听
        //调用者this:本类对象,当前的界面对象:表示我要给整个界面添加监听
        //参数this:当事件被触发时,会执行本类中的对应代码
        this.addKeyListener(this);

        //显示整个界面
        this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //细节1:如果我们按下一个按键没有松开,会重复调用keyPressed方法
    //细节2:如何区分按的哪个按键
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        //获取键盘上每个按键的编号
        int code=e.getKeyCode();
        System.out.println(code);
        if(code==65){
            System.out.println("A");
        }else if(code==66){
            System.out.println("B");
        }
    }
}
