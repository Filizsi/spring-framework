public class RemoveNNodesAfterM {
    public static void main(String[] args) {
        MySinglyLinkedList list=new MySinglyLinkedList();

        for(int i=0;i<10;i++) list.add(i);
        list.printNodes();
        System.out.println("Remove N Nodes after M Nodes");

        list.printNodes();
    }

    public Node deleteNAfterMNodes(Node head, int m, int n) {
        Node current = head;
        Node lastMNode = head;
        while (current != null) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // jump m nodes
            while (current != null && mCount != 0) {
                lastMNode = current;
                current = current.next;
                mCount--;
            }
            // jump n nodes to remove
            while (current != null && nCount != 0) {
                current = current.next;
                nCount--;
            }
            // delete n nodes
            lastMNode.next = current;
        }//end while
        return head;
    }// end method
}
