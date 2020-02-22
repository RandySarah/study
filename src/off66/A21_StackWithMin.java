package off66;

import java.util.Stack;

/**
 * Q21:定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数，
 * 在该栈中，调用min push pop的时间复杂度都是O(1)
 *
 * A:使用辅助栈存放当前最小元素
 * 栈          辅助栈          最小元素
 * 3             3             3
 * 3，2          3，2           2
 * 3，2，1       3，2，1         1
 *
 *每次把最小元素压入辅助栈，能保证辅助栈的栈顶一直是最小元素
 *当数据栈的元素被弹出之后,最小元素也从辅助栈弹出
 *
 *
 */
public class A21_StackWithMin {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static int min(){
        return stack2.peek();
    }

    public static void push(int n){
        stack1.push(n);

        if(stack2.isEmpty() || n < stack2.peek()){
            stack2.push(n);
        }else {
            stack2.push(stack2.peek());
        }
    }

    public static void pop(){
        stack2.pop();
        stack1.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(1);
        push(2);
        System.out.println(min());
        push(3);
        push(0);
        System.out.println(min());
        System.out.println(stack1);
        System.out.println(stack2);

    }

}
