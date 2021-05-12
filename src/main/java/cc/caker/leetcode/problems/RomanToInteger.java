package cc.caker.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * @author cakeralter
 * @date 2021/5/12
 * @see https://leetcode-cn.com/problems/roman-to-integer/
 * @since 1.0
 */
public class RomanToInteger {

    private static final Map<String, Integer> MAP = new HashMap<>(13);

    static {
        MAP.put("M", 1000);
        MAP.put("CM", 900);
        MAP.put("D", 500);
        MAP.put("CD", 400);
        MAP.put("C", 100);
        MAP.put("XC", 90);
        MAP.put("L", 50);
        MAP.put("XL", 40);
        MAP.put("X", 10);
        MAP.put("IX", 9);
        MAP.put("V", 5);
        MAP.put("IV", 4);
        MAP.put("I", 1);
    }

    public static int romanToInt(String s) {
        int num = 0;
        int i = 0, len = s.length();
        while (i < len) {
            if (i + 1 < len) {
                String key = s.substring(i, i + 2);
                Integer value = MAP.get(key);
                if (value != null) {
                    num += value;
                    i += 2;
                    continue;
                }
            }
            Integer value = MAP.get(s.substring(i, i + 1));
            num += value;
            i++;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
