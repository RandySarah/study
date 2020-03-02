package off66;

/**
 * Q49.实现一个函数，将字符串转换为整数，不能使用其他的库函数
 */
public class Q49_StringToInt {
    public static int stringToInt(String num){
        if(num == null || num.length() < 1){
            throw new RuntimeException("输入非法");
        }

        char first = num.charAt(0);

        if(first == '-'){
            return parseString(num,1,false);
        }else if(first == '+'){
            return parseString(num,1,true);
        }else if(first >= '0' && first <= '9'){
            return parseString(num,0,true);
        }else {
            throw new RuntimeException("输入非法");
        }
    }

    /**
     * 判断字符是否是数字
     *
     * @param c 字符
     * @return true是，false否
     */
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     *
     * @param num 字符串
     * @param index 解析的位数
     * @param positive 正负数
     * @return
     */
    public static int parseString(String num, int index, boolean positive){
        if(index >= num.length()){
            throw new RuntimeException("输入非法");
        }

        int result;
        long tmp = 0;

        while(index < num.length() && isDigit(num.charAt(index))){
            tmp = tmp * 10 + num.charAt(index) - '0';
            if(tmp > 0x8000_0000L){
                throw new RuntimeException();
            }
            index++;
        }

        if(positive){
            result = (int) tmp;
        }else {
            result = (int) -tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));


    }


}
