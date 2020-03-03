package off66;

/**
 * Q55.请实现一个函数用来找出字符流中第一个只出现一次的字符
 * 当从字符流中只读出前两个字符go时，第一个只出现一次的字符是g,当从该字符流中读出前六个字符google时，第一个只出现一次的字符是l
 *
 * A:使用哈希表
 */
public class Q55_FindOnce {
    private int index = 0;
    private int[] occuttence = new int[256];

    public Q55_FindOnce(){
        for (int i = 0; i < occuttence.length; i++){
            occuttence[i] = -1;
        }
    }

    private void insert(char ch) {
        if (ch > 255) {
            throw new IllegalArgumentException( ch + "must be a ASCII char");
        }

        // 只出现一次
        if (occuttence[ch] == -1) {
            occuttence[ch] = index;
        } else {
            // 出现了两次
            occuttence[ch] = -2;
        }

        index++;
    }


    public char firstAppearingOnce(String data){
        if(data == null){
            throw new RuntimeException();
        }

        for (int i = 0; i < data.length(); i++){
            insert(data.charAt(i));
        }

        char ch = '\0';

        // 用于记录最小的索引，对应的就是第一个不重复的数字
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < occuttence.length; i++) {
            if (occuttence[i] >= 0 && occuttence[i] < minIndex) {
                ch = (char) i;
                minIndex = occuttence[i];
            }
        }

        return ch;

    }

    public static void main(String[] args) {
        System.out.println(new Q55_FindOnce().firstAppearingOnce("goo")); // 'g'
    }

}
