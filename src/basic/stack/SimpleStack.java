package basic.stack;

class Stack {
    int stackSize;
    int top = 0;
    private  Node[] list;

    Stack(int size) {
        this.stackSize = size;
        list = new Node[this.stackSize];
    }


    void push(Node n) {
        if(top<list.length) {
            list[top] = n;
            top += 1;
        }else{
            System.out.println("Stack is full cannot insert "+n.value);
        }

    }

    Node pop() {
        Node removedValue = null;
        System.out.println(top);
        if(top>0){
            removedValue =  list[top-1];
            top-=1;
        }else{
            System.out.println("No elements to pop basic.stack is empty");
        }

        return removedValue;
    }

    int cap() {
        return list.length;
    }
    int size() {
        return top;
    }


    static class Node {
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}

class MyStack {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        System.out.println("Stack capacity is " + s.cap());

        s.push(new Stack.Node(1));
        s.push(new Stack.Node(2));
        s.push(new Stack.Node(3));
        s.push(new Stack.Node(4));
        s.push(new Stack.Node(5));
        s.push(new Stack.Node(6));
        System.out.println("Stack size is " + s.size());

        System.out.println("Popping " + s.pop().value);
        System.out.println("Popping " + s.pop().value);
        System.out.println("Popping " + s.pop().value);
        System.out.println("Popping " + s.pop().value);
        System.out.println("Stack size is " + s.size());


    }
}


