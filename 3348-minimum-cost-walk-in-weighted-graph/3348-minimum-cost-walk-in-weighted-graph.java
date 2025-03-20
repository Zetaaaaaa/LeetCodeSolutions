class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<int[]>> l = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>(2));
        }
        for (int[] e : edges) {
            l.get(e[0]).add(new int[]{e[1], e[2]});
            l.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        List<Integer> ans = new ArrayList<>(n);
        int cid = 0;
        int[] comp = new int[n];
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(a(i, l, cid, comp, vis));
                cid++;
            }
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            if (comp[query[i][0]] == comp[query[i][1]]) {
                result[i] = ans.get(comp[query[i][0]]);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public int a(int i, List<List<int[]>> l, int cid, int[] comp, boolean[] vis) {
        int w = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            comp[node] = cid;
            for (int[] neig : l.get(node)) {
                w &= neig[1];
                if (!vis[neig[0]]) {
                    vis[neig[0]] = true;
                    q.add(neig[0]);
                }
            }
        }
        return w;
    }
}