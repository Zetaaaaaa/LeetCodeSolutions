class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) 
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()) 
            if(map.get(key) > 1) ans.add(key);
        return new int[]{ans.get(0), ans.get(1)};
    }
}