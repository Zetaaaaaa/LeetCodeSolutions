#Question 313

class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        heap = [1]
        seen = {1}
        u = 1
        for _ in range(n):
            u = heapq.heappop(heap)
            for i in primes:
                nu = u * i
                if nu not in seen:
                    seen.add(nu)
                    heapq.heappush(heap, nu)
        
        return u