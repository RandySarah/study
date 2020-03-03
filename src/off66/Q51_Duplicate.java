package off66;

/**
 * Q51.数组中的重复数字
 * 在一个长度为n的数组里所有的数字都在0 - n-1的范围内，某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次，请找出数组中任意一个重复的数字
 *
 * 输入：{2,3,1,0,2,5,3} 对应输出的是重复数字2 3
 *
 * A:
 */
public class Q51_Duplicate {

    public static int duplicate(int[] number){
        if(number == null || number.length < 1){
            return -1;
        }

        for (int i : number){
            if(i < 0 || i >= number.length){
                return -1;
            }
        }

        for (int i = 0; i<number.length; i++){
            //当number[i] 与 i不相同的时候一直交换
            while (number[i] != i){
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if(number[i] == number[number[i]]){
                    return number[i];
                }else {//不同就交换
                    swap(number,i,number[i]);
                }
            }
        }
        return -1;
    }

    public static void swap(int[] data, int x, int y){
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplicate(numbers1));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicate(numbers3));
    }
}
