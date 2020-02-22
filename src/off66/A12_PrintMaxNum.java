package off66;

/**
 * Q12:输入一个数字n,按顺序打印出1到最大的n位十进制数，
 * 输入3则打印出1，2，3到999
 *
 * A1:先求出最大的n位数，用一个循环开始从1打印，但是由于没有规定n的范围，如果整型（int）和长整型(long long)都溢出的话需要考虑大数问题
 * A2:在字符串上模拟数字加法的解法，使用字符串解决大数问题，数字最大是n位的，我们需要一个长度为n+1的字符串，最后一位是结尾标志'\0',当实际数字不够的时候
 * 在字符串的前半部分补0，首先将字符串的每一位数字都初始化为'0'，然后每一次为字符串表示的数字加1，再打印出来
 *
 */
public class A12_PrintMaxNum {

    /**
     * 1、入口函数，传入数字
     * 校验位数，打印1-到最大位数
     * @param n
     */
    public static void printMaxNum(int n){
        if(n < 1){
            throw new RuntimeException("输入非法");
        }

        char number[] = new char[n];
        for(int i = 0; i < number.length; ++i){
            number[i] = '0';
        }

        //无溢出
        while(!incrementNumber(number)){
            //打印
            printNumber(number);

        }


    }

    /**
     * 将输入的字符串作为数子运算+1
     * @param number
     * @return 是否溢出
     */
    public static boolean incrementNumber(char[] number){
        boolean overflow = false; //判断是否溢出
        int takeover = 0; //判断是否进位
        int length = number.length;

        for (int i = length - 1; i >= 0; --i){//从后往前取字符转换为数字加进位符
            int sum = number[i] - '0' + takeover; //字符串转数字，加上进位

            if(i == length -1){//末尾加1
                ++sum;
            }

            if(sum >= 10){ //需要进位
                if (i == 0){ //超过最大位数，溢出，不可以进位
                    overflow = true;

                }else{ //可以进位
                    sum -= 10;
                    takeover = 1;
                    number[i] = (char) (sum + '0');
                }
            }else{ //不需要进位
                number[i] = (char) (sum + '0');
                break;
            }
        }
        return overflow;
    }


    /**
     * 将字符串打印出来数字格式
     * @param number
     */
    public static void printNumber(char[] number){

        boolean begin = true;
        int length = number.length;
        for (int i = 0; i < length; ++i){
            if(begin && number[i] != '0'){
                begin = false;
            }
            if(!begin){
                System.out.print(number[i]);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        printMaxNum(5);
    }
}
