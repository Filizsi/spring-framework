public class HeapMainApp {
    public static void main(String[] args) {
        MyHeap heap=new MyHeap(5);
        heap.insert(61);
        heap.insert(120);
        heap.insert(52);
        heap.insert(45);
        heap.insert(83);
        heap.printHeap();
        System.out.println(heap.remove()+ " is Removed and size is  :"+ heap.size);;
        heap.printHeap();

    }
}
