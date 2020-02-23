package off66;

/**
 * Q28.输入一个字符串，打印处该字符串中字符的所有排列，例如输入字符串abc，则打印出由字符a b c所能排列出来的所有字符串abc acb bac bca cab cba等
 *
 * A:首先求出可能在第一个位置的字符，把第一个字符和后面的所有字符交换
 * 在固定第一个字符，求后面所有字符的排列
 */
public class Q28_Permutation {

    public static void permutation(char[] chars){
        if(chars == null || chars.length < 1){
            return;
        }

        permutation(chars,0);
    }

    public static void permutation(char[] chars, int begin){
        //如果是最后一个元素，输出排列结果
        if(chars.length - 1 == begin){
            System.out.println(new String(chars) + "");
        }else{
            char tmp;
            //对当前还未处理的字符进行处理，每个字符都可以作为当前处理位置的元素
           for (int i = begin; i < chars.length; i++){
               //交换元素的位置
               tmp = chars[begin];
               chars[begin] = chars[i];
               chars[i] = tmp;

               permutation(chars,begin+1);
           }

        }

    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }
}
