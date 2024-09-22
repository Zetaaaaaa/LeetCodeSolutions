class Solution {
    public boolean areNumbersAscending(String s) {
        
        int[] tes1 = new int[s.length()]; 
        
        int count = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                count++;
                if(count == 2){
                    String cek = "";
                    cek += s.charAt(i-1);
                    cek += s.charAt(i);
                    
                    int number = Integer.parseInt(cek);

                    tes1[j-1] = number;   

                }else{
                    int tes = s.charAt(i) - '0';
                    tes1[j++] = tes;
                }
            }else{
                count = 0;
            }
        }
        
        int max1 = 0;
        for(int i = 0; i < tes1.length; i++){
            if(tes1[i] != 0 ){
                if(tes1[i] > max1){
                    max1 = tes1[i];
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
}