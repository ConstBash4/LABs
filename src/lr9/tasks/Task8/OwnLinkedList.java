package lr9.tasks.Task8;

public class OwnLinkedList {
    private Node head;

    public OwnLinkedList() {
        this.head = null;
    }

    // a) Методы с использованием цикла
    // Ввод с головы
    public void createHead(int[] data) {
        for (int i : data) {
            addFirst(i);
        }
    }

    // Ввод с хвоста
    public void createTail(int[] data) {
        for (int i : data) {
            addLast(i);
        }
    }

    // Вывод списка
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    // Добавление элемента в начало списка
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Добавление элемента в конец списка
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Вставка элемента в список с указанным номером
    public void insert(int data, int position) {
        if (position < 1) return;

        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) return;

        newNode.next = current.next;
        current.next = newNode;
    }

    // Удаление элемента с головы списка
    public void removeFirst() {
        if (head == null) return;
        head = head.next;
    }

    // Удаление последнего элемента списка
    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Удаление элемента из списка с указанным номером
    public void remove(int position) {
        if (position < 1 || head == null) return;

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) return;

        current.next = current.next.next;
    }

    // b) Методы с использованием рекурсии
    // Ввод с головы (рекурсия)
    public void createHeadRec(int[] array, int index) {
        if (index < 0) {
            return;
        }
        addFirst(array[index]);
        createHeadRec(array, index - 1);
    }

    // Ввод с хвоста (рекурсия)
    public void createTailRec(int[] array, int index) {
        if (index < 0) {
            return;
        }
        addLast(array[index]);
        createTailRec(array, index - 1);
    }

    // Вывод списка (рекурсия)
    private String toStringRec(Node current) {
        if (current == null) return "";
        return current.data + " " + toStringRec(current.next);
    }

    public String toStringRec() {
        return toStringRec(head);
    }
}
