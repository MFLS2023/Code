package tech.gaoqilan.testdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        /*
            用代码实现计算你活了多少天，用JDK7和JDk8两种方式
            快一周没动了
         */

        //JDK7 只要对时间计算或者判断，得先获取当前时间的毫秒值
        //1.出生年月的毫秒值
        String birthday="2004年12月27日";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        Date date=sdf.parse(birthday);//得到Date对象
        long birthdayTime=date.getTime();//获得毫秒值


        //2.当前时间
        long todayTime = System.currentTimeMillis();

        //3.计算间隔天数
        long time=todayTime-birthdayTime;
        System.out.println(time/1000/60/60/24);


        //JDK18
        //获取生日的年月日
        LocalDate ld1= LocalDate.of(2004,12,27);
        //获取当前时间（年月日）
        LocalDate ld2=LocalDate.now();

        long days= ChronoUnit.DAYS.between(ld1,ld2);
        System.out.println(days);

    }
}
