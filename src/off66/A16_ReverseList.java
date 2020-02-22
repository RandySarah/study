package off66;

/**
 * Q16.定义一个函数，输入一个链表的头节点，反转该链表并输出翻转链表后的头节点
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 * cur
 * A:使用临时节点保存当前处理节点的下一个节点（next）和上一个节点(pre)
 * 当前节点不为空的情况下，找到当前节点的下一个节点next，将当前节点的下一个节点指针指向上一个节点
 * 依次将上一个节点和当前节点右移
 */
public class A16_ReverseList {

    public static class ListNode{
        int value;
        ListNode next;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null; //保存先前节点
        ListNode next = null; //用作临时变量
        ListNode cur = head; //用作当前处理节点

        while (cur != null) {
            next = cur.next; //保存当前节点的下一个节点
            cur.next = pre; //当前节点的下一节点指向上一个节点
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void printList(ListNode node){
        if (node != null){
            while (node != null){
                System.out.print(node.value + " ");
                node = node.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
            ListNode head = new ListNode();
            head.value = 1;

            head.next = new ListNode();
            head.next.value = 2;

            head.next.next = new ListNode();
            head.next.next.value = 3;

            head.next.next.next = new ListNode();
            head.next.next.next.value = 4;

            head.next.next.next.next = new ListNode();
            head.next.next.next.next.value = 5;

            printList(head);
            head = reverseList(head);
            printList(head);

        }


    }


