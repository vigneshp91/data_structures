package basic.bst;

class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }

    }

    Node createNode(Node node,int data){
        if(node == null){
            node =  new Node(data);
        }else{
            if(data<node.data){
                node.left =  createNode(node.left,data);
            }else if(data>node.data){
                node.right =  createNode(node.right,data);
            }
        }
        return node;
    }
}
public class SimpleBST {
    public static void main(String[] args) {
        BST tree = new BST();
        BST.Node root = null;
        root = tree.createNode(root,8);
        root = tree.createNode(root,5);
        root = tree.createNode(root,10);
        root = tree.createNode(root,4);
        root = tree.createNode(root,6);
    }

}
