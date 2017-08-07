package ap.structures;

public class LinkedList {
    ListNode head;

    public void append(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);
    }

    public void prepend(int data) { //no special case.
        ListNode newHead = new ListNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) { //make special case when deleting head.
        if (head == null) {
            return;
        }
        if(head.data == data) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) { //if current.next == null, means it could be just head in list.or end of list
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    public void printList() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
