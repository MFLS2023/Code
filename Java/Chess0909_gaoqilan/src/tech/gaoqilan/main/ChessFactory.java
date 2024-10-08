package tech.gaoqilan.main;

//简单开发者工厂模式，设计模式
public class ChessFactory {
    private ChessFactory() {

    }

    public static Chess createChess(String name,int player,int px) {
        if("boss".equals(name)){
            return new Boss(player,px);
        }else if("shi".equals(name)){
            return new Shi(player,px);
        }else if("xiang".equals(name)){
            return new Xiang(player,px);
        }else if("ma".equals(name)){
            return new Ma(player,px);
        }else if("che".equals(name)){
            return new Che(player,px);
        }else if("pao".equals(name)){
            return new Pao(player,px);
        }else if("bing".equals(name)){
            return new Bing(player,px);
        }
        return null;
    }
}
