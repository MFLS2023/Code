package class004_sorting;

public class SortingAlgorithms {

        public static void swap(int[]arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        //选择排序：从小到大，每次找到最小的并记录下标，然后走完一轮交换，接着从下一个数字开始，循环往复直到完成排序
        public static void selectionSort(int[]arr){
            if(arr == null || arr.length <2){
                return;
            }
            for(int i=0;i<arr.length;i++){
                int temp=i;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]<arr[temp]) {
                        temp = j;
                    }
                }
                swap(arr,i,temp);
            }
        }

        //冒泡排序：从大到小，每次内层循环中如果后面的数比前面的大，则交换，
        public static void bubbleSort(int[]arr){
            if(arr == null || arr.length <2){
                return;
            }
            for(int i= arr.length-1;i>0;i--){
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[j+1]){
                        swap(arr,j,j+1);
                    }
                }
            }
        }

        //插入排序：从小到大，如果前一个数比当前的数要大，则交换，直到前一个数比当前数小为止
        public static void insertionSort(int[]arr){
            if(arr == null || arr.length <2){
                return;
            }
            for(int i=1;i<arr.length;i++){
                for(int j=i; j>0 && arr[j]< arr[j-1];j--){
                    swap(arr,j,j-1);
                }
            }
        }



}
