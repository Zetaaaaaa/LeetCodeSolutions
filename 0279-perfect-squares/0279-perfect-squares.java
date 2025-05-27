class Solution {
    public int numSquares(int n) {
        if(n == 0)  return 0;

        if(isroot(n))   return 1;

        for(int i = 1; i * i <= n; i++){
            if(isroot(n - (i * i))) return 2;
        }

        while(n % 4 == 0)
            n /= 4;
        
        if(n % 8 == 7)  return 4;


        return 3;

    }

    public boolean isroot(int n){
        int sqr = (int)Math.sqrt(n);

        return (sqr * sqr) == n;
    }
}