package cc.caker.leetcode.problems;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author cakeralter
 * @date 2021/5/14
 * @see https://leetcode-cn.com/problems/longest-common-prefix/
 * @since 1.0
 */
public class LongestCommonPrefix {

    /**
     * longestCommonPrefix
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }

        // 最短字符串
        int minLen = 0;
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() <= minLen) {
                minLen = strs[i].length();
                minStr = strs[i];
            }
        }

        int index = 0;
        StringBuilder longest = new StringBuilder(strs[0].length());

        return longest.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"anhui", "anqing", "annan", "anyang"}));
    }
}
