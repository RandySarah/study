package off66;

/**
 * Q26.复杂链表的复制
 * 复制一个复杂链表，该链表内每个结点有一个指针指向下一个节点外，还有一个指针指向链表的任意节点
 *
 *{
 *  value
 *  next
 *  sibling
 *}
 * A1:
 * 1、复制原始链表上的每一个节点，并用next连接起来
 * 2、设置每个节点的sibling指针，每个节点sibling指向节点的节点需要从头节点计算位置，时间复杂度为O(n^2)
 *
 * A2：(使用空间换时间)
 * 1、复制原始链表上的每个N创建N',将创建好的节点使用next连接起来，同时我们把配对信息放在哈希表中
 * 2、设置复制链表上的每个节点的sibling,如果N指向的是S,在哈希表中可以以O(1)的时间找到S对应的S'
 *
 * A3:
 * 1、根据原始链表的每个节点N创建对应的N',将N'放在N的后面
 * 2、设置复制节点的silbing,原始链表的N的silbing指向S,则复制出来的N'是N的next节点，指向S的next节点
 * 3、在拆分成为两个链表
 */
public class Q26_CloneInMultList {

    public static class ListNode{
        int value;
        ListNode next;
        ListNode silbing;
    }

    public static ListNode mulipClone(ListNode node){
        if(node == null){
            return null;
        }

        //克隆节点
        cloneNode(node);
        //修改sibling的指向
        modifySibling(node);
        //拆分链表
        return split(node);

    }

    public static void cloneNode(ListNode node){
        if(node == null){
            throw new RuntimeException("输入不合法");
        }

        while (node != null){
            ListNode tmp = new ListNode();
            tmp.value = node.value + 10;
            tmp.next = node.next;
            node.next = tmp;
            node = node.next.next;

        }

    }

    public static void modifySibling(ListNode node){
        while (node != null){
            if (node.silbing != null){
                ListNode tmp = node.silbing;
                node.next.silbing = tmp.next;
            }
            node = node.next.next;
        }
    }

    public static ListNode split(ListNode node){
        // 当链表为空就直接返回空
        if (node == null) {
            return null;
        }

        // 用于记录复制链表的头结点
        ListNode newHead = node.next;
        // 用于记录当前处理的复制结点
        ListNode pointer = newHead;
        // 被复制结点的next指向下一个被复制结点
        node.next = newHead.next;
        // 指向新的被复制结点
        node = node.next;

        while (node != null) {
            // pointer指向复制结点
            pointer.next = node.next;
            pointer = pointer.next;
            // head的下一个指向复制结点的下一个结点，即原来链表的结点
            node.next = pointer.next;
            // head指向下一个原来链表上的结点
            node = pointer.next;
        }

        // 返回复制链表的头结点
        return newHead;

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static boolean isSame(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }

        return h1 == null && h2 == null;
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

        head.silbing = head.next.next;
        head.next.silbing = head.next.next.next.next.next;
        head.next.next.next.silbing = head.next;

        ListNode tmp = head;
        ListNode newHead = mulipClone(head);
        printList(newHead);


    }

}
