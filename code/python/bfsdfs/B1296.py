# 백준 1296

from collections import deque
N,M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

size = 0

def bfs(x, y):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0 # 방문 시작한 노드를 0 처리
    count = 1 # 이건 bfs안에서 초기화해야 매번 count가 갱신되지

    while queue:
        x, y = queue.popleft()

        for i in range(4): 
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0 # 다음 방문한 노드를 0으로 처리
                # 이 식이 이상해
                # size = max(size, max(size))
                queue.append((nx, ny))
                count += 1

    return count

pic_count = 0
max_size = 0

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            pic_count += 1
            size = bfs(i,j)
            max_size = max(max_size, size)

print(pic_count)
print(max_size)