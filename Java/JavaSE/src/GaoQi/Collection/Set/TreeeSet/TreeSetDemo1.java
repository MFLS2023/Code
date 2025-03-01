package GaoQi.Collection.Set.TreeeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo1 {
    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        for(int i=0;i<100;i++){
            set.add(i);
        }
        System.out.println(set);
        set.remove(2);
        System.out.println(set);

        set.clear();
        System.out.println(set);

        System.out.println(set.isEmpty());

        Set<Employee1> set1=new TreeSet<>();
        set1.add(new Employee1("a",100,1));
        set1.add(new Employee1("b",200,2));
        set1.add(new Employee1("c",300,3));
        for(Employee1 e:set1){
            System.out.println(e);
        }

    }
}

class Employee1 implements Comparable <Employee1>{
    int id;
    String name;
    double salary;

    public Employee1(String name, double salary, int id) {

        this.name = name;
        this.salary = salary;
        this.id = id;
    }
    @Override
    public int compareTo(Employee1 e){
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

