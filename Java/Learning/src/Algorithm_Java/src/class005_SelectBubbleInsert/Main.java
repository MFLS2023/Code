package class005_SelectBubbleInsert;

import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        //随机最大数组长度N
        int N=200;
        //随机数组每个值，在1~V之间等概率随机
        int V=1000;
        //指定测试次数testTimes
        int testTimes=5000;
        System.out.println("测试开始：如有错误则会输出”出错了“，如果没有错误，将只输出”测试结束“");

        //开始进行排序的测试
        for(int i=0;i<testTimes;i++){
            //随机得到一个长度n，长度在[0~N-1]
            int n=(int)(Math.random()*N);
            //得到随机数组，将原数组进行拷贝方便测试
            int[] arr= randomArray(n,V);
            int[] arr1=copyArray(arr);
            int[] arr2=copyArray(arr);
            int[] arr3=copyArray(arr);
            selectionSort(arr1);
            bubbleSort(arr2);
            insertionSort(arr3);

            //开始对数器验证：进行每一个数据的验证
            if(!sameArray(arr1,arr2)|| !sameArray(arr1,arr3)){
                System.out.println("出错了，请重新检查");
                //当有错误之后
                //打印是什么例子出错了
                //打印三个功能，看各自排序的结果是否正确
                //可能要把例子代入每个方法，进行debug
            }
        }
        System.out.println("测试结束");
    }
    public static int[] randomArray(int n,int v){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            // Math.random() -> double -> [0,1)范围山的一个小数，0.37463473126、0.001231231，等概率！
            // Math.random() * v -> double -> [0,v)一个小数，依然等概率
            // (int)(Math.random() * v) -> int -> 0 1 2 3 ... v-1，等概率的！
            // (int) (Math.random() * v) + 1 -> int -> 1 2 3 .... v，等概率的！
            arr[i]=(int)(Math.random()*v)+1;
        }
        return arr;
    }

    //复制数组，方便验证
    public static int[] copyArray(int[]arr){
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=arr[i];
        }
        return ans;
    }

    //判断每个用例是否一致
    public static boolean sameArray(int[] arr1, int[] arr2){
        int n=arr1.length;
        for(int i=0;i<n;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    //数组中交换i和j位置的数
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //选择排序
    public static void selectionSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }
        //System.out.println("选择排序结果："+Arrays.toString(arr));
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
        //System.out.println("冒泡排序结果："+Arrays.toString(arr));
    }

    //插入排序
    public static void insertionSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
        //System.out.println("插入排序结果："+Arrays.toString(arr));
    }

}