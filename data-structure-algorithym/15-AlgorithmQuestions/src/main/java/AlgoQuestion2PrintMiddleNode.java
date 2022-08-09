public class AlgoQuestion2PrintMiddleNode {
    public static void main(String[] args) {
    MySinglyLinkedList sll=new MySinglyLinkedList();
        for (int i = 1; i < 11; i++) {
            sll.add(i);
        }
        sll.printNodes();
        System.out.println();
        printMiddle(sll);
    }
    public static void printMiddle(MySinglyLinkedList sll){
        if(sll.isEmpty()) throw new IllegalArgumentException();
        var sJump=sll.head;
        var dJump=sll.head;
        while(dJump!=sll.tail && dJump.next!=sll.tail){
            sJump=sJump.next;
            dJump=dJump.next.next;
        }
        if(dJump== sll.tail) System.out.println(sJump.value);
        else System.out.println(sJump.value + "," + sJump.next.value);
    }
}
