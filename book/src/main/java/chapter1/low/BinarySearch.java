package chapter1.low;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 12, 4,6,6,6, 32, 435, 5, 6, 5, 7, 6, 2, 34, 23, 4, 23431, 23};
        // 二分查找必须是排序后的数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(customBinary(6, arr));
        System.out.println(javaBinary(6, arr));


    }

    /**
     * 自定义二分查找法
     * @param key
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    static int customBinary(int key, int[] arr, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid]) {
            return customBinary(key, arr, lo, mid - 1);
        } else if (key > arr[mid]) {
            return customBinary(key, arr, mid + 1, hi);
        }
        return mid;
    }

    /**
     * 使用重载来递归查询
     * @param key
     * @param arr
     * @return
     */
    static int customBinary(int key, int[] arr) {
        return customBinary(key, arr, 9, arr.length - 1);
    }

    /**
     * Arrays 内置二分查找法
     * @param key
     * @param arr
     * @return
     */
    static int javaBinary(int key, int[] arr) {
        return Arrays.binarySearch(arr, key);
    }
}
