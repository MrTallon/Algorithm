package array;

/**
 * 搜索目标值
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-17 09:25
 */
public class SearchInsert_0035 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert_1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
