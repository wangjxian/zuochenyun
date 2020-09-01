package cn.com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public  abstract class StaskSout<T> {

    protected void sout(Stack<T> stack){
        System.out.println(stack.stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    protected void isEmpty(Stack<T> stack){
        if (stack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
    }


    private static class Node{
       private int code;
       private String name;

        public Node(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "code=" + code +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1,"node1"));
        nodes.add(new Node(2,"node2"));
        nodes.add(new Node(3,"node3"));
        nodes.add(new Node(3,"node4"));
        nodes.add(new Node(4,"node5"));
        nodes.add(new Node(5,"node6"));

        Map<Integer, List<Node>> map1 = nodes.stream().collect(Collectors.groupingBy(Node::getCode));
        soutNodeMap(map1);

        Map<Integer, List<Node>> map2 = nodes.stream().collect(Collectors.groupingBy(Node::getCode, Collectors.mapping(obj -> obj, Collectors.toList())));
        soutNodeMap(map2);
    }

    private static void soutNodeMap(Map<Integer, List<Node>> map) {
        String collect = map.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue().stream().map(Node::toString).collect(Collectors.joining(";","[","]"))).collect(Collectors.joining(","));
        System.out.println(collect);
    }


}
