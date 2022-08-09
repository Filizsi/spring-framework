public class MyQuickSort {
  public static void qsort(int[]array, int start, int end){
      if(start>=end) return;// termination
      int boundary= partition(array, start, end);
      qsort(array, start, boundary-1);// left array
      qsort (array, boundary+1,end);// right array

  }
  public static int partition(int[]  array, int start, int end){
      int pivot=array[end];// pick up last as pivot
      int boundary=start; // set boundary to start
      for (int i = start; i <= end; i++) {
         if(array[i]<=pivot)  swap(array, i, boundary++);
      }
      return boundary-1;
  }
    public static void swap(int[] array, int idx1,int idx2){
        int temp=array[idx1];
        array[idx1]=array[idx2];
        array[idx2]= temp;
    }

}
