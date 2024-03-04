package LinkList.SinglyLinkList.Impl;

public class Main {
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


    }
}
