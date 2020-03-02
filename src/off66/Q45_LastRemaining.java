package off66;

import java.util.LinkedList;
import java.util.List;

/**
 * Q45.约瑟夫环问题：将n个数字排成一个圈，从数字0开始每次删除圆圈里的第m个数字，求出这个圆圈里剩下的最后一个数字
 * A45:创建一个总共有n个结点的环形链表，然后每次在这个链表中删除第m个结点
 */
public class Q45_LastRemaining {

    public static int lastRemining(int n,int m){
        if(n < 1 || m < 1){
            return -1;
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++){
            list.add(i);
        }

        int idx = 0;
        int start = 0;

        while (list.size() > 1){
            for (int i = 1; i < m; i++){
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemining(5, 3)); // 最后余下3
    }

}
