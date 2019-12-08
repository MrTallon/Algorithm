package operation;

/**
 * 461. 汉明距离
 *
 * @author YangBo
 * @date 2019/08/21
 */
public class HammingDistance {


    private static int hammingDistance(int x, int y) {
        int i = x ^ y;
        if (i == 0) {
            return 0;
        }
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

}
