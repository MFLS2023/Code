package tech.gaoqilan.main;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.Serializable;

public abstract class Chess implements Serializable {
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
    //棋子的网络坐标
    protected Point p;

    //Point类 棋子的网格坐标（官方提供的）,初始坐标，不改变
    private Point initP;

    public void setP(Point p){
        this.p=(Point)p.clone();
        if (initP==null){
            initP=this.p;
        }
        calXY();
    }

    public Point getP() {
        return p;
    }
    //    //保存每个棋子的索引位置
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public  Chess(String name,int player,Point p){
        this.name=name;
        this.player=player;
        setP(p);
    }


    //判断上边还是下边  1上 2下
    public int isUpOrDown(){
        if(initP.y<6){
            return 1;
        }else if(initP.y>5){
            return 2;
        }
        return 0;
    }

    //判断是否王宫内
    public boolean isHome(Point tp,GamePanel_Gaoqilan gamePanel){
        if(tp.x<4||tp.x>6){
            return false;
        }
        int upOrDown  = isUpOrDown();
        if(upOrDown==1){
            if(tp.y>3||tp.y<1){
                return false;
            }
        }else if(upOrDown==2){
            if(tp.y<8||tp.y>10){
                return false;
            }
        }
        return true;
    }

    //判断走直线还是斜线  3 x轴直线，横向移动  2y轴直线，纵向移动   1 正斜线移动  -2都不是 0x轴日字（竖日），-1y轴日字（正日）
    public int line(Point tp){
        //x
        if(p.y==tp.y){
            return 3;
        }else if(p.x==tp.x){
            //y
            return 2;
        }else if(Math.abs(p.y-tp.y)==Math.abs(p.x-tp.x)){
            //正斜线
            return 1;
        }else{
            //日字
            if(Math.abs(p.x-tp.x)==2 && Math.abs(p.y-tp.y)==1){
                //x
                    return 0;
            }else if(Math.abs(p.x-tp.x)==1 && Math.abs(p.y-tp.y)==2){
                //y
                return -1;
            }
        }
        return -2;
    }

    //计算目标点与起点之间的距离，
    public int getStep(Point tp){
        int line=line(tp);
        if(line==3){
            //x
            return Math.abs(p.x-tp.x);
        }else if(line==2 || line==1){
            //y或正斜线
            return Math.abs(p.y-tp.y);
        }
        return 0;
    }

    //判断不能过河,false 没有过河  true过了河
    public boolean isOverRiver(Point tp){
        int upOrDown = isUpOrDown();
        if(upOrDown==1){
            //上
            if(tp.y<6){
                return false;
            }
        }else if(upOrDown==2){
            //下
            if(tp.y>5){
                return false;
            }
        }
        return true;
    }

    //判断是否蹩脚
    public boolean isBieJiao(Point tp,GamePanel_Gaoqilan gamePanel){
        Point center = new Point();//中心点
        if("xiang".equals(name)){
            center.x=(p.x+tp.x)/2;
            center.y=(p.y+tp.y)/2;
            return gamePanel.getChessByp(center) !=null;
        } else if("ma".equals(name)) {
            //马走日字
            int line =line(tp);
            if(line ==0){
                //x轴日字，求蹩脚点
                center.x=(p.x+tp.x)/2;
                center.y=p.y;

            }else if(line == -1){
                center.y=(p.y+tp.y)/2;
                center.x=p.x;
            }
            return gamePanel.getChessByp(center) !=null;
        }
        return true;
    }

    //计算起点到目标点之间的棋子数量，不包括起点和目标点的位置
    public int getCount(Point tp,GamePanel_Gaoqilan gamePanel){
        int line=line(tp);
        Point p1=new Point();
        int start=0;
        int end=0;
        int count=0;//保存路径上棋子个数
        //要区分横着走还是竖着走，并且区分上下左右
        if(line ==2){
            //y
            p1.x=tp.x;
            if(tp.y>p.y){
                //从上往下走
                start = p.y+1;
                end=tp.y;

            }else{
                //从下往上
                start = tp.y+1;
                end=p.y;
            }
            //计算起点和终点的目标变化
            for(int i=start;i<end;i++) {
                p1.y = i;
                if (gamePanel.getChessByp(p1) != null) {
                    count++;
                }
            }

        }else if(line ==3){
            //x
            p1.y=tp.y;
            if(tp.x>p.x){
                //从左往右走
                start = p.x+1;
                end=tp.x;

            }else{
                //从右往左
                start = tp.x+1;
                end=p.x;
            }
            for(int i=start;i<end;i++) {
                p1.x = i;
                if (gamePanel.getChessByp(p1) != null) {
                    count++;
                }
            }
        }
        return count;
    }

/*
自己写的兵的

    //判断过河没有  1上面的过了  2下面的过了  0没过
    public int is_Overriver(){
        int isUpOrDown = isUpOrDown();
        if(isUpOrDown==1){
            if(p.y>5){
                System.out.println("1过河了");
                    return 1;
            }
        }else if(isUpOrDown==2){
            if(p.y<6){
                System.out.println("2过河了");
                return 2;
            }
        }
        System.out.println("没过河了");
        return 0;
    }

    //兵选择过河还是没过河的条件
    public boolean bin_select(Point tp){
        int overriver=is_Overriver();
        System.out.println("overriver:"+overriver);
        if (overriver !=0){
            if( (Math.abs(tp.x-p.x)==1 && tp.y==p.y)||(tp.y-p.y==1 && tp.x==p.x && overriver==1)||(p.y-tp.y==1 &&tp.x==p.x && overriver==2)){
                System.out.println("过河走得没问题");
                return true;
            }
        }else{
            if((tp.y-p.y==1 && tp.x==p.x && isUpOrDown()==1)||(p.y-tp.y==1 &&tp.x==p.x && isUpOrDown()==2)){
                System.out.println("没过河没问题");
                return true;
            }
        }
        return false;
    }

 */

    //判断是否前进
    public boolean isForward(Point tp) {
        int upOrDown = isUpOrDown();
        if (upOrDown == 1) {
            //上
            if (tp.y > p.y) {
                return true;
            }
        } else if (upOrDown == 2) {
            //下
            if (tp.y < p.y) {
                return true;
            }
        }

        return false;
    }

    //判断是否后退
    public boolean isBack(Point tp) {
        int upOrDown = isUpOrDown();
        if (upOrDown == 1) {
            //上
            if (tp.y < p.y) {
                return true;
            }
        } else if (upOrDown == 2) {
            //下
            if (tp.y > p.y) {
                return true;
            }
        }

        return false;
    }


    //判断棋子是否可以移动到目标位置
    public abstract boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel);
//    {
//        if("boss".equals(name)){
//            return line(tp)>1 && isHome(tp,gamePanel) && getStep(tp)==1;
//        }else if("shi".equals(name)){
//            return line(tp)>1 && isHome(tp,gamePanel) && getStep(tp)==1;
//        }else if("xiang".equals(name)){
//
//            return line(tp) == 1 && getStep(tp) == 2 && !isBieJiao(tp,gamePanel) && ! isOverRiver(tp);
//        }else if("ma".equals(name)){
//            return (line(tp) ==0 || line(tp)==-1)  && !isBieJiao(tp,gamePanel);
//        }else if("che".equals(name)){
//            return line(tp)>1 && getCount(tp,gamePanel)==0;
//        }else if("pao".equals(name)){
//            Chess c=gamePanel.getChessByp(tp);
//            if(c!=null){
//                if(c.getPlayer()!=player){
//                    //吃子
//                    return line(tp)>1 && getCount(tp,gamePanel)==1;
//                }
//            }else{
//                //移动
//                return line(tp)>1 && getCount(tp,gamePanel)==0;
//            }
//        }else if("bing".equals(name)){
////            return bin_select(tp);
//            if(line(tp)<2 || getStep(tp)>1){
//                return false;
//            }
//            if(isOverRiver(p)){
//                return !isBack(tp);
//            }else{
//                return isForward(tp);
//            }
//        }
//        return false;
//    }

    //定义新的棋子类
//    public abstract boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel);


    //棋子绘制的方法：
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

    //绘制棋子的边框
    public void drawRect(Graphics g) {
        g.drawRect(x,y,SIZE,SIZE);
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
        initP =p;//不需要加条件，因为我们该方法只运用一次
        calXY();
//
//
    }
}
