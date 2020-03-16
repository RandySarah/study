package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 思路一：双指针思想：1、排序；2、确定A，寻找A+B+C=0，双指针为B和C
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L15_3sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        //定位num[k]，找到nums[i] + num[j] + num[k] = 0;
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0)
                break;
            if(k > 0 && nums[k] == nums[k - 1])
                continue;//本次双指针搜索只会得到重复的组合
            int i = k + 1, j = nums.length - 1;

            while(i < j){

                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);//跳过重复的i
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);//跳过重复的j
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);//跳过重复的i和j
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(num));
    }


}
