package Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target. You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new int[2];
        result = twoSumFunction(nums, target);
    }

    private static int[] twoSumFunction(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}