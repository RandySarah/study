package off66;

/**
 * Q47.写一个函数，求出两个整数之和，要求在函数体内不得使用+ - * /四则运算符号
 * A:5的二进制是101 17的二进制是10001
 * 1.各位相加但不进位，10100
 * 2.几下进步位，10
 * 3.将两个结果相加
 */
public class Q47_Add {

    public static int add(int x, int y){
        int sum;
        int carry;

        do{
            sum = x ^ y;
            carry = (x & y) << 1;

            x = sum;
            y = carry;
        }while (y != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2) + ", " + (1 + 2));
        System.out.println(add(5, 17) + ", " + (5 + 17));


    }
}
