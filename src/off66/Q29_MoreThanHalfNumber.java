package off66;

/**
 * Q29.数组中有一个出现超过次数一半的数字，请找出这个数字
 *
 * A1:排好序的数组中间的数字为该数字，快排效率高
 * A2:根据数组特点找到O(n)的算法，如果一个数字出现次数超过数组长度的一半，说明它出现的次数比其他所有数字出现的次数和还要多，
 * 因此在遍历数组的时候需要保存两个值，一个是数组中的一个数字，一个是次数。
 * 当我们遍历下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数+1
 * 如果下一个数字和我们之前保存的数字不同，则次数-1，
 * 如果次数为零，我们需要保存下一次出现的数子，并把次数设置为1
 * 最后一次把次数设置为1的数字是我们要找的数字
 */
public class Q29_MoreThanHalfNumber {

    public static int findNumber(int[] numbers){
        int num = numbers[0];
        int count = 1;

        for (int i = 1;i < numbers.length; ++i){
            if(count == 0){
                num = numbers[i];
                count = 1;
            }else if(numbers[i] == num){
                count++;
            }else {
                count--;
            }

        }
        return num;
    }

    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findNumber(numbers));
    }
}
