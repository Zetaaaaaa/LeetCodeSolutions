class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            char c= (char) ('A' + columnNumber % 26);
            str.insert(0,c);
            columnNumber /= 26;
        }
        return str.toString();
    }
}