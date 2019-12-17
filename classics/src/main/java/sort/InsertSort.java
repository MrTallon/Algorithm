package sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-12 00:08
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param arr 能比较的对象数组
     * @param <T> 已排序的对象数组
     */
    public static <T extends Comparable> void insertionSort(T[] arr) {
        int j;

        // 从数组第二个元素开始，向前比较
        for (int p = 1; p < arr.length; p++) {
            T tmp = arr[p];
            // 循环，向前依次比较
            // 如果比前面元素小，交换位置
            for (j = p; (j > 0) && (tmp.compareTo(arr[j - 1]) < 0); j--) {
                arr[j] = arr[j - 1];
            }
            // 如果比前面元素大或者相等，那么这就是元素的位置，交换
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = new Integer[] {2, 3, 1, 4, 3};

        System.out.println(Arrays.toString(intArr));
        insertionSort(intArr);
        System.out.println(Arrays.toString(intArr));
    }
}


