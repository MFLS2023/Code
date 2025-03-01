package tech.gaoqilan.testdemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        /*
            键盘录入一些1-100之间的整数，并添加到集合中，直到集合中所有数据和超过200为止


         */

        //1.创建一个集合用来添加整数
        ArrayList<Integer> list = new ArrayList<>();
        //2.键盘录入数据添加到集合中
        Scanner sc=new Scanner(System.in);
        int sum=0;
        while(true){
            System.out.println("请输入一个整数");
            String numStr = sc.nextLine();
            //将字符串转化为数字才能进行计算
            int num = Integer.parseInt(numStr);
            if(num<1 || num>100){
                System.out.println("当前数字不在1-100范围，请重新输入");
                continue;
            }
            sum+=num;
            //num：基本数据类型 集合里面的数据是Integer，在添加数据的时候触发了自动装箱
            //下面这个是旧版本的方法
            //list.add(Integer.valueOf(num));

            if(sum>200){
                System.out.println("当前集合中所有数据和已经满足要求了");
                break;
            }else{
                list.add(num);
            }

            //法二：
            //int sum1=getSum(list);

        }

    }
    private static int getSum(ArrayList<Integer>list){
        int sum=0;
        for(int i=0;i<list.size()-1;i++){
            int num=list.get(i);
            sum+=num;
        }
        return sum;
    }

}
