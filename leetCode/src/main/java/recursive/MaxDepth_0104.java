package recursive;

/**
 * 二叉树的最大深度
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-07-28 10:04
 */
public class MaxDepth_0104 {
    public int maxDepth(Tree root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Tree {
    int val;
    Tree left;
    Tree right;

    Tree(int x) {
        val = x;
    }
}
