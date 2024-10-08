class Solution {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        HashSet <Integer> set = new HashSet<>();
        for(int i = 1; i <=Math.sqrt(n);i++){
            if(n%i==0){
                set.add(i);
                set.add(n/i);
            }
        }
        if(set.size()<k)  return -1;

        for(int val:set){
            pq.add(val);
        }
        while(k-- > 1){
            pq.poll();
        }
        return pq.peek();
    }
}