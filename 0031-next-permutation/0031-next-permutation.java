class Solution {
    public static void reverse(int index,int arr[])
    {
        int len=arr.length+index;
        int start=index,end=arr.length-1;
        for(int i=index;i<len/2;i++)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;
        int len=nums.length;
        for(int i=len-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
            index=i;
            break;
            }
        }
        if(index==-1)
        {
            reverse(0,nums);
            return;
        }
       for(int i=len-1;i>index;i--)
       {
            if(nums[i]>nums[index])
            {
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                break;
            }
       }
       System.out.print(index);
       reverse(index+1,nums);
    }
}