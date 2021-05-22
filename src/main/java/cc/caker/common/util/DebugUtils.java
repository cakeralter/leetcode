package cc.caker.common.util;

/**
 * @author cakeralter
 * @date 2021/5/22
 * @since 1.0
 */
public interface DebugUtils {

    /**
     * printTab
     */
    static void printTab(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }
}
