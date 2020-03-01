package off66;

/**
 * Q37.输入两个链表，找出他们的第一个公共节点
 *
 * A:在第一个链表上遍历每一个节点，每遍历到一个节点时，在第二个链表上顺序遍历每个节点，如果第二个链表上有一个节点和第一个链表上的节点一样，说明两个链表在这个节点上重合
 * 于是找到了公共节点，如果第一个链表长度为m，第二个链表长度为n，该方法的时间复杂度为O(mn)
 *
 * B:该链表是一个单向链表，如果两个单向链表有公共的节点，从这个链表的某一个节点开始，它们的next都指向同一个节点，因此从第一个公共节点开始，之后他们的所有节点都是重合的
 * 将连个链表放在两个栈里，找到最后一个相同的节点
 *
 * C:先行法：先遍历两个链表得到长度，长的指针先走几步，两个链表一起比较直到找到第一个相同的节点
 */
public class Q37_FindFirstCommonNode {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static ListNode FindFirstCommonNode(ListNode head1, ListNode head2){
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);

        int diff = len1 - len2;

        ListNode longHead1 = head1;
        ListNode shortHead2 = head2;

        if(diff < 0){
            longHead1 = head2;
            shortHead2 = head1;
            diff = len2 - len1;
        }

        for (int i = 0; i < diff; i++){
            longHead1 = longHead1.next;
        }

        while (longHead1 != null && shortHead2 != null && longHead1 != shortHead2){
            longHead1 = longHead1.next;
            shortHead2 = shortHead2.next;
        }
        return longHead1;
    }

    public static int getListLength(ListNode head){
        int result = 0;
        while(head != null){
            result++;
            head = head.next;
        }
        return result;
    }

    private static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;

        System.out.println(FindFirstCommonNode(n1, n4)); // 6
    }

    public static void main(String[] args) {
        test1();
    }

}
