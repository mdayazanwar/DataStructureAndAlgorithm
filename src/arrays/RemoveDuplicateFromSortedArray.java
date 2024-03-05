package arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once
 * and returns the new length. Do not allocate extra space for another array;
 * you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8};
        System.out.println("Length of give array after removing duplicates: "+ removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {

        if( arr.length == 0) {
            return 0;
        }
        int i = 0;
        for( int j = 1; j< arr.length; j++ ) {
            if(arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
