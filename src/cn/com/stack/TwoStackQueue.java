package cn.com.stack;

import java.util.Stack;

/**
 * 【题目】编写一个类，用两个栈实现队列，支持队列的基本操作（add、 poll、peek）
 */
public class TwoStackQueue<T> {

    private final Stack<T> stack1 = new Stack<>();
    private final Stack<T> stack2 = new Stack<>();

    private void add(T item){
        stack1.push(item);
        stack2.clear();
        transfer(stack1,stack2);
    }

    private T peek(){
        return stack2.peek();
    }


    private void transfer(Stack<T> from,Stack<T> to){
        if (from.isEmpty()){
            throw new RuntimeException("from stack is empty");
        }
        if (!to.isEmpty()){
            throw new RuntimeException("to stack is not empty");
        }
        for (int i = from.size()-1; i>=0; i--){
            to.push(stack1.get(i));
        }
    }


    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.add(1);
        queue.add(2);


        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
