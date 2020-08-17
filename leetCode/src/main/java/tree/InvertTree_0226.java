package tree;

/**
 * 翻转二叉树
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-17 10:47
 */
public class InvertTree_0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
