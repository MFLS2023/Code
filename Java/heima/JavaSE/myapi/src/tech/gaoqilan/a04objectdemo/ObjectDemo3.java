package tech.gaoqilan.a04objectdemo;

public class ObjectDemo3 {
    public static void main(String[] args) throws CloneNotSupportedException {

        // 1. 先创建一个对象
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        User u1 = new User(1, "zhangsan", "1234qwer", "girl1", data);

        // 2. 克隆对象
        // 细节：
        // 为了保证原型会将我们创建一个对象，并把原对象中的数据拷贝过去。
        // 书写步骤：
        // 1. 让对象中的 clone 方法
        // 2. 让 java bean 实现 Cloneable 接口
        // 3. 创建新对象后调用 clone 就可以了。
        User u2 = (User) u1.clone();

        // 3. 验证一下拷贝：Object 中的克隆是浅克隆
        //如果u2不随u1变，则深克隆，如果要看浅克隆，只要把User类里面的clone方法，只留最开始的return语句即可
        int[] arr = u1.getData();
        arr[0] = 100;

        System.out.println(u1);
        System.out.println(u2);

        // 第三方的工具
        // 1. 第三方写的代码导入到项目中
        // 2. 编写代码
//        Gson gson = new Gson();
//        // 把对象变成一个字符串
//        String s = gson.toJson(u1);
//        // 使用字符串再变回对象即可
//        User user = gson.fromJson(s, User.class);
//
//        int[] arr = u1.getData();
//        arr[0] = 100;
//
//        // 打印对象
//        System.out.println(user);


    }
}

