package array;

/**
 * 寻找重复数
 * 快慢指针
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-09 21:35
 */
public class FindDuplicate_0287 {

    public static void main(String[] args) {
        int[] nums = {1, 2,2, 3};
        System.out.println(findDuplicate(nums));

    }

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int ptr1 = nums[0];
        int ptr2 = tortoise;

        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
