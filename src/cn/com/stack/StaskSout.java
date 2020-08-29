package cn.com.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public  abstract class StaskSout<T> {

    protected void sout(Stack<T> stack){
        System.out.println(stack.stream().map(Object::toString).collect(Collectors.joining(",")));
    }




}
