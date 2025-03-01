package GaoQi.Collection.Collections;

import java.util.*;

public class CollectionsDemo3 {
    public static void main(String[] args) {
        User user1=new User(1001,"张三",2000,"2018.5.5");
        User user2=new User(1002,"sadfas",208324,"2039.2.5");

        List<User> list=new ArrayList<>();
        list.add(user1);
        list.add(user2);

        for(User u :list){
            System.out.println(u);
        }


        Map<Integer,User> map=new HashMap<>();
        map.put(1001,user1);
        map.put(1002,user2);
        Set<Integer>keyset=map.keySet();
        for(Integer key:keyset){
            System.out.println(key+"----"+map.get(key));
        }
    }
}

class User{
    private int id;
    private String name;
    private double salary;

    private String hiredate;

    public User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "id:"+id+" name:"+name+" salary:"+salary+" hiredate:"+hiredate;
    }
}