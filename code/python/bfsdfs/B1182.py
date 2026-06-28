# # 1182 부분수열의합
# # bfs는 최소최대
# # dfs는 모든 수를 다 탐색해야 할 필요가 있을 때
# import sys
# input = sys.stdin.readline

# N,S = map(int, input().split()) # 여기서 다 받았어이미

# graph = [[] for _ in range(N+1)]
# arr = list(map(int, input().split())) # 근데 여기서 왜 어떤 경우에는 [list()] 이렇게 가고 왜 이경우에는 그냥 list 로 가?
# # 그리고 어떨때 [[] for _ in range(N+1)]로 가고 왜 어떨땐 list로 가?

# # visited = [False] * (N+1) # 그리고 여기서는 왜 visited 안세?

# count = 0
# cnt = 0
# # 이건 딱 봐도 다 해봐야 해 -> dfs
# def dfs(v):
#     visited[v] = True
#     for i in graph[v]:
#         if not visited[i]:
#             dfs(i)
#             cnt += 1
#     return cnt

# for i in range(N-1):
#     graph[i].append(i+1)
#     graph[i+1].append(i)
# # 그래프 연결
#     sum = sum + dfs(i)
#     if sum == S:
#         count += 1

# print(count)

# # 
# # list(map(int, input().split())) vs [] for _ in range(N+1)의 차이
# # 1) 그냥 LIST는 1차원배열
# # 2) [[]]는 2차원배열

# # VISITED는 DFS라 해서 항상쓰는게아니다. 
# # graph dfs는 visited가 필수지 1->2->3->1
# # 부분수열 dfs는 [1,2,3] 선택구조 tree니까 방문의 개념이 없다
# #        ()
# #     1       x
# # 2      x 2      x 이렇게 tree로 가니까 visited가 필요가 없다.

# # visited쓰는경우는 상하좌우 이동하거나 미로이거나 그래프, 트리인 경우
# # visited안쓰는경우는 부분수열, 순열, 조합, 모든 경우의 수
# # 문제 구조가 연결이면 graph
# # 문제 구조가 선택히면 list임

# import sys
# input = sys.stdin.readline
# N,S = map(int, input().split())
# arr = list(map(int, input().split()))

# count = 0

# def dfs(idx, total):
#     global count

#     if idx == N:
#         if total == S:
#             count +=1

#         return
    
#     # 1) idx 포함
#     dfs(idx + 1, total + arr[idx])

#     # 2) idx 미포함
#     dfs(idx + 1, total)

# dfs(0,0)

# # s=0이면 공집합을 제외해야한다.
# if S == 0:
#     count -= 1

# print(count)









import sys
input = sys.stdin.readline
N,S = map(int, input().split())
arr = list(map(int, input().split()))

count = 0

def dfs(idx, total):
    global count

    if idx == N:
        if total ==S:
            count += 1
        return
    dfs(idx + 1, total + arr[idx])
    dfs(idx + 1)

dfs(0,0)

# 공집합 제외
if S == 0:
    count -= 1











