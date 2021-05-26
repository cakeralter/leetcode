package cc.caker.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * <p>
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * @author cakeralter
 * @date 2021/5/26
 * @see https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @since 1.0
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    /**
     * reverseParentheses
     *
     * @param s
     * @return
     */
    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        Deque<Character> stack = new ArrayDeque<>();
        // 栈内括号对数
        int bracketCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    bracketCount++;
                    stack.push(c);
                    break;
                case ')':
                    bracketCount--;
                    StringBuilder esb = new StringBuilder();
                    char e;
                    while ((e = stack.pop()) != '(') {
                        esb.append(e);
                    }
                    if (bracketCount == 0) {
                        sb.append(esb);
                    } else {
                        for (int j = 0; j < esb.length(); j++) {
                            stack.push(esb.charAt(j));
                        }
                    }
                    break;
                default:
                    if (bracketCount == 0) {
                        sb.append(c);
                    } else {
                        stack.push(c);
                    }
                    break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
