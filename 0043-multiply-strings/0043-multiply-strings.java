class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")  || num2.equals("0") ){
            return "0";
        }
        String[] arr = new String[num2.length()];
        String zeros = "";
        int ind = num2.length()-1;
        for(int i = 0; i<num2.length(); i++){
            arr[i] = multOneLayer(num1, num2.charAt(ind))+ zeros;
            zeros+="0";
            System.out.println(arr[i]);
            ind--;
        }
        for(int i = 1; i<arr.length; i++){
            arr[i] = addStrings(arr[i], arr[i-1]);
            
        }
        return arr[arr.length-1];
    }


    private String multOneLayer(String num1, char num2) {
        StringBuilder ret = new StringBuilder();
        int ind1 = num1.length()-1;
        int carry = 0;
        while( ind1>=0 ){
            int temp = carry + (num1.charAt(ind1--) - '0') * (num2 - '0');
            carry = temp/10;
            temp = temp%10 ;

            ret.append(temp);
        }
        if(carry != 0){
            ret.append(carry);
        }
        return ret.reverse().toString();

    }

    private String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int ind1 = num1.length()-1;
        int ind2 = num2.length()-1;
        boolean carry = false;
        while( ind1>=0 || ind2>=0 ){
            int temp = 0;
            if(carry == true){
                temp++;
                carry = false;
            }
            if(ind1>=0 && ind2>=0){
                temp += num1.charAt(ind1--) - '0' + (num2.charAt(ind2--) - '0');
            }
            else if(ind1 >=0){
                temp += num1.charAt(ind1--) - '0';
            }
            else{
                temp += num2.charAt(ind2--) - '0';
            }
            if(temp/10 ==1 ){
                carry= true;
                temp%=10;
            }
            ret.append(temp);
            
        }
        if(carry == true){
            ret.append(1);
        }
        return ret.reverse().toString();

    }
}