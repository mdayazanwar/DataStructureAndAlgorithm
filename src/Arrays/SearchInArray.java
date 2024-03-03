package Arrays;

/**
 * Write a program to check if an array contains a number in Java.
 */
public class SearchInArray {
    public static void main(String[] args) {
        int[] arr  = {1, 2, 3, 4, 5, 6, 7};

        searchMissingNumber(arr, 6);
    }

    private static void searchMissingNumber(int[] arr, int valueToSearch) {
        for( int i = 0; i <= arr.length-1; i++) {
            if(arr[i]== valueToSearch) {
                System.out.print("Value found");
                return;
            }
        }
        throw new IllegalArgumentException("Value not Found");
    }
}
