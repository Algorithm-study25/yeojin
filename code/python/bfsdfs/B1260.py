from collections import deque
N, M, V = (map(int, input().split()))

graph = [[] for _ in range(N+1)] # 빈 리스트를 N+1개만든 리스트
# 결과는 [[], [], []] 이렇게 됨
# 왜? graph[1]-graph[3] 이렇게 연결할라고

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].sort() # 정렬하는것
    # 왜? 예를 들어, 입력이 1-3 / 1-2  이렇게 들어왔다면,
    # graph[1] = [3,2]
    # 정렬안하면 1 -> 3 -> 2
    # dfs/bfs는 리스트 순서대로 탐색함. 그래서 리스트를 미리 정렬해두면 자동으로 작은 번호부터 탐색됨

# dfs
visited_dfs = [False] * (N + 1) 
# 리스트인데, visited_dfs[1] = 1번 노드 방문 여부 체크하기 위함
visited_bfs = [False] * (N + 1)

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

dfs(graph, V, visited_dfs)
print()
bfs(graph, V, visited_bfs)

    

N, M, V = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N+1):
    graph.sort()

def dfs(graph, v, visited):
    