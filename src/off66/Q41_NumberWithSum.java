package off66;

import java.util.ArrayList;
import java.util.List;

/**
 * Q41_1:和为VS的两个数字，输入一个递增的排序数组和一个数字s,在数组中查找两个数，使得它们的和正好是s，如果有多对数字的和等于s,输出任一一对即可
 * A41_1:{1,2,4,7,11,15}期待的和为15，首先定义两个指针，第一个指针指向数组1，第二个指针指向15，这两个数字的和16大于15，则将第二个指针向左移动
 * 指向11，1和11的和12小于15，则将第一个指针向右移动指向2 和为13小于15，指针向右移动指向4 4和11的和15结束
 *
 * Q41_2:输入一个正数s,打印出所有和为s的正整数序列，至少含有两个数，例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，打印结果有三个序列1-5，4-6，7-8
 * A41_2:以求和为9的所有连续序列为例，先把small初始化为1，big初始化为2，此时序列为{1,2}，序列的和为3，小于9，接下来在增加big变为4，
 * 介于small和big之间的序列,也随之变成了{1,2,3,4},，此时和变为10大于9，删除序列中的一些数字，增加small变为2，此时得到的序列是{2,3,4}
 * 序列的和正好是9，我们找到了第一个和为9的连续序列，在增加big，重复之前的过程可以得到{4,5}
 */
public class Q41_NumberWithSum {

    public static List<Integer> findNumWithSum(int[] data,int sum){
        List<Integer> result = new ArrayList<>(2);

        if(data == null || data.length < 2){
            return result;
        }

        int end = data.length - 1;
        int begin = 0;
        long cursum;

        while (begin < end){
            cursum = data[begin] + data[end];

            if(cursum == sum){
                result.add(data[begin]);
                result.add(data[end]);
                break;
            }else if(cursum < sum){
                begin++;
            }else {
                end--;
            }
        }
        return result;
    }

    public static List<List<Integer>> findSequence(int sum){
        List<List<Integer>> result = new ArrayList<>();

        if(sum < 3){
            return result;
        }

        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;

        while(small < mid){
            if(curSum == sum){
                List<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++){
                    list.add(i);
                }
                result.add(list);
            }

            while (curSum > sum && small < mid){
                curSum -= small;
                small++;
                if(curSum == small){
                    List<Integer> list = new ArrayList<>(2);
                    for (int i = small; i <= big; i++) {
                        list.add(i);
                    }
                    result.add(list);
                }
            }
            big++;
            curSum += big;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumWithSum(data1, 15));

        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumWithSum(data2, 17));

        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumWithSum(data3, 10));

        System.out.println(findSequence(1));
        System.out.println(findSequence(3));
    }
}
