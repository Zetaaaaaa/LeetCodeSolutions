class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String d : details){
            int ones = d.charAt(12) - '0';
            int tens = d.charAt(11) - '0';
            count = (tens*10+ones > 60) ? count+1 : count;
        }
        return count;
    }
}