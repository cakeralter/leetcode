package cc.caker.leetcode.problems;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 226. 翻转二叉树
 * <p>
 * 翻转一棵二叉树。
 *
 * @author cakeralter
 * @date 2021/5/21
 * @see https://leetcode-cn.com/problems/invert-binary-tree/
 * @since 1.0
 */
public class InvertBinaryTree {

    /**
     * invertTree
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    /**
     * invert
     *
     * @param root
     */
    private static void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        invert(root.left);
        invert(root.right);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
}
