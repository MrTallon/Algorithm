package tree;

/**
 * 对称二叉树
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-17 10:27
 */
public class IsSymmetric_0101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }
}
