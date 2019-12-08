package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Algs包中一些常用参数
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class AlgsMethod {

    public static void main(String[] args) {
        /* StdRandom */
        //设置随机生成器的种子
        StdRandom.setSeed(100);
        //[0,1)之间的随机数
        double num = StdRandom.random();
        //[0,n)之间的整数
        int num2 = StdRandom.uniform(100);
        //[l0,hi)之间的整数
        int num3 = StdRandom.uniform(10, 100);
        //(lo,hi]之间的实数
        double num4 = StdRandom.uniform(10.0d, 100.0d);
        //返回真的概率为5
        boolean num5 = StdRandom.bernoulli(5.5);
        //正态分布，期望值为0，标准差为1
        double num6 = StdRandom.gaussian();
        //正态分布，期望值为1，标准差为是5
        double num7 = StdRandom.gaussian(1.0, 5.0);
        //返回i的概率为a[i]
        int[] a = {2, 3, 4, 5};
        int num8 = StdRandom.discrete(a);
        //将数组a随机排序
        StdRandom.shuffle(a);

        /* StdStats */
        //最大值
        double num9 = StdStats.max(a);
        //最小值
        double num10 = StdStats.min(a);
        //平均值
        double num11 = StdStats.mean(a);
        //采样方差
        double num12 = StdStats.var(a);
        //采样标准差
        double num13 = StdStats.stddev(a);
        //中位数（存疑）

        /* StdIn */
        //如果输入流中没有剩余值返回true
        boolean num14 = StdIn.isEmpty();
        //读取一个int类型的值
        int num15 = StdIn.readInt();
        //读取一个double类型的值
        double num16 = StdIn.readDouble();
        //读取一个float类型的值
        float num17 = StdIn.readFloat();
        //读取一个long类型的值
        long num18 = StdIn.readLong();
        //读取一个boolean类型的值
        boolean num19 = StdIn.readBoolean();
        //读取一个char类型的值
        char num20 = StdIn.readChar();
        //读取一个byte类型的值
        byte num21 = StdIn.readByte();
        //读取一个String类型的值
        String num22 = StdIn.readString();
        //输入流中是否还有下一行
        boolean num23 = StdIn.hasNextLine();
        //读取改行的其他内容
        String num24 = StdIn.readLine();
        //读取输入流中其余内容
        String num25 = StdIn.readAll();

    }

}
