package lr9;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class example8 {  
    private Node head;
    private Scanner scanner;

    public example8() {
        this.head = null;
        this.scanner = new Scanner(System.in);
    }

    public void createHead() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент: ");
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }

    public void createTail() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        Node tail = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент: ");
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int index, int data) {
        if (index < 0) return;
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean removeFirst() {
        if (head == null) return false;
        head = head.next;
        return true;
    }

    public boolean removeLast() {
        if (head == null) return false;
        if (head.next == null) {
            head = null;
            return true;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || head == null) return false;
        if (index == 0) return removeFirst();
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) return false;
        current.next = current.next.next;
        return true;
    }

    public void createHeadRec() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        head = createHeadRecHelper(n);
    }

    private Node createHeadRecHelper(int n) {
        if (n <= 0) return null;
        System.out.print("Введите элемент: ");
        int data = scanner.nextInt();
        Node node = new Node(data);
        node.next = createHeadRecHelper(n - 1);
        return node;
    }

    public void createTailRec() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        head = createTailRecHelper(n);
    }

    private Node createTailRecHelper(int n) {
        if (n <= 0) return null;
        System.out.print("Введите элемент: ");
        int data = scanner.nextInt();
        Node node = new Node(data);
        if (n == 1) {
            return node;
        }
        node.next = createTailRecHelper(n - 1);
        return node;
    }

    public String toStringRec() {
        StringBuilder sb = new StringBuilder();
        toStringRecHelper(head, sb);
        return sb.toString();
    }

    private void toStringRecHelper(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.data);
        if (node.next != null) sb.append(" -> ");
        toStringRecHelper(node.next, sb);
    }

    public static void main(String[] args) {
        example8 list = new example8();
        int choice;

        do {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Ввод с головы (цикл)");
            System.out.println("2. Ввод с хвоста (цикл)");
            System.out.println("3. Ввод с головы (рекурсия)");
            System.out.println("4. Ввод с хвоста (рекурсия)");
            System.out.println("5. Вывод (цикл)");
            System.out.println("6. Вывод (рекурсия)");
            System.out.println("7. Добавить в начало");
            System.out.println("8. Добавить в конец");
            System.out.println("9. Вставить по индексу");
            System.out.println("10. Удалить первый");
            System.out.println("11. Удалить последний");
            System.out.println("12. Удалить по индексу");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            choice = list.scanner.nextInt();

            switch (choice) {
                case 1 -> { list.createHead(); System.out.println("Список создан с головы."); }
                case 2 -> { list.createTail(); System.out.println("Список создан с хвоста."); }
                case 3 -> { list.createHeadRec(); System.out.println("Список создан с головы (рекурсия)."); }
                case 4 -> { list.createTailRec(); System.out.println("Список создан с хвоста (рекурсия)."); }
                case 5 -> System.out.println("Список: " + list);
                case 6 -> System.out.println("Рекурсивный вывод: " + list.toStringRec());
                case 7 -> {
                    System.out.print("Введите значение: "); int d = list.scanner.nextInt();
                    list.addFirst(d); System.out.println("Добавлен в начало.");
                }
                case 8 -> {
                    System.out.print("Введите значение: "); int d = list.scanner.nextInt();
                    list.addLast(d); System.out.println("Добавлен в конец.");
                }
                case 9 -> {
                    System.out.print("Введите индекс: "); int i = list.scanner.nextInt();
                    System.out.print("Введите значение: "); int d = list.scanner.nextInt();
                    list.insert(i, d); System.out.println("Вставлен.");
                }
                case 10 -> System.out.println(list.removeFirst() ? "Первый удалён." : "Список пуст.");
                case 11 -> System.out.println(list.removeLast() ? "Последний удалён." : "Нечего удалять.");
                case 12 -> {
                    System.out.print("Введите индекс: "); int i = list.scanner.nextInt();
                    System.out.println(list.remove(i) ? "Элемент удалён." : "Ошибка удаления.");
                }
                case 0 -> System.out.println("Выход...");
                default -> System.out.println("Неверный выбор.");
            }
        } while (choice != 0);

        list.scanner.close();
    }
}
