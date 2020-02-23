package off66;

/**
 * Q24.输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 二叉搜索树：所有左子节点的值都比根节点小，所有右子节点的值都比根节点大
 *
 * 5 7 6 9 11 10 8
 *
 *       8
 *     /  \
 *   6     10
 *  / \    / \
 * 5   7  9  11
 *
 *
 * A:后序遍历的最后一个值为根节点，前三个都比8小，是8的左子树，中间三个比8大，是8的右子树。递归下去判断左右子树是否满足
 */
public class Q24_IsBSTSquence {

    public static boolean isBSTSquence(int[] squence){
        if(squence == null || squence.length <= 0){
            return false;
        }

        return verifyBST(squence,0,squence.length-1);
    }


    public static boolean verifyBST(int[] squence, int start, int end){

        if(start >= end){//没有要处理的数据
            return true;
        }

        int index = start;

        while(index < end - 1 && squence[index] < squence[end]){
            index++;
        }

        int mid = index;

        while (index < end -1 && squence[index] > squence[end]){
            index++;
        }

        if(index != end-1){
            return false;
        }

        return verifyBST(squence, start, mid-1) && verifyBST(squence, mid, end-1);

    }


    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + isBSTSquence(data));

    }

}
