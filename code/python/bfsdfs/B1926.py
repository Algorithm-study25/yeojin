import sys
input = sys.stdin.readline
from collections import deque
N,M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

visited = [[False] * 0 for _ in range(N)]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))

    visited[x][y] = True

    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
              continue

            if graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))
                count += 1
    return count

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1 and not visited[i][j]:
            max_total = max(max_total, bfs(i,j))

