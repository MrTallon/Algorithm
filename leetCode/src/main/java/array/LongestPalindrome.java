package array;

/**
 * 字符串中的最长回文
 * https://leetcode-cn.com/problems/longest-palindromic-substring/comments/
 * <p>
 * Tips：https://blog.csdn.net/qq_32354501/article/details/80084325
 * https://www.cnblogs.com/mini-coconut/p/9074315.html
 *
 * @author YangBo
 * @date 2019/05/22
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "address";

        System.out.println(method(s));
        System.out.println(manacher(s));
    }

    private static int maxLen = 0;

    private static String sub = "";

    /**
     * 第一版：从中心向外扩散
     * 时间复杂度：O(n^2)
     *
     * @param s 参数
     * @return 回文串
     */
    private static String method(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            // 单核回文
            findLongestPalindrome(s, i, i);
            // 双核回文
            findLongestPalindrome(s, i, i + 1);
        }
        return sub;
    }

    private static void findLongestPalindrome(String s, int low, int high) {
        while (low >= 0 && high <= s.length() - 1) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                // 向两边扩散寻找以当前字符为中心的最大回文子串
                low--;
                high++;
            } else {
                break;
            }
        }
    }

    /**
     * 第二版：马拉车（Manacher） 算法
     * https://subetter.com/algorithm/manacher-algorithm.html
     *
     * @param s 参数
     * @return 回文串
     */
    private static String manacher(String s) {
        // 处理参数数组
        char[] t = preProcess(s).toCharArray();
        int n = t.length;
        // 用于储存回文串长度的临时数组
        int[] p = new int[n];

        int c = 0, r = 0;
        for (int i = 1; i < n - 1; i++) {
            // equals to i' = c - (i-c)
            int iMirror = 2 * c - i;
            p[i] = r > i ? Math.min(p[iMirror], r - i) : 0;
            // Attempt to expand palindrome centered at i
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }
            // if palindrome centered at i expand past r
            // adjust center based on expanded palindrome
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        // 截取字符串
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        int beginIndex = (centerIndex - 1 - maxLen) / 2;
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    private static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder result = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            result.append("#").append(s.charAt(i));
        }
        result.append("#$");
        return result.toString();
    }
}
