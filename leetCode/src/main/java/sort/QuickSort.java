package sort;

/**
 * Implemented quickSort
 *
 * @author YangBo
 * @date 2019/05/21
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 213, 123, 1, 23,12,3,123,21,3,123,12,4,3245,3,543,6,7};
        sort(array);
        for (int a : array) {
            System.out.println(a);
        }
    }
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
