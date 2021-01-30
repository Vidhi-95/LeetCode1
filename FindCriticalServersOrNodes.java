import java.util.*;

public class Solution {

static int dis;

    public int[] findCriticalNodes(int nodeNum, int[][] graph) {
        dis = 0;
        int[] discovery = new int[nodeNum], lowest = new int[nodeNum];
        boolean[] visited = new boolean[nodeNum];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] con : graph) {
            map.computeIfAbsent(con[0], val -> new HashSet<>()).add(con[1]);
            map.computeIfAbsent(con[1], val -> new HashSet<>()).add(con[0]);
        }
        Set<Integer> critical = new HashSet<>();
//        Start from some point.
        for (int i = 0; i < nodeNum; i++) {
            if (!visited[i]) {
                dfs(i, null, map, critical, visited, discovery, lowest);
            }
        }
        int[] result = new int[critical.size()];
        int i = 0;
        for (int node : critical) {
            result[i++] = node;
        }
        return result;
    }

    private static void dfs(int cur, Integer parent, Map<Integer, Set<Integer>> map, Set<Integer> critical, boolean[] visited, int[] discovery, int[] lowest) {
        lowest[cur] = discovery[cur] = ++dis;
        visited[cur] = true;
        Set<Integer> childs = map.getOrDefault(cur, new HashSet<>());
        int child = 0;
        boolean isCritical = false;
//        Loop through all the dependencies.
        for (int dep : childs) {
//            Avoid going back in the same direction. Check using the logic, that the dep node is not the parent of the current node.
            if (parent != null && dep == parent) continue;
//            Find the lowest node that can be reached from this node.
            if (!visited[dep]) {
                child++;
                dfs(dep, cur, map, critical, visited, discovery, lowest);
                lowest[cur] = Math.min(lowest[cur], lowest[dep]);
                if (parent != null && lowest[dep] >= discovery[cur]) isCritical = true;
            } else {
                lowest[cur] = Math.min(lowest[cur], discovery[dep]);
            }
        }
//            If current is parent and there are more than one children.
//            If you cant find a lowest point that can be reached than current, then this will be critical point.
        if ((parent == null && child > 1) || (parent != null && isCritical)) {
            critical.add(cur);
        }
    }
}