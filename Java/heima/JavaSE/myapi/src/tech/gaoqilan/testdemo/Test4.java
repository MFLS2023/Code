package tech.gaoqilan.testdemo;

import java.time.LocalDate;
import java.util.Calendar;

public class Test4 {
    public static void main(String[] args) {
        /*
            判断任意一个年份是闰年还是平年
            用JDK17或者JDK18
         */

        //jdk17
        //思路1：时间设置为3月1日，然后把日历往前-1天，看是不是29天
        System.out.println("2月份天数：");
        Calendar c= Calendar.getInstance();
        c.set(2004,2,1);
        c.add(Calendar.DAY_OF_MONTH,-1);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //思路2：看一年有多少天
        System.out.println("这一年的天数：");
        Calendar c1= Calendar.getInstance();
        c1.set(2001,0,1);
        c1.add(Calendar.DAY_OF_YEAR,-1);
        int day1 = c1.get(Calendar.DAY_OF_YEAR);
        System.out.println(day1);

        //jdk18
        System.out.println("这一天是这个月的几号：");
        LocalDate ld = LocalDate.of(2000, 3, 1);
        LocalDate ld2=ld.minusDays(1);
        //获取这一天是这个月的几号
        int day2 = ld2.getDayOfMonth();
        System.out.println(day2);

        //直接查询
        System.out.println(ld.isLeapYear());


    }
}
