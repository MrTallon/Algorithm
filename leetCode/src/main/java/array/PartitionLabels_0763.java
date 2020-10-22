package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 * 又是抄答案的一天
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-22 15:00
 */
public class PartitionLabels_0763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
