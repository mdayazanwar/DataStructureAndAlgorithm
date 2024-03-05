package linkedlist.singlylinklist.Impl;

public class MainSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkList singlyLinkList = new SinglyLinkList();
        singlyLinkList.createLinkList(10);
        singlyLinkList.traversal();
        singlyLinkList.insert(20, 0);
        singlyLinkList.insert(30, 0);
        singlyLinkList.traversal();
        singlyLinkList.insert(40, 10);
        singlyLinkList.insert(50, 11);
        singlyLinkList.traversal();
        singlyLinkList.insert(25, 1);
        singlyLinkList.insert(15, 2);
        singlyLinkList.traversal();

        singlyLinkList.search(10);

        singlyLinkList.delete(0);
        singlyLinkList.delete(0);
        singlyLinkList.traversal();

        singlyLinkList.delete(4);
        singlyLinkList.delete(3);

        singlyLinkList.traversal();
        singlyLinkList.delete(1);

        singlyLinkList.traversal();

        singlyLinkList.deleteEntireList();
        singlyLinkList.traversal();

    }
}
