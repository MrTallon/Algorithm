package array;

/**
 * https://www.bilibili.com/video/av48277621
 *
 * @author YangBo
 * @date 2019/04/14
 *
 * 找到数组中的第一个 "B"
 *
 * 例：GGGBBBBBBB
 * 返回 4
 *
 * 提示：二分法
 *
 */
public class FirstBadVersion {

    //⬇️⬇️⬇️⬇️已知⬇️⬇️⬇️⬇️

    private static int FIRST_BAD = 4;

    private static boolean isBadVersion(int version) {
        if (version >= FIRST_BAD) {
            return true;
        }
        return false;
    }
    //⬆️⬆️⬆️⬆️已知⬆️⬆️⬆️⬆️

    private static int firstBadVersion(int n) {

        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        int rst = firstBadVersion(10);
        System.out.println(rst);
    }

}
