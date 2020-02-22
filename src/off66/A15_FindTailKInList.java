package off66;

/**
 * Q15.输入一个链表，输出该链表的倒数第K个结点
 *
 * A:定义两个指针，第一个指针先走k-1步，接下来两个指针一起走，等到第一个指针到达尾节点时，
 * 第一个指针刚好在到数第K个节点
 */
public class A15_FindTailKInList {

    public static class ListNode{
        private int value;
        private ListNode next;
    }

    public static ListNode findTailKInList(ListNode head, int value){
        ListNode pre1 = head;
        ListNode pre2 = head;

        for (int i = 0; i < value - 1; i++){
            pre1 = pre1.next;
        }

        while (pre1.next != null){
            pre1 = pre1.next;
            pre2 = pre2.next;
        }

        return pre2;
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

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(findTailKInList(head, 1).value); // 倒数第一个
        System.out.println(findTailKInList(head, 5).value); // 中间的一个
        System.out.println(findTailKInList(head, 9).value); // 倒数最后一个就是顺数第一个

    }
}
