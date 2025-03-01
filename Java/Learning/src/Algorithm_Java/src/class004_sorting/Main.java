package class004_sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrSelection = {3,4,5,2,1};
        int[] arrBubble = {3,4,5,2,1};
        int[] arrInsertion = {3,4,5,2,1};

        // 选择排序
        System.out.println("原数组: " + Arrays.toString(arrSelection));
        SortingAlgorithms.selectionSort(arrSelection);
        System.out.println("选择排序结果: " + Arrays.toString(arrSelection));

        // 冒泡排序
        System.out.println("原数组: " + Arrays.toString(arrBubble));
        SortingAlgorithms.bubbleSort(arrBubble);
        System.out.println("冒泡排序结果: " + Arrays.toString(arrBubble));

        // 插入排序
        System.out.println("原数组: " + Arrays.toString(arrInsertion));
        SortingAlgorithms.insertionSort(arrInsertion);
        System.out.println("插入排序结果: " + Arrays.toString(arrInsertion));
    }
}
