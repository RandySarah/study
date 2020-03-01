package off66;

/**
 * Q31.连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数，数组中一个或连续的多个整数组成一个子数组，求所有子数组的和的最大值
 * 要求时间复杂度为O(n)
 *
 * 例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18
 *
 * A1:列出数组的所有子数组并求出他们的和 时间复杂度O(n^2)
 * A2:动态规划
 * A3:
 *      步骤  操作  累计额的子数组和    最大的子数组和
 *      1     +1         1               1
 *      2     -1        -1               1
 *      3     +3         3               3
 *      4     +10       13              13
 *      5     -4        9               13
 *      6     +7        16              16
 *      7     +2        18              18
 *      8     -5        13              18
 */
public class Q31_FindSumInArray {
    public static int findMaxsubArray(int[] array){

        //参数校验
        if(array == null || array.length < 1){
            throw new RuntimeException("输入非法");
        }

        //记录最大的子数组和，初始化为最小的整数
        int Max = Integer.MIN_VALUE;

        //记录的和
        int curMax = 0;

        for (int i : array){
            if (curMax <= 0){
                curMax = i;
            }else{
                curMax += i;
            }

            if(Max < curMax){
                Max = curMax;
            }
        }

        return Max;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(findMaxsubArray(data));
        System.out.println(findMaxsubArray(data2));
        System.out.println(findMaxsubArray(data3));
    }

}
