public class LinkedListApp {
    public static void main(String[] args) {
        MySinglyLinkedList list1 = new MySinglyLinkedList();
        for(int i = 0 ; i< 11 ; i++){
            list1.add(i);
        }
        list1.printNodes();
        System.out.println();
        System.out.println(list1.indexOf(4));
        System.out.println(list1.size);
        list1.deleteNode(1);
        list1.printNodes();
        System.out.println();
        System.out.println("kth item from last "+list1.getKthFromLast(4));
        list1.removeKthFromLast(1);
        list1.printNodes();
    }

}
