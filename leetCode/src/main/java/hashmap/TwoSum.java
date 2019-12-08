package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author YangBox
 * @date 2019/04/23
 */
public class TwoSum {

    /**
     * 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] method_01(int[] nums, int target) {

        int[] rst = new int[2];

        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                rst[0] = i;
                rst[1] = map.get(target - nums[i]);
            }
            if (rst[0]==rst[1]){
                continue;
            }
            return rst;
        }
        return null;
    }

    /**
     * 优化版
     * 时间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] method_02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{index, i};
            }
        }
        return new int[]{0, 0};
    }
}
