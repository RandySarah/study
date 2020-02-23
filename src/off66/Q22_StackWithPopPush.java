package off66;

import java.util.Stack;

/**
 * Q22.栈的压入弹出序列
 *
 * 输入两个序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为栈的弹出顺序
 *
 * 如: 1 2 3 4 5 为该栈的压入顺序，
 * 则  4 5 3 2 1 为该栈的弹出顺序
 * 则  4 3 5 1 2 不是该栈的弹出序列
 *
 * A:建立一个辅助栈，将第一个序列的数字依次压入栈中，并按照第二个序列的顺序依次从该栈中弹出数字
 * 如果下一个弹出的数字是栈顶数字，则直接弹出，
 * 如果下一个弹出的数子不是栈顶数字，将压栈序列中还没有入栈的数字压入辅助栈，
 * 如果所有的数字都压入栈了，还没有找到弹出的数字，则该序列不可能为弹出序列
 */

public class Q22_StackWithPopPush {

    public static boolean isPopOrder(int[] push, int[] pop){

        Stack<Integer> stack = new Stack<>();

        int pushIndex = 0;
        int popIndex = 0;

        while (pushIndex < push.length){
            stack.push(push[pushIndex]);//入栈
            pushIndex++;

            while (!stack.isEmpty() && stack.peek() == pop[popIndex]){//出栈
                stack.pop();
                popIndex++;
            }
        }

        if(stack.isEmpty()){//辅助栈为空，说明出栈顺序正确
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));


    }



}
