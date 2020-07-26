package list;

public class SimpleList {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        printNodes(n1);

    }

    static void printNodes(Node head){
        do{
            System.out.println(head.value);
            head = head.next;
        }while (head!=null);



    }
}

class Node{
    Node(int val){
        this.value =val;
    }
    int value = 0;
    Node next = null;

}
