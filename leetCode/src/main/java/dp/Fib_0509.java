package dp;

/**
 * 斐波那契
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-17 17:24
 */
public class Fib_0509 {
    public static void main(String[] args) {
        System.out.println(fib(4));

    }
    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
