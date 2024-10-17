package tech.gaoqilan.a04objectdemo;

public class ObjectDemo1 {
    public static void main(String[] args) {
        Object obj = new Object();
        String str1=obj.toString();
        System.out.println(str1);
        //System：类名，out：静态对象，println():方法，参数表示打印的内容
        //当我们打印一个对象的时候，底层会调用对象的toString方法，把对象变成字符串，然后再打印在控制台上，打印完换行处理
        //思考：默认情况下，一i那位Object类中的toString方法返回的是地址值，但是地址值对我们没用
        //思考方案：我想要获取到对应的元素，怎么办，解决方案：重写
        //toString方法的结论：
        //如果我们打印一个对象，想要看到属性值的话，那么就重写toString方法，在方法中把对象的属性值进行拼接



    }
}
