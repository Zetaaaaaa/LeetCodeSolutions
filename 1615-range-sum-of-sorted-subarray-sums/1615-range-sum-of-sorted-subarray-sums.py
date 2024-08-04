class Solution:
    MOD = 10**9 + 7

    def rangeSum(self, nums, n, left, right):
        sz = (n * (n + 1)) // 2 
        subsum = [0] * sz
        pointer = 0

        for i in range(len(nums)):
            here = 0
            for j in range(i, len(nums)):
                here += nums[j] 
                subsum[pointer] = here 
                pointer += 1

        subsum.sort() 

        prefixSum = [0] * (sz + 1) 
        for i in range(sz):
            prefixSum[i + 1] = (prefixSum[i] + subsum[i]) % self.MOD

        return (prefixSum[right] - prefixSum[left - 1] + self.MOD) % self.MOD 