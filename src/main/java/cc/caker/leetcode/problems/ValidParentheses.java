package main.java.cc.caker.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author cakeralter
 * @date 2021/8/6
 * @see https://leetcode-cn.com/problems/valid-parentheses/
 * @since 1.0
 */
public class ValidParentheses {

    /**
     * isValid
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        List<Character> inStack = Arrays.asList('(', '{', '[');
        Deque<Character> stack = new ArrayDeque<>(length / 2);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 入栈
            if (inStack.contains(c)) {
                stack.push(c);
                continue;
            }
            // 出栈
            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();
            boolean valid = (top == '(' && c == ')')
                    || (top == '[' && c == ']')
                    || (top == '{' && c == '}');
            if (!valid) {
                return false;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
