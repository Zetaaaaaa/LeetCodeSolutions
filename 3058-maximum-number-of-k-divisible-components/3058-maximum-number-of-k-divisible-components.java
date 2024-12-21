import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int[] result = {0};
        dfs(0, tree, values, k, visited, result);

        return result[0];
    }

    private long dfs(int node, List<List<Integer>> tree, int[] values, int k, boolean[] visited, int[] result) {
        visited[node] = true;
        long sum = values[node];
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                sum += dfs(neighbor, tree, values, k, visited, result);
            }
        }
        if (sum % k == 0) {
            result[0]++;
            return 0;
        }
        return sum;        
    }
}