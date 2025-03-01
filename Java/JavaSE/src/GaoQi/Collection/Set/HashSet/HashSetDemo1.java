package GaoQi.Collection.Set.HashSet;
import java.util.Set;
import java.util.HashSet;

public class HashSetDemo1 {
    public static void main(String[] args) {
        Set<String> set1=new HashSet<>();

        set1.add("aa");
        set1.add("bb");

        System.out.println(set1);
        set1.remove("bb");

        System.out.println(set1);
    }

}
