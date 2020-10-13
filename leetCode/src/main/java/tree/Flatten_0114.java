package tree;

/**
 * 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * 题解：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-13 17:29
 */
public class Flatten_0114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // 后续遍历
        // 1. 左右子树拉平
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2. 左子树作为右子树
        root.left = null;
        root.right = left;

        //3. 右子树接在左子树末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
