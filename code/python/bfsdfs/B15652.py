import sys
input = sys.stdin.readline

N,M = map(int, input().split())
result = []

def dfs(start):
    if len(result) == M:
        print(*result)
        return
    for i in range(start, N+1):
        result.append(i)
        # if start == i:
        #     dfs(i)    
        dfs(i)
        result.pop()
dfs(1)