package cc.caker.leetcode.problems;

import cc.caker.common.util.MockUtils;
import cc.caker.common.util.PrintUtils;
import cc.caker.leetcode.model.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author cakeralter
 * @date 2021/5/23
 * @see https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @since 1.0
 */
public class ReverseNodesInKGroup {

    static ListNode tail;

    /**
     * reverseKGroup
     * TODO 递归实现 空间复杂度不达标
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        int i = 1;
        while (i * k <= len) {
            head = reverseBetween(head, (i - 1) * k + 1, i * k);
            i++;
        }
        return head;
    }

    /**
     * reverseBetween
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        if (head.next == null) {
            return null;
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * reverseN
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tail = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

    public static void main(String[] args) {
        PrintUtils.print(reverseKGroup(MockUtils.buildListNode(5), 2));
        PrintUtils.print(reverseKGroup(MockUtils.buildListNode(5), 3));
        PrintUtils.print(reverseKGroup(MockUtils.buildListNode(5), 1));
        PrintUtils.print(reverseKGroup(MockUtils.buildListNode(1), 1));
    }
}
