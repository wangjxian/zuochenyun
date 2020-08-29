package cn.com.stack;


import java.util.Stack;

/**
 * 【题目】实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回 栈中最小元素的操作。
 * 【要求】
 *   1.pop、push、getMin操作的时间复杂度都是O(1)。
 *   2．设计的栈类型可以使用现成的栈结构。
 */
public class GetMinStack {


    private final Stack<Integer> stackData = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    private Integer pop(){
        if (stackData.isEmpty()){
            return null;
        }
        Integer pop = stackData.pop();
        int index = minStack.indexOf(pop);
        if (index != -1){
            minStack.removeElementAt(index);
        }
        return pop;
    }

    private void push(Integer item){
        stackData.push(item);
        if (minStack.isEmpty() || minStack.peek() >= item){
            minStack.push(item);
        }
    }

    private Integer getMin(){
        if (minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }


    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        Integer pop = stack.pop();
        System.out.println(pop);
        stack.push(4);
        System.out.println(stack.getMin());
    }

}
