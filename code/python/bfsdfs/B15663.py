import sys
input = sys.stdin.readline
N,M = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
visited = [False] * N

def dfs(depth):
    if depth == M:
        print(*result)
        return

    prev = 0

    for i in range(N):
        if not visited[i] and arr[i] != prev:
            visited[i] = True
            result.append(arr[i])

            prev = arr[i]

            dfs(depth+1)
            result.pop()
            visited[i] = False

result = []
dfs(0)