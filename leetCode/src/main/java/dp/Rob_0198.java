package dp;

import java.util.Arrays;

public class Rob_0198 {
    public static void main(String[] args) {
        int[] arr = {1, 2,4,10};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return Arrays.stream(nums).max().getAsInt();
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
