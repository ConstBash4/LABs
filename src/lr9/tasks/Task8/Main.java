package lr9.tasks.Task8;

public class Main {
    public static void main(String[] args) {
        OwnLinkedList list = new OwnLinkedList();

        list.createHead(new int[] {3,2,1});
        System.out.println("Список после ввода с головы: " + list.toString());

        list.createTail(new int[] {4,5,6});
        System.out.println("Список после ввода с хвоста: " + list.toString());

        list.insert(9, 3);
        System.out.println("Список после вставки: " + list.toString());

        list.addFirst(0);
        System.out.println("Список после добавления в начало: " + list.toString());

        list.addLast(7);
        System.out.println("Список после добавления в конец: " + list.toString());

        list.removeFirst();
        System.out.println("Список после удаления первого элемента: " + list.toString());

        list.removeLast();
        System.out.println("Список после удаления последнего элемента: " + list.toString());

        list.remove(2);
        System.out.println("Список после удаления элемента на позиции 2: " + list.toString());

        list.createHeadRec(new int[] {9,8,7}, 2);
        System.out.println("Список после ввода с головы (рекурсия): " + list.toStringRec());

        list.createTailRec(new int[] {1,2,3}, 2);
        System.out.println("Список после ввода с хвоста (рекурсия): " + list.toStringRec());
    }
}
