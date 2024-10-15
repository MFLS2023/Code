package tech.gaoqilan.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //JFrame 界面，窗体
    //子类呢？也表示界面，窗体
    //以后跟游戏相关的所有逻辑都在这里了


    //创建一个二维数组
    //目的:用来管理数据
    //加载图片的时候,会根据二维数组中的数据及逆行加载
    int[][] data = new int[4][4];

    public GameJFrame() {


        //初始化界面
        initJFrame();

        //初始化菜单
        initJFrameBar();

        //初始化数据(打乱数据)
        iniData();
        //初始化图片
        initImage();

        //让界面始终显示出来，建议写在最后
        this.setVisible(true);


    }

    //记录0的坐标
    int x = 0, y = 0;
    //初始化数据
    private void iniData() {
        //需求
        //把一个一维数组中的数：0-15打乱顺序
        //再将这16个数据按照4*4的方式存放到二维数组中

        //1.定义一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据的顺序,遍历数组,然后将每个元素与随即索引的元素交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int index = r.nextInt(tempArr.length);
            //交换
            int temp = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = temp;
        }
        //3.遍历数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.println(tempArr[i]+" ");
        }
        System.out.println();

        //4.创建二维数组


        //5.给二维数组添加数据
        //解法一:
//        for (int i = 0; i < tempArr.length; i++) {
//            if(tempArr[i] == 0){
//                x=i/4;
//                y=i%4;
//            }else{
//                data[i/4][i%4]=tempArr[i];
//            }
//        }

        //解法二:
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (tempArr[i] == 0) {
                    x = i;
                    y = j;
                    System.out.println(x+"   "+y);
                } else {
                    data[i][j] = tempArr[index];
                }
                index++;
            }
        }
    }

    //初始化图片
    //添加图片的时候,就需要按照二维数组中管理的数据添加图片
    private void initImage() {
        //清楚已经生成的图片,
        this.getContentPane().removeAll();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载图片的序号
                int number = data[i][j];
                //创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon("..\\puzzlegame\\image\\girl\\girl3\\" + number + ".jpg");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                //给图片添加边框,0 RAISED 让图片凸起来,1 LONERED图片凹下去
                jLabel.setBorder(new BevelBorder(1));
                //指定图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
//                //添加一次之后number自增，切换到下一张图片
//                number++;
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\study\\Code\\Java\\heima\\JavaSE\\puzzlegame\\image\\background.png"));
        //把背景图片移动添加到界面中
        background.setBounds(40, 40, 508, 560);

        //先加载的图片在上方,后加载的在下方
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }


    private void initJFrameBar() {
        //初始化菜单
        //创建多个菜单
        JMenuBar JMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象（功能、关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutusJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replaygame = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个条目加到选项中
        functionJMenu.add(replaygame);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(accountItem);

        aboutusJMenu.add(accountItem);

        //将菜单里的两个选项加到菜单中
        JMenuBar.add(functionJMenu);
        JMenuBar.add(aboutusJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(JMenuBar);
    }

    private void initJFrame() {
        //设置游戏界面宽高
        this.setSize(603, 680);
        //设置标题
        this.setTitle("拼图单机版 v1.0");
        //设置游戏界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置程序随游戏界面的关闭而停止
        this.setDefaultCloseOperation(3);
        //取消默认居中，才能让图片随坐标变化
        this.setLayout(null);
        //给整个界面添加键盘事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对  上,下,左,右做判断
        //左37 上 38 右39 下40
        int code = e.getKeyCode();
        //定义 a b 来判断 x y的变化
        int a = 0;
        int b = 0;
        if (code == 37) {
            if(y==3){
                return;
            }
            data[x ][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            initImage();
            System.out.println("向左移动");
        } else if (code == 38) {
            if(x==3){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            initImage();
            System.out.println("向上移动");
        } else if (code == 39) {
            if(y==0){
                return;
            }
            data[x ][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            initImage();
            System.out.println("向右移动");
        } else if (code == 40) {
            if(x==0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            initImage();
            System.out.println("向下移动");
        }




    }
}
