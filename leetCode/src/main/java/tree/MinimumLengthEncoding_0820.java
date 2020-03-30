package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 字母表(字典树)
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-28 09:38
 */
public class MinimumLengthEncoding_0820 {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k) {
                set.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word : set) {
            ans += word.length() + 1;
        }
        return ans;
    }

    /**
     * 字典树
     */
    public int tree(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node : nodes.keySet()) {
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }
}

class TrieNode {
    TrieNode[] children;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrieNode trieNode = (TrieNode) o;

        if (count != trieNode.count) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(children, trieNode.children);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(children);
        result = 31 * result + count;
        return result;
    }
}
