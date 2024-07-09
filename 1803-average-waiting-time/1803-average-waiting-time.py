class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        sumwt = 0
        currtime = customers[0][0]
        for i in customers:
            if(i[0] > currtime):
                currtime = i[0] + i[1]
            else:
                currtime += i[1]
            sumwt += currtime - i[0]
        return sumwt/len(customers)