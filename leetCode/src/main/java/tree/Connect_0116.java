package tree;

/**
 * 填充右节点
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-13 17:19
 */
public class Connect_0116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 输入两个节点，连接起来
     * @param left 左节点
     * @param right 右节点
     */
    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        // 连接节点
        left.next = right;
        // 连接相同父节点的两个子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        // 核心：连接跨越父节点的两个子节点
        connectTwoNode(left.right, right.left);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};