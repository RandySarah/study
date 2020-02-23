package off66;

import java.util.ArrayList;
import java.util.List;

/**
 * Q25.输入一个二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径，
 * 从树的根节点一直往下直到叶节点所经过的节点形成一条路径。
 *
 * A:路径是根路径到叶子节点，只有前序遍历首先访问根节点
 *
 * 使用前序遍历访问到某个节点时，将该节点添加到路径上，并累计该节点的值和路径的和等于输入的整数则打印出来
 * 当前节点不是叶节点则继续访问子节点，当前节点访问结束后，在函数退出前在路径上删除当前节点，并减去当前节点的值，
 */
public class Q25_FindPathInBinaryTree {

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void findPath(BinaryTreeNode head, int sum){
        List<Integer> list = new ArrayList<>();
        if(head != null){
            findPath(head,list,0,sum);
        }
    }

    public static void findPath(BinaryTreeNode node, List<Integer> list, int cursum, int sum){
        if(node != null){
            cursum += node.value;
            list.add(node.value);

            if(cursum < sum){
                findPath(node.left,list,cursum,sum);//递归处理左子树
                findPath(node.right,list,cursum,sum);//递归处理右子树
            }else if(cursum == sum){
                if(node.left == null && node.right == null){
                    System.out.println(list.toString());
                }
            }

            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 10;
        root.left = new BinaryTreeNode();
        root.left.value = 5;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 4;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 12;

        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);
    }


}
