def dfs(graph, start, visited):
    visited[start] = True
    print(start, end='  ') # 방문처리

    for i in graph[start]:
        if not visited[i]:
            dfs(graph, i, visited)

from collections import deque

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft() # 시간복잡도 상수시간을 보장해준다.
        print(v, end=' ')

        for i in graph[start]:
            if not visited[i]:
                queue.append(i) # 큐 맨 끝에 넣는다.
                visited[i] = True


a = input()

a = int(input())

a,b = map(int, input().split())

arr = list(map(int, input().split())) # 리스트로 받기 1 2 3 4 -> [1, 2, 3, 4]

# 2차원으로 입력받기
n = int(input())
graph = [list(map(int, input().split())) for i in range(n)]


import sys
input = sys.stdin.readline

n, m, v = map(int, input(). split())

graph = [[] for _ in range(n+1)] # 인접리스트 형태로 바로 저장하는 것이 일반적이다.
for _ in range(m):
    u, w = map(int, input().split())
    graph[u].append(w)
    graph[w].append(u) # 무방향 그래프라면 양쪽 다 추가

print(graph)