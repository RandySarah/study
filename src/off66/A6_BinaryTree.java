package off66;

/**
 * Q6:根据二叉树的前序和中序遍历结果，请重建处该二叉树
 *          1
 *       /     \
 *     2        3
 *    /       /   \
 *  4        5     6
 *   \             /
 *    7          8
 *
 * 前序遍历：{1,2,4,7,3,5,6,8}
 * 中序遍历：{4,7,2,1,5,3,6,8}
 * 后序遍历：{7,4,2,5,8,6,3,1}
 *
 * A:根据前序和中序遍历的特点实现：
 * 前序遍历创建根节点，中序遍历区分出根节点的左右子树，在分别进行递归构造子树
 */
public class A6_BinaryTree {

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode construct(int[] preorder, int[] inorder){

        //合法性校验
        if(preorder == null || inorder == null || preorder.length != inorder.length || inorder.length <1){
            return null;
        }

        //重建二叉树
        return construct(preorder,0, preorder.length - 1, inorder, 0, inorder.length-1);

    }

    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        //开始位置大于结束位置说明没有待处理的数据了
        if(ps > pe || is > ie){
            return null;
        }

        //取到前序遍历的第一个数字，作为当前根节点
        int value = preorder[ps];

        //在中序遍历的数组中找到根节点的位置
        int index = is;
        while (index <= ie && inorder[index] != value){
            index++;
        }
        if(index > ie){//谦虚遍历的数字没有在中序数组中
            throw new RuntimeException("输入非法");
        }

        //创建当前节点
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.value = value;
        //          ps            pe
        // 前序遍历：{1,2,4,7,3,5,6,8}
        //          is  index     ie
        // 中序遍历：{4,7,2,1,5,3,6,8}
        binaryTreeNode.left = construct(preorder, ps + 1 , ps + index - is, inorder, is, index - 1);
        binaryTreeNode.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1 ,ie);

        return binaryTreeNode;
    }

    public static void printTree(BinaryTreeNode binaryTreeNode){
        if (binaryTreeNode != null){
            System.out.println(binaryTreeNode.value);
            printTree(binaryTreeNode.left);
            printTree(binaryTreeNode.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

}