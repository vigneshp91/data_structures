package list;


class DLinkedList {
    Node head;
    Node tail;

    void addNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
            node.previous = last;
            tail = node;
        }
    }

    static class Node {
        Node(int val) {
            this.value = val;
        }

        int value = 0;
        Node next = null;
        Node previous = null;

    }
}

public class DoublyLinkedList {


    static void printNodes(DLinkedList.Node head) {
        do {
            System.out.println(head.value);
            head = head.next;
        } while (head != null);

    }

    static void printNodesReverse(DLinkedList.Node tail) {
        do {
            System.out.println(tail.value);
            tail = tail.previous;
        } while (tail != null);

    }

    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
        DLinkedList.Node n1 = new DLinkedList.Node(1);
        DLinkedList.Node n2 = new DLinkedList.Node(2);
        DLinkedList.Node n3 = new DLinkedList.Node(3);
        DLinkedList.Node n4 = new DLinkedList.Node(4);
        DLinkedList.Node n5 = new DLinkedList.Node(5);

        list.addNode(n1);
        list.addNode(n2);
        list.addNode(n3);
        list.addNode(n4);
        list.addNode(n5);


        printNodes(list.head);
        System.out.println("Printing in reverse");
        printNodesReverse(list.tail);

    }
}
