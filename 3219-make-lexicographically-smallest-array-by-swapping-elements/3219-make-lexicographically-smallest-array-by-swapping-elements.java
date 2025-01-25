class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        List<LinkedList<Integer>> rangeList = new ArrayList<>();
        LinkedList<Integer> firstRange = new LinkedList<>();
        firstRange.add(sortedNums[0]);
        rangeList.add(firstRange);
        
        Map<Integer, Integer> rangeMap = new HashMap<>();
        rangeMap.put(sortedNums[0], 0);

        int idx = 0;
        int n = nums.length;

        for(int i=1; i<n; ++i){
            LinkedList<Integer> curRange = rangeList.get(idx);
            if(sortedNums[i] - limit <= curRange.peekLast()){
                curRange.add(sortedNums[i]);
            }else{
                LinkedList<Integer> nextRange = new LinkedList<>();
                nextRange.add(sortedNums[i]);
                rangeList.add(nextRange);
                idx++;
            }
            rangeMap.put(sortedNums[i], idx);
        }
        for(int i=0; i<n; ++i){
            
            int numIdx = rangeMap.get(nums[i]);
            LinkedList<Integer> range = rangeList.get(numIdx);
            nums[i] = range.pollFirst();
        }
        return nums;
    }
}