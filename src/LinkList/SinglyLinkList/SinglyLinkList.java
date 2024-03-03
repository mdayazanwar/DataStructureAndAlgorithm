package LinkList.SinglyLinkList;

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

    public Node insert(int value, int location) {
        if( head == null) {
            return createLinkList(value);
        }else if(location == 0)  { /* Insert Element from  front */
            Node newNode = new Node();
            newNode.value = value;
            newNode.next = head;
            head = newNode;
        }
        else if(location >= size) { // insert element from last in link list
            Node newNode  = new Node();
            newNode.value =  value;
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
            Node newNode =  new Node();
            newNode.value =  value;
            newNode.next = tempNode.next;
            tempNode.next = newNode;

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
