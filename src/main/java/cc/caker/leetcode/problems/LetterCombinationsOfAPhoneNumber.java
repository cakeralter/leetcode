package cc.caker.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author cakeralter
 * @date 2021/5/15
 * @see https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @since 1.0
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * letterCombinations
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return Collections.emptyList();
        }

        // 字符映射数组
        Map<Character, String> map = new HashMap<>(7);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> combinationList = new ArrayList<>();
        for (char c : map.get(digits.charAt(0)).toCharArray()) {
            combinationList.add(String.valueOf(c));
        }
        List<String> temp = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            temp.clear();
            for (String s : combinationList) {
                temp.addAll(combinations(s, map.get(digits.charAt(i))));
            }
            combinationList.clear();
            combinationList.addAll(temp);
        }
        return combinationList;
    }

    /**
     * combinations
     *
     * @param str1
     * @param str2
     * @param combinationList
     */
    private static List<String> combinations(String str1, String str2) {
        List<String> combinationList = new ArrayList<>(str2.length());
        for (int i = 0; i < str2.length(); i++) {
            combinationList.add(str1 + str2.charAt(i));
        }
        return combinationList;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("298").toArray()));
    }
}
