package tree.avltree;

public class AVLMain {
    public static void main (String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(20);
        avlTree.levelOrderTraversal();
        avlTree.delete(20);
        System.out.println();
        avlTree.levelOrderTraversal();
    }
}
