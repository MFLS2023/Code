import tech.gaoqilan.ui.GameJFrameTEST;
import tech.gaoqilan.ui.LoginJFrame;
import tech.gaoqilan.ui.RegeisterJFrame;

public class APP {
    public static void main(String[] args) {
        //表示程序的启动入口
        //如果我们要开启一个界面，就创造谁的对象就可以了

        new LoginJFrame();

        new RegeisterJFrame();

        new GameJFrameTEST();

    }
}
