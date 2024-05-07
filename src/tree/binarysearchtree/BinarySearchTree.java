package tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BSTNode root;
    BinarySearchTree() {
        root = null;
    }

    public void  preOrderTraversal(BSTNode node) {
        if( node == null) {
            return;
        }
        System.out.print(node.value +" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void  postOrderTraversal(BSTNode node) {
        if( node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value +" ");
    }

    public void  inOrderTraversal(BSTNode node) {
        if( node == null) {
            return;
        }

        preOrderTraversal(node.left);
        System.out.print(node.value +" ");
        preOrderTraversal(node.right);

    }
    public void levelOrderTraversal() {
        if(root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }
    public void insert(int value) {
        insert(root, value);
    }
    public BSTNode insert(BSTNode root, int value) {
        if(root == null) {
            root = new BSTNode();
            root.value = value;
            return  root;
        }
        if(value<= root.value) {
            root.left = insert(root.left, value);
        }
        else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void delete( int value) {
        delete(root, value);
    }
    public  BSTNode delete(BSTNode root, int value) {
        if( root == null) {
            System.out.println("Binary search tree is empty.");
            return null;
        }
        if(value < root.value) {
            root.left = delete(root.left, value);
        }
        else if(value > root.value) {
            root.right = delete(root.right, value);
        }
        else {

            if(root.left != null && root.right != null) {
                BSTNode tempNode = root;
                BSTNode minimumNodeRight = minimumNode(tempNode.right);
                root.value = minimumNodeRight.value;
                root.right = delete(root.right, minimumNodeRight.value);
            } else if (root.left!= null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    private BSTNode minimumNode(BSTNode right) {
        if(root.left == null) {
             return  root;
        }
        else return  minimumNode(root.left);
    }
}
