class Solution {
    public char findTheDifference(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        char t1[] = s1.toCharArray();
        char t2[] = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        String s11 = new String(t1);
        String s22 = new String(t2);
        for(int i=0;i<n1;i++)
        {
            if(s11.charAt(i)!=s22.charAt(i))
                return s22.charAt(i);
        }
        return s22.charAt(n2-1);
    }
}