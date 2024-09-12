package tech.gaoqilan.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.LinkedList;

public class GamePanel_Gaoqilan extends JPanel {
    //定义一个保存所有棋子的成员变量，类型是数组
    private Chess [] chesses = new Chess[32];

    public Chess[] getChesses() {
        return chesses;
    }

    public void setChesses(Chess[] chesses) {
        this.chesses = chesses;
        repaint();
    }

    //Java集合的使用
    private LinkedList<Record> huiqiList = new LinkedList();
    //当前选中的棋子
    private Chess selectedChess;
    //记住当前选中的阵营
    public int curPlayer=1;
    //提示的label
    private JLabel hintLabel;

    public void setHintLabel(JLabel hintLabel){
        this.hintLabel=hintLabel;
    }

    public void huiqi(){
        Record record=huiqiList.pollLast();
        //将操作的棋子的坐标修改回去
        record.getChess().setP(record.getStart());
        chesses[record.getChess().getIndex()]=record.getChess();
        if(record.getEatedChess()!=null){
            chesses[record.getEatedChess().getIndex()]=record.getEatedChess();

        }
        curPlayer=1-(1-record.getChess().getPlayer());
        overMyTurn();
        //刷新棋盘
        repaint();
    }
    //无参构造方法：权限修饰符 类名{}
    //构造方法可以让我们自定义创建对象时，做一些必要的操作
    public GamePanel_Gaoqilan() {
        super();//调用父类的构造方法，每个类的构造方法中都隐藏了这行代码，且必须在第一行
        System.out.println("GamePanel_Gaoqilan");
        createChesses();
        //操作棋子

        //点击事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击棋盘的坐标为：x=" + e.getX() + ", y=" + e.getY());
                Point p=Chess.getPointFromXY(e.getX(), e.getY());
                System.out.println("点击棋盘的网格坐标对象为：p=" + p);

                if(selectedChess == null) {
                    //第一次选择

                    selectedChess=getChessByp(p);
                    if(selectedChess!=null && selectedChess.getPlayer()==curPlayer) {
                        //说明选的是敌方那个的棋子
                        selectedChess=null;
                        hintLabel.setText("<html> 不能选对方的棋子<br/>"+(curPlayer ==0? "黑方走":"红方走")+"<html>");
                    }
                }else{
                    //重新选择、移动、吃子
                    Chess c = getChessByp(p);
                    if(c!=null){
                        //第n次的时候有棋子
                        //重新选择、吃子（判断是不是对方属性）
                        if(c.getPlayer()==selectedChess.getPlayer()){
                            //重新选择
                            System.out.println("重新选择" );
                            selectedChess = c;
                        }else{
                            //吃子
                            System.out.println("吃子" );
                            if(selectedChess.isAbleMove(p,GamePanel_Gaoqilan.this)){
                                /*
                                    从数组中删掉被吃掉的棋子
                                    修改要移动棋子的坐标
                                 */
                                //将被吃的棋子放入recode中
                                Record record=new Record();
                                record.setChess(selectedChess);
                                record.setStart(selectedChess.getP());
                                record.setEnd(selectedChess.getP());
                                record.setEatedChess(c);
                                huiqiList.add(record);

                                chesses[c.getIndex()]=null;//从数组中删掉被吃掉的棋子
                                selectedChess.setP(p);
                                overMyTurn();
                            }
                        }
                    }else{
                        //第n次点击的时候没有棋子，空白地方，那就是移动
                        System.out.println("移动" );
                        if(selectedChess.isAbleMove(p,GamePanel_Gaoqilan.this)){
                            Record record=new Record();
                            record.setChess(selectedChess);
                            record.setStart(selectedChess.getP());
                            record.setEnd(selectedChess.getP());
                            record.setEatedChess(c);
                            huiqiList.add(record);

                            selectedChess.setP(p);
                            overMyTurn();
                        }
                    }
                }
                System.out.println("点击的棋子对象为 selectedChess=" + selectedChess);

                //告诉棋盘，重新执行print方法，即刷新
                repaint();
                //刷新棋盘说明走完了

            }
        });
    }

    //结束当前回合
    private void overMyTurn(){
        curPlayer =curPlayer ==0? 1:0;
        //不要忘记框置为空
        selectedChess=null;
        hintLabel.setText(curPlayer ==0? "黑方走":"红方走");
    }

    public int getCurPlayer(){
        return curPlayer;
    }

    //根据坐标找棋子,利用网格坐标p对象查找棋子对象

    private void createChesses(){
        String[] names={"che","ma","xiang","shi","boss",
                "shi","xiang","ma","che","pao","pao","bing",
                "bing","bing","bing","bing"};
        int[] xs={1,2,3,4,5,6,7,8,9,2,8,1,3,5,7,9};
        for(int i=0;i<names.length;i++){
//            Chess c = new Chess();//创建棋子类的对象
//            Chess c=new Che(0,1)//创建车
//            Chess c1=new Ma(0,2);
            Chess c=ChessFactory.createChess(names[i],0,xs[i]);

            //解耦合，如上代码耦合度非常高，可以使用多态和开发模式来降耦合度
//            c.setName(names[i]);//指定棋子名称
//            c.setP(xs[i]);//指定棋子的网络坐标
//            c.setPlayer(0);
            c.setIndex(i);
            chesses[i]=c;//将棋子保存到数组中
        }
        for(int i=0;i<names.length;i++){
//            Chess c = new Chess();//创建棋子类的对象
//            c.setName(names[i]);//指定棋子名称
//            c.setP(xs[i]);//指定棋子的网络坐标
            Chess c=ChessFactory.createChess(names[i],1,xs[i]);
            c.setPlayer(1);
            c.reverse();
            c.setIndex(i+16);
            chesses[ c.getIndex()]=c;//将棋子保存到数组中
        }
    }
    private void drawChesses(Graphics g){
        for (Chess item:chesses){//for-each循环,不需要坐标的时候
            if(item!=null){
                item.draw(g,this);
            }

        }
    }
    //有个问题，paint会被调用两次，然后同时又是创建，绘制，要将他们分开
    @Override   //重写注解，如果该方法不是重写父类的方法，加上会报错
    public void paint(Graphics g) {
        super.paint(g);//清除原来的痕迹
        System.out.println("Paint");
        String bgPath="pic"+ File.separator+"qipan.jpg";
        Image bgImg=Toolkit.getDefaultToolkit().getImage(bgPath);//获取Toolkit的实例
        g.drawImage(bgImg,0 , 0, this);

        drawChesses(g);

        if(selectedChess !=null ){
            selectedChess.drawRect(g);
        }

}
    public Chess getChessByp(Point p){
        for(Chess item:chesses){
            if(item!=null&&item.getP().equals(p)){
                return item;
            }
        }
        return null;
    }



//    private int reverseX(int x){
//        return 10-x;
//    }
//    private int reverseY(int y){
//        return 11-y;
//    }
}

