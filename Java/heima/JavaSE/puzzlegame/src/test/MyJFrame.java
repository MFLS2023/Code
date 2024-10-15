package test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame  implements ActionListener {
    //创建一个按钮对象
    JButton jtb1 = new JButton("点我啊");

    //创建一个按钮对象
    JButton jtb2 = new JButton("再点我啊");

    public MyJFrame() {
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

        //设置宽和高
        jtb1.setBounds(0, 0, 100, 50);
        //给按钮添加事件
        jtb1.addActionListener(this);

        //设置宽和高
        jtb2.setBounds(100, 0, 100, 50);
        //给按钮添加事件
        jtb2.addActionListener(this);

        //按钮添加到界面中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        //显示整个界面
        this.setVisible(true);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前的按钮有进行判断
        //获取当前被操作的那个按钮对象
        Object source = e.getSource();
        if(source==jtb1){
            jtb1.setSize(200,200);
        }else if(source==jtb2){
            Random r=new Random();
            jtb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
