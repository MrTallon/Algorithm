package array;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-13 20:47
 */
public class LongestCommonPrefix_0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }
}
