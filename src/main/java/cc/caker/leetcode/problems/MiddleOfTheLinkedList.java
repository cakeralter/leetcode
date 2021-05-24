package cc.caker.leetcode.problems;

import cc.caker.leetcode.model.ListNode;

/**
 * 876. 链表的中间结点
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author cakeralter
 * @date 2021/5/24
 * @see https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @since 1.0
 */
public class MiddleOfTheLinkedList {

    /**
     * middleNode
     * 快慢指针
     * 快指针每次走两步，慢指针每次走一步，当快指针跑完时，慢指针位置即是中间点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
