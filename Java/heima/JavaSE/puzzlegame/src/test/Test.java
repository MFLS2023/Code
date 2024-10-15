package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //需求
        //把一个一维数组中的数：0-15打乱顺序
        //再将这16个数据按照4*4的方式存放到二维数组中

        //1.定义一维数组
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //2.打乱数组中的数据的顺序,遍历数组,然后将每个元素与随即索引的元素交换
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int index=r.nextInt(tempArr.length);
            //交换
            int temp=tempArr[index];
            tempArr[index]=tempArr[i];
            tempArr[i]=temp;
        }
        //3.遍历数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.println(tempArr[i]+" ");
        }
        System.out.println();

        //4.创建二维数组
        int[][]data=new int[4][4];

        //5.给二位数组添加数据
        //解法一:
        for (int i = 0; i < tempArr.length; i++) {
            data[i/4][i%4]=tempArr[i];
        }

        //解法二:
        int index=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j]=tempArr[index];
                index++;
            }
        }
    }
}
