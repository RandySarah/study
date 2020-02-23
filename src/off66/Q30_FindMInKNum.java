package off66;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Q30.输入n个整数，找出其中最小的K个数
 *
 * A1.将输入的n个整数排序，排序后位于最前面的K个数就是最小的K个数 O(nlogn)
 * A2.基于数组的第k个数字来调整，使比该数字小的位于数组的左边，比该数字大的位于数组的右边，调整后位于左边的k个数字为要找的数组，但不是排过序的
 * O(n)的时间复杂度，仅当我们可以修改数组元素时使用
 * A3.使用大小堆来实现 O(nlogk)
 *
 * 创建一个大小为k的数据容器来存储最小的k个数字，使用二叉树实现大小堆
 * 使用大堆，如果堆中的数字小于读取的数子，不操作
 * 如果堆中的数字大于读取的数子，如果堆不满，则入堆，如果堆已满，则删除堆顶元素
 *
 * 容器的实现用数据结构中的最大堆，因为其根结点的值永远是最大的结点值。我们用红黑树来实现我们的最大堆容器。
 * 而TreeSet类实现了红黑树的功能，它的底层是通过TreeMap实现的，
 * TreeSet中的数据会按照插入数据自动升序排序。我们只需要将数据放入TreeSet中，其就会为我们实现排序。
 */
public class Q30_FindMInKNum {

    public static ArrayList<Integer> getLeastNumbers(int[] numbers, int k){

        ArrayList<Integer> list = new ArrayList<>();
        int lens = numbers.length;
        if(numbers == null || lens == 0 || k <= 0 || k > lens){
            return list;
        }
        TreeSet<Integer> kSet = new TreeSet<>();

        for (int i = 0; i < lens; i++){
            if(kSet.size() < k){
                kSet.add(numbers[i]);
            }else if(numbers[i] < kSet.last()) {
                kSet.remove(kSet.last());
                kSet.add(numbers[i]);
            }
        }

        Iterator<Integer> iterator = kSet.iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }

        return list;
    }


    public static void main(String[] args) { //测试
        int nums[] = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = getLeastNumbers(nums, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
