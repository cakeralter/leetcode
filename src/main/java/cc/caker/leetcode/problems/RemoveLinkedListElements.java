package cc.caker.leetcode.problems;

import cc.caker.common.util.MockUtils;
import cc.caker.common.util.PrintUtils;
import cc.caker.leetcode.model.ListNode;

/**
 * 203. 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @author cakeralter
 * @date 2021/6/5
 * @see https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @since 1.0
 */
public class RemoveLinkedListElements {

    /**
     * removeElements
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = MockUtils.buildListNode(new int[]{7, 7, 7, 7});
        ListNode result = removeElements(head, 7);
        PrintUtils.print(result);
    }
}
