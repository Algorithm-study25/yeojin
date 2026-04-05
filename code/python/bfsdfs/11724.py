import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)] 

for i in range(M): # 여기가 N+1이 아니라 M. 왜지? 아 간선의 갯수만큼 돌아야 함
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 방문여부 체크
visited = [False] * (N+1)

# DFS
def dfs(graph, v, visited):
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 연결 요소 개수 세기
cnt = 0

for i in range(1, N+1):
    if not visited[i]:
        dfs(graph, i, visited)
        cnt += 1

print(cnt)
