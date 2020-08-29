package cn.com.stack;

import java.util.Stack;

/**
 * 【题目】一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小 的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 */
public class SortStackByStack extends StaskSout<Integer>{

    private final Stack<Integer> stack = new Stack<>();

    private void sort(Stack<Integer> stack){
        isEmpty(stack);

        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()){
            //取出stack的栈顶 pop
            Integer pop = stack.pop();
            //如果pop比help的的栈顶peek小
            while (!help.isEmpty() && help.peek() > pop){
                //则把peek压入stack中
                stack.push(help.pop());
            }
            //pop比peek大的压入help
            help.push(pop);
        }

        //重新压入stack
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    private void sort(){
        sort(this.stack);
    }

    public static void main(String[] args) {
        SortStackByStack sortStackByStack = new SortStackByStack();
        sortStackByStack.stack.push(5);
        sortStackByStack.stack.push(3);
        sortStackByStack.stack.push(4);
        sortStackByStack.stack.push(1);
        sortStackByStack.stack.push(2);

        sortStackByStack.sort();
        sortStackByStack.sout(sortStackByStack.stack);
    }
}
