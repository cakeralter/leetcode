package cc.caker.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @author cakeralter
 * @date 2021/6/7
 * @see https://leetcode-cn.com/problems/pascals-triangle/
 * @since 1.0
 */
public class PascalsTriangle {

    /**
     * generate
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            if (i == 1) {
                row.add(1);
            } else {
                List<Integer> last = triangle.get(i - 2);
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        row.add(1);
                    } else {
                        row.add(last.get(j - 1) + last.get(j));
                    }
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
