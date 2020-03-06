package javaTest.SortTest;

/**
 * Q3.选择排序
 * 类似插入排序，每次从未排序区建找到最小元素，将其放在已排序区间的末尾
 */
public class Q3_SelectSort {
    public static void sort(int[] array){
        int len = array.length;

        for (int i =0; i < len; ++i){
            int mix = i;//最小元素的下标
            int tmp;

            for(int j = i+1; j < len; j++){
                if(array[j] < array[mix]){
                    mix = j;
                }
            }
            if(i != mix){
                tmp = array[i];
                array[i] = array[mix];
                array[mix] = tmp;
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
