package cc.caker.leetcode.problems;

import cc.caker.leetcode.model.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author cakeralter
 * @date 2021/5/24
 * @see https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @since 1.0
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * removeNthFromEnd
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        // fast先跑n步
        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        // 删除头节点
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
