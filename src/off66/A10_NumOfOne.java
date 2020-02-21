package off66;

/**
 * Q10:请实现一个函数，输入为一个整数，输出为该二进制中表示1的个数
 *
 * A1:判断整数二进制表示的最右边是不是1，接着把整数右移一位，直到整个整数位数判断完成
 * A2:每次将整数的最后一位置为0，直到该整数为0
 */
public class A10_NumOfOne {

    public static int numOfOne1(int n){
        int result = 0;
        //int整形占四个字节，总计32位
        //java提供两种右移运算符，属于位运算符。位运算符用来对二进制位进行操作。
        //>>: 算术右移运算符，也称带符号右移。用最高位填充移位后左侧的空位。
        //>>>: 逻辑右移运算符，也称无符号右移。只对位进行操作，用0填充左侧的空位。
        for (int i = 0; i < 32; ++i){
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static int numOfOne2(int n){
        int result = 0;

        //二进制中有多少个1做多少次操作
        while (n != 0){
            result++;
            //每次操作都使n的最右一个1变为0
            n = (n - 1) & n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numOfOne1(9));
        System.out.println(numOfOne1(9));
    }
}
