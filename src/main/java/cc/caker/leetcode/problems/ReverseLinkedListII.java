package cc.caker.leetcode.problems;

import cc.caker.common.util.MockUtils;
import cc.caker.common.util.PrintUtils;
import cc.caker.leetcode.model.ListNode;

/**
 * 92. 反转链表 II
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @author cakeralter
 * @date 2021/5/22
 * @see https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @since 1.0
 */
public class ReverseLinkedListII {

    /**
     * reverseBetween
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    static ListNode tail;
    static int count = 0;

    /**
     * reverseN
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseN(ListNode head, int n) {
        PrintUtils.printIndent(count++);
        System.out.printf("head=%s, n=%d\n", head, n);
        if (n == 1) {
            PrintUtils.printIndent(--count);
            System.out.println("return head:" + head);
            tail = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
        PrintUtils.printIndent(--count);
        System.out.println("return last:" + head);
        return last;
    }

    public static void main(String[] args) {
        ListNode head = MockUtils.buildListNode(5);
        PrintUtils.print(head);
        ListNode reverseHead = reverseBetween(head, 2, 4);
        PrintUtils.print(reverseHead);
    }
}
