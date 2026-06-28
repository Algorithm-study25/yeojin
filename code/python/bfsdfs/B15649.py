# 15649
# 백트랙킹
import sys
input = sys.stdin.readline

N,M = map(int, input().split())

arr = list(range(1, N+1))

visited = [False] * N
result = []
def dfs(width):
    if width == M:
        print(*result)
        return

    for i in range(N):
        if not visited[i]:
            result.append(arr[i])
            visited[i] = True

            dfs(width + 1)
            result.pop()
            visited[i] = False

dfs(0)