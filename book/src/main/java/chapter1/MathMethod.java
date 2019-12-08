package chapter1;

/**
 * Math中常用方法
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class MathMethod {
    public static void main(String[] agrs) {
        //常量PI
        System.out.println(Math.PI);
        //常量e
        System.out.println(Math.E);

        //ring 四舍五入，返回double(10.5异常)
        System.out.println(Math.rint(10.5));
        System.out.println(Math.rint(-10.5));

        //round 四舍五入 flout时返回int，double时返回lang
        System.out.println(Math.round(10.5d));
        System.out.println(Math.round(-10.5f));

        //ceil 天花板 向上取整
        System.out.println(Math.ceil(10.5));
        System.out.println(Math.ceil(-11.1));

        //floor 地板 向下取整
        System.out.println(Math.floor(10.9));
        System.out.println(Math.floor(-11.1));

        //random 取[0,1)之间的随机数
        System.out.println(Math.random());

        //sqrt 计算平方根
        System.out.println(Math.sqrt(16));
        //cbrt 计算立方根
        System.out.println(Math.cbrt(8));
        //pow 计算a的b次方
        System.out.println(Math.pow(2, 3));
        //max 两者最大值
        System.out.println(Math.max(1, 10));
        //min 两者最小值
        System.out.println(Math.min(1, 10));
        //abs 绝对值
        System.out.println(Math.abs(-10.8));

        //log 计算以e为底的对数
        System.out.println(Math.log(Math.E));
        //指数函数 计算以e为底的10次方
        System.out.println(Math.exp(10));

        //正弦函数
        System.out.println(Math.sin(10.0));
        //余弦函数
        System.out.println(Math.cos(10.0));
        //正切函数
        System.out.println(Math.tan(10));

    }
}
