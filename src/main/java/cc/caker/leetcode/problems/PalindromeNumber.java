package cc.caker.leetcode.problems;

/**
 * 9. 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @author cakeralter
 * @date 2021/4/24
 * @since 1.0
 */
public class PalindromeNumber {

    /**
     * isPalindrome
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x, inverse = 0;
        while (x != 0) {
            inverse = inverse * 10 + x % 10;
            x /= 10;
        }
        return origin == inverse;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(764535467));
    }
}
