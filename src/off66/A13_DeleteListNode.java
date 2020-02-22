package off66;

/**
 * Q13.在O(1)时间删除链表节点
 *
 * A->B->C->D
 *
 * A:假如要删除C节点，我们能得到D节点，将D节点的内容赋值到C上，再将D节点删除
 * 如果要删除的节点是尾节点，需要从头遍历删除
 * 如果要删除的链表只有一个节点，要删除的既是头节点也是尾节点，删除节点之后需要把链表的头节点置为NULL
 *
 */
public class A13_DeleteListNode {

    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode deleteNode(ListNode head, ListNode delNode){

        if(head == null || delNode == null){
            return head;
        }

        //链表中只有一个节点
        if (head == delNode && delNode.next == null){
            return delNode.next;
        }

        //要删除的结点不是尾结点
        if (delNode.next != null){
            ListNode next = delNode.next;
            delNode.next = next.next;
            delNode.value = next.value;
        }

        //删除的节点是尾节点
        if(delNode.next == null){
            ListNode pre = head;
            ListNode del = head;
            while (del.next != null){
                pre = del;
                del = del.next;
            }
            pre.next = null;
        }

        return head;
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

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);

        head = deleteNode(head, head); // 删除头结点
        printList(head);

        head = deleteNode(head, last); // 删除尾结点
        printList(head);


    }

}
