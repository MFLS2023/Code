package class006_binarysearch;

//import java.util.Arrays;

public class BinarySearch {
    public static int binarysearch(int[] arr, int target) {
        int l=0,r=arr.length-1,m;
        if(arr == null || arr.length==0){
            return -1;
        }
        while(l<=r){
            m=l+(r-l)/2;
            if(target==arr[m]){
                return m;
            }else if(target<arr[m]){
                r=m+1;
            }else{
                l=m-1;
            }
        }
        return -1;
    }
}
