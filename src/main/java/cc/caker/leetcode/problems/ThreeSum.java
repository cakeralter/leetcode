package cc.caker.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author cakeralter
 * @date 2021/5/14
 * @see https://leetcode-cn.com/problems/3sum/
 * @since 1.0
 */
public class ThreeSum {

    /**
     * threeSum
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return Collections.emptyList();
        }

        Set<String> duplicateKey = new HashSet<>(length);
        List<List<Integer>> result = new ArrayList<>(length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length - 2 && nums[i] <= 0; i++) {
            // 重复的数过滤掉
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            map.clear();
            for (int j = i + 1; j < length; j++) {
                Integer b = map.get(nums[j]);
                if (b != null) {
                    String key = nums[i] + "_" + b + "_" + nums[j];
                    // 重复的结果过滤掉
                    if (!duplicateKey.contains(key)) {
                        List<Integer> integerList = new ArrayList<>(3);
                        integerList.add(nums[i]);
                        integerList.add(b);
                        integerList.add(nums[j]);
                        result.add(integerList);
                        duplicateKey.add(key);
                    }
                } else {
                    map.put(-nums[i] - nums[j], nums[j]);
                }
            }
        }

        return result;
    }

    /**
     * print
     *
     * @param list
     * @return
     */
    private static String print(List<List<Integer>> list) {
        if (list.isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            builder.append("[");
            for (int j = 0; j < list.get(i).size(); j++) {
                builder.append(list.get(i).get(j));
                if (j != list.get(i).size() - 1) {
                    builder.append(",");
                }
            }
            builder.append("]");
            if (i != list.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(print(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(print(threeSum(new int[]{})));
        System.out.println(print(threeSum(new int[]{0})));
        System.out.println(print(threeSum(new int[]{-5, 0, -2, 3, -2, 1, 1, 3, 0, -5, 3, 3, 0, -1})));
        System.out.println(print(threeSum(new int[]{-1, 0, 1})));
    }
}
