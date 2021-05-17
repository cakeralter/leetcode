package cc.caker.leetcode.problems;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 993. 二叉树的堂兄弟节点
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * @author cakeralter
 * @date 2021/5/17
 * @see https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @since 1.0
 */
public class CousinsInBinaryTree {

    @NoArgsConstructor
    @AllArgsConstructor
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    static int xParentVal, xDepth, yParentVal, yDepth;

    /**
     * isCousins
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y || root.val == x || root.val == y) {
            return false;
        }
        preDfs(root, null, 0, x, y);
        return xDepth == yDepth && xParentVal != yParentVal;
    }

    private static void preDfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xParentVal = parent.val;
            xDepth = depth;
        }
        if (node.val == y) {
            yParentVal = parent.val;
            yDepth = depth;
        }
        preDfs(node.left, node, depth + 1, x, y);
        preDfs(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {

    }
}
