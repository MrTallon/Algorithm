package dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 水壶装水
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-21 23:29
 */
public class CanMeasureWater_0365 {
    public boolean canMeasureWater(int x, int y, int z) {
        // 不懂 这步的判断依据，如果 2 4 8 ，8 > 2 + 4, 可是符合条件的
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }
}
