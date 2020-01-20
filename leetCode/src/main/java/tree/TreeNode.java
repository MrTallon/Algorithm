package tree;

/**
 * Tree 练习
 *
 * @author YangBo
 * @date 2019/04/23
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    private TreeNode(int x) {
        this.val = x;
    }

    private void insert(int value) {
        // ge to left
        if (value <= val) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        }
        // go to right
        else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    private boolean contains(int value) {
        if (value == val) {
            return true;
        } else if (value < val) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    /**
     * 中序
     */
    private void pringInOrder() {
        if (left != null) {
            left.pringInOrder();
        }
        System.out.println(val);
        if (right != null) {
            right.pringInOrder();
        }
    }
}
