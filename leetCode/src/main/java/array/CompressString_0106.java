package array;

/**
 * 字符串压缩
 * https://leetcode-cn.com/problems/compress-string-lcci/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-16 19:07
 */
public class CompressString_0106 {
    public static void main(String[] args) {
        System.out.println(compressString("aabbbcccaa"));
    }
    public static String compressString(String S) {

        if (S == null || S.length() == 0) {
            return "";
        }
        S += "!";
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[S.length()];
        chars[0] = S.charAt(0);
        int num = 0;
        int i = 1;
        for (i = 1; i < S.length(); i++) {
            chars[i] = S.charAt(i);
            num++;
            if (chars[i-1] != chars[i]) {
                sb.append(chars[i - 1]);
                sb.append(num);
                num = 0;
            }
        }
        int last = S.length() - i;
        if (last != 0) {
            sb.append(S.charAt(S.length()-1));
            sb.append(last);
        }
        if (sb.length() >= S.length()) {
            return S.substring(0,S.length()-1);
        }
        return sb.toString();
    }
}
