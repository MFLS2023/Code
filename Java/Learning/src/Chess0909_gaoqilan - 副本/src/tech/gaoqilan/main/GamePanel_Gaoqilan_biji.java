package tech.gaoqilan.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GamePanel_Gaoqilan_biji extends JPanel {


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
        //这种方法没办法放大图片   g.drawImage(bgImg,0,0,this);

        // 获取组件的尺寸
        int width = getWidth();
        int height = getHeight();

        // 设置图片放大的目标尺寸，这里假设放大到组件的大小
        // 可以根据需要设置为其他尺寸

        // 绘制图片，将图片放大到目标宽度和高度
        g.drawImage(bgImg,0 , 0, width, height, this);
        /*
        g.drawImage(Image img,int x , int y, targetWidth, targetHeight, this);
            img:要绘制的图像
            x:坐标x，从左上角开始为正
            y:坐标y，往下为正
            observer:图片观察者，写JPanel对象即可，这里的this可以指 GamePanel_Gaoqilan 也可以是 JPnel，表示就是当执行该行代码时的对象
         */
        //如何画棋子
        //定义了一个String类型的变量，名为path，且赋值为
        /*
            `String che0Path="pic"+ File.separator+"che0.png";
            Image che0Img=Toolkit.getDefaultToolkit().getImage(che0Path);
            g.drawImage(che0Img,10,10,this);

            String ma0Path="pic"+ File.separator+"ma0.png";
            Image ma0Img=Toolkit.getDefaultToolkit().getImage(ma0Path);
            g.drawImage(ma0Img,80,10,this);

            String xiang0Path="pic"+ File.separator+"xiang0.png";
            Image xiang0Img=Toolkit.getDefaultToolkit().getImage(xiang0Path);
            g.drawImage(xiang0Img,160,10,this);
            上面的代码特别繁琐，使用数组和循环来优化代码
                变量有个局限性，就是只能保存一个数据
                如何保存多个数据？
                    使用数组和集合
            数组的基本使用
                1.如何定义，一定要指定长度
                    静态，一行，定义和赋值得在一行
                        格式： 数据类型[] 数组名 = new 数据类型[]{值1，值2，值3，...；
                    动态，可以先定义 后赋值
                        格式：数据类型[] 数组名 = new 数据类型[长度]
                        先定义： 数据类型[] 数组名 [=null];
                        后赋值： 数组名 = new 数组类型[长度]；
                2.数组的长度  length属性
                3.数组的索引
                    从0开始，长度-1结束
                    超过范围，越界，报错
                4.数组元素的使用及赋值
                    格式：数组名[索引值] = 值;
                    注意：数组在使用之前，一定要初始化，即赋值，否者空指针异常
                5.数组的异常
                6.数组的遍历，使用循环
                    各个元素的过一遍
         */



//        String[] names={"che","ma","xiang","shi","boss","shi","xiang","ma","che","pao","pao","bing","bing","bing","bing","bing"};
//        int player=0;//棋子阵容
//        String suffix= ".png";//图片后缀
//
//        //int [] xs={10,90,170,250,330,410,490,570,650,90,490,10,170,330,490,650};
//        //int [] ys={10,10,10,10,10,10,10,90,90,170,170,170,170,170};
//        int [] xs = {1,2,3,4,5,6,7,8,9,2,8,1,3,5,7,9};
//        int [] ys = {1,1,1,1,1,1,1,1,1,3,3,4,4,4,4,4,};
//
//        int size = 40;//棋子大小
//        int margin = 35;//棋盘的边距
//        int space=87;//棋子之间间距
//
//        /*
//            //String[]names=new String[3];
//            //names[0]="che0.png";
//            //int []a1 =null;//只是定义一个名为a1的数组，并且没有被初始化
//            //a1[0] = 0;//java.lang.NullPointerException
//         */
//
//        for(int i=0;i<names.length;i++){
//            String path="pic"+ File.separator+names[i] + player + suffix;
//            Image img=Toolkit.getDefaultToolkit().getImage(path);
//            g.drawImage(img,margin-size/2+space*(xs[i]-1),
//                    margin-size/2+space*(ys[i]-1)*5/6,this);
//        }
//
//
//        player=1;
//        for(int i=0;i<names.length;i++){
//            String path="pic"+ File.separator+names[i] + player + suffix;
//            Image img=Toolkit.getDefaultToolkit().getImage(path);
//            g.drawImage(img,margin-size/2+space*(reverX(xs[i])-1),
//                    margin-size/2+space*(reverY(ys[i])-1)*5/6,this);
//        }
//    }

    String[] names={"che","ma","xiang","shi","boss","shi","xiang","ma","che","pao","pao","bing","bing","bing","bing","bing"};
    for(int i=0;i<names.length;i++){
        Chess c = new Chess();//创建棋子类的对象
        c.setName(names[i]);//指定棋子名称
//        c.setP(ps[i]);//指定棋子的网络坐标
//        c.setPlayer(1);
        c.reverse();
        c.draw(g,this);
    }
}

    private int reverX(int x){
        return 10-x;
    }
    private int reverY(int y){
        return 11-y;
    }
}

