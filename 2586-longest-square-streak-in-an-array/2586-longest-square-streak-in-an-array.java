class Solution {
    public int longestSquareStreak(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 1;
        while(!set.isEmpty()) {
            int num = set.first();
            int streak = 0;
            while(!set.isEmpty() && set.contains(num)) {
                set.remove(num);
                num = num*num;
                streak++;
            }
            
            longestStreak = Math.max(streak, longestStreak);
        }
        
        return longestStreak == 1 ? -1 : longestStreak;
    }
}