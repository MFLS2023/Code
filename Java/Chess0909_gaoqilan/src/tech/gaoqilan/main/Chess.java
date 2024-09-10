package tech.gaoqilan.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Chess {
    //棋子大小
    private final int SIZE=40;
    //棋盘外边距
    private final int MARGIN = 35;
    //棋子间距
    private final int SPACE=87;

    //棋子名称
    private String name;//不能直接public，会违反Java三大特性的封装
    //棋子后缀名
    private String suffix=".png";
    //棋子阵营，0红1黑
    private int player;
    //棋子绘制时的坐标位置
    private int x,y;

    //Point类 棋子的网格坐标（官方提供的）
    private Point p;
    //棋子绘制得到方法：
    //Graphics 属性  JPanel  panel

    public void draw(Graphics g, JPanel panel) {
        String path="pic"+ File.separator+name + player + suffix;
        Image img=Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img,x,y,SIZE,SIZE,panel);
    }

    public void CalXY(){
        x=MARGIN-SIZE/2+SPACE*(p.x-1);
        y=MARGIN-SIZE/2+SPACE*(p.y-1);
    }
}
