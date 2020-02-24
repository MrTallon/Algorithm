package dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Stealing_0198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }
        return dp[nums.length-1];
    }
}

