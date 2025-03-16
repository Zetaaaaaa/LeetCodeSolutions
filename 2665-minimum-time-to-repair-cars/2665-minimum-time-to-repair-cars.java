class Solution {

    public long repairCars(int[] ranks, int cars) {
        long ans = 0;
        long low = 0;
        long high = Long.MAX_VALUE;
        while(low<=high) {
            long mid = low+(high-low)/2;
            boolean res = check(ranks, cars, mid);
            if(res==true){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    boolean check(int[] ranks, int cars, long time) {
        
        int cnt = 0;
        for(int rank: ranks) {
            int low = 0 ;
            int high = cars;
            int c = 0;
            while(low<=high){
                int m = low+(high-low)/2;
                long t = (long)rank*m*m;
                if(t<=time){
                    c = m;
                    low = m+1;
                }else{
                    high = m-1;
                }
            }
            
            cnt+= c;
            if(cnt>=cars)
                return true;
        }
        return false;
    }
}