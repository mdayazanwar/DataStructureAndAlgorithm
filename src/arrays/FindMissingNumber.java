package arrays;


/**
 * Write Java function called findMissingNumberInArray that takes an integer array
 * containing n-1 unique elements from a range of 1 to n, with one missing number,
 * and returns the missing number.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println("missing number in given array: "+  findMissingNumberInArray(arr));
    }

    public static int findMissingNumberInArray(int[] arr) {
        int n  = arr.length + 1;
        int expectedSum =  n * ( n + 1 ) / 2;
        int actual = 0;
        for (int number : arr) {
             actual += number;
        }
        return  expectedSum - actual;
    }
}
