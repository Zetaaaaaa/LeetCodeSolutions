class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> broken = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()){
            broken.add(ch);
        }
        int res = 0;
        for(String word : words){
            boolean type = true;
            for(char ch : word.toCharArray()){
                if(broken.contains(ch)){
                    type = false;
                    break;
                }
            }
            if(type)    res++;
        }
        return res;
    }
}