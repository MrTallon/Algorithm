package tree;

/**
 * 判断平衡二叉树
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-17 09:52
 */
public class IsBalanced_0110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
