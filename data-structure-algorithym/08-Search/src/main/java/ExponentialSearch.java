public class ExponentialSearch {
    public static void main(String[] args) {
        int[] arr=new int[10];
        long start=System.currentTimeMillis();
        long end=System.currentTimeMillis();
        for (int i=0;i<10;i++) {
            arr[i]=i;
        }
        //System.out.println(ternarySearchRecursive(arr, 4, 0, arr.length-1));
        System.out.println(exponentialSearch(arr, 4));
    }
    public static int exponentialSearch(int[] array, int data){
        int bound=1;
        // find proper search window
        while(bound<array.length && array[bound]<data) bound*=2;
        int left=bound/2;
        int right = Math.min(bound, array.length-1);
        // now call binary search for this window (left ,right)
        return BinarySearch.binarySearchRecursive(array, data, left, right);
    }
}
