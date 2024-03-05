package arrays;

import java.util.Arrays;

/**
 * Write a function which takes integer array as a parameter and returns a new integer array with unique elements.
 * (remove duplicates)
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        int[] arr =  {1, 1, 2, 2, 3, 3, 4, 5};
        int[] uniqueArray =  removeDuplicate(arr);
        for( int number :  uniqueArray) {
            System.out.print(number + " " );
        }
    }

    public static int[] removeDuplicate(int[] arr) {
        int n  = arr.length;
        int[] uniqueArray = new int[n];
        int index  = 0;
        for( int i  =  0; i < n; i++) {
            boolean isDuplicate = false;
            for( int j = i + 1; j < n; j++) {
                if(arr[i] ==  arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate) {
                uniqueArray[index++] =  arr[i];
            }
        }
        return Arrays.copyOf(uniqueArray, index);
    }
}
