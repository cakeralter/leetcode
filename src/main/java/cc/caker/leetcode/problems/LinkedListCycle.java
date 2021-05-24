package cc.caker.leetcode.problems;

import cc.caker.leetcode.model.ListNode;

/**
 * 141. 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author cakeralter
 * @date 2021/5/24
 * @since 1.0
 */
public class LinkedListCycle {

    /**
     * hasCycle
     *
     * @param head
     * @return
     * @see https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488584&idx=1&sn=90f7956fd9d8320fcb81aaf33c3fe7f1&chksm=9bd7ea40aca06356cdb87ba86518c50646b48b8534d42625ba454c084187400b979c8d736a61&scene=21#wechat_redirect
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
