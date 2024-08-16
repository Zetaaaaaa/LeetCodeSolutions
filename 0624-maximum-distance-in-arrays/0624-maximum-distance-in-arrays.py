class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        minn, maxx = arrays[0][0], arrays[0][-1]
        diff = -float("inf")
        for ar in arrays[1:]:
            maxdiff = abs(maxx - ar[0])
            mindiff = abs(minn - ar[-1])
            diff = max(diff, mindiff, maxdiff)
            if(ar[0] < minn):
                minn = ar[0]
            if ar[-1] > maxx:
                maxx = ar[-1]
        return diff