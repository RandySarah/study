package off66;

/**
 * Q27.输入一颗二叉搜索树,将该二叉搜索树转换成一个排序的双向链表，不能创建任何新的节点，只能调整树种节点指针指向
 *
 * A:将二叉搜索树中序遍历得到有序序列，将每个节点的左指针指向上一个有序序列的节点，将右指针指向保存为序列的最后一个节点
 */
public class Q27_BinaryTreeAndList {

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode convert(BinaryTreeNode node){

        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];

        convertNode(node, lastNode);

        BinaryTreeNode head = lastNode[0];
        while (head.left != null){
            head = head.left;
        }

        return head;
     }

    public static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode){
        //节点不为空
        if(node != null){
            //如果有左子树先处理左子树
            if(node.left != null){
                convertNode(node.left,lastNode);
            }
            //当前节点的前驱指向已经处理好的链表尾部
            node.left = lastNode[0];
            //双向链表的尾部的后继节点指向当前节点
            if(lastNode[0] != null){
                lastNode[0].right = node;
            }
            //链表尾部节点更新为当前节点
            lastNode[0] = node;

            if(node.right != null){
                convertNode(node.right,lastNode);
            }
        }
    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }


    private static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;

        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;

        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;

        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;

        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");

        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
    }

}
