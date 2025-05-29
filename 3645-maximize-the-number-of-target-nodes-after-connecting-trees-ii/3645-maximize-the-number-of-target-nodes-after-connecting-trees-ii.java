class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        List<Integer>[] adj = new List[m];
        for (int i = 0; i < m; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges2) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] lvls = new int[2];
        dfs(adj, new boolean[m], lvls, 0, 0);
        int max = Math.max(lvls[0], lvls[1]);
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges1) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        lvls = new int[2];
        int[] res = new int[n];
        dfs2(adj, new boolean[n], res, lvls, 0, 0);
        for (int i = 0; i < n; i++) {
            res[i] = lvls[res[i]] + max;
        }
        return res;
    }

    static void dfs2(List<Integer>[] adj, boolean[] seen, int[] res, int[] lvls, int node, int lvl) {
        seen[node] = true;
        lvls[lvl]++;
        res[node] = lvl;
        for (int neighbor : adj[node]) {
            if (!seen[neighbor]) {
                dfs2(adj, seen, res, lvls, neighbor, lvl ^ 1);
            }
        }
    }

    static void dfs(List<Integer>[] adj, boolean[] seen, int[] res, int node, int lvl) {
        seen[node] = true;
        res[lvl]++;
        for (int neighbor : adj[node]) {
            if (!seen[neighbor]) {
                dfs(adj, seen, res, neighbor, lvl ^ 1);
            }
        }
    }
}