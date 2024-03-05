package linkedlist.circularsinglylinkedlist;

public class MainCircularSinglyLinkedList {
    public static void main(String[] args) {
        CircularLinkedListImpl circularLinkedList = new CircularLinkedListImpl();
        circularLinkedList.createCircularSinglyLinkedList(50);
        circularLinkedList.insert(40, 0);
        circularLinkedList.insert(30, 0);
        circularLinkedList.insert(20, 0);
        circularLinkedList.traversal();
        circularLinkedList.insert(60, 4);
        circularLinkedList.insert(70, 5);
        circularLinkedList.insert(80, 6);
        circularLinkedList.traversal();
        circularLinkedList.insert(55 ,3);
        circularLinkedList.traversal();
        circularLinkedList.insert(65 ,5);
        circularLinkedList.traversal();
        circularLinkedList.delete(0);
        circularLinkedList.delete(0);
        circularLinkedList.traversal();
        circularLinkedList.delete(6);
        circularLinkedList.delete(5);
        circularLinkedList.traversal();
        circularLinkedList.delete(2);
        circularLinkedList.traversal();
        circularLinkedList.search(60);
        circularLinkedList.deleteEntireList();
        circularLinkedList.traversal();

    }
}
