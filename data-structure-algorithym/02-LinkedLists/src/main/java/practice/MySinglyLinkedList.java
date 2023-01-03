package practice;

import java.util.List;

public class MySinglyLinkedList {
    Node head;
    Node tail;
    int size;

    public MySinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void add(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    void PrintNodes() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
        }

    }

    ;

    void DeleteNode(int value) {
        Node current = head;
        Node prev = head;
        if (isEmpty()) throw new NullPointerException();
        while (current != null) {
            if (current.value == value) {
                //1
                if (current == head) {
                    head = current.next;
                    current.next = null;
                } else if (current == tail) {
                    tail = prev;
                    prev.next = null;
                } else {
                    prev.next = current.next;
                    current.next = null;
                }


            }
            size--;
        }
        prev = current;
        current = current.next;


    }


    int indexOf(int value) {
        int position = 0;
        if (isEmpty()) return -1;
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return position;
            } else {
                current = current.next;
                position++;
            }
        }
        return -1;
    }

    public int findKthItem(int kth) {
        Node p1 = head;
        Node p2 = head;

        //iterate kth times
        for (int i = 0; i < kth - 1; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.value;

    }

    public void removeKthItem(int kth) {
        Node prev = null;
        Node p1 = head;
        Node p2 = head;

        //iterate kth times
        for (int i = 0; i < kth - 1; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == head) {
            head = p1.next;
            p1.next = null;

        } else {
            prev.next = p1.next;
            p1.next = null;
        }

    }

    public void removeDuplicate() {
        Node current = head;

        while (current != null) {
            Node p2 = current.next;
            if (p2.next != null && current.value == p2.value) {
                p2 = p2.next;
            }
            current.next = p2;
            current = p2;
        }
    }

    public void reverse() {
        Node current = head.next;
        Node prev = head;
        while (current != null) {
            Node nextN = current.next;
            current.next = prev;
            prev = current;
            current = nextN;
        }
        tail = head;
        tail.next = null;
        head = prev;
    }

    public void removeNthNodeFromList(int num) {
        Node prev=null;
        Node p1=head ,p2=head;


        for(int i=0;i<num-1;i++){
            p2=p2.next;
        }
        while(p2.next!=null){
            prev=p1;
            p1=p1.next;
            p2=p2.next;

            if(p1==head){
                head=p1.next;
                p1.next=null;
            }else{
                prev.next=p1.next;
                p1.next=null;
            }
        }



    }

    public Node removeLast(){
        Node temp = head;
        Node prev = head;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        tail=prev;
        tail.next=null;
        return temp;

    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            head=newNode;
            tail=newNode;

        }else{
            newNode.next=head;
            head=newNode;
        }
        size++;

    }

    public Node removeFirst(){
        if(isEmpty()) return null;
        Node temp =head;
        Node after = head.next;
        head.next=null;
        head=temp;
        size--;
        if(size==0)
            tail=null;
        return temp;
    }

    public Node get(int index){
        if(index<0 || index>=size){
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public boolean set(int index, int value) {
        Node newNode = new Node(value);
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            temp = newNode;
            return true;

        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index<0 || index==size) return false;
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
        return true;

    }

    }
