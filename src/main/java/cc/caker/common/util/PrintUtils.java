package cc.caker.common.util;

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
    static <T> void printList(List<T> list) {
        System.out.print("[");
        list.forEach(e -> System.out.print(e + " "));
        System.out.println("]");
    }
}
