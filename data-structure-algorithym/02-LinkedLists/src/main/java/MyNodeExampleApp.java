public class MyNodeExampleApp {
    public static void main(String[] args) {
        MyNode nodeA=new MyNode("Node A");
        MyNode nodeB=new MyNode("Node B");
        MyNode nodeC=new MyNode("Node C");
        nodeA.next=nodeB;
        nodeB.next=nodeC;

        System.out.println(nodeA.name+" " + nodeA.next.name+" " + nodeB.next.name);

        // iterate over the list I've created
        MyNode current=nodeA;
        while (current!=null){
            System.out.println(current.name);
            current=current.next;
        }
        //printing starts where u assign it
        System.out.println("=========================");
        current = nodeB;
        while (current!=null){
            System.out.println(current.name);
            current=current.next;
        }
        //print null
        System.out.println(current);
    }
}
