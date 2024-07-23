class Solution(object):
    def frequencySort(self, nums):
        freq = Counter(nums)
        return sorted(nums, key=lambda x : (freq[x], -x))