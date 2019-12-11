package tree;


/**
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-11 23:59
 */
public class TreeNode {

    /**
     * 节点值
     */
    int value;

    /**
     * 左节点
     */
    TreeNode left;

    /**
     * 右节点
     */
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

