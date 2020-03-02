package off66;

/**
 * Q40.一个整型数组里除了两个数字以外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字，要求时间复杂度是O(n)，空间复杂度是O(1)
 *
 * A：任何一个数字异或自己都为0，遍历数组异或数组中的每一个数字
 *假设输入数组{2,4,3,6,3,2,5,5}，当我们一次对数组中的每一个数字做完异或运算之后，得到的结果是0010，异或得到结果的倒数第二位是1，
 * 根据倒数第二位是否是1，将数组分为两组，{2,3,6,3,2}和{4,5,5}
 * 分别对两个子数组求异或，就能找出第一个子数组中只出现一次的数字是6，第二个子数组中只出现一次的数字是4
 */
public class Q40_FindNumbersAppearanceOnce {
    public static int[] findNumbersAppearanceOnce(int[] data){
        int[] result = {0,0};
        if (data == null || data.length < 2){
            return result;
        }

        int xor = 0;
        for (int i : data){
            xor ^= i;
        }

        int indexOf1 = findFirstBit1(xor);

        for (int i : data){
            if(isBit1(i,indexOf1)){
                result[0] ^= i;
            }else {
                result[1] ^= i;
            }
        }
        return result;
    }


    public static int findFirstBit1(int num){
        int index = 0;
        while((num & 1) == 0 && index < 32){
            num >>>= 1;
            index++;
        }
        return index;
    }

    public static boolean isBit1(int num, int indexBit){
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumbersAppearanceOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);

        int[] data2 = {4, 6};
        int[] result2 = findNumbersAppearanceOnce(data2);
        System.out.println(result2[0] + " " + result2[1]);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        int[] result3 = findNumbersAppearanceOnce(data3);
        System.out.println(result3[0] + " " + result3[1]);
    }

}
