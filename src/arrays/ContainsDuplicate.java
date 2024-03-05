package arrays;

/**
 * Write a program to check if an array is unique or not
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4, 5, 6, 7};
        boolean result =  isUnique(arr);
        System.out.println(result);
    }
    public static boolean isUnique(int[] arr) {
        for ( int i  = 0 ; i< arr.length; i++) {
            for( int j = i+1; j< arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
