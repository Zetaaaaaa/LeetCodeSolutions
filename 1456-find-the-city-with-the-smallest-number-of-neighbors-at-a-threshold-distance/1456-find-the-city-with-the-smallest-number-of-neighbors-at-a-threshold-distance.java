public class Solution {
    public int findTheCity(int N, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int res = Integer.MAX_VALUE;
        int city = Integer.MIN_VALUE;

        for (int i = 0; i < N; ++i) {
            int count = -1;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] minDistances = new int[N];
            Arrays.fill(minDistances, Integer.MAX_VALUE);
            minDistances[i] = 0;
            pq.add(new int[]{i, 0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int currCity = curr[0], currWeight = curr[1];

                if (currWeight > minDistances[currCity]) continue;

                if (!graph.containsKey(currCity)) continue;

                if (currWeight <= distanceThreshold) count++;

                if (!graph.containsKey(currCity)) continue;

                for (int[] neighbours : graph.get(currCity)) {
                    int newCity = neighbours[0], newWeight = neighbours[1];

                    if (newWeight + currWeight < minDistances[newCity]) {
                        minDistances[newCity] = newWeight + currWeight;
                        pq.add(new int[]{newCity, newWeight + currWeight});
                    }
                }
            }

            if (count <= res) {
                res = count;
                city = i;
            }
        }
        return city;
    }
}