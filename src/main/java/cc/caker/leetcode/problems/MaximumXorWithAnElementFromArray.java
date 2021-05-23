package cc.caker.leetcode.problems;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1707. 与数组中元素的最大异或值
 * <p>
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。
 * 换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。
 * 如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 * @author cakeralter
 * @date 2021/5/23
 * @see https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
 * @since 1.0
 */
public class MaximumXorWithAnElementFromArray {

    static Map<String, Integer> answerMap = new HashMap<>();

    /**
     * maximizeXor
     *
     * @param nums
     * @param queries
     * @return
     */
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        TrieNode root = new TrieNode();
        int[][] sortedQueries =
                Arrays.stream(queries).sorted(Comparator.comparing(query -> query[1])).toArray(int[][]::new);

        int index = 0;
        for (int[] sortedQuery : sortedQueries) {
            int x = sortedQuery[0];
            int m = sortedQuery[1];
            String key = x + "_" + m;
            if (m < nums[0]) {
                answerMap.put(key, -1);
                continue;
            }
            while (index < nums.length && nums[index] <= m) {
                root.insert(nums[index++]);
            }
            int maxXor = maxXor(root, x);
            answerMap.put(key, maxXor);
        }

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answers[i] = answerMap.get(queries[i][0] + "_" + queries[i][1]);
        }
        return answers;
    }

    /**
     * maxXor
     * nums中不大于m的数与x异或结果的最大值
     *
     * @param root
     * @param x
     * @return
     */
    private static int maxXor(TrieNode root, int x) {
        TrieNode p = root;
        for (int i = MAX_INT_SIZE; i >= 0; i--) {
            // bit
            int xBit = (x >> i) & 1;
            if (xBit == 0) {
                p = p.right != null ? p.right : p.left;
            } else {
                p = p.left != null ? p.left : p.right;
            }
        }
        return p.num ^ x;
    }

    static final int MAX_INT_SIZE = 31;

    @Accessors(chain = true)
    @Data
    @NoArgsConstructor
    static class TrieNode {
        int val = -1;
        TrieNode left;
        TrieNode right;
        boolean isLeaf = false;
        int num = -1;

        public TrieNode(int val) {
            this.val = val;
        }

        /**
         * init
         *
         * @param nums
         * @return
         */
        public static TrieNode init(int[] nums) {
            TrieNode root = new TrieNode();
            for (int num : nums) {
                root.insert(num);
            }
            return root;
        }

        /**
         * insert
         *
         * @param num
         */
        public void insert(int num) {
            TrieNode p = this;
            String s = "";
            for (int i = MAX_INT_SIZE; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (p.left == null) {
                        p.left = new TrieNode(0);
                    }
                    p = p.left;
                } else {
                    if (p.right == null) {
                        p.right = new TrieNode(1);
                    }
                    p = p.right;
                }
            }
            p.num = num;
            p.isLeaf = true;
        }

        /**
         * print
         *
         * @param root
         */
        public static void print(TrieNode root) {
            if (root == null) {
                return;
            }
            if (root.isLeaf) {
                System.out.println(root.num);
            }
            print(root.left);
            print(root.right);
        }
    }

    public static void main(String[] args) {
        /*int[] answers1 = maximizeXor(new int[]{536870912, 0, 534710168, 330218644, 142254206},
                new int[][]{new int[]{558240772, 1000000000}, new int[]{307628050, 1000000000},
                        new int[]{3319300, 1000000000}, new int[]{2751604, 683297522},
                        new int[]{214004, 404207941}});
        System.out.println(Arrays.toString(answers1));

        int[] answers2 = maximizeXor(new int[]{5, 2, 4, 6, 6, 3},
                new int[][]{new int[]{12, 4}, new int[]{8, 1}, new int[]{6, 3}});
        System.out.println(Arrays.toString(answers2));

        int[] answers3 = maximizeXor(new int[]{0, 1, 2, 3, 4},
                new int[][]{new int[]{3, 1}, new int[]{1, 3}, new int[]{5, 6}});
        System.out.println(Arrays.toString(answers3));*/

        int[] answers3 = maximizeXor(new int[]{760625198, 15138539, 61033, 267654046, 133000577, 229497, 155443, 109330, 13340119, 8260519, 981126373, 441631490, 498767021, 171522247, 503991705, 11276686, 176397, 23247190, 472734721, 243117401},
                new int[][]{new int[]{4194304, 91884}});
        System.out.println(Arrays.toString(answers3));
    }
}
