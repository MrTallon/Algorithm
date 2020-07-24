package operation;

/**
 * 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 * 判断奇偶，先手偶数必胜，先手奇数必败
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-24 09:30
 */
public class DivisorGame_1025 {
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(13 & 1);
    }
}
