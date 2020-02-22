package off66;

/**
 * Q11.实现函数duble Power(double base, int exponent),求base的exponent次方
 *
 * A:
 */
public class A11_Power {
    public static double power(double base, int exponent){
        //指数和底数不能同时为0
        if(base == 0 && exponent == 0){
            throw  new RuntimeException("非法输入");
        }

        //指数为0返回1
        if(exponent == 0){
            return 1;
        }

        //求指数的绝对值
        long exp = exponent;
        if(exponent < 0){
            exp = -exp;
        }

        //求幂次方
        double result = powerWithUnsignedExponent(base,exp);

        //指数为负数的话需要除以1
        if(exponent < 0){
            result = 1 / result;
        }

        return result;
    }

    /**
     * 求一个数的正整数次幂
     * @return
     */
    public static double powerWithUnsignedExponent(double base, long exponent){
        //指数为0，返回1
        if(exponent == 0){
            return 1;
        }

        //指数为1，返回底数
        if(exponent == 1){
            return base;
        }

        //递归求一半的值
        double result = powerWithUnsignedExponent(base, exponent>>1);

        result *= result;

        //处理指数为奇数的情况
        if(exponent % 2 != 0){
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2,-4));
        System.out.println(power(2,4));
        System.out.println(power(2,0));


    }
}
