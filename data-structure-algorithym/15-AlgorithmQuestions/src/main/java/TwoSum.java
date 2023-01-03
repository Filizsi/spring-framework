import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {

        int[] myArray = new int[]{1, 4, 6, 7, 2};
//        System.out.println(twoSum(myArray,9));

//        System.out.println(Arrays.toString(twoSum1(myArray,10)));
//        System.out.println(Arrays.toString(twoSum2(myArray, 10)));
        System.out.println(twoSum3(myArray, 9));


    }
    //brute force solution n*n

    //    public static int[] twoSum1(int [] array, int target){
//
//        for(int i=0 ;i<array.length-1;i++){
//            for(int j = i+1 ;j<array.length;j++){
//                if(array[i]+array[j]==target){
//                    return new int[] {i,j};
//                }
//            }
//        }
//        return new int[]{};
//    }
//
//    //optimal solution with hashmap O(n)
    public static int[] twoSum2(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int potemtial = target - array[i];

            if (map.containsKey(potemtial)) {
                return new int[]{i, map.get(potemtial)};
            } else
                map.put(array[i], i);
        }
        return new int[]{};
    }

//    public static int[] twoSum(int [] arr,int target) {
//
//        Map<Integer,Integer> result= new HashMap<>();
//
//        for(int i=0 ;i< arr.length;i++){
//            if(result.containsKey(target-arr[i])) {
//                return new int[]{i, result.get(target - arr[i])};
//            }else{
//                result.put(arr[i],i);
//            }
//        }
//        return new int []{};
//
//
//    }

    public static int[] twoSum3(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < target)
                i++;
            else if (sum > target)
                j--;
            else
                return new int[]{i, j};

        }

        return new int[]{};
    }


    public static int[] twosum_1(int[] array, int target) {
        Arrays.sort(array);
        int p1 = 0;
        int p2 = array.length - 1;


        while (p1 < p2) {
            int sum = array[p1] + array[p2];
            if (sum < target) {
                p1++;
            } else if (sum > target) {
                p2--;
            } else {
                return new int[]{p1, p2};
            }

        }
        return new int[]{};
    }

    public static int[] twosum_2(int[] array, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){
            int potential = target-array[i];
            if(map.containsKey(potential)){
                return new int[] {i,map.get(potential)};

            }else{
                map.put(array[i],i);
            }



    }
        return new int[] {};
}







































}


