package basic.queue;

class Queue{
    private Node[] q;
    private int queueCapacity;
    private int front=0;
    private int rear;

    Queue(int size){
        this.queueCapacity = size;
        q = new Node[size];
    }

    void enqueue(Node n){
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

    boolean deQueue(){
        if(front<rear) {
            System.out.println("removing "+q[front].value);
            for (int i = front; i < rear; i++) {
                q[i] = q[i+1];
            }
            rear-=1;
            printQueue();
            //front+=1;
            return true;
        }
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


    static class Node {
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}
public class MyQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(new Queue.Node(1));
        queue.enqueue(new Queue.Node(2));
        queue.enqueue(new Queue.Node(3));
        queue.enqueue(new Queue.Node(4));
        queue.enqueue(new Queue.Node(5));


        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        queue.printQueue();
        System.out.println(queue.size());
        System.out.println(queue.length());


    }
}
