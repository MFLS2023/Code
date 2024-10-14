package tech.gaoqilan.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    //JFrame 界面，窗体
    //子类呢？也表示界面，窗体
    //以后游戏界面都在这里了
    public GameJFrame() {
        this.setSize(603,680);
        //已过时的方法：gameJframe.show();
        this.setVisible(true);
    }
}
