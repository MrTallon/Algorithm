/**
 * @author tallon
 * @version v1.0.0
 * @date 2020-04-29 00:57
 */
public class KMP {
    /**
     * 时间复杂度 O(m+n)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(kmpMatch("12345454514q56", "4q"));
    }

    /**
     * 求出一个字符串数组的next数组
     *
     * @param t 字符串数组
     * @return next数组
     */
    private static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int i = 2; i < t.length; i++) {
            k = next[i - 1];
            while (k != -1) {
                if (t[i - 1] == t[k]) {
                    next[i] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[i] = 0;
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     *
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i < s_arr.length && j < t_arr.length) {
            if (j == -1 || s_arr[i] == t_arr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t_arr.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
