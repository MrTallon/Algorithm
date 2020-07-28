package array;

/**
 * 罗马数字
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-24 09:46
 */
public class RomanToInt_0013 {
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int preNum = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            if (preNum < getValue(s.charAt(i))) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = getValue(s.charAt(i));
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
