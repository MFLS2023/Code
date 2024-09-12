package tech.gaoqilan.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainFrame_Gaoqilan extends JFrame implements ActionListener{

    private GamePanel_Gaoqilan gp = null;

    //创建按钮点击事件
    public MainFrame_Gaoqilan(){

        //设置窗口的大小
        setSize(500,450);

        //设置窗口居中
        setLocationRelativeTo(null);

        //设置点击关闭按钮同时结束虚拟机，每个Java程序都是一个虚拟机
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置布局管理员
        setLayout(new BorderLayout());
        //将游戏面板添加到窗口中
        gp=new GamePanel_Gaoqilan();
        add(gp, BorderLayout.CENTER);
        //添加按钮面板
        JPanel btnPanel=new JPanel(new GridLayout(6,1));
        add(btnPanel, BorderLayout.EAST);

        JLabel hintLabel=new JLabel("红方走");
        btnPanel.add(hintLabel);
        gp.setHintLabel(hintLabel);
        JButton btnHuiQi=new JButton("悔棋");
        btnHuiQi.setActionCommand("HuiQi");
        btnPanel.add(btnHuiQi);
        btnHuiQi.addActionListener(this);

        JButton btnSave=new JButton("保存棋谱");
        btnSave.setActionCommand("Save");
        btnPanel.add(btnSave);
        btnSave.addActionListener(this);

        JButton btnImport=new JButton("导入");
        btnImport.setActionCommand("Import");
        btnPanel.add(btnImport);
        btnImport.addActionListener(this);

        JButton bitnQiuHe= new JButton("求和");
        bitnQiuHe.setActionCommand("QiuHe");
        btnPanel.add(bitnQiuHe);
        bitnQiuHe.addActionListener(this);

        JButton btnRenShu=new JButton("认输");
        btnRenShu.setActionCommand("RenShu");
        btnPanel.add(btnRenShu);
        btnRenShu.addActionListener(this);

        //设置窗口可见，建议放到后面
        setVisible(true);

    }


    public static void main(String[] args){


        //创建一个名称为frm的JFrame的实例
//        JFrame frm=new JFrame();


        //创建匿名对象
        new MainFrame_Gaoqilan();
        //创建实例的格式：类名 实例名 = new 类的构造方法();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("已点击按钮");
        String cmd=e.getActionCommand();
        switch(cmd){
            case"HuiQi":
                System.out.println("悔棋");
                gp.huiqi();
                break;
                case "Save":
                    System.out.println("保存");
                    save();
                    break;
                    case "Import":
                        System.out.println("导入");
                        daoru();
                        break;
                        case "QiuHe":
                            System.out.println("求和");
                            break;
                            case "RenShu":
                                System.out.println("认输");
                                break;
                                default:
                                    break;

        }
    }

    // 导入数据
    private void daoru(){
        JFileChooser chooser=new JFileChooser();
//        chooser.setFileSelectionMode(JFileChooser.);
        int result=chooser.showSaveDialog(null);
        File parent =chooser.getSelectedFile();
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try(FileInputStream fileInputStream = new FileInputStream(parent)){
            fis=new FileInputStream(parent);
            ois=new ObjectInputStream(fis);
            Chess[] chesses=(Chess[]) ois.readObject();
            gp.setChesses(chesses);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void save(){
        JFileChooser chooser=new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result=chooser.showSaveDialog(null);
        File parent =chooser.getSelectedFile();
        System.out.println("parent---->"+parent);
        //创建文件
        String path=parent.getAbsolutePath() + File.separator+System.currentTimeMillis()+".txt";
        File file=new File(path);
        if(!file.exists()){
            try {

                file.createNewFile();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            //创建文件输出流对象
            fos = new FileOutputStream(file);
            //创建文件对象  输出流对象
            oos =new ObjectOutputStream(fos);
            oos.writeObject(gp.getChesses());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
