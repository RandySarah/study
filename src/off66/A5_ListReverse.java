package off66;

import java.util.Stack;

/**
 * Q5:从尾到头打印链表
 * 输入链表的头节点，从尾到头打印每个节点的值
 */
public class A5_ListReverse {

    public static class ListNode{

        int value;//节点的值
        ListNode next;//下一个节点

    }

    /**
     * 1、将链表遍历一遍入栈
     * 2、将栈中数据pop出来并打印
     * @param root
     */
    public static void reverse(ListNode root){

        Stack<ListNode> stack = new Stack<>();

        while (root != null){
            stack.push(root);
            root = root.next;
        }

        ListNode tmp;

        while (!stack.empty()){
            tmp = stack.pop();
            System.out.print(tmp.value + " ");
        }

    }

    public static void main(String[] args) {
        ListNode node1  = new ListNode();
        node1.value = 1;

        ListNode node2  = new ListNode();
        node2.value = 2;

        ListNode node3  = new ListNode();
        node3.value = 3;

        ListNode node4  = new ListNode();
        node4.value = 4;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reverse(node1);
    }
}
