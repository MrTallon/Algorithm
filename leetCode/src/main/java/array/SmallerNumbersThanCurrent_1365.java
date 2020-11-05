package array;

/**
 * 小于当前数字
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-26 09:25
 */
public class SmallerNumbersThanCurrent_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    index++;
                }
            }
            res[i] = index;
        }
        return res;
    }
}
