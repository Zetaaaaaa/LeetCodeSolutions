class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> arr[a]-arr[b]);
        int n = arr.length;
        for(int i = 0; i < n;i++)
            pq.offer(i);
        
        int[] ans = new int[n];
        int c = 1;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            ans[idx] = c;
            while(!pq.isEmpty() && arr[pq.peek()] == arr[idx]){
                ans[pq.poll()] = c;
            }
            c++;

        }
        return ans;
    }
}