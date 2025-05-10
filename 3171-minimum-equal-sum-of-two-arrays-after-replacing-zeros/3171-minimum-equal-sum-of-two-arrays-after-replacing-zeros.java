class Solution 
{
    public long minSum(int[] nums1, int[] nums2) 
    {
        long sum1 = 0;
        long sum2 = 0;
        int zero1 = 0;
        int zero2 = 0;

        for(int i = 0; i < nums1.length; i++)
        {
            if(nums1[i] == 0)
            {
                nums1[i] += 1;
                zero1++;
            }

            sum1 += nums1[i];
        }    

        for(int i = 0; i < nums2.length; i++)
        {
            if(nums2[i] == 0)
            {
                nums2[i] += 1;
                zero2++;
            }

            sum2 += nums2[i];
        }    

        if(sum1 < sum2 && zero1 == 0)
        {
            return -1;
        }

        if(sum2 < sum1 && zero2 == 0)
        {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}