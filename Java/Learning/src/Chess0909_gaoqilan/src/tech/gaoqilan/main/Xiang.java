package tech.gaoqilan.main;

import java.awt.*;

public class Xiang extends Chess {
    public Xiang(int player, Point p) {
        super("xiang", player, p);
    }

    public Xiang(int player, int px) {
        this(player, new Point(px, 1));
    }


    @Override
    public boolean isAbleMove(Point tp,GamePanel_Gaoqilan gamePanel) {
        return line(tp) == 1 && getStep(tp) == 2 && !isBieJiao(tp,gamePanel) && ! isOverRiver(tp);
    }
}

