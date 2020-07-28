package basic.queue;

public class Queue{
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
