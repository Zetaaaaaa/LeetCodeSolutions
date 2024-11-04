class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        int wLength = words[0].length();
        int tLength = words[0].length() * words.length; 
        
        int i = 0, j = 0;
        while (j < s.length()) {
            
            if(j - i + 1 < tLength)
                j++;
            
            else if (j - i + 1 == tLength) {
                String sub = s.substring(i, j + 1);
                Map<String, Integer> map2 = new HashMap<>();
                int index = 0;
                while (index < sub.length()) {
                    String temp = sub.substring(index, index + wLength);
                    map2.put(temp,map2.getOrDefault(temp, 0) + 1);
                    index += wLength;
                }
                
                if (map.equals(map2))
                    ans.add(i);
                i++;   j++;
            }
        }
        return ans;
    }
}