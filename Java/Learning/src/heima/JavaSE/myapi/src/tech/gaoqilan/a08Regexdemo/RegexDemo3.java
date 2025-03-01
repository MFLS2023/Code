package tech.gaoqilan.a08Regexdemo;

public class RegexDemo3 {
    public static void main(String[] args) {


        //写正则表达式：拿着一个正确的数据，从左到右拆分，找每一部分的规律，依次去写,
        //分成三部分：
        //第一部分1表示手机号码只能以 1 开头
        //第二部分：{3-9}表示手机号第二位只能是3-9之间
        //第三部分\\d{9}表示任意数字可以出现9次，
        String regex1="1[3-9]\\d{9}";
        System.out.println("1234564596".matches(regex1));
        System.out.println("13567984521".matches(regex1));
        System.out.println("12345678911".matches(regex1));
        System.out.println("-------------------------------");
        //座机号码
        //020-2324242 01222442 027-42424 0712-3242434
        //分成三部分
        //第一部分：区号
        //第二部分：-
        //第三部分：号码
        String regex2="0\\d{2,3}-?[1-9]\\d{4,9}";
        System.out.println("020-2324242".matches(regex2));
        System.out.println("01222442".matches(regex2));
        System.out.println("027-42424".matches(regex2));
        System.out.println("0712-3242434".matches(regex2));
        System.out.println("0753-888888888".matches(regex2));
        System.out.println("--------------------");

        //邮箱号码
        //第一部分：数字、字母、下划线  \\w
        //第二部分 @
        //第三部分 数字+.+字母（结尾）
        // gql06272@outlook.com  seey@duck.com   zuano.1@edu.cn
        String regex3="\\w+@[\\w&&[^_]]{2,9}(\\.[\\w&&[^_]&&[^0]]{2,6}){1,2}";
        System.out.println("gql06272@outlook.com".matches(regex3));
        System.out.println("seey@duck.com".matches(regex3));
        System.out.println("zuano1@edu.cn".matches(regex3));

        System.out.println("-------------------");
        String regx4="\\w{4,16}";
        System.out.println("zhangsan".matches(regx4));
        System.out.println("sadfhuihui223".matches(regx4));
        System.out.println("afhuisdhui###".matches(regx4));

        System.out.println("-------------------");
        String regx5="[1-9]\\d{16}(\\d|X|x)";
        String regx6="[1-9]\\d{16}[\\dXx]";
        System.out.println("13211234398472878X".matches(regx6));
        System.out.println("12345678911131517X".matches(regx6));
        System.out.println("12345678911131517x".matches(regx6));

        System.out.println("----------------------");
        String regx7="a((?i)b)c";
        System.out.println("abc".matches(regx7));
        System.out.println("Abc".matches(regx7));
        System.out.println("aBc".matches(regx7));

        //身份证号码的严格校验
        //前6位：省份 市区 派出所等信息 第一位不能是0，后面五位是任意数字
        //331320 20001020 111x
        //年
        // [1-9]\\d{5}(18|19|20)\\d{2} (0[1-9]|1[0-2]) (0[1-9]|[12]\\d|3[0-1])(\\d{3}(Xx)|\\d{4})
        String regex8="[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[0-1])((\\d{3}[Xx])|\\d{4})";
        System.out.println("-----------------------------");
        System.out.println("41080119930228457X".matches(regex8));
        System.out.println("510801197609022309".matches(regex8));
        System.out.println("154041198107053787".matches(regex8));
        System.out.println("130313197204039024".matches(regex8));
        System.out.println("430102197606046442".matches(regex8));
        System.out.println("36999919991230123X".matches(regex8));



        //实际开发中，很少会写自己的正则表达式

    }

}
