package array;

/**
 * 使数组唯一的最小增量
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-22 21:56
 */
public class MinIncrementForUnique_0945 {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x : A) {
            count[x]++;
        }

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;

    }
}
