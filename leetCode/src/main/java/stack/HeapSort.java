package stack;

import java.util.Arrays;

/**
 * 堆排序练习
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class HeapSort {

    /**
     * 堆排序
     *
     * @param array 待调整的堆
     */
    static void heapSort(int[] array) {

        // 1.把无序组构建成二叉堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            HeapOperator.downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));

        // 2.循环删除堆顶元素，移到尾部集合，调节产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素和第一个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            HeapOperator.downAdjust(array, 0, i);
        }

    }

    public static void main(String[] args) {

        int[] array = {12, 3, 4, 3, 25, 34, 56, 45, 7};
        heapSort(array);

        // 排序后的数组
        System.out.println(Arrays.toString(array));
    }

}
