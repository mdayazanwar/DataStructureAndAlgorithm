package LinkList.DoublyLinkList;

public class MainDoublyLinkList {
    public static void main(String[] args) {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        doublyLinkList.createDoublyLinkedList(30);
        doublyLinkList.traversal();
        doublyLinkList.insert(20, 0);
        doublyLinkList.insert(10, 0);
        doublyLinkList.traversal();
        doublyLinkList.insert(40, 10);
        doublyLinkList.insert(50, 11);
        doublyLinkList.traversal();
        doublyLinkList.insert(25, 1);
        doublyLinkList.insert(35, 3);
        doublyLinkList.traversal();
        doublyLinkList.search(50);
        doublyLinkList.search(100);

        doublyLinkList.delete(0);
        doublyLinkList.traversal();
        doublyLinkList.delete(5);
        doublyLinkList.traversal();
        doublyLinkList.delete(2);
        doublyLinkList.traversal();
        doublyLinkList.deleteEntireList();
        doublyLinkList.traversal();
    }
}
