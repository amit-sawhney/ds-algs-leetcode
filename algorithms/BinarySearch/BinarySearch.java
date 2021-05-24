package algorithms.BinarySearch;

/**
 * This class represents a basic iterative apporach to a binary search
 */
public class BinarySearch {
    
    public static void main(String[] args) {
        int[] arr = { -1, 2, 3, 6, 10, 30 };

        int index = binarySearch(arr, -1);

        // Prints: 0
        System.out.println(index);
    }

    /**
     * The binary search algorithm
     * 
     * @param arr the array to search through
     * @param target the target value to search for in the array
     * @return the index of the target value, -1 otherwise if it isn't in the array
     */
    public static int binarySearch(int[] arr, int target) {
        
        // Starts the initial range at the beginning of the entire array
        int leftIndex = 0;

        // Ends the initial range at the end of the entire array
        int rightIndex = arr.length - 1;

        // If leftIndex > rightIndex, then the target must not exist as it was passed
        while (leftIndex <= rightIndex) {

            // Get the index right in the middle
            int middleIndex = (leftIndex + rightIndex) / 2;

            // This can also be wrriten as:
            // int middleIndex = leftIndex + (rightIndex - leftIndex) / 2

            if (target == arr[middleIndex]) {
                return middleIndex;
            } else if (target > arr[middleIndex]) {
                // Shift the range of values to be searched to be the right half of the current range
                leftIndex = middleIndex + 1; 
            } else {
                // Shift the range of values to be searched to be the left half of the current range
                rightIndex = middleIndex - 1;
            }
        }

        // -1 represents not found
        return -1;
    }
}
