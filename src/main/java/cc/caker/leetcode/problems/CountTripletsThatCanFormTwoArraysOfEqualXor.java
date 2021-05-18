package cc.caker.leetcode.problems;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * <p>
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * @author cakeralter
 * @date 2021/5/18
 * @since 1.0
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXor {

    /**
     * countTriplets
     * <p>
     * a == b
     * =>
     * a ^ b = 0
     * =>
     * arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] ^ arr[j] ^ arr[j + 1] ^ ... ^ arr[k] = 0
     *
     * @param arr
     * @return
     */
    public static int countTriplets(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                xor ^= arr[k];
                if (xor == 0) {
                    count += (k - i);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(countTriplets(new int[]{2, 3}));
        System.out.println(countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
        System.out.println(countTriplets(new int[]{218, 218}));
    }
}
