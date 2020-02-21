package off66;

/**
 *  Q8:把一个数组最开始的若干个元素搬到数组的末尾，我们称之数组的旋转。
 *  输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3，4, 5, 1, 2｝为｛1, 2, 3, 4，5}的一个旋转，该数组的最小值为1
 *
 *  A:利用二分查找算法，先查找数组的中间元素5，第一个指针指向3，第二个指针指向2，
 *  判断5大于第一个指针指向的3，说明前一段还是递增数组，将第一个指针指向5，
 *  使用二分查找重新计算5和2中间数据为1，判断1小于5，不是递增数据，后面指针向前移动，
 *  直到两个指针相遇，或者计算不出来中间元素后比较找到最小值
 */
public class A8_ArrayRevole {

    public static int min(int[] numbers){
        if(numbers == null || numbers.length < 0){
            throw new RuntimeException("数据非法");

        }

        int lo = 0; //首
        int hi = numbers.length - 1; //尾
        int mid = 0;

        while (numbers[lo] >= numbers[hi]){
            if(hi - lo == 1){
                return numbers[hi];
            }

            mid  = lo + (hi - lo) / 2;

            if(numbers[lo] == numbers[mid] && numbers[mid] == numbers[hi]){
                return minInorder(numbers);
            }

            if(numbers[mid] >= numbers[lo]){
                lo = mid;
            }

            if(numbers[mid] <= numbers[hi]){
                hi = mid;
            }
        }
        return numbers[mid];
    }

    public static int minInorder(int[] numbers){

        int min = numbers[0];

        for (int i = 0; i < numbers.length; ++i){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(min(array1));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(min(array2));

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(min(array5));

        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(min(array6));

        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));

        // 输入NULL
        System.out.println(min(null));

    }
}
