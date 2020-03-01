package off66;

/**
 * Q34.丑数
 * 我们把只包含因子2，3，5的数称作丑数，求按从小到大的顺序的第1500个丑数。
 * 6 8都是丑数，14不是因为包含因子7 习惯把1当做第一个丑数
 *
 * A1.逐个判断某个数是不是丑数的解法，直观但不够高效
 * A2.创建数组保存已找到的丑数，使用空间换时间的解法
 */
public class Q34_UglyNumber {

    public static boolean isUgluNum(int num){
        while (num % 2 == 0){
            num /= 2;
        }

        while (num % 3 == 0){
            num /= 3;
        }

        while (num % 5 == 0){
            num /= 5;
        }

        return num == 1;
    }

    public static int getUglyNumber(int index){
        if(index <= 0){
            return 0;
        }

        int num = 0;
        int uglyFound = 0;

        while(uglyFound < index){
            num++;
            if(isUgluNum(num)){
                uglyFound++;
            }

        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("Solution 1:");
        System.out.println(getUglyNumber(1500));


//        System.out.println("Solution 2:");
//        test2();
    }


}
