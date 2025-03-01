package GaoQi.Collection.Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {
    public static void main(String[] args) {

        Employee e1=new Employee(1001,"张三",1000000.0);
        Employee e2=new Employee(1002,"小二",2000000.0);
        Employee e3=new Employee(1003,"小五",3000000.0);
        Employee e4=new Employee(1004,"小六",4000000.0);

        Map<Integer,Employee>map=new HashMap<>();

        map.put(1,e1);
        map.put(2,e2);
        map.put(3,e3);
        map.put(10001,e4);
        Employee emp=map.get(1);
        System.out.println(emp.getName());
        System.out.println(map);




    }
}


class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "id="+id+",name="+name+",salary="+salary+"]";
    }
}


