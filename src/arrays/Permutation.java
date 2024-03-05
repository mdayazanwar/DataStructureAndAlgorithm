package arrays;

public class Permutation {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 1, 2, 3};
        boolean result =  permutation(arr1, arr2 );
        System.out.println(result);
    }

    public static boolean permutation(int[] array1, int[] array2) {
        boolean result= false;
        for (int j : array1) {
            result = false;
            for (int k : array2) {
                if (j == k) {
                    result = true;
                    break;
                }
            }
            if (!result) {
                return result;
            }
        }
        return result;
    }
}
