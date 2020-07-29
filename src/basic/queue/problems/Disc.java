package basic.queue.problems;


import java.io.*;
import java.util.*;





class Disc {
     static class Queue{
    private Node[] q;
    private int queueCapacity;
    private int front=0;
    private int rear;
    private boolean isEmpty = true;

    public Queue(int size){
        this.queueCapacity = size;
        q = new Node[size];
    }

    public Node[] getQueue(){
        return q;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void enqueue(Node n){
        isEmpty = false;
        if (rear == 0){
            q[0] = n;
            rear+=1;
        }else if (rear<queueCapacity){
            q[rear] = n;
            rear+=1;
        }else if(rear==q.length){
            System.out.println("Queue is full can not insert "+n.value);
        }

    }

    public boolean deQueue(){
        if(front<rear) {
            //System.out.println("removing "+q[front].value);
            for (int i = front; i < rear; i++) {
                q[i] = q[i+1];
            }
            rear-=1;
            //printQueue();
            //front+=1;
            return true;
        }
        isEmpty = true;
        System.out.println("Queue is empty");
        return false;
    }

    public int size() {
        return rear;
    }
    public int length() {
        return q.length;
    }

    public void printQueue() {
        for (int i=front;i<rear;i++){
            if (q[i]!=null)
                System.out.print(q[i].value  +" ");
        }
        System.out.println("");
    }

    public Node[] sortQueue() {
        Node temp;
        for (int i = front; i < rear; i++)
        {
            for (int j = i + 1; j < rear; j++) {
                if (q[i].value < q[j].value)
                {
                    temp = q[i];
                    q[i] = q[j];
                    q[j] = temp;
                }
            }
        }


        return q;
    }


    public static class Node {
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    @SuppressWarnings("unchecked")
    static ArrayList<Integer>[] Solve(int[] arr) {
        Queue arrPending = new Queue(N);
        ArrayList<Integer>[] output=new ArrayList[N];

        for (int i = 0; i <= arr.length-1; i++) {
            if(isLargeDiscFound(arr[i],Arrays.copyOfRange(arr,i+1,arr.length))) {
                //System.out.println("\n");
                arrPending.enqueue(new Queue.Node(arr[i]));
                arrPending.sortQueue();
                output[i] =  new ArrayList<Integer>();
            }
            else{
                output[i] =  new ArrayList<Integer>();
                output[i].add(arr[i]);
                int pendingAdded=0;
                //System.out.print(arr[i]);
                if(!(arrPending.isEmpty())) {
                    int queueSize = arrPending.size();
                    for (int j = 0; j < queueSize; j++) {
                        Queue.Node temp = arrPending.getQueue()[j];
                        if(!isLargeDiscFound(temp.value,Arrays.copyOfRange(arr,i+1,arr.length))) {
                            pendingAdded+=1;
                            output[i].add(temp.value);
                        }
                       // System.out.print(" " + temp.value);
                       // arrPending.deQueue();
                    }
                    for (int k = 0; k < pendingAdded; k++) {
                        arrPending.deQueue();
                    }
                }
            }
        }
        return output;

    }



    static Boolean isLargeDiscFound(int value,int[] arr){
        boolean isLargeFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>value){
                return true;
            }
        }
        return false;

    }
}
