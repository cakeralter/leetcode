package cc.caker.leetcode.problems;

/**
 * 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author cakeralter
 * @date 2021/4/4
 * @since 1.0
 */
public class LongestPalindromicSubstring {

    /**
     * longestPalindrome
     * TODO 动态规划优化
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        String longest = "";
        int longestLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + longestLength; j < length; j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring)) {
                    longest = substring;
                    longestLength = longest.length();
                }
                if (longestLength > length / 2 && i > length / 2) {
                    break;
                }
            }
        }
        return longest;
    }

    /**
     * isPalindrome
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("eccsaabccbaeeead"));
        System.out.println(longestPalindrome("miycvxmqggnmmcwlmizfojwrurwhwygwfykyefxbgveixykdebenzitqnciigfjgrzzbtgeazyrbiirmejhdwcgjzwqolrturjlqpsgunuqerqjevbheblmbvgxyedxshswsokbhzapfuojgyfhctlaifrisgzqlczageirnukgnmnbwogknyyuynwsuwbumdmoqwxprykmazghcpmkdcjduepjmjdxrhvixxbfvhybjdpvwjbarmbqypsylgtzyuiqkexgvirzylydrhrmuwpmfkvqllqvekyojoacvyrzjevaupypfrdguhukzuqojolvycgpjaendfetkgtojepelhcltorueawwjpltehbbjrvznxhahtuaeuairvuklctuhcyzomwrrznrcqmovanxmiyilefybkbveesrxkmqrqkowyrimuejqtikcjfhizsmumajbqglxrvevexnleflocxoqgoyrzgqflwiknntdcykuvdcpzlakljidclhkllftxpinpvbngtexngdtntunzgahuvfnqjedcafzouopiixw"));

        System.out.println(isPalindrome("abccba"));
        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("aba"));
    }
}
