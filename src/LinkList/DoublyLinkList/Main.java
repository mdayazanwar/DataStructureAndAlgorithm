package LinkList.DoublyLinkList;

public class Main {
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

    }
}
