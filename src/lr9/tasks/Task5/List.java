package lr9.tasks.Task5;

public class List {
    private Node head;
    //добавление элементов с "головы"
    public void createByHead(int[] data) {
        Node current = null;
        for (int i = 0; i < data.length; i++) {
            if(i == 0) {
                head = new Node(data[i], null);
                current = head;
            } else {
                Node node = new Node(data[i], null);
                current.next = node;
                current = node;
            }
        }
    }
    //добавление элементов с "хвоста"
    public void createByTail(int[] data) {
        for (int i = (data.length-1); i >= 0; i--) {
            head = new Node(data[i], head);
        }
    }

    public void outputList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }
}
