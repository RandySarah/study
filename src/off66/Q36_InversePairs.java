package off66;

/**
 * Q36_数组中的逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对，输入一个数组，求出这个数组中逆序对的总数
 *
 * A:顺序扫描整个数组，逐个比较该数字和它后面的数字大小，如果后面的数字比它小，则这两个数字组成了一个逆序对，假设数组中含有n个数字，由于每个数字都要和O(n)个数字去比较，
 * 因此这个算法的时间复杂度是O(n^2)，归并排序
 */
public class Q36_InversePairs {
    public static int inversePairs(int[] data){
        if(data == null || data.length < 1){
            throw new RuntimeException("数组非法");
        }

        int[] copy = new int[data.length];

        System.arraycopy(data,0,copy,0,data.length-1);

        return inversePairsCore(data,copy,0,data.length-1);
    }

    public static int inversePairsCore(int[] data,int[] copy,int start,int end){
        if(start == end){
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = inversePairsCore(copy,data,start,start + length);
        int right = inversePairsCore(copy,data,start + length + 1,end);

        //前半段数字的最后一个下标
        int i = start + length;
        //后半段最后一个数字的下标
        int j = end;
        //开始拷贝的位置
        int indexCopy = end;
        //逆序数
        int count = 0;

        while(i >= start && j >= start + length + 1){
            if(data[i] > data[j]){
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length);//对应的逆序数
            }else{
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        for (; i >= start;){
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }

        for(; j>= start + length + 1;){
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
    }
}
