package javaTest.SortTest;

/**
 * Q1:冒泡排序
 * 每次冒泡操作都对相邻的两个元素进行比较是否满足大小关系的要求，如果不满足则进行交换，
 * 一次冒泡至少会让一个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序工作
 *
 * 冒泡只涉及到相邻数据的交换操作，需要常量级的临时空间，空间复杂度是O(1)，是原地排序算法
 * 冒泡相同大小的数据在排序前后不会改变顺序，是稳定的排序算法
 */
public class Q1_BubbleSort {

    public static void sort(int[] array){
        int len = array.length;

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len-i-1; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void print(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,9,6,7,8};
        sort(array);
        print(array);
    }
}
