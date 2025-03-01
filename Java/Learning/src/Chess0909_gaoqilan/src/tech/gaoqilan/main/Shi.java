package tech.gaoqilan.main;

import java.awt.*;

public class Shi extends Chess {
    public Shi(int player, Point p) {
        super("shi", player, p);
    }

    public Shi(int player, int px) {
        this(player, new Point(px, 1));
    }


    @Override
    public boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel) {

        return line(tp)>1 && isHome(tp,gamePanel) && getStep(tp)==1;
    }
}

