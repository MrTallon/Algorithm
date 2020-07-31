package array;

/**
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-31 17:53
 */
public class FindMagicIndex_0803 {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        boolean b = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                b = true;
                res = Math.min(res, i);
            }
        }
        return b ? res : -1;
    }
}
