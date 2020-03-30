package array;

/**
 * 约瑟夫环
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * https://blog.csdn.net/u011500062/article/details/72855826
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-30 23:37
 */
public class LastRemaining_0062 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
