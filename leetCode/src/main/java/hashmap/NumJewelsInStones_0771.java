package hashmap;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author YangBo
 * @date 2019/08/26
 */
public class NumJewelsInStones_0771 {
    public static void main(String[] args) {
        String J = "ab";
        String S = "abcdeAa";
        System.out.println(numJewelsInStones(J, S));
        System.out.println(method2(J, S));

    }

    private static int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }
        int count = 0;
        for (String s : S.split("")) {
            for (String j : J.split("")) {
                if (s.equals(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 考虑更高的空间性能，使用byte数组。ASCII码中字母的跨度为65~122，所以定义数组长度为58最节省。(大佬解法)
     *
     * @param J
     * @param S
     * @return
     */
    private static int method2(String J, String S) {

        if (J.isEmpty() || S.isEmpty()) {
            return 0;
        }

        byte[] arr = new byte[58];
        int count = 0;
        for (char ch : J.toCharArray()) {
            arr[ch - 65] = 1;
        }
        for (char ch : S.toCharArray()) {
            if (arr[ch - 65] == 1) {
                count++;
            }
            ;
        }
        return count;
    }

}
