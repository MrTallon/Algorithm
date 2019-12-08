package recursive;

/**
 * 汉诺塔
 *
 * @author YangBo
 * @date 2019/09/02
 */
public class HanoiTower {

    private static void print(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
            return;
        }
        // 先将N-1移动到辅助空间
        print(N - 1, from, help, to);
        // N 移动到目标空间
        System.out.println("move " + N + " from " + from + " to " + to);
        // 让N-1从辅助空间回到源空间
        print(N - 1, help, to, from);
    }
}
