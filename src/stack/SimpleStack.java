package stack;

import java.util.ArrayList;
import java.util.List;

public class SimpleStack {

}

class Stack{

    private final List<Node> list=new ArrayList<Node>();

    void push(Node n){
        list.add(n);
    }

    Node pop(){
        return list.remove(list.size()-1);
    }

    int size(){
        return list.size();
    }


    static class Node{
        int value;
        Node(int value){
            this.value = value;
        }
    }
}

class MyStack{
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(new Stack.Node(1));
        s.push(new Stack.Node(2));
        s.push(new Stack.Node(3));
        System.out.println("Stack size is "+s.size());
        System.out.println("Popping "+s.pop().value);
        System.out.println("Popping "+s.pop().value);
        System.out.println("Popping "+s.pop().value);
        System.out.println("Stack size is "+s.size());

    }
}


