package dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 思路：
 * 没思路
 */
public class MaxSum_0053 {

    public static void main(String[] args) {
        int[] array = {1, 2, -1};
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 分治
     *
     * @param nums 数组
     * @param l    左起
     * @param r    右终
     */
    private static int helper(int[] nums, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        int mid = (l + r) >>> 1;
        int left = helper(nums, l, mid - 1);
        int right = helper(nums, mid + 1, r);
        int leftMaxSum = 0;
        int sum = 0;
        // left surfix maxSum start from index mid - 1 to l
        for (int i = mid - 1; i >= l; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }
        int rightMaxSum = 0;
        sum = 0;
        // right prefix maxSum start from index mid + 1 to r
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(sum, rightMaxSum);
        }
        // max(left, right, crossSum)
        return Math.max(leftMaxSum + rightMaxSum + nums[mid], Math.max(left, right));
    }

    /**
     * 动态规划
     *
     * @param nums dp[i] - 表示到当前位置 i 的最大子序列和
     *             状态转移方程为： dp[i] = max(dp[i - 1] + nums[i], nums[i])
     *             初始化：dp[0] = nums[0]
     *  时间复杂度: O(n)
     *  空间复杂度: O(1)
     */
    private static int dp(int[] nums) {
        int currMaxSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
        }
        return maxSum;
    }
}
