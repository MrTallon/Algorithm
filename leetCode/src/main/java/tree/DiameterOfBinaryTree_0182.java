package tree;

/**
 * 求二叉树的直径
 * 递归+动态规划
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-10 02:00
 */
public class DiameterOfBinaryTree_0182 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        setDeep(root);
        return diameter;
    }

    private int setDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = setDeep(root.left);
        int right = setDeep(root.right);
        if (left + right > diameter) {
            diameter = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
