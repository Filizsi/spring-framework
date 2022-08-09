package linkedList;

public class Runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(12);
        list.insert(23);
        list.insertAtStart(1000);
        list.insertAt(1,133);
        list.deleteAt(0);
        list.print();
    }
}
