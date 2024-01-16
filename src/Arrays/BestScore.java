package Arrays;

public class BestScore {

    /**
     * Given an array, write a function to get first, second best scores from the array
     * and return it in new array.
     */

    public static void main(String[] args) {

        int[] arr = {67, 56, 98, 34, 59, 86, 34, 93};
        int[] result =  findTopTwoScore(arr);
        System.out.println("First highest : "+ result[0] + "\n"
        + "Second Highest: "+ result[1]);
    }

    private static int[] findTopTwoScore(int[] arr) {
         int firstHighest = Integer.MIN_VALUE;
         int secondHighest = Integer.MIN_VALUE;

         for(int score : arr) {
             if(score > firstHighest) {
                 secondHighest = firstHighest;
                 firstHighest = score;
             }
             else if(score > secondHighest && score < firstHighest) {
                 secondHighest = score;
             }
         }

         return new int[] {firstHighest, secondHighest};

    }
}
