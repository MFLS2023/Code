package sorting;

public class SortingAlgorithms {

        public static void swap(int[]arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

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
