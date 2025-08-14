class Solution {
    public String largestGoodInteger(String num) {
        int len = num.length();
        char ch = 0;
        for(int i = 0; i < len - 2; i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                ch =(char) Math.max(ch, num.charAt(i));
            }
        }
        if(ch == 0) return "";

        return String.valueOf(ch).repeat(3);

    }
}