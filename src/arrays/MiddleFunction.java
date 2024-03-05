package arrays;

import java.util.Arrays;

/**
 * Write a function called middle that takes an array and returns a new array that contains all but the first and last elements.
 *
 * myArray = [1, 2, 3, 4]
 * middle(myArray)  # [2,3]
 *
 */

public class MiddleFunction {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Result: "+ Arrays.toString(middle(arr)));
    }

    public static int[] middle(int[]  arr) {

        if(arr.length <= 2) {
            return new int[0];
        }

        int[] result = new int[arr.length -2];
        for( int i = 1; i < arr.length -1 ; i++) {
            result[i-1] = arr[i];
        }
        return result;
    }
}
