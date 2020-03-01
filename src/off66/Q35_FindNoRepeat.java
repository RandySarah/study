package off66;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Q35.在字符串中找出第一个只出现一次的字符，如输入abaccdeff则输出b
 *
 * A：使用哈希表key存放字符，value存放位置
 */
public class Q35_FindNoRepeat {
    public static char findNoRepeat(String s){
        if(s == null || s.length() < 1){
            throw new RuntimeException("输入非法");
        }

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                map.put(c,-1);
            }else {
                map.put(c,i);
            }
        }

        int index = Integer.MAX_VALUE;
        char result = '\0';

        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();

        for(Map.Entry<Character,Integer> entry : entrySet){
            if(entry.getValue() >= 0 && entry.getValue() < index){
                index = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(findNoRepeat("google")); // l
        System.out.println(findNoRepeat("aabccdbd")); // '\0'
        System.out.println(findNoRepeat("abcdefg")); // a
        System.out.println(findNoRepeat("gfedcba")); // g
        System.out.println(findNoRepeat("zgfedcba")); // g
    }

}
