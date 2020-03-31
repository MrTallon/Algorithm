package array;

import java.util.Arrays;

/**
 * 排序
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-31 18:36
 */
public class SortArray_0912 {
    public int[] sortArray(int[] nums) {
        return quick(nums, 0, nums.length-1);
    }

    private int[] quick(int[] nums, int i, int j) {
        if (i >= j) {
            return nums;
        }
        int pivot = nums[(i + j) / 2];
        int index = partition(nums, i, j, pivot);
        quick(nums, i, index - 1);
        quick(nums, index, j);
        return nums;
    }

    private int partition(int[] nums, int i, int j, int pivot) {
        while (i <= j) {
            while (nums[i] <= pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] bubble(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    public int[] quick(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

}
