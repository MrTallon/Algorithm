package linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 * 四数求出目标值
 *
 * @author YangBo
 * @date 2019/05/23
 */
public class FourSum {

    private static List<List<Integer>> method(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        if (nums.length < 4) {
            return result;
        }

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 相同数字的跳过，节省时间
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                // 不合理情况，直接返回，节省时间
                break;
            }

            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                // 跳过太小的数字，节省时间
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((j + 2) < n && nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {

                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int current_sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (current_sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (current_sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
