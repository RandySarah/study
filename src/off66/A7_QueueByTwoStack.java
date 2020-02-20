package off66;

import java.util.Stack;

/**
 * Q7:用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 *
 * A:用两个先进后出的栈实现一个先进先出的队列
 * 1、定义两个栈，s1和s2
 * 2、插入数据直接入栈s1
 * 3、删除数据，先判断s2，有值直接从栈顶pop，无值的话将s1的数据装入到s2中在从栈顶pop
 *
 */
public class A7_QueueByTwoStack {

    private static Stack stack1 = new Stack();
    private static Stack stack2 = new Stack();

    public static void appendTail(int n){
        stack1.push(n);
    }

    public static void deleteHead(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if(stack2.isEmpty()){
            throw new RuntimeException("stack2 is null");
        }

        stack2.pop();
    }

    public static void main(String[] args) {
        A7_QueueByTwoStack.appendTail(1);
        A7_QueueByTwoStack.appendTail(2);
        A7_QueueByTwoStack.appendTail(3);
        A7_QueueByTwoStack.appendTail(4);
        A7_QueueByTwoStack.appendTail(5);

        A7_QueueByTwoStack.deleteHead();
        A7_QueueByTwoStack.deleteHead();

    }



}
