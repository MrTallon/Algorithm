package dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Stairs_0070 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));

    }

    private static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
