package leetcode;

/**
 * 5.最长回文字符串：https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class L5_longestPalindromicSubstring {

    /**
     * 穷举法，增加剪枝函数
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if(s.length() == 0){
            return "";
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        int len = s.length();

        for(int i = 0;i<len;i++){
            // 剪枝函数，当前可能的最长字符串已经小于等于最大值
            if(len-1-i+1<=maxLength){
                break;
            }
            for(int j=len-1;j>=i;j--){
                // 剪枝函数，当前可能的最长字符串已经小于等于最大值
                if(j-i+1 <= maxLength){
                    break;
                }
                // 判断是否是回文字符串
                int k=i;
                int m=j;
                while(k<=m){
                    if(s.charAt(k) != s.charAt(m)){
                        //2头字符不相同，故不是
                        break;
                    }
                    k++;
                    m--;
                }
                //判断结果，当k>m时说明循环退出是回文数，此时根据剪枝函数，肯定比最大值大
                if(k>m){
                    maxLength = j-i+1;
                    start=i;
                    end=j;
                }
            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 最长回文字符串==穷举法，超出时间限制
     * @param str
     * @return
     */
    public static String maxPalindromic(String str){

        if(str == null || str.equals("") || str.length() == 1)
            return str;

        if(str.length() == 2 && str.charAt(0) != str.charAt(1)){
            return str.substring(0,1);
        }else if(str.length() == 2 && str.charAt(0) == str.charAt(1)){
            return str;
        }

        String maxStr = str.substring(0,1);//最长的回文串
        int maxLen = 1;//最长的回文串长度
        int len = 0;//保存回文串的长度

        for(int i = 0; i < str.length(); ++i){
            for (int j = i + 1; j < str.length(); ++j){
                String substr = str.substring(i,j+1);//结束索引不包含该字段，注意
                if(isPalindromic(substr)){
                    len = substr.length();
                    if(len > maxLen){
                        maxLen = len;
                        maxStr = substr;
                    }
                }
                len = 0;
            }
        }
        return maxStr;
    }

    /**
     * 判断一个字符串是否为回文字符串
     * @param str
     * @return
     */
    public static boolean isPalindromic(String str){
        int len = str.length();
        for (int i = 0; i < len; ++i){
            if(str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
//        System.out.println(isPalindromic("aba"));
//        System.out.println(isPalindromic("gdhbbhdvdhbvh"));
//        System.out.println(isPalindromic("babad"));

        System.out.println(longestPalindrome("abcda"));
//        System.out.println(maxPalindromic("gdhbbhdvdhbvh"));
//        System.out.println(maxPalindromic("babad"));
    }
}
