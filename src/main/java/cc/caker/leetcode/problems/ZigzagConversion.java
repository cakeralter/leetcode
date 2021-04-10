package cc.caker.leetcode.problems;

import java.util.Arrays;

/**
 * Z 字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * @author cakeralter
 * @date 2021/4/10
 * @see https://leetcode-cn.com/problems/zigzag-conversion/
 * @since 1.0
 */
public class ZigzagConversion {

    /**
     * convert
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        int length = s.length(), width = length, height = numRows;
        boolean up = false;
        char[][] chars = new char[height][width];
        int index = 0, i = -1, j = 0;
        while (index < length) {
            if(up) {
                i--;
                j++;
            } else {
                i++;
            }
            chars[i][j] = s.charAt(index++);
            if (i == 0) {
                // 下移
                up = false;
            }
            if (i == height - 1) {
                up = true;
            }
        }

        StringBuilder builder = new StringBuilder(s.length());
        for (i = 0; i < chars.length; i++) {
            for(j = 0; j< chars[i].length; j++) {
                if(chars[i][j] != '\u0000') {
                    builder.append(chars[i][j]);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(convert("PAYPALISHIRING", 3));
//        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("ABC", 2));
    }
}
