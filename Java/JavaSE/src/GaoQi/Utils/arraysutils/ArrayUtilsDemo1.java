package GaoQi.Utils.arraysutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtilsDemo1 {
    public static void main(String[] args) {
        String[] intro = new String[] { "沉", "默", "王", "二" };
        String[] revised = Arrays.copyOf(intro, 3);
        String[] expanded = Arrays.copyOf(intro, 5);
        System.out.println(Arrays.toString(revised));
        System.out.println(Arrays.toString(expanded));

        String[]abridgement=Arrays.copyOfRange(intro,0,3);
        System.out.println(Arrays.toString(abridgement));

        String[] abridgementExpanded = Arrays.copyOfRange(intro, 0, 6);
        System.out.println(Arrays.toString(abridgementExpanded));

        String[] stutter=new String[4];
        Arrays.fill(stutter,"无敌了哥们");
        System.out.println(Arrays.toString(stutter));

        boolean result=Arrays.equals(intro,stutter);
        System.out.println(result);

        boolean result2=Arrays.equals(abridgementExpanded,stutter);
        System.out.println(result2);
        System.out.println(Arrays.hashCode(intro));
        System.out.println(Arrays.hashCode(stutter));

        String[] number=new String[]{"9","2","5","1","6","3","8","7"};
        String[] sorted=Arrays.copyOf(number,8);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        int exact=Arrays.binarySearch(sorted,"3");
        System.out.println(exact);
        System.out.println(Arrays.binarySearch(sorted,"7",String::compareToIgnoreCase));

        System.out.println(Arrays.stream(sorted,0,5).count());

        System.out.println(Arrays.toString(sorted));

        List<String> rest=Arrays.asList(sorted);
        System.out.println(rest.contains("3"));

        List<String>rest2=new ArrayList<>(Arrays.asList(sorted));
        rest2.add("0");
        rest2.remove("5");
        System.out.println(rest2);

        int[]array=new int[10];
        Arrays.setAll(array,i->i*2);
        System.out.println(Arrays.toString(array));

        int[] arr = new int[] { 1, 2, 3, 4};
        Arrays.parallelPrefix(arr, (left, right) -> left + right);
        System.out.println(Arrays.toString(arr));

    }
}
