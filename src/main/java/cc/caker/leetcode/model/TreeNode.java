package cc.caker.leetcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author cakeralter
 * @date 2021/5/22
 * @since 1.0
 */
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
