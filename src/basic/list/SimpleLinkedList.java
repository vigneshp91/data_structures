package basic.list;

public class SimpleLinkedList {

    public static void main(String[] args) {
        MyList list = new MyList();
        MyList.Node n1 = new MyList.Node(1);
        MyList.Node n2 = new MyList.Node(2);
        MyList.Node n3 = new MyList.Node(3);

        list.addNode(n1);
        list.addNode(n2);
        list.addNode(n3);
        printNodes(list.head);

    }

    static void printNodes(MyList.Node head){
        do{
            System.out.println(head.value);
            head = head.next;
        }while (head!=null);

    }


}
 class MyList {
    Node head = null;

     void  addNode(Node node){
        if (head == null){
            head = node;
        }else{
            Node last = head;
            while (last.next!=null){
                last = last.next;
            }
            last.next = node;
        }

    }
     static class Node {
        Node(int val) {
            this.value = val;
        }

        int value = 0;
        Node next = null;

    }
}


