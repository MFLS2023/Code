package tech.gaoqilan.main;

import java.awt.*;

public class Bing extends Chess {
    public Bing(int player, Point p) {
        super("bing", player, p);
    }

    public Bing(int player, int px) {
        this(player, new Point(px, 4));
    }


    @Override
    public boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel) {
        if(line(tp)<2 || getStep(tp)>1){
            return false;
        }
        if(isOverRiver(p)){
            return !isBack(tp);
        }else{
            return isForward(tp);
        }
    }
}

