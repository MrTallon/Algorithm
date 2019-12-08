package operation;

import java.util.Arrays;
import java.util.Random;

/**
 * 1～1001 唯一重复的那个数字
 *
 * @author YangBo
 * @date 2019/07/26
 */
public class SameNum {
    public static void main(String[] args) {
        // 总个数
        int N = 11;

        // 初始化1001的数
        int[] arr = new int[N];

        // 为前1000个数赋值
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }

        // 第1001个数为随机数(1~1000)
        arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;

        int x1 = 0;
        for (int i = 1; i <= N - 1; i++) {
            x1 = x1 ^ i;
        }
        for (int i = 0; i < N; i++) {
            x1 = x1 ^ arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("末尾的随机数： " + arr[arr.length - 1]);
        System.out.println(x1);

        System.out.println("======");
        // 原来Integer还可以实现进制转换啊
        System.out.println(Integer.toString(10,9));
    }
}

