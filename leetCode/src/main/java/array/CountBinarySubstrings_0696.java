package array;

/**
 * 计数二进制子串
 * https://leetcode-cn.com/problems/count-binary-substrings/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-10 09:37
 */
public class CountBinarySubstrings_0696 {
    public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}
