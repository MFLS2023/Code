package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrSelection = {64, 25, 12, 22, 11};
        int[] arrBubble = {64, 34, 25, 12, 22, 11, 90};
        int[] arrInsertion = {12, 11, 13, 5, 6};

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
