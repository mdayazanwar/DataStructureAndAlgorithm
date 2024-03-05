package arrays;

/**
 * Write a program to find maximum product of two integers in the array where all elements are positive.
 */
public class MaxProdcutOfTwoInteger {
    public static void main(String[] args) {
        int[] arr  = {10, 20, 30, 40, 50};
        System.out.println("Max product: "+ maxProduct(arr));
    }

    public  static int maxProduct(int[] arr) {
        int result =0;
        String pair = "";
        for( int i =0; i<arr.length; i++) {
            for( int j = i+1; j < arr.length; j++){
                if(arr[i] * arr[j] > result) {
                    result = arr[i] * arr[j];
                }
            }
        }
        return  result;
    }
}
