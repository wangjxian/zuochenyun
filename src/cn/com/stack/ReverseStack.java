package cn.com.stack;

import java.util.Stack;

/**
 * 【题目】一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、 4、3、2、1。
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也 就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他 数据结构。
 */
public class ReverseStack extends StaskSout<Integer> {

    private final Stack<Integer> stack = new Stack<>();

    /**
     * 取出stack中栈底的元素并移除
     * @return
     */
    private Integer getAndRemoveLastStackItem(Stack<Integer> stack){
        if (stack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        Integer pop = stack.pop();
        if (stack.isEmpty()){
            return pop;
        }
        Integer lastStackItem = getAndRemoveLastStackItem(stack);
        stack.push(pop);
        return lastStackItem;
    }


    private void reverse(){
        reverse(this.stack);
    }


    private void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        Integer lastStackItem = getAndRemoveLastStackItem(stack);
        reverse(stack);
        stack.push(lastStackItem);
    }


    public static void main(String[] args) {
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.stack.push(1);
        reverseStack.stack.push(2);
        reverseStack.stack.push(3);
        reverseStack.stack.push(4);
        reverseStack.sout(reverseStack.stack);

        reverseStack.reverse();
        reverseStack.sout(reverseStack.stack);
    }


}
