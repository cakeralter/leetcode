package cc.caker.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 421. 数组中两个数的最大异或值
 * <p>
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * @author cakeralter
 * @date 2021/5/16
 * @reference https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/python3-qiao-miao-li-yong-qian-zhui-shu-0alcy/
 * @see https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * @since 1.0
 */
public class MaximumXorOfTwoNumbersInAnArray {

    private static final int INT_MAX_BIT_LENGTH = 32;

    /**
     * findMaximumXOR
     *
     * @param nums
     * @return
     */
    public static int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 构建字典树
        TrieNode tree = new TrieNode();
        for (int num : nums) {
            tree.insert(num);
        }

        // 查询最大异或
        int maxXor = 0;
        for (int num : nums) {
            TrieNode currentNode = tree;
            for (int j = INT_MAX_BIT_LENGTH - 1; j >= 0; j--) {
                byte bit = (byte) (num >> j & 1);
                boolean exist = false;
                for (TrieNode child : currentNode.children) {
                    if ((child.value ^ bit) == 1) {
                        currentNode = child;
                        exist = true;
                        break;
                    }
                }
                if (!exist && !currentNode.children.isEmpty()) {
                    currentNode = currentNode.children.get(0);
                }

                int xor = num ^ currentNode.total;
                if (xor > maxXor) {
                    maxXor = xor;
                }
            }
        }

        return maxXor;
    }

    /**
     * 字典树节点
     */
    static class TrieNode {

        private byte value;
        private final List<TrieNode> children;
        private int total = -1;

        public TrieNode() {
            this.children = new ArrayList<>();
        }

        public TrieNode(byte value) {
            this();
            this.value = value;
        }

        /**
         * 插入节点
         *
         * @param value
         */
        public void insert(int value) {
            TrieNode currentNode = this;
            // 搜索插入位置
            for (int i = INT_MAX_BIT_LENGTH - 1; i >= 0; i--) {
                byte bit = (byte) (value >> i & 1);
                boolean exists = false;
                for (TrieNode child : currentNode.children) {
                    if (child.value == bit) {
                        currentNode = child;
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    TrieNode newNode = new TrieNode(bit);
                    currentNode.children.add(newNode);
                    currentNode = newNode;
                }
            }
            currentNode.total = value;
        }

        /**
         * search
         *
         * @param value
         * @return
         */
        public TrieNode search(int value) {
            return null;
        }

        /**
         * print
         */
        public void print(TrieNode root) {
            if (root.children.isEmpty()) {
                System.out.println(root.value);
                return;
            }
            for (TrieNode child : root.children) {
                print(child);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(findMaximumXOR(new int[]{0}));
        System.out.println(findMaximumXOR(new int[]{1}));
        System.out.println(findMaximumXOR(new int[]{2, 4}));
        System.out.println(findMaximumXOR(new int[]{8, 10, 2}));
        System.out.println(findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}
