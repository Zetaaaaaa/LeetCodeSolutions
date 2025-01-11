class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(k == n)  return true;
        else{
            Map<Character, Integer> map = new HashMap<>();
            int ctr = 0;
            for(char c : s.toCharArray()){
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            for(int f : map.values()){
                if(f % 2 == 1){
                    ctr++;
                }
            }
            return ctr <= k && k <= n;
        }

    }
}