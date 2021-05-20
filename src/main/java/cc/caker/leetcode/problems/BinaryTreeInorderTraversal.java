package cc.caker.leetcode.problems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @author cakeralter
 * @date 2021/5/20
 * @see https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @since 1.0
 */
public class BinaryTreeInorderTraversal {

    /**
     * inorderTraversal
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list, root);
        return list;
    }

    /**
     * traversal
     *
     * @param list
     * @param node
     */
    private static void traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(list, node.left);
        list.add(node.val);
        traversal(list, node.right);
    }

    @Data
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
