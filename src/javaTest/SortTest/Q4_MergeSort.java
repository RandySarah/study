package javaTest.SortTest;

/**
 * Q4.归并排序
 * 利用递归与分治的技术将数据序列划分为越来越小的半子表，再对半子表进行排序，
 * 最后用递归的方法将排好序的半子表合并成越来越大的有序序列
 */
public class Q4_MergeSort {

    public static void sort(int[] array){
        merge(array,0,array.length-1);
    }

    /**
     * 递归分为左右数组排序，在进行排序合并
     * @param array
     * @param p
     * @param r
     */
    public static void merge(int[] array, int p, int r){
        if(p < r){
            int q = (p+r)/2;
            merge(array,p,q);
            merge(array,q+1,r);
            merge(array,p,q,r);
        }
    }

    public static void merge(int[] a, int p, int q, int r){
        //n1和n2分别代表左边序列和右边序列的长度，左边从p开始包括q，右边从q+1开始
        int n1 = q-p+1;
        int n2 = r-q;
        //new出来左右数组进行初始化
        int L[] = new int[n1];
        int R[] = new int[n2];

//		k用来表示当前遍历的数组a的索引
        int i=0,j=0,k=0;
//		分别给L和R赋值
        for(i=0,k=p; i<n1; i++,k++){
            L[i] = a[k];
        }
//		从右边开始
        for(j=0,k=q+1; j<n2; j++,k++){
            R[j] = a[k];
        }
//		比较左右数组大小,将数据合并到原来数组
        for(i=0,j=0,k=p; i<n1&&j<n2; k++){
            if(L[i] > R[j]){
                a[k] = R[j];
                j++;
            }else{
                a[k] = L[i];
                i++;
            }
        }
//		将两个数组中剩下的数放到a中
        if(i<n1){
            for(j=i; j<n1; j++,k++){
                a[k] = L[j];
            }
        }
        if(j<n2){
            for(i=j; i<n2; i++,k++){
                a[k] = R[i];
            }
        }
    }

    public static void print(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,9,6,7,8};
        sort(array);
        print(array);
    }
}
