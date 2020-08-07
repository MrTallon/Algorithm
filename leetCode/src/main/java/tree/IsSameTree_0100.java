package tree;

/**
 * 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-07 09:48
 */
public class IsSameTree_0100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
