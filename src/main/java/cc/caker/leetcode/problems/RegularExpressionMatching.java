package cc.caker.leetcode.problems;

/**
 * 10. 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * @author cakeralter
 * @date 2021/4/24
 * @since 1.0
 */
public class RegularExpressionMatching {

    /**
     * isMatch
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        // 完全匹配
        if(!p.contains(".") && !p.contains("*") && !p.equals(s)) {
            return false;
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("a", "a*"));
        System.out.println(isMatch("aaaaaaaa", "a*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
        System.out.println(isMatch("aaaabbbbccccdddd", ".*b*c*.*"));
        System.out.println(isMatch("aaaabbbbccccdddd", ".*"));
        System.out.println(isMatch("aaaabbbbccccdddd", "."));
        System.out.println(isMatch("aaaabbbbccccdddd", "a*b*c*d"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaaa", "aaa"));
        System.out.println(isMatch("aaa", "aaaa"));
        System.out.println(isMatch("aaaaa", "a*a"));
    }
}
