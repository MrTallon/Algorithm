package array;

import java.util.Arrays;
import java.util.List;

/**
 * 1-100中的99个数，找出那个不存在的
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653189951&idx=1&sn=0181c95484b67d108672235b14e5ebbb&chksm=8c9905e5bbee8cf3362ccc4c7e091caa18b5783183ce4475b6f011c09c1cb03847ea4cb5220c&scene=21#wechat_redirect
 *
 * @author YangBo
 * @date 2019/08/20
 */
public class FindNum {

    public static void main(String[] args) {
        Integer[] array = new Integer[99];
        for (Integer i = 0; i < 99; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("---------------");
        System.out.println(method1(array));
        System.out.println(method2(array));


    }

    /**
     * 开辟list空间，遍历list是否不包含哪个数字
     * 时间复杂度O(n)
     */
    private static int method1(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        for (int i = 1; i < 101; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 不需独立开辟空间，用1-100的和减去数组，结果就是缺失的数字
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    private static int method2(Integer[] array) {
        if (array.length < 2) {
            return -1;
        }
        int i = (array.length + 1) * array.length / 2;
        for (int n : array) {
            i -= n;
        }
        return i;
    }
}
