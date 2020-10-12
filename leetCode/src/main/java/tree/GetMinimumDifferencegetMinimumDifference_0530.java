package tree;

/**
 * 最小绝对值(中序遍历)
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-12 10:07
 */
public class GetMinimumDifferencegetMinimumDifference_0530 {
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
