package array;

/**
 * https://leetcode-cn.com/problems/multiply-strings/comments/
 * <p>
 * Tip：https://blog.csdn.net/afei__/article/details/83891547
 * <p>
 * desc: 字符串相乘
 *
 * @author YangBo
 * @date 2019/05/08
 */
class Multiply_0043 {
    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }

    public static String multiply(String num1, String num2) {
        char[] arr = new char[num1.length() + num2.length()];
        //乘法
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                // -'0'是为了将 ACSLL 码的字符转为数字
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        //处理进位
        int decimal = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] += decimal;
            decimal = arr[i] / 10;
            arr[i] %= 10;
        }
        //处理前端的0
        int beginIndex = 0;
        while (beginIndex < arr.length - 1 && arr[beginIndex] == 0) {
            beginIndex++;
        }
        // 将数字转换为 ACSLL 对应的字符数字
        for (int i = beginIndex; i < arr.length; i++) {
            arr[i] += '0';
        }
        return new String(arr, beginIndex, arr.length - beginIndex);
    }

}
