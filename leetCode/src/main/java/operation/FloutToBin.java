package operation;

/**
 * (0,1)之间的double实数（0.625）转化为二进制（0.101）
 * 思路：乘2挪去整数
 *
 * @author YangBo
 * @date 2019/08/22
 */
public class FloutToBin {
    public static void main(String[] args) {
        System.out.println(method(0.3));
    }

    private static String method(double x) {
        StringBuffer sb = new StringBuffer();
        sb.append("0.");
        while (x != 0) {
            x *= 2;
            if (x >= 1) {
                x -= 1;
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        if (sb.length() > 34) {
            return "ERROR";
        }
        return sb.toString();
    }
}
