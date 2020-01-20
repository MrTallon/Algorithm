package set;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 判断数组中是否有重复元素
 * https://lseetcode-cn.com/problems/contains-duplicate/
 *
 * @author YangBo
 * @date 2019/07/19
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(containsDuplicate(arr));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() != nums.length;
    }
}
