package javaTest.SortTest;

/**
 * Q7.计数排序
 * 将要排序的数据作为数组的下标，统计出数据出现的次数，最后格式化原数组
 */
public class Q7_CountSort {
    public static void sort(int[] array){

        int max = -1;

        for (int i = 0;i< array.length;++i){
            if(array[i] > max){
                max = array[i];
            }
        }

        int[] array2 = new int[max+1];

        for (int i = 0; i< array.length;++i){
            int num = array[i];
            array2[num] += 1;
        }

        for (int j = 0,i=0; j<array2.length;++j){
            int n = array2[j];
            for (int k = 0;k<n;k++){
                array[i++] = j;
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
