# # from collections import deque
# # n = int(input().split())

# # for i in range(n*n):
# #     arr = [list(map(int, input().split()))]
# #     stu = arr[i][0]

# # graph = [[0] * n for _ in range(n)]
# # # 여기서 arr을 뭐로 정의해야하지?

# # def bfs(graph, start, visited):
# #     queue = deque([start])
# #     visited[start] = True

# #     while queue:
# #         v = queue.popleft()

# #         for i in graph[v]:
# #             if not visited[v]:
# #                 queue.append(i)
# #                 visited
# #                 [i] = True
# # dx = [1,-1,0,0]
# # dy = [0,0,1,-1]

# # graph = [row [:] for row in arr] # 2차원 배열 복붙

# # def find_love(x,y):
# #     # 인접한 곳에 조아하는 사람 있는지 찾는 코드
# #     for i in range(n):
# #         for j in range(n):
# #             for k in range(4):
# #                 nx = x + dx[k]
# #                 ny = y + dy[k]

# #                 if 0<= nx < n and 0<= ny < n:
# #                     if graph[nx][ny] in arr[i] # arr안에 있다면,
# #                         count += 1
# #                         # 여기서 
# #                         hoobo.append((nx,ny))

# # hoobo = []
# # hoobo.sort()
# # hoobo[0] = # 그 값이 들어가야해. 후보들 중, 제일 작은 값이

# # def find_leftover(x,y): # 빈칸찾는
# #     for i in range(n):
# #         for j in range(n):
# #             for k in range(4):
# #                 nx = x + dx[k]
# #                 ny = y + dy[k]

# #                 if 0<= nx < n and 0<= ny < n:
# #                     if graph[nx][ny] == 0:
# #                         count += 1

# # # count가 제일 많은거 return하여, 2순위로 쓸 수 있게
# # bfs는 퍼지는 구조일때 쓴다.
# # 얘는 퍼지는 구조는 아니고 여러개 중 선택이니까
# n = int(input())
# order = [] # 학생이 들어오는 순서를 저장하기 위함, 학생이 순서대로 들어오니까
# like = {} # 전형적인 key-value구조니까

# for _ in range(n*n):
#     data = list(map(int, input().split()))
#     student = data[0]
#     order.append(student)
#     like[student] = data[1:]

# board = [[0]*n for _ in range(n)]

# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]

# def get_score(x, y, student):
#     like_cnt = 0
#     empty_cnt = 0

#     for d in range(4):
#         nx = x + dx[d]
#         ny = y + dy[d]

#         if 0 <= nx < n and 0 <= ny < n:
#             if board[nx][ny] in like[student]:
#                 like_cnt += 1
#             elif board[nx][ny] == 0:
#                 empty_cnt += 1 # 아 empty_count도 관리해야지

#     return like_cnt, empty_cnt

# for student in order:
#     candidates = []

#     for i in range(n):
#         for j in range(n):
#             if board[i][j] != 0:
#                 continue

#             like_cnt, empty_cnt = get_score(i, j, student)
#             candidates.append((like_cnt, empty_cnt, i, j))

#     # 정렬 (핵심!)
#     candidates.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))

#     x, y = candidates[0][2], candidates[0][3]
#     board[x][y] = student

# result = 0

# score_map = {0:0, 1:1, 2:10, 3:100, 4:1000}

# for i in range(n):
#     for j in range(n):
#         student = board[i][j]
#         cnt = 0

#         for d in range(4):
#             nx = i + dx[d]
#             ny = j + dy[d]

#             if 0 <= nx < n and 0 <= ny < n:
#                 if board[nx][ny] in like[student]:
#                     cnt += 1

#         result += score_map[cnt]

# print(result)

n = int(input().split())
like = {}
order = []

for i in range(n*n):
    data = list(map(int, input().split()))
    student = data[0]
    order.append(student)
    like = data[1:]

board = [[0] * n for _ in range(n)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def get_score(x,y,student):
    like_count = 0
    zero_count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0<= nx < n and 0 <= ny < n:
            if board[nx][ny] in like[student]:
                like_count += 1
        elif board[nx][ny] == 0:
            zero_count += 1
        
    return like_count, zero_count

for student in order:
    candidates = []

    for i in range(n):
        for j in range(n):
            if board[i][j] != 0:
                continue
        
            like_count, zero_count = get_score(i,j,student)
            candidates.append((like_count, zero_count))

    candidates.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))

    x,y = candidates[0][2], candidates[0][3]
    board[x][y] = student

result = 0

score_map = {0:0, 1:1, 2:10, 3:100, 4:1000}

for i in range(n):
    for j in range(n):
        student = board[i][j]
        cnt = 0

        for d in range(4):
            nx = i + dx[d]
            ny = j + dy[d]

            if 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] in like[student]:
                    cnt += 1

        result += score_map[cnt]

print(result)