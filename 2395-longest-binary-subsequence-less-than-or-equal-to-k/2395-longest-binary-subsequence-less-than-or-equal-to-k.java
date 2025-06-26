public class Solution 
{
    public int longestSubsequence(String s, int k) 
    {
        int zeros = 0;
        for (char c : s.toCharArray()) 
        {
            if (c == '0')
            {
                zeros++;
            } 
        }

        long value = 0;
        int power = 0;
        int count = 0;

        for (int i = s.length() - 1; i >= 0 && power < 32; i--) 
        {
            if (s.charAt(i) == '1') 
            {
                value += 1L << power;
                if (value > k)
                {
                    break;
                }

                count++;
                power++;
            } 
            else 
            {
                power++;
            }
        }

        return count + zeros;
    }
}