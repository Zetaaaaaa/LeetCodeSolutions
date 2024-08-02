class Solution(object):
    def minSwaps(self, nums):
        o = sum(nums)
        if o == 0:
            return 0
        
        nums += nums
        maxx = 0
        curr = 0
        
        for i in range(len(nums)):
            if i >= o:
                if nums[i - o] == 1:
                    curr -= 1
            
            if nums[i] == 1:
                curr += 1
            
            if i >= o - 1:
                maxx = max(maxx, curr)
        
        return o - maxx
