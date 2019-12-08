package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.bilibili.com/video/av48277621
 *
 * @author YangBo
 * @date 2019/04/14
 * <p>
 * 给一个排序好的数组和区间，
 * 找出数组中不在区间内的数字
 * <p>
 * 例：[0,1,3,50,75],0,99
 * retrun [2, 4->49, 51->74, 75->99]
 */

public class QuestionMissingRanges {

    private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //定义返回值
        List<String> rst = new ArrayList<>();
        //判断非空
        if (nums == null || nums.length == 0) {
            rst.add(lower + "->" + upper);
            return rst;
        }
        //算法逻辑
        //给定区间最小值不在数组中
        addToList(rst, lower, nums[0] - 1);
        //区间中
        int prev = nums[0];
        int i = 1;
        while (i < nums.length) {
            int cur = nums[i];
            if (cur != prev + 1) {
                addToList(rst, prev + 1, cur - 1);
            }
            prev = cur;
            i++;
        }
        //给定区间最大值不在数组中
        addToList(rst, nums[nums.length - 1], upper);
        return rst;
    }

    private static void addToList(List<String> rst, int start, int end) {

        if (start == end) {
            rst.add(String.valueOf(start));
        } else if (start < end) {
            rst.add(start + "->" + end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> rst = findMissingRanges(nums, lower, upper);
        System.out.println(rst.toString());
    }
}
