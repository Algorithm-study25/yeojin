# # 전체를 돌다가 1 발견, BFS 시작, 연결된 모든 1 탐색, 개수 count

# from collections import deque
# N = int(input())

# graph = [list(map(int, input())) for _ in range(N)]

# dx = [1, -1, 0, 0]
# dy = [0, 0, 1, -1]

# def bfs(x, y):
#     queue = deque()
#     queue.append((x, y))
#     graph[x][y] = 0 # 방문처리
#     count = 1

#     while queue:
#         x,y = queue.popleft()

#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]

#             if nx < 0 or ny < 0 or nx >= N or ny >= N:
#                 continue

#             if graph[nx][ny] == 1:
#                 graph[nx][ny] = 0 # 방문터리
#                 queue.append((nx, ny))
#                 count += 1
#     return count

# result = []

# for i in range(N):
#     for j in range(N):
#         if graph[i][j] == 1:
#             result.append(bfs(i, j))

# result.sort()

# print(len(result))

# for x in result:
#     print(x)



from collections import deque
N = int(input())
graph = [list(map(int, input())) for _ in range(N)]


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y):
    queue = deque()
    queue.append((x,y))

    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx <0 or ny < 0 or nx >= N or ny >=N:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                count +=1

        return count
    
result = []

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            result.append(bfs(i,j))

result.sort()

print(len(result))
for x in result:
    print(x)