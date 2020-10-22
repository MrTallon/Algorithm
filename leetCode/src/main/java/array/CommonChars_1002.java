package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 查找常用字符串
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-14 18:11
 */
public class CommonChars_1002 {
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String s : A) {
            int[] freq = new int[26];

        }

    }
}
