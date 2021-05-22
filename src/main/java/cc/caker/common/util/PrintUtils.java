package cc.caker.common.util;

import cc.caker.leetcode.model.ListNode;

import java.util.List;

/**
 * @author cakeralter
 * @date 2021/5/20
 * @since 1.0
 */
public interface PrintUtils {

    /**
     * printList
     *
     * @param list
     * @param <T>
     */
    static <T> void print(List<T> list) {
        System.out.print("[");
        list.forEach(e -> System.out.print(e + " "));
        System.out.println("]");
    }

    /**
     * print
     *
     * @param head
     */
    static void print(ListNode head) {
        System.out.print("[");
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println("]");
    }

    /**
     * printIndent
     *
     * @param n
     */
    static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }
}
