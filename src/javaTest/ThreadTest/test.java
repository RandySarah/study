package javaTest.ThreadTest;

import java.util.List;
import java.util.Map;

public class test {

    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode find(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public void funcTest(List<Object> list1, List<Object> list2, List<Object> list3, List<Object> list4){


        for(int i = 0; i<list2.size(); i++){
            if(list2.get(i) instanceof String){
                list4.add(list2.get(i));
            }else{
                list2.remove(i); //并发修改会抛出异常
            }
        }
        Object tempo = new Object();//list只添加了一个 只有一个new
        for(int i = 0; i<list1.size();i++){
            if(list1.get(i) instanceof Map){
                for(int j = 0; j<list2.size(); j++){
                    tempo = ((Map) list1.get(i)).get(list2.get(j)); //npe
                    list3.add(tempo); //内部数据不统一，使用的时候会存在问题
                }
            }
        }
        list3.addAll(list4);
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        head1.value = 1;

        ListNode head2 = new ListNode();
        head2.value = 2;

        head1.next = head2;

        ListNode head3 = new ListNode();
        head3.value = 3;

        head2.next = head3;

        ListNode head4 = new ListNode();
        head4.value = 4;

        head3.next = head4;

        ListNode head5 = new ListNode();
        head5.value = 5;

        head4.next = head5;

        System.out.println(find(head1).value);

        String str = "111";
        str.toCharArray();




    }
}
