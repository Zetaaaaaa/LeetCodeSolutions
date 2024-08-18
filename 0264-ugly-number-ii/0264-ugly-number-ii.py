class Solution:
    def solve(self):
        ugly = [1]
        p2 = p3 = p5 = 0
        for i in range(1, 1691):
            next_ugly = min(ugly[p2] * 2, ugly[p3] * 3, ugly[p5] * 5)
            ugly.append(next_ugly)
            if next_ugly == ugly[p2] * 2:
                p2 += 1
            if next_ugly == ugly[p3] * 3:
                p3 += 1
            if next_ugly == ugly[p5] * 5:
                p5 += 1
        return ugly
    def nthUglyNumber(self, n: int) -> int:
        ugly = self.solve()
        return ugly[n-1]

        