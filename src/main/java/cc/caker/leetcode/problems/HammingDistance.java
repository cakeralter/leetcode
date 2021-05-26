package cc.caker.leetcode.problems;

/**
 * 461. 汉明距离
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * @author cakeralter
 * @date 2021/5/27
 * @see https://leetcode-cn.com/problems/hamming-distance/
 * @since 1.0
 */
public class HammingDistance {

    /**
     * hammingDistance
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        x ^= y;
        y = 0;
        while (x != 0) {
            y += (x & 1);
            x >>= 1;
        }
        return y;
    }
}
