package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 重复子树
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * <p>
 * 题解：
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=126&sessionid=1602582017&key=f87c13d2d4a2ca88a7e85a73f7413523153eb88705f23a0e8e2bcc2dfc06d31b0525945faac91053bb50b2161ea5005ff123af4ab54f3b346f8e695048a208e19477efc38e569ff6042c7075620000e4b7eeb481d4e08cf4bffd48b1ecbbe38c16c46d309814c629f323508749e5f2838e71cde3334fc35483d5776bce38b16a&ascene=1&uin=MjAyMzE1NTQwNQ%3D%3D&devicetype=Windows+10+x64&version=62090538&lang=zh_CN&exportkey=AUz3h6vS8%2B5v9WJfYZlIySI%3D&pass_ticket=2Mo9QaPuZF093k%2FIQZZXebSPfnYL9l8HGqmt3zoua4ikJHM2xmwcMSRdOCu3QAov&wx_header=0
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-13 17:42
 */
public class FindDuplicateSubtrees_0652 {

    /**
     * 记录所有子树
     */
    Map<String, Integer> memo = new HashMap<>();

    /**
     * 记录重复的子树根节点
     */
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        // 特殊字符表示空节点
        if (root == null) {
            return "#";
        }
        // 左右子树序列成字符串
        String left = traverse(root.left);
        String right = traverse(root.right);
        // 后序遍历描述一颗二叉树
        String result = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(result, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(result, freq + 1);
        return result;
    }

}
