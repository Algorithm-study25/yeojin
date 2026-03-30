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

