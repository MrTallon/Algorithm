package chapter1.low;

/**
 * 判断三个数是否相等
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class JudgeNumEquals {
    public static void main(String[] args) {
        int[] arr = {44, 44, 44};
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println("三数相等");
        } else {
            System.out.println("三数不相等");
        }
    }
}
