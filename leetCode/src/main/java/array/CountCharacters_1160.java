package array;

/**
 * 字母表
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-17 11:23
 */
public class CountCharacters_1160 {

    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0 || words == null || words.length == 0) {
            return 0;
        }
        int[] charsCount = count(chars);
        int res = 0;
        for (String word : words) {
            int[] wordCount = count(word);
            if (contains(charsCount, wordCount)) {
                res += word.length();
            }
        }
        return res;
    }

    /**
     * 次数对比
     */
    boolean contains(int[] chars_count, int[] word_count) {
        for (int i = 0; i < 26; i++) {
            if (chars_count[i] < word_count[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计出现的个数
     */
    int[] count(String word) {
        int[] counter = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            counter[c - 'a']++;
        }
        return counter;
    }
}
