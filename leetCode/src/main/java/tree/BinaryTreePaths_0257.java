package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-09-04 09:42
 */
public class BinaryTreePaths_0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(root.val);
            // 当前节点是叶子节点
            if (root.left == null && root.right == null) {
                // 把路径加入到答案中
                paths.add(pathSB.toString());
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
