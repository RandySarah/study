package off66;

/**
 * Q38.数字在排序数组中的次数
 * A:如何用二分查找算法在数组中找到第一个k，二分查找算法总是先拿数组中间的数字和k作比较。如果中间的数字比k大，那么k只有可能出现在数组的前半段，
 * 下一轮我们只在数组的前半段查找就可以了。如果中间的数字比k小，那么k只有可能出现在数组的后半段，下一轮我们只在数组的后半乓查找就可以了。
 * 如果中间的数字和k 相等呢？我们先判断这个数字是不是第一个k。如果位于中间数字的前面一个数字不是k,此时中间的数字刚好就是第一个k。
 * 如果中间数字的前面一个数字也是k，也就是说第一个k肯定在数组的前半段， 下一轮我们仍然需要在数组的前半段查找。
 */
public class Q38_FindNumCount {

    public static int getNumberOfK(int[] data, int k){
        int number = 0;
        if(data != null && data.length > 0){
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);

            if(first > -1 && last > -1){
                number = last - first + 1;
            }
        }
        return number;
    }


    public static int getFirstK(int[] data, int k, int start, int end){
        if(data == null || data.length < 1 || start > end){
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if(midData == k){
            if(midIdx > 0 && data[midData - 1] != k || midIdx ==0){
                return midIdx;
            }else {
                end = midIdx - 1;
            }
        }else if(midData > k){
            end = midIdx - 1;
        }else {
            start = midIdx + 1;
        }

        return getFirstK(data,k,start,end);
    }

    public static int getLastK(int[] data, int k, int start, int end){
        if(data == null || data.length < 1 || start > end){
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        } else {
            end = midIdx - 1;
        }

        return getLastK(data, k, start, end);
    }

    public static void main(String[] args) {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4
    }

}
