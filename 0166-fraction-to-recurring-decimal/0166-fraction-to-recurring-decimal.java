class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)   return "";
        StringBuilder s = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0){
            s.append('-');
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long n= num/den;
        long remainder = num % den;
        s.append(n);
        if(remainder == 0)   return s.toString();
        else s.append('.');
        while(!map.containsKey(remainder)){
            map.put(remainder, s.length());
            n = remainder * 10 / den;
            remainder = remainder * 10 % den;
            if(remainder != 0 || remainder == 0 && !map.containsKey(remainder)){
                s.append(n);
            }

        }
        if(remainder != 0){
            s.insert(map.get(remainder), "(");
            s.append(')');
        }
        return s.toString();
    }
}