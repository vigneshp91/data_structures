package basic.stack.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Brackets  {

    static class Stack {
        int stackSize;
        int top = 0;
        private  Stack.Node[] list;

        Stack(int size) {
            this.stackSize = size;
            list = new Stack.Node[this.stackSize];
        }


        void push(Stack.Node n) {
            if(top<list.length) {
                list[top] = n;
                top += 1;
            }else{
                System.out.println("Stack is full cannot insert "+n.value);
            }

        }

        Stack.Node getTop(){
            if(top>0)
                return list[top-1];
            else
                return null;
        }

        Stack.Node pop() {
            Stack.Node removedValue = null;
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
            String value;

            Node(String value) {
                this.value = value;
            }
        }
    }


    public static void main(String[] args) {
          /* Sample code to perform I/O:
         * Use either of these methods for input*/

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCountInput = null;                // Reading input from STDIN
        try {
            testCountInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hi, " + testCountInput + ".");    // Writing output to STDOUT
        int testCount = Integer.parseInt(testCountInput);

        for (int i = 0; i < testCount; i++) {
            try {
                String input = br.readLine();
                String[] inputarr = input.trim().split("");
                System.out.println(inputarr);
                processBrackets(inputarr);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Scanner
//        Scanner s = new Scanner(System.in);
//        String name = s.nextLine();                 // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT


    }

    private static void processBrackets(String[] inputarr) {
        Stack s = new Stack(inputarr.length);
        for (int i = 0; i < inputarr.length; i++) {
            if(Objects.equals(inputarr[i], "{") || Objects.equals(inputarr[i], "(") || Objects.equals(inputarr[i], "[")){
                s.push(new Stack.Node(inputarr[i]));
            }else if(Objects.equals(inputarr[i], "}") && Objects.equals(s.getTop().value, "{"))
                s.pop();
            else if(Objects.equals(inputarr[i], ")") && Objects.equals(s.getTop().value, "("))
                s.pop();
            else if(Objects.equals(inputarr[i], "]") && Objects.equals(s.getTop().value, "["))
                s.pop();


        }

        if(s.size() == 0){
            System.out.println("YES");
        }
        else
            System.out.println("No");
    }
}
