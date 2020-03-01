package off66;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Q33.把数组排成最小的数数
 *
 * 输入一个正整数数组，把数组里所有的数子拼接起来排成一个数，打印拼接出的所有数字中最小的一个
 * 例如输入数组{3,32,321} 则打印出这三个数字能排成的最小数字321323
 *
 * A:找到排序规则，数组根据这个排序规则排序后能排成一个最小的数字，两个数字能拼出mn和nm，如果mn<nm则应该打印出mn，m排在n的前面
 */
public class Q33_SortArrayMIn {
    public static String sort(int[] array){
        if(array == null || array.length == 0){
            return "";
        }
        int len = array.length;
        String[] str = new String[len];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; ++i){
            str[i] = String.valueOf(array[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });

        for (int i = 0; i < len; ++i){
            stringBuilder.append(str[i]);
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {

        int[] data = {3, 5, 1, 4, 2};
        System.out.println(sort(data));
    }

}
