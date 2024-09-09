package tech.gaoqilan.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GamePanel_Gaoqilan extends JPanel {


    @Override   //重写注解，如果该方法不是重写父类的方法，加上会报错
    public void paint(Graphics g) {
        //super.paint(g);//注释或删除即可
        /*
            paint方法是JPanel的绘制面板内容的方法
            Graphics：绘制类
                常用方法
                g.drawImage：画图片
                g.drawChars：画文字
                g.drawLine：画直线
                g.drawOval：画圆或椭圆

            如何在JPanel画一张图片
                1.准备图片路径
                    File.separator ；路径分隔符
                        windows: \ 反斜杠
                        linux macos /斜杠
                        Java是不区分的，官方自动会帮你区分
                2.通过图片路径得到图片对象
                3.使用g.drawImage方法将图片绘制到面板
         */
        //1.准备图片路径
        String bgPath="pic"+ File.separator+"qipan.jpg";

        /*
            Toolkit.getDefaultToolkit().sync();//获取Toolkit的实例
                createImage()：创建图片
                getImage()：获取图片
         */

        //2.通过图片路径得到图片  swing就是awt的升级版，awt就是原始版
         Image bgImg=Toolkit.getDefaultToolkit().getImage(bgPath);//获取Toolkit的实例

        //3.使用g.drawImage方法将图片绘制到面板上
        g.drawImage(bgImg,0,0,this);

        /*
        g.drawImage(Image img,int x , int y, targetWidth, targetHeight, this);
            img:要绘制的图像
            x:坐标x，从左上角开始为正
            y:坐标y，往下为正
            observer:图片观察者，写JPanel对象即可，这里的this可以指 GamePanel_Gaoqilan 也可以是 JPnel，表示就是当执行该行代码时的对象

         */

        //1.准备图片路径
        String che0Path="pic"+ File.separator+"che0.png";

        /*
            Toolkit.getDefaultToolkit().sync();//获取Toolkit的实例
                createImage()：创建图片
                getImage()：获取图片
         */

        //2.通过图片路径得到图片  swing就是awt的升级版，awt就是原始版
        Image che0Img=Toolkit.getDefaultToolkit().getImage(che0Path);//获取Toolkit的实例

        //3.使用g.drawImage方法将图片绘制到面板上
        g.drawImage(che0Img,0,0,this);


    }
}
