package off66;


/**
 * Q4:请实现一个函数，将字符串中的空格替换为%20
 * we are happy
 * we%20are%20happy
 *
 * A4:计算出替换后的字符串长度，从尾到头移动并将空格替换为20%
 */
public class A4_ReplaceSpace {

    /**
     *
     * @param string 字符数组
     * @param useLength 已使用的长度
     * @return 替换后使用的长度
     */
    public static int replace(char[] string, int useLength){
        //校验输入
        if (string == null || string.length < 0 || useLength < 0){
            return -1;
        }

        int count = 0;
        //遍历统计出字符串的长度
        for (int i = 0; i < useLength; ++i){
            if(string[i] == ' '){
                count++;
            }
        }

        //没有空白字符不处理
        if(count == 0){
            return useLength;
        }

        //计算替换后需要的长度，本字符串长度不够返回处理失败
        int targetLength = useLength + count * 2;
        if (targetLength > string.length){
            return -1;
        }
        int tmp = targetLength;
        //从尾到头开始移动字符串并进行空格替换
        useLength--;
        targetLength--;

        while (useLength >= 0 && useLength < targetLength){

            if (string[useLength] == ' '){
                string[targetLength--] = '%';
                string[targetLength--] = '0';
                string[targetLength--] = '2';
            }else {
                string[targetLength--] = string[useLength];
            }
            useLength--;

        }

        System.out.println(string);

        return tmp;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = 'w';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = 'a';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = 'h';
        string[8] = 'a';
        string[9] = 'p';
        string[10] = 'p';
        string[11] = 'y';
        replace(string,12);
    }
}
