package cc.caker.leetcode.problems;

/**
 * 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * @author cakeralter
 * @date 2021/4/11
 * @see https://leetcode-cn.com/problems/reverse-integer/
 * @since 1.0
 */
public class ReverseInteger {

    /**
     * reverse
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (int) result == result ? (int) result : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(1534236469));
    }
}
