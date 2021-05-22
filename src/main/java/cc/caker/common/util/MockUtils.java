package cc.caker.common.util;

import cc.caker.leetcode.model.ListNode;

/**
 * @author cakeralter
 * @date 2021/5/22
 * @since 1.0
 */
public interface MockUtils {

    /**
     * buildListNode
     *
     * @param nums
     * @return
     */
    static ListNode buildListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }

    /**
     * buildListNode
     *
     * @param size
     * @return
     */
    static ListNode buildListNode(int size) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i + 1;
        }
        return buildListNode(nums);
    }
}
