package ap.structures;

public class Stack {
    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    Node top;

    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public int peek() {
        int data = top.data;
        return data;
    }

    public void push(int data) {
        Node n = new Node(data);
        if (top == null) {
            top = n;
            return;
        }
        n.next = top;
        top = n;
    }

    public int pop() {
        Node n = top;
        top = top.next;
        return n.data;
    }

    public void printStack() {
        Node n = top;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}



