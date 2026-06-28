# # from collections import deque

# # T = int(input())

# # M, N, K = map(int, input().split())

# # graph = [list(map(int, input())) for _ in range(K)]

# # # 근데 여기서 m,n,k를 t만큼 반복해서 받아야하는데

# # dx = [1, -1, 0, 0]
# # dy = [0, 0, 1, -1]

# # def bfs(x, y):
# #     queue = deque()
# #     queue.append((x,y))

# #     while queue:
# #         x, y = queue.popleft()


# #         for i in range(4):
# #             nx = x + dx[i]
# #             ny = y + dy[i]

# #             if nx <0 or ny < 0 or nx >=M or ny >= N:
# #                 continue

# #             if graph[nx][ny] == 0 # 방문한적있다면
# #                 continue 

# # bfs(0,0) # (0,0)부터 돌면서 갯수를 count
# # # bfs 돈 횟수를 count해서 풀면 돼

# # count = 0
# # for i in range(M):
# #     for j in range(N):
# #         bfs(i,j)
# #         count += 1

# # print(count)

# from collections import deque
# T = int(input())
# dx = [1, -1, 0, 0]
# dy = [0, 0, 1, -1]

# for _ in range(T):
#     M,N,K = map(int, input().split())

#     graph = [[0] * M for _ in range(N)]

#     for _ in range(K):
#         x,y = map(int, input().split())
#         graph[y][x] = 1

#     def bfs(x,y):
#         queue = deque()
#         queue.append((x,y))
#         graph[x][y] = 0
#         while queue:
#             x,y = queue.popleft()

#             for i in range(4):
#                 nx = x + dx[i]
#                 ny = y + dy[i]

#                 if nx < 0 or ny <0 or nx >=N or ny >= M:
#                     continue

#                 if graph[nx][ny] == 1:
#                     graph[nx][ny]=0 # 배추가 있으면 계속 탐색
#                     queue.append((nx, ny))


#     count = 0

#     for i in range(N):
#         for j in range(M):
#                 if graph[i][j] == 1:
#                     bfs(i,j)
#                     count += 1

#     print(count)

from collections import deque

T = int(input())

dx = [1,-1,0,0]
dy = [0,0,1,-1]

for _ in range(T):
    M,N,K = map(int, input().split)

    graph = [[0] * M for _ in range(N)]

    for _ in range(K):
        x,y = int(input().split())
        graph[y][x] = 1

    def bfs(x,y):
        queue = deque()
        queue.append((x,y))
        graph[x][y] = 0 # 방문처리

        while queue:
            x,y = queue.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0  or ny < 0 or nx >= N or ny >= M:
                    continue

                if graph[nx][ny] == 1:
                    graph[nx][ny] = 0
                    queue.append((nx,ny))
    
    count = 0 
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(i, j)
                count +=1

    print(count)
    

            