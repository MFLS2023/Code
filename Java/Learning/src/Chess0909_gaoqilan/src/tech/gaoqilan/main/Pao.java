package tech.gaoqilan.main;

import java.awt.*;

public class Pao extends Chess {
    public Pao(int player, Point p) {
        super("Pao", player, p);
    }

    public Pao(int player, int px) {
        this(player, new Point(px, 3));
    }


    @Override
    public boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel) {
        Chess c=gamePanel.getChessByp(tp);
        if(c!=null){
            if(c.getPlayer()!=player){
                //吃子
                return line(tp)>1 && getCount(tp,gamePanel)==1;
            }
        }else{
            //移动
            return line(tp)>1 && getCount(tp,gamePanel)==0;
        }
        return false;
    }
}

