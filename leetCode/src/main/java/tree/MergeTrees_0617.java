package tree;

/**
 * 合并二叉树
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-17 10:58
 */
public class MergeTrees_0617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
