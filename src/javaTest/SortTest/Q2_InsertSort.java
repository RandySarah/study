package javaTest.SortTest;

/**
 * Q2:插入排序
 * 将数组分为两个区间，已排序区间和未排序区间，初始已排序区间只有一个元素是数组的第一个元素
 * 插入算法的核心思想是取未排序区间的元素，在已排序区间中找到合适的位置将其插入。
 * 合适的插入位置后的元素需要后延
 */
public class Q2_InsertSort {

    public static void sort(int[] array){
        int len = array.length;
        for (int i = 1; i < len; ++i){
             int val = array[i];
             int j = i-1;
             for (; j >= 0; j--){
                 if(array[j] > val){
                     array[j+1] = array[j];
                 }else {
                     break;
                 }
             }
            array[j+1] = val;
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
