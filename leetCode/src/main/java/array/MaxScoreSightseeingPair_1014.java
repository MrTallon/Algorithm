package array;

/**
 * 最佳观光组合
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-06-17 20:04
 */
public class MaxScoreSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] A) {
        int left = A[0], res = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        return res;
    }
}
