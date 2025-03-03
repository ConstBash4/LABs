package lr9.examples.Example6;

public class TEST {
    public static void main(String[] args) {
        //пример изменил:
        //несвязанные узлы создаются в цикле
        //в этом же цикле они связываются
        int n = 10;
        Node[] nodes = new Node[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new Node(i, null);
            if(i >= 1) {
                nodes[i-1].next = nodes[i];
            }
        }

        Node ref = nodes[0];
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
