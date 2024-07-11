class Solution:
    def reverseParentheses(self, s: str) -> str:
        l,ot = len(s),0
        res = ''
        def my(sta):
            tmp = deque()
            stop,nxt = 1,0
            for k in range(sta,l):
                # print(sta,tmp)
                if s[k] == ')':
                    stop -= 1
                    if stop == 0:
                        return tmp
                elif s[k] == '(':
                    stop += 1
                    if stop == 2:
                        # nxt = 1
                        r = my(k+1)
                        # r.reverse()
                        tmp.extendleft(r)
                else:
                    if stop == 1:
                        tmp.appendleft(s[k])
            return tmp
        for x in range(l):
            if s[x] == '(':
                if ot == 0:
                    res += ''.join(map(str, my(x+1)))
                ot += 1
            elif s[x] == ')':
                ot -= 1
            else:
                if ot == 0:
                    res += s[x]
        return res