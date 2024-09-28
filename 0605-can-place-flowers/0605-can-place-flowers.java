class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        for(int i = 0; i < flowerbed.length;i++){
            if(n==0)    return true;
            if(flowerbed[i] == 0){
                count++;
                if(count == 3){
                    n--;
                    count = 1;
                }
            }
            else    count = 0;
        }
        if(count ==2)   n--;
        return n == 0;
    }
}