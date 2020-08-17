package tree;

/**
 * 最小深度
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-17 10:36
 */
public class MinDepth_0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        if (root.left != null) {
            result = Math.min(result, minDepth(root.left));
        }
        if (root.right != null) {
            result = Math.min(result, minDepth(root.right));
        }
        return result + 1;
    }
}
