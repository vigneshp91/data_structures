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

    boolean isRootNode(Node node){
        return (node.right!=null || node.left!=null);
    }

    void performInOrderTraversal(Node root){
        //left root right
        if (isRootNode(root)){
            if(root.left!=null){
                performInOrderTraversal(root.left);
            }
            System.out.println(root.data);
            if(root.right!=null){
                performInOrderTraversal(root.right);
            }

        }else
            System.out.println(root.data);


    }

    void performPreOrderTraversal(Node root){
        //root left  right
        if (isRootNode(root)){
            System.out.println(root.data);
            if(root.left!=null){
                performPreOrderTraversal(root.left);
            }
            if(root.right!=null){
                performPreOrderTraversal(root.right);
            }

        }else
            System.out.println(root.data);


    }

    void performPostOrderTraversal(Node root){
        // left  right root
        if (isRootNode(root)){
            if(root.left!=null){
                performPostOrderTraversal(root.left);
            }
            if(root.right!=null){
                performPostOrderTraversal(root.right);
            }
            System.out.println(root.data);

        }else
            System.out.println(root.data);


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
        System.out.println("InOrderTraversal");
        tree.performInOrderTraversal(root);
        System.out.println("PreOrderTraversal");
        tree.performPreOrderTraversal(root);
        System.out.println("PostOrderTraversal");
        tree.performPostOrderTraversal(root);
    }

}
