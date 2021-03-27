package cc.caker.leetcode.problems;

/**
 * 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author cakeralter
 * @date 2021/3/25
 * @see https://leetcode-cn.com/problems/add-two-numbers/
 * @since 1.0
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * TODO
     * addTwoNumbers
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, sum = new ListNode(), p0 = sum;
        // 进位
        int carry = 0;
        while (true) {
            int val;
            if (p1 == null) {
                val = p2.val + carry;
                p2 = p2.next;
                if (val > 9) {
                    val -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
            } else if (p2 == null) {
                val = p1.val + carry;
                p1 = p1.next;
                if (val > 9) {
                    val -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
            } else {
                val = p1.val + p2.val + carry;
                p1 = p1.next;
                p2 = p2.next;
                if (val > 9) {
                    val -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            p0.val = val;

            if (p1 == null && p2 == null) {
                if (carry > 0) {
                    p0.next = new ListNode(carry);
                }
                break;
            }
            p0.next = new ListNode();
            p0 = p0.next;
        }

        return sum;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        System.out.println(addTwoNumbers(l1, l2));
    }
}
