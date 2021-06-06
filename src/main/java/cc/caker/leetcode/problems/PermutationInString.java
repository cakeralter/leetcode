package cc.caker.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 567. 字符串的排列
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * @author cakeralter
 * @date 2021/6/6
 * @see https://leetcode-cn.com/problems/permutation-in-string/
 * @since 1.0
 */
public class PermutationInString {

    /**
     * checkInclusion
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(s1.length()),
                window = new HashMap<>(s1.length());
        for (char c : s1.toCharArray()) {
            Integer count = need.getOrDefault(c, 0);
            need.put(c, count + 1);
        }
        int left = 0, right = 0, valid = 0;

        while (right < s2.length()) {
            char cr = s2.charAt(right++);
            if (need.containsKey(cr)) {
                Integer count = window.getOrDefault(cr, 0);
                count++;
                window.put(cr, count);
                if (Objects.equals(count, need.get(cr))) {
                    valid++;
                }
            }

            System.out.printf("window[%d, %d)\n", left, right);

            // 缩小窗口
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char cl = s2.charAt(left++);
                if (need.containsKey(cl)) {
                    Integer count = window.get(cl);
                    if (Objects.equals(count, need.get(cl))) {
                        valid--;
                    }
                    window.put(cl, count - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
