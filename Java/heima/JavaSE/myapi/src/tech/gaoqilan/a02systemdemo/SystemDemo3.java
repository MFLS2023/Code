package tech.gaoqilan.a02systemdemo;

public class SystemDemo3 {
    public static void main(String[] args) {
        //public static void arraycopy(数据源数组, 起始索引, 目标数组, 目标索引, 拷贝个数) 数组拷贝
        // 1. 如果拷贝的数组目的地数组和源是基本类型数组，那么两者的类型必须保持一致，否则会报错
        // 2. 在拷贝的过程中不考虑数组的大小化，如果超出范围就会溢出
        // 3. 如果拷贝的数组目的地数组和源是引用数据类型，那么子类类型可以赋值给父类类型

        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);

        Student[] arr1 = {s1, s2, s3};
        Person[] arr2 = new Person[3];
        // 拷贝 arr1 中的数组元素到 arr2 中
        System.arraycopy(arr1, 0, arr2, 0, 3);

        // 遍历 arr2
        for (int i = 0; i < arr2.length; i++) {
            Student stu = (Student) arr2[i];
            System.out.println(stu.getName() + ", " + stu.getAge());
        }
    }


}
