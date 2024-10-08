class Solution {
    public int minSwaps(String s) {
        int girl = 0, boys = 0;

        for (int i = 0; i < s.length(); i++) {
            if (boys > 0 && s.charAt(i) == ']') {
                boys--;
            } 
            else {
                if (s.charAt(i) == '[') {
                    boys++;
                } 
                else {
                    girl++;
                }
            }
        }

        int single = boys;
        if (single == 1) {
            return 1;
        }

        return (int)Math.ceil((double)single / 2);
    }
}