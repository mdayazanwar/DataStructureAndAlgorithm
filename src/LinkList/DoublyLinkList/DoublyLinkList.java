package LinkList.DoublyLinkList;

public class DoublyLinkList {
    Node head;
    Node tail;
    int size;

     public Node createDoublyLinkedList(int value) {
         Node newNode = new Node();
         newNode.value = value;
         newNode.prev = null;
         newNode.next = null;
         head = newNode;
         tail = newNode;
         size = 1;
         return head;
     }

     public Node insert( int value, int location) {
         if(location < 0) {
             return head;
         }
         if( head == null) {
             createDoublyLinkedList(value);
             return head;
         }
         Node newNode = new Node();
         newNode.value = value;

         if( location  == 0 ) {
             newNode.prev =  null;
             newNode.next = head;
             head.prev = newNode;
             head = newNode;
         }
         else if(location >size) {
             tail.next = newNode;
             newNode.prev = tail;
             newNode.next = null;
             tail = newNode;
         }
         else {
             Node temp = head;
             for( int i = 0;  i < location; i++) {
                 temp = temp.next;
             }
             newNode.next = temp.next;
             temp.next.prev = newNode;
             temp.next = newNode;
             newNode.prev = temp;
         }
         size ++;
         return head;
     }

    public void traversal () {
        if (head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.print("Element in the list are: ");
            Node temoNode  = head;
            while(temoNode.next != null) {
                System.out.print( temoNode.value+" -> ");
                temoNode=  temoNode.next;
            }
            System.out.println(temoNode.value);
        }
    }
}
