package cc.caker.leetcode.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 字典树节点
 *
 * @author cakeralter
 * @date 2021/5/23
 * @since 1.0
 */
@Accessors(chain = true)
@Data
@RequiredArgsConstructor
public class TrieNode {
    public final int val;
    public TrieNode[] children;
}
