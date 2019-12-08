package chapter1.low;

/**
 * 简单算法
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class SimpleMethod {

    /**
     * 判断是否为回文
     *
     * @return
     */
    private static boolean huiwen() {
        String txt = "10";
        int N = txt.length();
        for (int i = 0; i < N / 2; i++) {
            if (txt.charAt(i) != txt.charAt(N - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从一个命令行中提取文件名和后缀名
     */
    private static void getName() {
        String txt = "吉泽明步.avi";
        int dot = txt.indexOf(".");
        // 文件名
        String base = txt.substring(0, dot);

        // 后缀名
        String extension = txt.substring(dot + 1);
    }

    /**
     * 检查一个字符串数组中的元素是否已按照字母表顺排序
     *
     * @param a
     * @return
     */
    private static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
