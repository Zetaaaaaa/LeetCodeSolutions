class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum=0, x=0;
        for(int i:arr){
            sum+=i;
            map.put(sum, x);
            x++;
        }

        int size = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(map.get(sum-target)!=null){
                size= Math.min(size, i-map.get(sum-target));
            }

            if(map.get(sum+target)!=null && size<Integer.MAX_VALUE){
                res = Math.min(res, map.get(sum+target)-i+size);
            }
        }

        return res==Integer.MAX_VALUE? -1:res;
    }
}