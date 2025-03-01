package tech.gaoqilan.main;

import java.awt.*;

public class Che extends Chess {
    public Che(int player, Point p) {
        super("che", player, p);
    }

    public Che(int player, int px) {
        this( player, new Point(px, 1));
    }


    @Override
    public boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel) {
        return line(tp)>1 && getCount(tp,gamePanel)==0;
    }
}

