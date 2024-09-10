package tech.gaoqilan.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Chess {
    //棋子大小
    private static final int SIZE=30;
    //棋盘外边距
    private static final int MARGIN = 20;
    //棋子间距
    private static final int SPACE=40;

    //棋子名称
    private String name;//不能直接public，会违反Java三大特性的封装
    //改为使用get和set方法获取及设置属性值
    public void setName(String name){
        this.name=name;
    }

    //棋子后缀名
    private final String suffix=".png";
    //棋子阵营，0红1黑
    protected int player;

    public void setPlayer(int player){
        this.player=player;
    }

    public int getPlayer() {
        return player;
    }

    //棋子绘制时的坐标位置
    private int x,y;
    //Point类 棋子的网格坐标（官方提供的）,初始坐标，不改变
    private Point p;
//    private Point initP;

    public void setP(Point p){
        this.p=(Point)p.clone();
        calXY();
    }

    public Point getP() {
        return p;
    }
    //    //保存每个棋子的索引位置
//    private int index;

//    public void setIndex(int index) {
//        this.index = index;
//    }
//
//    public int getIndex() {
//        return index;
//    }

    //棋子绘制得到方法：
    //Graphics 属性  JPanel  panel

    public void draw(Graphics g, JPanel panel) {
        String path="pic"+ File.separator+name + player + suffix;
        Image img=Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img,x,y,SIZE,SIZE,panel);
    }

    public void calXY(){
        x=MARGIN-SIZE / 2 + SPACE*(p.x-1);
        y=MARGIN-SIZE / 2 + SPACE*(p.y-1);
    }

    /*
        static：静态关键字
            修饰方法：称为类方法或静态方法
                如何调用
                    实例.方法()   or   类名.方法()
                注意，类方法只能使用类属性
            修饰属性
                称为类属性或静态属性
                如何调用
                    实例，属性名或类名，属性名
                注意，静态属性只有一个共用的内存地址，所以不管有多少个对象，其他对象都会受影响

     */
    //根据xy坐标计算网格坐标对象
    public static Point getPointFromXY(int x,int y){
        Point p=new Point(x,y);
        p.x=(x-MARGIN + SIZE /2)/SPACE+1;
        p.y=(y-MARGIN + SIZE /2)/SPACE+1;
        if (p.x<1||p.x>9||p.y<1||p.y>10){
            return null;
        }
        return p;
    }

//    public Point(Point p){this(p.x,p.y);}
//
//    public Point(int x,int y){
//        this.x=x;
//        this.y=y;
//    }
    public void reverse(){
        p.x=10-p.x;
        p.y=11-p.y;
//        initP =p;
        calXY();
//
//
    }
}
