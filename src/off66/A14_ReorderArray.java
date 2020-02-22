package off66;

/**
 * Q14:输入一个数组，调整数组顺序使得奇数位于偶数前面
 *
 * A1:从头扫描这个数组，遇到偶数则将这个数字后面依次向前移动，直到最后一位为空将这个数字放进去
 * A2:前后两个指针，依次遍历，第一个指针找到偶数，第二个指针找到奇数，则将两个数字交换，直到两个指针相遇
 */
public class A14_ReorderArray {

    public static void reorder(int[] array){
        int i = 0;
        int j = array.length-1;

        while (i < j){
            if(array[i] % 2 != 0){//奇数，不要移动
                i++;
            }
            if(array[j] %2 != 1){//偶数，不要移动
                j--;
            }
            if(i < j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        for(int n = 0; n < array.length; ++n){
            System.out.print(array[n] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorder(array);
    }

}
