package cc.caker.leetcode.problems;

import cc.caker.common.util.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. 前K个高频单词
 * <p>
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * @author cakeralter
 * @date 2021/5/20
 * @see https://leetcode-cn.com/problems/top-k-frequent-words/
 * @since 1.0
 */
public class TopKFrequentWords {

    /**
     * topKFrequent
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 1) {
            return Collections.singletonList(words[0]);
        }

        Map<String, Integer> map = new LinkedHashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            Integer count = map.getOrDefault(words[i], 0);
            map.put(words[i], count + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator =
                Map.Entry.comparingByValue(Comparator.reverseOrder());
        comparator = comparator.thenComparing(Map.Entry::getKey);
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(map.size(), comparator);
        heap.addAll(map.entrySet());

        List<String> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(heap.poll().getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        PrintUtils.printList(topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding"
        }, 2));
        PrintUtils.printList(topKFrequent(new String[]{
                "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        }, 4));
        PrintUtils.printList(topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding"
        }, 3));
    }
}
