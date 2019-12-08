package sort;

/**
 * Implemented BubbleSort
 *
 * @author YangBo
 * @date 2019/05/22
 */
public class BubbleSort {

    /**
     * 第一版：基础版
     * @param array
     */
    private static void version_01(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array ,j, j+1);
                }
            }
        }
    }

    /**
     * 第二版：增加排序标识符，当数组有序后直接跳出循环
     * @param array
     */
    private static void version_02(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 有序标记，每一轮的初始为 true
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array ,j, j+1);
                    // 有元素交换，所以数组不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 第三版：寻找出数组中已存在的有序区，减少每次多余的比较
     * @param array
     */
    private static void version_03(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要到这里即可
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                    //把无序数组的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 双向冒泡排序
     * @param array
     */
    private static void version_04(int array) {

    }

    private static void swap(int array[],int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
