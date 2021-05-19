package cc.caker.leetcode.problems;

import java.util.Arrays;

/**
 * 1738. 找出第 K 大的异或坐标值
 * <p>
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的值可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * @author cakeralter
 * @date 2021/5/19
 * @see https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * @since 1.0
 */
public class FindKthLargestXorCoordinateValue {

    /**
     * kthLargestValue
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthLargestValue(int[][] matrix, int k) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0];
        }
        int[][] xors = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int xor = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    xors[0][0] = matrix[0][0];
                } else if (i == 0) {
                    xors[0][j] = xors[0][j - 1] ^ matrix[0][j];
                } else if (j == 0) {
                    xors[i][0] = xors[i - 1][0] ^ matrix[i][0];
                } else {
                    xor ^= matrix[i][j];
                    xors[i][j] = xor ^ xors[i - 1][j];
                }
            }
        }

        // 排序
        // TODO perf: 小顶堆求第K大的数
        int[] array = new int[xors.length * xors[0].length];
        for (int i = 0; i < xors.length; i++) {
            for (int j = 0; j < xors[0].length; j++) {
                array[i * xors[0].length + j] = xors[i][j];
            }
        }
        Arrays.sort(array);
        return array[array.length - k];
    }

    public static void main(String[] args) {
        /*System.out.println(kthLargestValue(new int[][]{
                new int[]{5, 2}, new int[]{1, 6}
        }, 1));
        System.out.println(kthLargestValue(new int[][]{
                new int[]{5, 2}, new int[]{1, 6}
        }, 2));
        System.out.println(kthLargestValue(new int[][]{
                new int[]{5, 2}, new int[]{1, 6}
        }, 3));
        System.out.println(kthLargestValue(new int[][]{
                new int[]{5, 2}, new int[]{1, 6}
        }, 4));*/
        System.out.println(kthLargestValue(new int[][]{
                new int[]{10, 9, 5}, new int[]{2, 0, 4},
                new int[]{1, 0, 9}, new int[]{3, 4, 8}
        }, 10));
    }
}
