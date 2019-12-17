package sort;

import java.util.Arrays;

/**
 * 哈希排序
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-12 00:09
 */
public class ShellSort {

    /**
     * 哈希排序（二分插入排序）
     *
     * @param arr 能比较的对象数组
     * @param <T> 已排序的对象数组
     */
    public static <T extends Comparable> void shellSort(T[] arr) {
        int j;

        for (int gap = arr.length / 2 ; gap > 0; gap /= 2) {
            // 从数组第 gap 个元素开始，向前比较
            for (int p = gap; p < arr.length; p++) {
                T tmp = arr[p];
                // 循环，向前依次比较
                // 如果比前面元素小，交换位置
                for (j = p; (j >= gap) && (tmp.compareTo(arr[j - gap]) < 0); j-= gap) {
                    arr[j] = arr[j - gap];
                }
                // 如果比前面元素大或者相等，那么这就是元素的位置，交换
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = new Integer[] {2, 3, 1, 4, 3};

        System.out.println(Arrays.toString(intArr));
        shellSort(intArr);
        System.out.println(Arrays.toString(intArr));
    }
}

