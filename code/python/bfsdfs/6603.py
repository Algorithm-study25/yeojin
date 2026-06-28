import sys
input = sys.stdin.readline

def dfs(start):
    if len(result) == 6:
        print(*result)
        return
    
    for i in range(start, k):
        result.append(nums[i])
        dfs(i+1)
        result.pop()
    
while True:

    data = list(map(int, input().split()))

    if data[0] == 0:
        break
    k = data[0]
    nums = data[1:]

    result = []
    dfs(0)
    print()
