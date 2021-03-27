package cc.caker.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author cakeralter
 * @date 2021/3/27
 * @since 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * TODO 滑动窗口进行优化
     * lengthOfLongestSubstring
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < chars.length; j++) {
                char c = chars[j];
                if (list.contains(c)) {
                    break;
                }
                list.add(c);
            }
            maxLen = Math.max(list.size(), maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int length = lengthOfLongestSubstring("abcabcbb");
//        int length = lengthOfLongestSubstring("bbbbb");
//        int length = lengthOfLongestSubstring("pwwkew");
        int length = lengthOfLongestSubstring("");

        System.out.println(length);
    }
}
