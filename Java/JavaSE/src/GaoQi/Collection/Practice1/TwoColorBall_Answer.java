package GaoQi.Collection.Practice1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static GaoQi.Collection.Practice1.TwoColorBall.getRandom;

public class TwoColorBall_Answer {
        public static void main(String[] args) {
            Set<Integer> set3 = new HashSet<>();
            set3.add(getRandom(1,7));
            for(int i=0;i<6;i++){
                set3.add(getRandom(1,34));
            }

            Set<Integer> set4 = new HashSet<>();
            Scanner sc = new Scanner(System.in);
            for(int i=0;i<7;i++){
                set4.add(sc.nextInt());
            }

            System.out.println(set3);
            System.out.println(set4);

            int score = 0;
            for(Integer num : set4) {
                if(set3.contains(num)) {
                    score++;
                }
            }
            System.out.println(score);
        }


}
