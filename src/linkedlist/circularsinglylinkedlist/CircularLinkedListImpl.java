package linkedlist.circularsinglylinkedlist;

public class CircularLinkedListImpl {

    Node head;
    Node tail;
     int size;

     public void createCircularSinglyLinkedList(int value) {
         Node node  = new Node();
         node.value = value;
         node.next = node;
         head = node;
         tail = node;
         size  = 1 ;
     }

     public void insert(int value, int position) {
         if( head == null) {
             createCircularSinglyLinkedList(value);
             return;
         }
         if( position < 0) {
             System.out.println("In valid position");
             return;
         }
         Node newNode = new Node();
         newNode.value = value;
         if( position == 0) {
             newNode.next = head;
             tail.next = newNode;
             head = newNode;
         }
         else if( position >= size) {
             Node temp = head;
             for(int i  = 0; i< size-1;i++) {
                 temp = temp.next;
             }
             temp.next = newNode;
             newNode.next = head;
             tail =  newNode;
         }
         else {
             Node temp = head;
             for( int i  =0 ; i < position ;i++) {
                 temp = temp.next;
             }
             newNode.next = temp.next;
             temp.next = newNode;
         }
         size ++;
     }

    public void traversal () {
        if (head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.print("Element in the list are: ");
            Node temoNode  = head;
            while(temoNode.next != head) {
                System.out.print( temoNode.value+" -> ");
                temoNode=  temoNode.next;
            }
            System.out.println(temoNode.value);
        }
    }
}
