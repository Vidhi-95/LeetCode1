import java.util.*;
/**
 * Definition for a N-ary node.
 * public class MAryTreeNode {
 *     int val;
 *     List<TreeNode> children;
 * }
 */

public class Solution {

 static MAryTreeNode maxNode;
    static double maxAvg;

    public MAryTreeNode subtreeMaxAvg(MAryTreeNode root) {
        maxNode = null;
        maxAvg = -1 * Integer.MAX_VALUE;
        dfs(root);
        return maxNode;
    }

    private static int[] dfs(MAryTreeNode root) {
        if (root == null) return new int[2];
        int count = 1, sum = root.val;
        if (root.children != null) {
            for (MAryTreeNode dep : root.children) {
                int[] next = dfs(dep);
                count += next[0];
                sum += next[1];
            }
        }
        double curAvg = (double) sum / count;
        if (curAvg > maxAvg) {
            maxNode = root;
            maxAvg = curAvg;
        }
        return new int[]{count, sum};
    }
}