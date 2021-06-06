package cc.caker.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author cakeralter
 * @date 2021/6/5
 * @see https://leetcode-cn.com/problems/minimum-window-substring/
 * @since 1.0
 */
public class MinimumWindowSubstring {

    /**
     * minWindow
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(t.length()), window = new HashMap<>(t.length());
        for (char c : t.toCharArray()) {
            Integer count = need.getOrDefault(c, 0);
            need.put(c, count + 1);
        }

        int left = 0, right = 0;
        int valid = 0, start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char cR = s.charAt(right++);
            if (need.containsKey(cR)) {
                Integer count = window.getOrDefault(cR, 0);
                count++;
                window.put(cR, count);
                if (Objects.equals(count, need.get(cR))) {
                    valid++;
                }
            }

            System.out.printf("window[%d, %d)\n", left, right);

            // 缩小窗口
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char cL = s.charAt(left++);
                if (need.containsKey(cL)) {
                    Integer count = window.get(cL);
                    if (Objects.equals(count, need.get(cL))) {
                        valid--;
                    }
                    window.put(cL, count - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "aa"));
    }
}
