class Solution {
    int ct;
    String sp;
    public String getHappyString(int n, int k) {
        if(!pnt(n,k)) return "";
        ct = 0;
        sp = "";
        dfs(n , "" ,0,k);
        return sp;
    }

    boolean pnt(int n , int k){
        int ans = 3;
        int a = n-1;
        while(a>0){
            ans *= 2;
            a--;
        }
        return (ans<k)?false:true;
    }

    public void dfs(int n ,String st ,int i,int k ){
        if(ct>k) return;
        if(i == n){
            ct++;
            if(ct == k){
                sp = st;
            }
            return;
        }
        if(i == 0 || (i>0 && st.charAt(i-1) != 'a'))dfs(n , st+"a" , i+1 , k);
        if(i == 0 || (i>0 && st.charAt(i-1) != 'b'))dfs(n , st+"b" , i+1 , k);
        if(i == 0 || (i>0 && st.charAt(i-1) != 'c'))dfs(n , st+"c" , i+1 , k);

    }
}