package GaoQi.Collection.Practice1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoColorBall {

    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        for(int i=1;i<7;i++){
            set1.add(i);
        }
        Set<Integer > set2=new HashSet<>();
        for(int i=1;i<34;i++){
            set2.add(i);
        }
//        System.out.println(set1);
//        System.out.println(set2);

        Set<Integer> set3=new HashSet<>();
        set3.add(getRandom(1,7));
        for(int i=0;i<6;i++){
            set3.add(getRandom(1,34));
        }

        Set<Integer>set4=new HashSet<>();
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++){
            set4.add(sc.nextInt());
        }
        System.out.println(set3);
        System.out.println(set4);
        int score=0;
        for(int i=0;i<7;i++){
            if(set3.contains(set4.toArray()[i])){
                score++;
            }
        }
        System.out.println(score);
    }


    public static int getRandom(int min, int max){
        return (int)(Math.random()*(max-min))+min;
    }


}
