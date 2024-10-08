class Solution {
    public String convert(String s, int numRows) {
       if (numRows == 1 || s.length() <= numRows) {
            return s;
        }       

        List<StringBuilder> rows= new ArrayList<>(); 
        for(int i=0; i< numRows; i++){ 
            rows.add(new StringBuilder());
        }
        int index=0;
        boolean down=true;
        for(int i=0;i<s.length();i++){
            rows.get(index).append(s.charAt(i));
            if(index==numRows-1){
                down=false; // move up
            }else if(index==0){
                down=true;//move down
            }
            if(down) index++;
            else index--;
        }
         StringBuilder ans= new StringBuilder();
            for(StringBuilder rowsStringBuilder : rows){ 
                ans.append(rowsStringBuilder);
            }
            return ans.toString();
    }
}