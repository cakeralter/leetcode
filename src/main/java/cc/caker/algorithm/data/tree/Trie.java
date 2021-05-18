package cc.caker.algorithm.data.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 字典树
 * <p>
 * 又称单词查找树，Trie树，是一种树形结构，是一种哈希树的变种。
 * 典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
 * 它的优点是：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。
 *
 * @author cakeralter
 * @date 2021/5/17
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Trie {

    /**
     * 根节点
     */
    private TrieNode root;
    /**
     * 节点数量
     */
    private int size;

    /**
     * insert
     *
     * @param str
     */
    public void insert(String str) {

    }

    /**
     * search
     *
     * @param str
     * @return
     */
    public boolean search(String str) {
        return false;
    }

    /**
     * 字典树节点
     */
    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    static class TrieNode {

        private char val;
        private TrieNode[] trieNodes;
    }
}
