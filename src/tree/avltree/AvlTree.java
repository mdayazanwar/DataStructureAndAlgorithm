package tree.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AvlTree {
    AvlNode root;

    AvlTree() {
        root = null;
    }

    public void postOrderTraversal(AvlNode node) {
        if( node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value + " ");
    }

    public void preOrderTraversal(AvlNode node) {
        if( node == null) {
            return;
        }
        System.out.println(node.value+ " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void inOrderTraversal(AvlNode  node) {
        if( node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value+" ");
        inOrderTraversal(node.right);
    }

    public void levelOrderTraversal() {
        if( root == null) {
            System.out.println("AVL Tree is empty");
            return;
        }
        Queue<AvlNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()) {
            AvlNode presentNode = queue.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println();
    }

    AvlNode search(AvlNode node, int value) {
        if (node == null ) {
            System.out.println("Value: "+ value+ " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: "+ value+ " found in AVL");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void insert(int value) {
        root =  insertNode(root, value);
    }

    private AvlNode insertNode(AvlNode node , int value) {
        if( node == null) {
            AvlNode newNode = new AvlNode();
            newNode.value = value;
            newNode.height  = 1;
            return newNode;
        }
        if(value < node.value) {
            node.left = insertNode(node.left, value);
        }
        else {
            node.right = insertNode(node.right, value) ;
        }
        node.height  = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance  =  getBalance(node);

        if( balance > 1 && value < node.left.value) { // LL condition
            return rotateRight(node);
        }
        if(balance > 1 && value > node.left.value) { // LR Condition
            node.left = rotateLeft(node);
            return rotateRight(node.left);
        }
        if(balance < -1 && value > node.right.value ) { // RR condition
            return rotateLeft(node);
        }
        if( balance < -1 && value < node.right.value) { // RL condition
            node.right = rotateRight(node.right);
            return rotateLeft(node.right);
        }
        return node;
    }

    public int getHeight(AvlNode node ) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    // rorate right

    private AvlNode rotateRight(AvlNode disBalanceNode) {
        AvlNode newRoot =  disBalanceNode.left;
        disBalanceNode.left = disBalanceNode.left.right;
        newRoot.right = disBalanceNode;
        disBalanceNode.height = 1 + Math.max(getHeight(disBalanceNode.left), getHeight(disBalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }
    //rotate left
    private AvlNode rotateLeft(AvlNode disBalanceNode) {
        AvlNode newRoot = disBalanceNode.right;
        disBalanceNode.right = disBalanceNode.right.left;
        newRoot.left = disBalanceNode;
        disBalanceNode.height = 1 + Math.max(getHeight(disBalanceNode.left), getHeight(disBalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //get Balance
    public int getBalance(AvlNode node) {
        if(node == null)  return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public void delete( int value ) {
        root =  deleteNode(root, value);
    }

    private AvlNode deleteNode(AvlNode node, int value) {
        if (node == null) {
            System.out.println("Not found");
            return node;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left != null && node.right != null) {
                AvlNode minNodeRight = minimumNode(node.right);
                node.value = minNodeRight.value;
                node.right = deleteNode(minNodeRight,value);
            }
            else if( node.left != null) {
                node = node.left;
            }
            else if ( node.right != null) {
                node = node.right;
            }
            else node = null;
        }
        int balance = getBalance(node);
        if( balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        if( balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node.left);
        }
        if(balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }
        if(balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node.left);
        }
        return node;
    }
    private AvlNode minimumNode(AvlNode node) {
        if( node.left == null) {
            return node;
        }
        return minimumNode(node.left);
    }
}