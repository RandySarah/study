package off66;

/**
 * Q32.从1到n整数中1出现的次数
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数，例如输入12，从1到12这些整数中包含1的数字有1 10 11和12 1一共出现了5次
 *
 * A1:累加1到n中每个整数出现的次数，可以通过每次对10求余数判断整数的个位数字是不是1，如果大于10，除以10以后在判断个位数字是不是1
 *
 * A2:规律求解：https://blog.csdn.net/derrantcm/article/details/46753185
 */
public class Q32_numOf1 {
    public static int numberOf1Between1AndN(int n){
        if(n <= 0){
            return 0;
        }
        String value = n + "";

        int[] num = new int[value.length()];

        for (int i = 0; i < num.length; i++){
            num[i] = value.charAt(i) - '0'; //charAt()方法用户返回指定索引处的字符
        }

        return numberOf1(num,0);
    }

    /**
     * 求0-numbers表的数字中1的个数
     * @param numbers 数字，如{1,2,3,4,5}表示数字12345
     * @param curIdx 当前处理的位置
     * @return  1的个数
     */
    public static int numberOf1(int[] numbers, int curIdx){
        if(numbers == null || curIdx >= numbers.length || curIdx < 0){
            return 0;
        }
        //待处理的第一个数字
        int first = numbers[curIdx];
        //要处理的数字和位数
        int length = numbers.length - curIdx;
        //如果只有1位且这一位是0返回0
        if(length == 1 && first == 0){
            return 0;
        }
        //如果只有1位且这1位不是0返回1
        if(length == 1 && first > 0){
            return 1;
        }

        //假设numbers是21345
        //numFirstDigit是数字10000-19999的第一个位中的数目
        int numFirstDigit = 0;

        //如果高位不是1，如21345 在[1236,21345中]，最高位1出现的只有在[10000,19999]中，出现1的次数是10^4方
        if(first > 1){
            numFirstDigit = powerBase10(length - 1);
        }else if(first == 1){//如果最高位是1，如12345，在[2346,12345]中，最高位1出现的只在[10000,12345]中，总计2345+1个
            numFirstDigit = atoi(numbers,curIdx + 1) + 1;
        }
        //[1346,21345]除了第一位之外数位中1的个数
        int numOtherDigits = first * (length - 1) * powerBase10(length - 2);
        //[1,1234]中1的数目
        int numRecursive = numberOf1(numbers,curIdx + 1);

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    /**
     * 将数字数组转化为数值
     * @param num
     * @param i
     * @return
     */
    public static int atoi(int[] num, int i){
        int result = 0;
        for (int j = i; j < num.length; j++){
            result = result * 10 + num[i];
        }
        return result;
    }


    /**
     * 求10的n次方
     * @param n
     * @return
     */
    public static int powerBase10(int n){
        int result = 1;
        for (int i = 0; i < n; i++){
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(1)); // 1
        System.out.println(numberOf1Between1AndN(5)); // 1
        System.out.println(numberOf1Between1AndN(10)); // 2
        System.out.println(numberOf1Between1AndN(55)); // 16
        System.out.println(numberOf1Between1AndN(99)); // 20
        System.out.println(numberOf1Between1AndN(10000)); // 4001
        System.out.println(numberOf1Between1AndN(21345)); // 18821
        System.out.println(numberOf1Between1AndN(0)); // 0
    }

}
