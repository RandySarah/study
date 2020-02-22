package off66;

/**
 * Q18.输入两颗二叉树A和B,判断B是不是A的子结构
 *
 * A18.在A树中先找一个和B根节点值一样的节点
 * 从这个节点开始判断树B是不是A的子结构
 */
public class A18_IsSubTree {

    /**
     * 二叉树结构定义
     */
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 从A树找到和B树元素相同的节点，开始比较
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == root2){
            return true;
        }

        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
        }

        boolean result = false;

        if(root1.value == root2.value){
            result = match(root1, root2);
        }

        if(result){
            return true;
        }

        return hasSubTree(root1.left,root2) || hasSubTree(root1.right,root2);
    }

    /**
     * 两颗树从根节点开始对每个元素进行判断，是否是A的子树
     * @param root1
     * @param root2
     * @return
     */
    public static boolean match(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == root2){
            return true;
        }

        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
        }

        if(root1.value == root2.value){
            return match(root1.left,root2.left) || match(root1.right,root2.right);
        }

        return false;

    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;

        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 9;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));
    }


}
