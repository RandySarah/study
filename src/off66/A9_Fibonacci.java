package off66;

/**
 * Q9:写一个函数，输入n，求斐波那契Fiboncci数列的第n项
 * 1、n = 0 -> f(n) = 0;
 * 2、n = 1 -> f(n) = 1;
 * 3、n > 1 -> f(n) = f(n-1) + f(n-2)
 */
public class A9_Fibonacci {

    public static int Fibonacci(int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(0));
        System.out.println(Fibonacci(1));
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci(7));

    }
}
