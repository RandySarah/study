package off66;

/**
 * Q42.翻转单词顺序&左旋转字符串
 * Q42_1：输入一个英文句子，翻转句子中单词顺序，但单词内的顺序不变 输入i am a student 得到 student a am I
 * 思路：先翻转句子中所有的字符，再反转每个单词中字符的顺序
 *
 * Q42_2：字符串的左旋操作是把字符串前面的若干个字符转移到字符串的尾部，请定义一个函数实现字符串左旋操作的功能，比如输入字符串abcdefg和数字2，
 * 该函数将左旋转两位得到结果cdefgab
 *
 * 思路：将abcdefg分为两部分 ab 和 cdefg 分别反转这两部分得到ba gfedc 在反转整个字符串得到 cdefgab
 */
public class Q42_Reverse {

    public static void reverse(char[] data, int start, int end) {
        if(data == null || data.length < 1 || start < 0 || end > data.length || start > end){
            return;
        }

        while(start < end){
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;

            start++;
            end--;
        }
    }

    public static char[] reverseSentence(char[] data){
        if(data == null || data.length < 1){
            return data;
        }

        //翻转整个句子
        reverse(data, 0, data.length - 1);

        int start = 0;
        int end = 0;

        //翻转每个单词
        while (start < data.length){
            if(data[start] == ' '){//空格都往前进
                start++;
                end++;
            }else if(end == data.length || data[end] == ' '){//句子结束或者每个单词结束后翻转这个单词
                reverse(data,start,end-1);
                end++;
                start = end;
            }else {//只加end
                end++;
            }
        }

        return data;
    }

    public static char[] leftRotateString(char[] data, int n){
        if(data == null || n < 0 || n > data.length){
            return data;
        }
        reverse(data,0,n-1);
        reverse(data,n,data.length - 1);
        reverse(data,0,data.length - 1);
        return data;
    }


    public static void main(String[] args) {
        System.out.println(new String(reverseSentence("I am a student.".toCharArray())));
        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 2)));

    }

}
