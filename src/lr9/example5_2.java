package lr9;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class example5_2 {
    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        int[] values = {1, 2, 3};
        for (int value : values) {
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                tail.next = new Node(value);
                tail = tail.next;
            }
        }
        System.out.print("Список (хвост): ");
        printList(head);
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
