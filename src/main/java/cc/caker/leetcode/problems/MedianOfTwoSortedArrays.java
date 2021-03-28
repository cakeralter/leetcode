package cc.caker.leetcode.problems;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * @author cakeralter
 * @date 2021/3/28
 * @since 1.0
 */
public class MedianOfTwoSortedArrays {

    /**
     * TODO 时间复杂度不达标
     * findMedianSortedArrays
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] summary = new int[len];
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            int num1 = nums1[p1], num2 = nums2[p2];
            if (num1 <= num2) {
                summary[p1 + p2] = num1;
                p1++;
            } else {
                summary[p1 + p2] = num2;
                p2++;
            }
        }

        while (p1 < nums1.length) {
            summary[p2 + p1] = nums1[p1++];
        }

        while (p2 < nums2.length) {
            summary[p1 + p2] = nums2[p2++];
        }

        if (len % 2 == 0) {
            return (double) (summary[len / 2 - 1] + summary[len / 2]) / 2;
        } else {
            return summary[len / 2];
        }
    }

    public static void main(String[] args) {

//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
//        int[] nums1 = new int[]{1, 2};
//        int[] nums2 = new int[]{3, 4};
//        int[] nums1 = new int[]{};
//        int[] nums2 = new int[]{1};
//        int[] nums1 = new int[]{2};
//        int[] nums2 = new int[]{};
        int[] nums1 = new int[]{1, 4, 5, 6, 8};
        int[] nums2 = new int[]{2, 4, 6, 9, 12, 13, 14, 15};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
