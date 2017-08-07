package ap.structures;

public class Queue {
    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    Node head;
    Node tail;

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public int peek() {
        return head.data;
    }

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }

    }

    public int remove() {
        int n = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return n;
    }

    public void printQueue() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

