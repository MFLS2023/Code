package GaoQi.Collection.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> treemap1=new TreeMap<>();
        treemap1.put(20,"aa");
        treemap1.put(10,"bb");
        treemap1.put(30,"cc");

        for(Integer key:treemap1.keySet()){
            System.out.println(key+"---"+treemap1.get(key));
        }

        Map<Employee,String> treemap2=new TreeMap<>();
        treemap2.put(new Employee("张三",100000.0,1001),"张三很不错");
        treemap2.put(new Employee("小二",20000.0,1002),"小二还不错");
        treemap2.put(new Employee("小五",20000.0,1003),"小五还不错");

        for(Employee key:treemap2.keySet()){
            System.out.println(key+"---"+treemap2.get(key));
        }

    }
}


class Employee implements Comparable <Employee>{
    int id;
    String name;
    double salary;

    public Employee(String name, double salary, int id) {

        this.name = name;
        this.salary = salary;
        this.id = id;
    }
    @Override
    public int compareTo(Employee e){
        if(this.salary>e.salary){
            return 1;
        }else if(this.salary<e.salary){
            return -1;
        }else{
            if(this.id>e.id){
                return 1;
            }else if(this.id<e.id){
                return -1;
            }else{
                return 0;
            }
        }
    }

    @Override
    public String toString(){
        return "id="+id+",name="+name+",salary="+salary;
    }
}