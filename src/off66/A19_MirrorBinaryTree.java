package off66;

/**
 * Q19.请完成一个函数，输入一个二叉树，输出它的镜像
 *
 * A:前序遍历这棵树的每个节点，如果这个节点有子节点，就交换它的两个子节点，
 * 当交换完所有非叶子结点的两个子节点后，得到这棵树的镜像
 */
public class A19_MirrorBinaryTree {

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode mirrorBinary(BinaryTreeNode root){

        if(root != null){

            BinaryTreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            mirrorBinary(root.left);
            mirrorBinary(root.right);

        }
        return root;
    }

    public static void printTree(BinaryTreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.value + " ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;
        printTree(root);
        System.out.println();
        mirrorBinary(root);
        printTree(root);
    }

}
