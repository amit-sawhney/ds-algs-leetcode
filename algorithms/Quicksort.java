package algorithms;

import java.util.Arrays;

/**
 * This class shows how to write a simple quicksort algorithm. There is a worked out example at the bottom of this file
 * stepping through how a quicksort is executed.
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] testArray = { 5, 3, 7, 1, -1 };

        qs(testArray, 0, testArray.length - 1);

        // testArray: -1, 1, 3, 5, 7
        System.out.println(Arrays.toString(testArray));
    }

    /**
     * This the primary driver for the quicksort method.
     * 
     * @param arr        the array to be sorted
     * @param leftIndex  the left/starting index of the subarray to quicksort
     * @param rightIndex the right/end index of the subarray to quicksort
     */
    public static void qs(int[] arr, int leftIndex, int rightIndex) {
        // Replacing the below if statement with:
        /*
         * if (leftIndex > rightIndex) { return; }
         */
        // would also work

        // Essentially a base case that tells when the quicksort should run
        if (leftIndex < rightIndex) {

            int pivotIndex = partition(arr, leftIndex, rightIndex);

            // Recursively quicksort the parts of the array around the pivot
            // (we know the pivot is in the right place)
            qs(arr, leftIndex, pivotIndex - 1);
            qs(arr, pivotIndex + 1, rightIndex);

        }
    }

    /**
     * Paritions the array (in place) by splitting the array into two sectiosn,
     * values greater than the pivot chosen and values less than the pivot chosen
     * 
     * At the end of partitioning, it is known that the pivot is in the correct spot
     * 
     * @param arr        the array to partition
     * @param leftIndex  the left/starting index of the subarray to partition
     * @param rightIndex the right/end index of the subarray to partition
     * @return the index of the pivot after the parition
     */
    private static int partition(int[] arr, int leftIndex, int rightIndex) {

        // Choose a default pivot value (this version utilizes the last value in the
        // subarray)
        int pivot = arr[rightIndex];

        int i = leftIndex - 1;

        // Loop through the array from the left index to one less than the right index
        for (int j = leftIndex; j < rightIndex; j++) {

            // Swap i and j if the value at j is less than the pivot
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        // Put the pivot in the correct place to establish the boundary between values
        // less
        // then the pivot and values greater than the pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[rightIndex];
        arr[rightIndex] = temp;

        // Index of the pivot
        return i + 1;
    }
}

/**
 * Initial quick sort: 
 * 
 * Partion:
 * pivot: -1
 * 
 * i = -1
 * 5, 2, 7, 1, -1
 * 
 * j = 0
 * 5 > -1: do nothing
 * 
 * j = 1
 * 2 > -1: do nothing
 * 
 * j = 2
 * 7 > -1: do nothing
 * 
 * j = 3
 * 1 > -1: do nothing
 * 
 * swap 5 (i + 1 = 0) and -1 (high value)
 * Array state: -1, 2, 7, 1, 5
 * return i + 1 = 0
 * 
 * Quicksort arr from index 0 to 0 (pivot - 1) and quicksort arr from index 1 (pivot + 1) to 4
 * 
 * Left quicksort (0 to 0)
 * 0 = 0 so base case is hit, return
 * 
 * Right quicksort (1 to 4)
 * 1 < 4, so continue with quicksort
 * 
 * Parition:
 * pivot: 5 
 * 
 * i = 0
 * -1, 2, 7, 1, 5
 * 
 * j = 1
 * 2 < 5: increase i, swap i and j
 * i++ --> 1
 * swap 1 (i) and 1 (j)
 * Array state: -1, 2, 7, 1, 5
 * 
 * j = 2
 * 7 > 5: do nothing
 * 
 * j = 3
 * 1 < 5: increase i, swap i and j
 * i++ --> 2
 * swap 2 (i) and 3 (j)
 * Array state: -1, 2, 1, 7, 5
 * 
 * swap 3 (i + 1) and 5 (high value)
 * Array state: -1, 2, 1, 5, 7
 * return i + 1 = 3
 * 
 * Quicksort arr from index 0 to 2 (pivot - 1) and quicksort arr from index 4 (pivot + 1) to 4
 * 
 * Left quicksort (0 to 2)
 * 
 * Parition:
 * pivot = 1
 * 
 * i = -1
 * -1, 2, 1, 5, 7
 * 
 * j = 0
 * -1 < 1: increase i, swap i and j
 * i++ --> 0
 * swap 0 (i) and 0 (j)
 * -1, 2, 1, 5, 7
 * 
 * j = 1
 * 2 > 1: do nothing
 * 
 * swap 2 (i + 1) and 1 (high value)
 * Array state: -1, 1, 2, 5, 7
 * return i + 1 = 1
 * 
 * Right quicksort (4 to 4)
 * 4 = 4, so base case is it, return
 * 
 * Quicksort arr from index 0 to 0 (pivot - 1) and quicksort arr from index 2 (pivot + 1) to 4
 * Note: At this point, quicksort will continue on but will not make any swaps. It will eventually hit
 *       all base cases because the array is sorted.
 * 
 */