package linkedlist.doublylinklist;

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

    public void search(int value) {
         Node temp = head;
         for( int i = 0 ; i< size ; i++) {
            if( temp.value == value) {
                System.out.println("Element " + value+" found at position " + i );
                return;
            }
            else {
                temp = temp.next;
            }
        }
         System.out.println("Element not found in the list");
    }

    public void delete(int position) {
        if (head == null) {
            System.out.println("The DLL does not exist!");
            return;
        }

        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }

        if (size == 1) {
            // Deleting the only node in the list
            head = null;
            tail = null;
        } else if (position == 0) {
            // Deleting the first node
            head = head.next;
            head.prev = null;
        } else if (position == size - 1) {
            // Deleting the last node
            tail = tail.prev;
            tail.next = null;
        } else {
            // Deleting a node in the middle
            Node tempNode = head;
            for (int i = 0; i < position; i++) {
                tempNode = tempNode.next;
            }
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;
        }

        size--;
    }
    public void deleteEntireList() {
         head  = null;
         tail = null;
         System.out.println("List has been deleted successfully");
    }
}
