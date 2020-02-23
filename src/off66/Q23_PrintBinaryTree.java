package off66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Q23.从上往下打印二叉树，同一层的节点按照从左向右的顺序打印
 *
 * A:借助队列，打印第一节点时，将它的子节点放在队列中，在按队列顺序取出节点并打印，直至队列为空
 */
public class Q23_PrintBinaryTree {

   public static class BinaryTreeNode{
       int value;
       BinaryTreeNode left;
       BinaryTreeNode right;
   }

   public static void printBinaryTree(BinaryTreeNode node){

       Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

       if(node != null){
           queue.offer(node);
       }

       while (!queue.isEmpty()){
           BinaryTreeNode tmp = queue.poll();
           System.out.print(tmp.value + " ");//打印一个元素并删除
           if(tmp.left != null){
               queue.offer(tmp.left);
           }
           if(tmp.right != null){
               queue.offer(tmp.right);
           }
       }
   }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
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
        printBinaryTree(root);

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 1;
        root2.left = new BinaryTreeNode();
        root2.left.value = 3;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.value = 5;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.value = 9;
        System.out.println("\n");
        printBinaryTree(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.value = 0;
        root3.right = new BinaryTreeNode();
        root3.right.value = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.value = 4;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.value = 8;
        System.out.println("\n");
        printBinaryTree(root3);

        // 1
        BinaryTreeNode root4 = new BinaryTreeNode();
        root4.value = 1;
        System.out.println("\n");
        printBinaryTree(root4);

        // null
        System.out.println("\n");
        printBinaryTree(null);

    }


}
