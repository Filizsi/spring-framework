public class kthLargest {
    public static void main(String[] args) {
        int[] numbers={3,2,3,1,2,4,5,5,6};
        /*int[] numbers=new int[10];
        for (int i = 0; i < 10; i++) {
           numbers[i]=i;
        }*/

        System.out.println(getKthLargest(numbers, 4));
    }
    public static int getKthLargest(int[] array, int k){
        // create a Heap for the array and put numbers into the Heap
        MyHeap heap=new MyHeap(array.length);
        for (int i = 0; i < array.length ; i++) {
         heap.insert(array[i]);
        }
        for (int i = 0; i < k-1; i++) {
           heap.remove();
        }
        return heap.getRoot();
    }
}
