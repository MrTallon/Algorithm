package chapter1.high;

import java.util.Arrays;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class ArrayExercise {
    /**
     * 求最大公约数
     */
    private static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    /**
     * 两数是否互质
     */
    private static boolean isCoprime(int m, int n) {
        return 1 == gcd(m, n);
    }

    private static boolean[][] boolArray(int n) {
        boolean[][] resultAry = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //如果是第0行或者第0列
                if (i == 0 || j == 0) {
                    resultAry[i][j] = false;
                } else {
                    resultAry[i][j] = isCoprime(i, j);
                }
            }
        }
        return resultAry;
    }

    public static void main(String[] args) {
        boolean[][] resultArray = boolArray(9);
        for (boolean[] booleans : resultArray) {
            System.out.println(Arrays.toString(booleans));
        }
    }

}
