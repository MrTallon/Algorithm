package list;

import java.util.Random;

/**
 * 跳跃表
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-26 17:18
 */
public class SkipList<T extends Comparable<? super T>> {
    private int maxLevel;
    private SkipList<T>[] root;
    private int[] powers;
    private Random rd = new Random();

    SkipList() {
        this(4);
    }

    SkipList(int i) {
        maxLevel = i;
        root = new SkipList[maxLevel];
        powers = new int[maxLevel];
        for (int j = 0; j < maxLevel; j++) {
            root[j] = null;
        }
        choosePowers();
    }

    public boolean isEmpty() {
        return root[0] == null;
    }

    public void choosePowers() {
        powers[maxLevel - 1] = (2 << (maxLevel - 1)) - 1;
        for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++) {
            powers[i] = powers[i + 1] - (2 << j);
        }
    }

    public int chooseLevel() {
        int i, r = Math.abs(rd.nextInt()) % powers[maxLevel - 1] + 1;
        for (i = 0; i < maxLevel; i++) {
            if (r < powers[i]) {
                return i - 1;
            }
        }
        return i - 1;
    }

    // TODO https://blog.csdn.net/u013709270/article/details/53470428
}
