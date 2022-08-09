public class PerformanceForSearchAlgorithms {
    public static void main(String[] args) {
        int[] data = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            data[i] = i;
        }
        long[] linearSearchResults = linearSearch(333333, data);
        System.out.println("Linear Search Results:  " + linearSearchResults[0] + " miliseconds and " + linearSearchResults[1] + " comparisons..");
        long[] binarySearchResults = binarySearchIterative(data, 333333);
        System.out.println("Binary Search Results:  " + binarySearchResults[0] + " miliseconds and " + binarySearchResults[1] + " comparisons..");
        long[] ternarySearchResults = ternarySearchIterative(data, 333333);
        System.out.println("Ternary Search Results:  " + ternarySearchResults[0] + " miliseconds and " + ternarySearchResults[1] + " comparisons..");
        long[] jumpSearchResults = jumpSearch(data, 333333);
        System.out.println("Jump Search Results:  " + jumpSearchResults[0] + " miliseconds and " + jumpSearchResults[1] + " comparisons..");
    }

    public static long[] linearSearch(int value, int[] array) {
        long[] result = new long[2];
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            if (array[i] == value) {
                result[1] = i;
                result[0] = (System.currentTimeMillis() - startTime);
                return result;
            }
        }
        return new long[2];
    }

    public static long[] binarySearchIterative(int[] array, int data) {
        long[] result = new long[2];
        long startTime = System.currentTimeMillis();
        int comparisons = 0;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            comparisons++;
            if (array[middle] == data) {
                result[0] = System.currentTimeMillis() - startTime;
                result[1] = comparisons;
                return result;
            }
            comparisons++;
            if (data < array[middle]) right = middle - 1;
            else left = middle + 1;
        }
        return new long[2];
    }

    public static long[] ternarySearchIterative(int[] array, int data) {
        long[] result = new long[2];
        long startTime = System.currentTimeMillis();
        int comparisons = 0;

        int left = 0;
        int right = array.length - 1;

        while (right >= left) {
            int partition = (right - left) / 3;
            int middle1 = left + partition;
            int middle2 = right - partition;
            comparisons++;
            if (array[middle1] == data) {
                result[0] = System.currentTimeMillis() - startTime;
                result[1] = comparisons;
                return result;
            }
            comparisons++;
            if (array[middle2] == data) {
                result[0] = System.currentTimeMillis() - startTime;
                result[1] = comparisons;
                return result;
            }
            comparisons++;
            if (data < array[middle1]) right = middle1 - 1;
            else if (data > array[middle2]) {
                left = middle2 + 1;
                comparisons++;
            } else {
                left = middle1 + 1;
                right = middle2 - 1;
            }
        }
        return new long[2];
    }

    public static long[] jumpSearch(int[] array, int data) {
        long[] result = new long[2];
        long startTime = System.currentTimeMillis();
        int comparisons = 0;

        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;
        // make jumps in this while loop
        while (start < array.length && array[next - 1] < data) {
            start = next;
            next += blockSize;
            comparisons++;
            if (next > array.length) next = array.length;
        }
        // now I have found block I will make a linear search
        for (int i = start; i < next; i++) {
            comparisons++;
            if (array[i] == data) {
                result[0] = System.currentTimeMillis() - startTime;
                result[1] = comparisons;
                return result;
            }

        }
        return new long[2];
    }
}
