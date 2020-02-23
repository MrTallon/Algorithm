package recursive;

/**
 * 斐波那契数列
 *
 * @author 35242
 */
public class Fibonacci {

    /**
     * 递归 O(2^n)
     * 有很多重复的运算
     *
     * @param i
     * @return
     */
    private static int method1(int i) {
        if (i <= 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return method1(i - 1) + method1(i - 2);
        }
    }

    private static int method2(int i, int[] mem) {
        if (i <= 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (exist(mem, i)) {
            return mem[i];
        }
        return method2(i - 1, mem) + method2(i - 2, mem);
    }

    private static boolean exist(int[] mem, int i) {
        // TODO
        return false;
    }
}
