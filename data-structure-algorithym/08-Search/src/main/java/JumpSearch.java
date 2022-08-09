public class JumpSearch {
    public static void main(String[] args) {
        int[] arr=new int[10];
        for (int i=0;i<10;i++) {
            arr[i]=i;
        }
        //System.out.println(ternarySearchRecursive(arr, 4, 0, arr.length-1));
        System.out.println(jumpSearch(arr, 4));
    }
    public static int jumpSearch(int[] array, int data){
            int blockSize=(int) Math.sqrt(array.length);
            int start=0;
            int next=blockSize;
            // make jumps in this while loop
        while(start<array.length && array[next-1]<data) {
            start=next;
            next+=blockSize;
            if (next> array.length) next=array.length;
        }
        // now I have found block I will make a linear search
        for(int i=start; i<next;i++) {if (array[i]==data) return i; }
     return -1;
    }
}
