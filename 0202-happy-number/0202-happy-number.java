class Solution {
    public boolean isHappy(int n) {
        int s = 0;
        if(n==1)    return true;
        else if(n==4)   return false;
        else{
            while(n>0){
                s += Math.pow(n%10,2);
                n/=10;
            }
            return isHappy(s);
        }
    }
}