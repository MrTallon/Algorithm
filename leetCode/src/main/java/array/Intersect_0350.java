package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-13 19:14
 */
public class Intersect_0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 为降低空间复杂度，优先遍历较短数组
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
