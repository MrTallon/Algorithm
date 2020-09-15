package array;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-09-15 09:52
 */
public class MaxSubArray_0042 {
    public int maxSubArray(int[] nums) {
        int i = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            i = Integer.max(sum, i);
            sum = Integer.max(sum, 0);
        }
        return i;
    }
}
