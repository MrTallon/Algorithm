package operation;

/**
 * 191. 位1的个数
 * <p>
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author YangBo
 * @date 2019/07/26
 */
public class HammingWeight {
    public static void main(String[] args){
        int n = 3;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(Integer.toString(3, 2));
        System.out.println(count);
    }
}
