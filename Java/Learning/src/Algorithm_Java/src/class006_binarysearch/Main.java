package class006_binarysearch;


public class Main {
    public static void main(String []array){
        int []sortedarray={1,2,3,4,5,6,7,8,9,10};

        int target=3;
        System.out.println("下面开始寻找是否存在目标值，存在则输出目标的下标，如果没找到，则输出-1");
        System.out.println(BinarySearch.binarysearch(sortedarray,target));
    }
}
