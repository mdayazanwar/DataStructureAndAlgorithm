package tree.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    public void  preOrderTraversal(Node node) {
        if( node == null) {
            return;
        }
        System.out.print(node.value +" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void  postOrderTraversal(Node node) {
        if( node == null) {
            return;
        }

        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.print(node.value +" ");
    }

    public void  inOrderTraversal(Node node) {
        if( node == null) {
            return;
        }

        preOrderTraversal(node.left);
        System.out.print(node.value +" ");
        preOrderTraversal(node.right);

    }
    public void levelOrder() {
        if(root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }
    public void search(String value) {
        if( root == null) {
            System.out.println("Binary tree is empty");
            return;
        }
        Queue<Node>  queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node presentNode = queue.remove();
            if(presentNode.value.equals(value)) {
                System.out.println("Value "+ value+ " is found in the tree");
                return;
            }
            else {
                if(presentNode.left!= null) queue.add(presentNode.left);
                if(presentNode.right!= null) queue.add(presentNode.right);
            }
        }
        System.out.println("Value "+ value +" is not found in binary tree");
    }
    public void insert( String value) {
        Node newNode = new Node();
        newNode.value = value;
        if( root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node presentNode = queue.remove();
            if(presentNode.left == null) {
                presentNode.left = newNode;
                break;
            }
            else if(presentNode.right == null) {
                presentNode.right = newNode;
                break;
            }
            else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public void deleteDeepestNode() {
        if( root == null) {
            System.out.println("There is no element in binary tree");
            return;
        }
        if (root.left == null && root.right == null) {
            // Tree has only one node, so delete the root
            root = null;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node previpusNode ,presentNode=null;
        while(!queue.isEmpty()) {
            previpusNode = presentNode;
             presentNode = queue.remove();
            if(presentNode.left== null){
                // If the left child of present node is null, the right child of previous node becomes the deepest node
                previpusNode.right = null;
                return;
            }
            else if(presentNode.right== null) {
                // If the right child of present node is null, the left child of present node becomes the deepest node
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    public Node getDeepestNode() {

        if(root == null ) {
            System.out.println("Tree is empty");
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node presentNode = null;
        while(!queue.isEmpty()) {
             presentNode = queue.remove();
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    public void deleteNode(String value) {
        if(root == null) {
            System.out.println("Binary tree is empty");
            return;
        }
        Queue<Node>  queue = new LinkedList<>();
        queue.add(root);
        Node deepentNode =  getDeepestNode();
        while(!queue.isEmpty()) {
            Node presentNode =  queue.remove();
            if(presentNode.value.equals(value)) {
                presentNode.value = deepentNode.value;
                deleteDeepestNode();
                System.out.println("Node has been deleted");
                return;
            }
            else {
                if(presentNode.left != null) queue.add(presentNode.left);
                if(presentNode.right != null) queue.add(presentNode.right);
            }
        }
        System.out.println("Node doesn't exist in binary tree");
    }

    public void deleteBT() {
        root = null;
        System.out.println("Binary tree has been deleted");
    }
}
