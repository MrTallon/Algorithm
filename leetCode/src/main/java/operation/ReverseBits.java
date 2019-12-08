package operation;

/**
 * 二进制 奇偶位互换位置
 * 0101
 * 1010
 *
 * @author YangBo
 * @date 2019/08/20
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverse(6));
    }

    public static int reverse(int n) {
        // 和1010 1010 1010 做与运算
        int ou = n & 0xaaaaaaaa;
        // 和0101 0101 0101 做与运算
        int ji = n & 0x55555555;
        return (ou >> 1) ^ (ji << 1);
    }
}
