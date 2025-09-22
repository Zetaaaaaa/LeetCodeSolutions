class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        int maxFreq = Collections.max(freq.values());
        int res = 0;
        for(int ctr : freq.values()){
            if(ctr == maxFreq)  res += ctr;
        }
        return res;
    }
}