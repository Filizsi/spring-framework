import java.util.Arrays;

public class SortingMainApp {
    public static void main(String[] args) {
        var myarray=new int[]{ 8, 2, 4, 1, 3,0,-1};


        MyQuickSort qSort= new MyQuickSort();
        MyQuickSort.qsort(myarray,0,myarray.length-1);
        System.out.println(Arrays.toString(myarray));

    }
}
