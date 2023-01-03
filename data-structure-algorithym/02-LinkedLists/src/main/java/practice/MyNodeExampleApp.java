package practice;

import iQ.Node;

public class MyNodeExampleApp {
    public static void main(String[] args) {
        MyNode nodeA = new MyNode("Node A");
        MyNode nodeB = new MyNode("Node B");
        MyNode nodeC = new MyNode("Node C");

        nodeA.next = nodeB;
        nodeB.next = nodeC;

        System.out.println(nodeA.name+nodeA.next.name+nodeB.next.name);

        MyNode current =nodeA;
        while(current!=null){
            System.out.println(current.name);
            current=current.next;
        }


    }
}
