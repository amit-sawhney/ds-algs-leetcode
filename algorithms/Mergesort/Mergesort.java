package algorithms.Mergesort;

import java.util.Arrays;

/**
 * This class contains the recursive and helper function code to execute a merge sort
 */
public class Mergesort {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 7, 1, -1 };

        mergesort(arr, 0, arr.length - 1);

        // Prints: -1, 1, 3, 5, 7
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Recursive function to execute a merge sort.
     * 
     * @param arr        the array to be sorted in place
     * @param leftIndex  the left index of the range of the array to sort
     * @param rightIndex the right index of the range of the array to sort
     */
    public static void mergesort(int[] arr, int leftIndex, int rightIndex) {
        // Replacing the below if statement with:
        /*
         * if (leftIndex >= rightIndex) { return; }
         */
        // would also work

        // Only call mergesort on arrays with two values because an array with 1 value
        // is sorted
        if (leftIndex < rightIndex) {

            int midIndex = (leftIndex + rightIndex) / 2;

            // Merge sort the left half of the array
            mergesort(arr, leftIndex, midIndex);

            // merge sort the right half of the array
            mergesort(arr, midIndex + 1, rightIndex);

            // Merges the two *SORTED* array
            merge(arr, leftIndex, midIndex, rightIndex);
        }
    }

    /**
     * Merges two sorted sections of an array in place
     * 
     * @param arr        the array with the sections to merge
     * @param leftIndex  the left index of the range
     * @param midIndex   the index splitting the left index and the right index
     *                   also, the end of the left section
     * @param rightIndex the right index of the range
     */
    private static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {

        int leftArraySize = midIndex - leftIndex + 1;
        int[] leftArray = new int[leftArraySize];

        int rightArraySize = rightIndex - midIndex;
        int[] rightArray = new int[rightArraySize];

        // Copy the left section of the array into a separate array
        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = arr[leftIndex + i];
        }

        // Copy the right section of the array into a separate array
        for (int i = 0; i < rightArraySize; i++) {
            rightArray[i] = arr[midIndex + i + 1];
        }

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int arrIndex = leftIndex;

        // Merge algorithm to properly combine the left and right sections
        // This only works knowing that the two sections are SORTED
        while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize) {
            // If the left section's value is smaller
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                arr[arrIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                // If the right section's value is smaller
                arr[arrIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }

            arrIndex++;
        }

        /**
         * Either the next or the following for loop will execute. NOT BOTH.
         */

        // Copy the rest of the left section into the correct places if there are
        // remaining values
        for (int i = leftArrayIndex; i < leftArraySize; i++) {
            arr[arrIndex] = leftArray[i];
            arrIndex++;
        }

        // Copy the rest of the right section into the correct places if there are
        // remaining values
        for (int i = rightArrayIndex; i < rightArraySize; i++) {
            arr[arrIndex] = rightArray[i];
            arrIndex++;
        }
    }
}
