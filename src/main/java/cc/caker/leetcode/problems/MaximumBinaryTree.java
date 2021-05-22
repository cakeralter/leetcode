package cc.caker.leetcode.problems;

import cc.caker.leetcode.model.TreeNode;

/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * @author cakeralter
 * @date 2021/5/22
 * @see https://leetcode-cn.com/problems/maximum-binary-tree/
 * @since 1.0
 */
public class MaximumBinaryTree {

    /**
     * constructMaximumBinaryTree
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     * buildTree
     *
     * @param nums
     * @param start
     * @param end
     */
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 最大值下标
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        if (maxIndex > start) {
            root.left = buildTree(nums, start, maxIndex - 1);
        }
        if (maxIndex + 1 <= end) {
            root.right = buildTree(nums, maxIndex + 1, end);
        }
        return root;
    }
}
