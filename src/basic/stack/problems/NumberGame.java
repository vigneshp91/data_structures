package basic.stack.problems;


import java.io.*;
import java.util.*;



public class NumberGame {
    static class Stack {
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

        Node getTop(){
            if(top>0)
                return list[top-1];
            else
                return null;
        }

        Node pop() {
            Node removedValue = null;
            // System.out.println(top);
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
        {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer> out_ = funGame(arr);
        System.out.print(out_.get(0));
        for(int i_out_=1; i_out_<out_.size(); i_out_++)
        {
            System.out.print(" " + out_.get(i_out_));
        }

        wr.close();
        br.close();
    }
    static ArrayList<Integer> funGame(int[] arr){
        Stack stack_a = new Stack(arr.length);
        Stack stack_b = new Stack(arr.length);
        for (int i = 0; i < arr.length; i++) {
            stack_b.push(new Stack.Node(arr[i]));
            stack_a.push(new Stack.Node(arr[arr.length-i-1]));
//            System.out.println("stack b"+stack_b.getTop().value);

        }
        ArrayList<Integer> out = new ArrayList<>();
        while (stack_a.size()>0 && stack_b.size()>0 ){
            System.out.println("stack a "+stack_a.getTop().value+" stack b "+stack_b.getTop().value);
            if(stack_a.getTop().value < stack_b.getTop().value) {
                out.add(2);
                //System.out.print("2 ");
                stack_a.pop();
            }
            else if(stack_a.getTop().value > stack_b.getTop().value) {
                out.add(1);
                //System.out.print("1 ");
                stack_b.pop();
            }
            else if(stack_a.getTop().value == stack_b.getTop().value) {
                out.add(0);
               // System.out.print("0 ");
                stack_a.pop();
                stack_b.pop();
            }
        }

        return out;

    }
}
