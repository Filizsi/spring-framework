public class InsertionSort {
 public static int[] insertionSort(int[] array){
     for (int i = 1; i < array.length; i++) {
         int toBeInserted= array[i];// save current value in a variable called toBeInserted
         int j=i-1;// predecessor
         // this is where we do shifting operation
         while(j>=0 && array[j]>toBeInserted){
             // shift elements
             array[j+1]=array[j];
             j--;
         }
         array[j+1]=toBeInserted;// put toBeInserted in its place
     }
     return array;
 }
}