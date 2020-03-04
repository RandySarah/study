package off66;

import java.util.LinkedList;
import java.util.List;

/**
 * Q61.按之字形顺序打印二叉树
 * 请实现一个函数按照之字形顺序打印二叉树，第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，以此类推
 *
 * A:需要两个栈，打印某一行的节点时，把下一层的子节点保存到对应的栈里，如果打印的是奇数层，先保存左子节点在保存右子节点，
 * 如果打印的是偶数层，先保存右子节点的，在保存左子节点到第二个栈里
 */
public class Q61_PrintTree {

    /**
     * 结点定义
     */
    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void print(BinaryTreeNode root){
        if(root == null){
            return;
        }
        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();

        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while(current.size() > 0){
            node = ((LinkedList<BinaryTreeNode>) current).remove(current.size()-1);
            System.out.printf("%-3d",node.val);

            if(flag == 0){//偶数行先打印右边数据，左边先入栈
                if(node.left != null){
                    reverse.add(node.left);
                }

                if(node.right != null){
                    reverse.add(node.right);
                }
            }else{
                if(node.right != null){
                    reverse.add(node.right);
                }
                if(node.left != null){
                    reverse.add(node.left);
                }
            }

            if(current.size() == 0){//打印完一行，交换current
                flag = 1 -flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        print(n1);
    }

}
