package LinkList.SinglyLinkList.Impl;

public class SinglyLinkList {
    private Node head;
    private Node tail;
    int size = 0;
    public Node createLinkList(int value) {
        Node newnode =  new Node();
        newnode.value = value;
        newnode.next = null;
        head= newnode;
        tail = newnode;
        size++;
        return newnode;
    }

    /**
     * this function is responsible to insert element in the list at specified position
     */
    public Node insert(int value, int location) {
        if(location < 0) {
            return head;
        }
        Node newNode = new Node();
        newNode.value = value;
        if( head == null) {
            return createLinkList(value);
        }else if(location == 0)  { /* Insert Element from  front */
            newNode.next = head;
            head = newNode;
        }
        else if(location >= size) { // insert element from last in link list
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
        else { // insert element in the middle of the link list
            Node tempNode =  head;
            int position  = 0;
            while( position < location) {
                tempNode = tempNode.next;
                position++;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;

        }
        size ++;
        return head;
    }

    /**
     * This function is responsible to print entire list
     */
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

    /**
     * This function is resonsible to search element in the list
     */
    public  void search(int value) {
        Node temp = head;
        for( int i = 0; i < size; i++ ) {
            if( temp.value ==  value) {
                System.out.println("Element "+ value + " at position " + i);
                return;
            }
            else {
                temp = temp.next;
            }
        }
        System.out.println("Element "+ value +" not found in the list");
    }

    /**
     *  This function is responsible to delete element for specified position
     */
    public void delete( int position ){
        if( position < 0 || head == null) {  // position less tha n 0 is not a valid condition. null head means there is no  list exist
            return;
        }
        if(position == 0) { // Delete element from the first position
            System.out.println("Deleted Element from list is "+head.value);
            head =  head.next;
            size--;
        }
        else if(position >= size) { // Delete eleent from the last position
            Node temp  =  head;
            for( int i  = 0; i < size -1 ; i++) {
                temp = temp.next;
            }
            if( temp == head) { // If there is only one element remaining in the list
                System.out.println("Deleted element from the list is "+ temp.value);
                tail = head = null;
                size--;
                return;
            }
            System.out.println("Deleted Element from the list is "+ temp.next.value);
            temp.next = null;
            tail = temp;
            size--;
        }
        else { // delete element from te specified position
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            System.out.println("Deleted element form the list is " + temp.next.value );
            temp.next = temp.next.next;
            size--;
        }
    }

    /**
     * This function is responsible to delete entire list
     */
    public void deleteEntireList () {
        head = null;
        tail =  null;
        System.out.println(" Linked list has been deleted successfully");
    }
}
