package cc.caker.leetcode.problems;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author cakeralter
 * @date 2021/5/21
 * @see https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @since 1.0
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * flatten
     * <p>
     * 1、将 root 的左子树和右子树拉平。
     * 2、将 root 的右子树接到左子树下方，然后将整个左子树作为右子树。
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        // 左子树挂到右子树位置
        root.right = root.left;
        // 左子树置空
        root.left = null;

        // 右子树挂到左子树后面
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
    }
}
