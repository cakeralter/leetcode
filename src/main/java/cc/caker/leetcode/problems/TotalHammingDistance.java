package cc.caker.leetcode.problems;

/**
 * 477. 汉明距离总和
 * <p>
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * @author cakeralter
 * @date 2021/5/28
 * @see https://leetcode-cn.com/problems/total-hamming-distance/
 * @since 1.0
 */
public class TotalHammingDistance {

    /**
     * totalHammingDistance
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int i = 0;
        while (i < 32) {
            int c0 = 0;
            int c1 = 0;
            for (int num : nums) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    c0++;
                } else {
                    c1++;
                }
            }
            total += (c0 * c1);
            i++;
        }
        return total;
    }
}
