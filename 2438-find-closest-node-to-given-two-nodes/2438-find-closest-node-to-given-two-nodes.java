class Solution {
    void bfs(int []edges,int distance[],int src)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        distance[src] = 0;
        while(q.size()>0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int node = q.poll();
                int next = edges[node];
                if(next!=-1 && distance[next]==(int)1e9)
                {
                    distance[next] = distance[node]+1;
                    q.add(next);
                }
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n =  edges.length;
        //bfs
        int distance[] = new int[n];
        Arrays.fill(distance,(int)1e9);
        int distance2[] = new int[n];
        Arrays.fill(distance2,(int)1e9);
        bfs(edges,distance,node1);
        bfs(edges,distance2,node2);
        int ans = (int)1e9;
        int node = -1;
        for(int i=0;i<n;i++)
        {
            if(distance[i]==(int)1e9 || distance2[i]==(int)1e9)
            {
                continue;
            }
            int allMaxi = Math.max(distance[i],distance2[i]);
            if(ans>allMaxi)
            {
                node = i;
                ans = allMaxi;
            }
        }
        return node;
    }
}