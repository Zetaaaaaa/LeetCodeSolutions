class Solution {
    public String[] divideString(String s, int k, char fill) {
        int l = s.length();
        int group = (l + k - 1)/k;
        
        int fill_no = l % k;
        int ctr = 0;
        //List<String> res = new ArrayList<String>();
        String[] res = new String[group];
        for(int i = 0; i < group; i++){
            StringBuilder grp = new StringBuilder();
            for(int j = 0; j < k; j++){
                int idx = i * k + j;
                if(idx < l){
                    grp.append(s.charAt(idx));
                }
                else    grp.append(fill);
            }
            res[i] = grp.toString();
        }
        return res;
    }
}