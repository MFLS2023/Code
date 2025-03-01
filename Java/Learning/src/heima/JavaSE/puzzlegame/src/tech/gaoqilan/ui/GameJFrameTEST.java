package heima.JavaSE.puzzlegame.src.tech.gaoqilan.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class GameJFrameTEST extends JFrame implements KeyListener, ActionListener, MouseListener {
    //JFrame 界面，窗体
    //子类呢？也表示界面，窗体
    //以后跟游戏相关的所有逻辑都在这里了


    //创建一个二维数组
    //目的:用来管理数据
    //加载图片的时候,会根据二维数组中的数据及逆行加载
    int[][] data = new int[4][4];

    public GameJFrameTEST() {


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
    //定义一个变量，记录当前展示图片的路径
    String path = "..\\puzzlegame\\image\\sport\\sport2\\";
    //创建正确的数组
    int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    //统计步数
    int count = 0;

    //创建选项下面的条目对象
    JMenuItem replaygame = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");

    //创建 更换图片 下的条目对象
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");

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
//        for (int i = 0; i < tempArr.length; i++) {a
//            System.out.println(tempArr[i]+" ");
//        }
//        System.out.println();

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
                if (tempArr[index] == 0) {
                    x = i;
                    y = j;
                    System.out.println(x + "   " + y);
                }
                data[i][j] = tempArr[index];

                index++;
            }
        }
    }

    //初始化图片
    //添加图片的时候,就需要按照二维数组中管理的数据添加图片
    private void initImage() {
        //清除已经生成的图片,
        this.getContentPane().removeAll();
        if (victory()) {
            //显示胜利的图标
            JLabel winJLabel = new JLabel(new ImageIcon("D:\\study\\Code\\Java\\heima\\JavaSE\\puzzlegame\\image\\win.png"));
            winJLabel.setBounds(203, 203, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        //创建统计步数按钮
        JLabel countCount = new JLabel("步数" + count);
        countCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(countCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载图片的序号
                int number = data[i][j];
                //创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon(path + number + ".jpg");
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

        //添加一个更换图片的按钮
        JMenu updateJMenu = new JMenu("更换图片");


        //将每一个条目加到选项中
        functionJMenu.add(replaygame);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(accountItem);


        //将条目添加到 更换图片选项中
        updateJMenu.add(girlItem);
        updateJMenu.add(animalItem);
        updateJMenu.add(sportItem);
        aboutusJMenu.add(accountItem);

        //将菜单里的两个选项加到菜单中
        JMenuBar.add(functionJMenu);
        JMenuBar.add(aboutusJMenu);
        JMenuBar.add(updateJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(JMenuBar);

        //给条目绑定事件
        replaygame.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        girlItem.addMouseListener(this);
        animalItem.addMouseListener(this);
        sportItem.addMouseListener(this);


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


    //按下不松时，调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //把界面中的所有图片全部删除
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all = new JLabel(new ImageIcon(path + "\\all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片
            JLabel background = new JLabel(new ImageIcon("D:\\study\\Code\\Java\\heima\\JavaSE\\puzzlegame\\image\\background.png"));
            //把背景图片移动添加到界面中
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }


    //松开按键，会调用该方法
    @Override
    public void keyReleased(KeyEvent e) {
        //判断是否胜利，胜利直接结束
        if (victory()) {
            //结束方法
            return;
        }


        //对  上,下,左,右做判断
        //左37 上 38 右39 下40
        int code = e.getKeyCode();
        //定义 a b 来判断 x y的变化(即实际上有图片的位置坐标相当于空白格子坐标的差值)
        // 比如空白0要向左,那么有图片的y坐标相当于0的坐标小1即b--
        //如果是用下面注释掉的代码,得注意改变x和y==0or==3的情况,同时这样做会导致移动空白格子反方向

        int a = 0;
        int b = 0;
        if (code == 37) {
            if (y == 0) {
                return;
            }
//            data[x ][y] = data[x][y+1];
//            data[x][y+1] = 0;
//            y++;
//            initImage();
            b--;
            System.out.println("向左移动");
        } else if (code == 38) {
            if (x == 0) {
                return;
            }
//            data[x][y] = data[x+1][y];
//            data[x+1][y] = 0;
//            x++;
//            initImage();
            a--;
            System.out.println("向上移动");
        } else if (code == 39) {
            if (y == 3) {
                return;
            }
//            data[x][y] = data[x][y-1];
//            data[x][y-1] = 0;
//            y--;
//            initImage();
            b++;
            System.out.println("向右移动");
        } else if (code == 40) {
            if (x == 3) {
                return;
            }
//            data[x][y] = data[x-1][y];
//            data[x-1][y] = 0;
//            x--;
//            initImage();
            a++;
            System.out.println("向下移动");
        }
        data[x][y] = data[x + a][y + b];
        data[x + a][y + b] = 0;
        x += a;
        y += b;
        if (code <= 40 && code >= 37) {
            count++;
        }
        initImage();
        if (code == 87) {
            //把界面中的所以图片全部删除
//            this.getContentPane().removeAll();
//            //加载完整图片
//            JLabel all=new JLabel(new ImageIcon(path+"\\all.jpg"));
//            all.setBounds(83,134,420,420);
//            this.getContentPane().add(all);
//            //加载背景图片
//            JLabel background=new JLabel(new ImageIcon("D:\\study\\Code\\Java\\heima\\JavaSE\\puzzlegame\\image\\background.png"));
//            //把背景图片添加到界面中
//            this.getContentPane().add(background);
            x = 3;
            y = 3;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    data[i][j] = win[i][j];
                }
            }
            initImage();
//            //刷新界面
//            this.getContentPane().repaint();
        }


    }

    //判断data数组中的数据是否和win数组中相同
    //如果一致，返回true，否则false
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            //i:一次表示二维数组中的索引
            //data[i]:每次表示一个一维数组
            for (int j = 0; j < data.length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //判断
        if (obj == replaygame) {
            System.out.println("重新游戏");
            count = 0;
            iniData();
            initImage();
        } else if (obj == reloginItem) {
            System.out.println("重新登录");
            //返回登录界面，关闭当前游戏界面，打开登录界面
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("公众号");

            //创建一个对象
            JDialog jDialog = new JDialog();
            //创建容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("..\\puzzlegame\\image\\about.png"));
            //设置位置和宽高
            jLabel.setBounds(0, 0, 258, 258);
            //给弹框设置大小
            jDialog.getContentPane().add(jLabel);
            //弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
            //让弹窗显示出来0.

            jDialog.setVisible(true);
        }

    }

    //D:\\study\\Code\\Java\\heima\\JavaSE\\puzzlegame\\image\\background.png  ..\puzzlegame\image\about.png  ..\puzzlegame\image\girl\girl2\
    public void update(int x) {
        Random random = new Random();
        if (x == 1) {
            int number = random.nextInt(14);
            System.out.println(number);
        } else if (x == 2) {
            int number = random.nextInt(9);
            System.out.println(number);
        } else if (x == 3) {
            int number = random.nextInt(11);
            System.out.println(number);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
//        Object obj = e.getSource();
//        System.out.println("danji");
//        if (obj == girlItem) {
//            System.out.println("随机切换美女图片");
//            count = 0;
//            update(1);
//            iniData();
//            initImage();
//        } else if (obj == animalItem) {
//            System.out.println("随机切换动物图片");
//            count = 0;
//            update(2);
//            iniData();
//            initImage();
//        } else if (obj == sportItem) {
//            System.out.println("随机切换运动图片");
//            count = 0;
//            update(3);
//            iniData();
//            initImage();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("press");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("exit");
    }
}

