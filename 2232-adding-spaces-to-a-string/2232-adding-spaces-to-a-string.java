class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i=0, ptr=0;
        while(i < s.length() && ptr < spaces.length){
            if(ptr < spaces.length && i != spaces[ptr]){
                sb.append(s.charAt(i));
                i++;
            }
            else{
                sb.append(" ");
                ptr++;
            }
        }
        for(int j=i; j<s.length(); j++){
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}