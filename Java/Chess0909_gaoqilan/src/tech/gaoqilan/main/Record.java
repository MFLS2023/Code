package tech.gaoqilan.main;


import java.awt.*;

//走棋记录
public class Record {
    //操作的棋子类
    private Chess chess;
    //起点坐标
    private Point start;
    //结束坐标
    private Point end;

    private Chess eatedChess;

    public Record(){

    }

    public Record(Chess chess, Point start, Point end) {
        this.chess = chess;
        this.start = start;
        this.end = end;
    }

    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Chess getEatedChess() {
        return eatedChess;
    }

    public void setEatedChess(Chess eatedChess) {
        this.eatedChess = eatedChess;
    }

    @Override
    public String toString() {
        return "Record{" +
                "chess=" + chess +
                ", start=" + start +
                ", end=" + end +
                ", eatedChess=" + eatedChess +
                '}';
    }
}
