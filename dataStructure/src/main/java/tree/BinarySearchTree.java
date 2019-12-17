package tree;

/**
 * 二叉搜索树(BST)实现
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-11 23:58
 */
public class BinarySearchTree {

    /**
     * 根节点
     */
    private static TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * 查找
     * 树深(N) O(lgN)
     * 1. 从root节点开始
     * 2. 比当前节点值小,则找其左节点
     * 3. 比当前节点值大,则找其右节点
     * 4. 与当前节点值相等,查找到返回TRUE
     * 5. 查找完毕未找到,
     *
     * @param key
     * @return
     */
    public TreeNode search(int key) {
        TreeNode current = root;
        while (current != null
                && key != current.value) {
            if (key < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    /**
     * 插入
     * 1. 从root节点开始
     * 2. 如果root为空,root为插入值
     * 循环:
     * 3. 如果当前节点值大于插入值,找左节点
     * 4. 如果当前节点值小于插入值,找右节点
     *
     * @param key
     * @return
     */
    public TreeNode insert(int key) {
        // 新增节点
        TreeNode newNode = new TreeNode(key);
        // 当前节点
        TreeNode current = root;
        // 上个节点
        TreeNode parent = null;
        // 如果根节点为空
        if (current == null) {
            root = newNode;
            return newNode;
        }
        while (true) {
            parent = current;
            if (key < current.value) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return newNode;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return newNode;
                }
            }
        }
    }

    /**
     * 删除节点
     * 1.找到删除节点
     * 2.如果删除节点左节点为空 , 右节点也为空;
     * 3.如果删除节点只有一个子节点 右节点 或者 左节点
     * 4.如果删除节点左右子节点都不为空
     *
     */
    public TreeNode delete(int key) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        // 找到删除节点 及 是否在左子树
        while (current.value != key) {
            parent = current;
            if (current.value > key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }

            if (current == null) {
                return current;
            }
        }

        // 如果删除节点左节点为空 , 右节点也为空
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            // 在左子树
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // 如果删除节点只有一个子节点 右节点 或者 左节点
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }

        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // 如果删除节点左右子节点都不为空
        else if (current.left != null && current.right != null) {
            // 找到删除节点的后继者
            TreeNode successor = getDeleteSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return current;
    }

    /**
     * 获取删除节点的后继者
     * 删除节点的后继者是在其右节点树种最小的节点
     *
     * @param deleteNode
     * @return
     */
    private TreeNode getDeleteSuccessor(TreeNode deleteNode) {
        // 后继者
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode current = deleteNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        // 检查后继者(不可能有左节点树)是否有右节点树
        // 如果它有右节点树,则替换后继者位置,加到后继者父亲节点的左节点.
        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }

        return successor;
    }

    private void toString(TreeNode root) {
        if (root != null) {
            toString(root.left);
            System.out.print(" value = " + root.value);
            if (root.right != null) {
                System.out.print(" -> ");
            }
            toString(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);b.insert(1);b.insert(4);b.insert(6);
        b.insert(2);b.insert(10);b.insert(9);b.insert(20);b.insert(25);

        // 打印二叉树
        b.toString(root);
        System.out.println();

        // 是否存在节点值10
        TreeNode node01 = b.search(10);
        System.out.println("是否存在节点值为10 => " + node01.value);
        // 是否存在节点值11
        TreeNode node02 = b.search(11);
        System.out.println("是否存在节点值为11 => " + node02);

        // 删除节点8
        TreeNode node03 = b.delete(8);
        System.out.println("删除节点8 => " + node03.value);
        b.toString(root);
    }
}


