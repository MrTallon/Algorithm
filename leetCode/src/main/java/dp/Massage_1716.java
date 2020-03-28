package dp;

/**
 * 按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-24 10:56
 */
public class Massage_1716 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(massage(arr));

    }

    public static int massage(int[] nums) {
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
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}