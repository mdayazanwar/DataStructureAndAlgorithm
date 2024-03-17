package tree.binarytree;

public class BTMain {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert("Dharbendra");
        binaryTree.insert("Amitabh");
        binaryTree.insert("Sambha");
        binaryTree.insert("Basanti");
        binaryTree.insert("Shole");
        binaryTree.insert("Gabbar");
        binaryTree.insert("thakur");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println();
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.search("Shole");
        binaryTree.deleteNode("Gabbar");
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.deleteBT();
        binaryTree.levelOrder();

    }
}
