from collections import deque

N,M=map(int, input().split())

dx = [1,-1,0,0]
dy = [0,0,1,-1]
count = 1
array = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True
    area = 1 # 그림의 크기

    queue.append((x,y))
    visited[x][y] = True
    area = 1

    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if array[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    area += 1

    return area # 그림의크기

count = 0
max_area = 0

for i in range(N):
    for j in range(M):
        if array[i][j] == 1 and not visited[i][j]:
            count += 1
            max_area = max(max_area, bfs(i,j))
        
print(count)
print(max_area)