package cc.caker.leetcode.problems;

import cc.caker.leetcode.model.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author cakeralter
 * @date 2021/5/22
 * @see https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @since 1.0
 */
public class FanZhuanLianBiaoLcof {

    /**
     * reverseList
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode next = reverseList(head.next);
        ListNode p = next;
        while (p.next != null) {
            p = p.next;
        }
        head.next = null;
        p.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), p = head;
        int i = 2;
        while (i <= 5) {
            p.next = new ListNode(i);
            p = p.next;
            i++;
        }

        ListNode res = reverseList(head);
        System.out.println();
    }
}
