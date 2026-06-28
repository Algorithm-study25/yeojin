from collections import deque
N,K,L = map(int, input().split())

arr = [list(map, int(input().split())) for _ in range(N)]

robots = []

for _ in range(K):
    x,y = map(int, input().split())
    robots.append((x-1,y-1))

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def rotate_dir(x,y,d):  # d=0123인데, 가장 최대가 어딘지 기억하는
    for _ in range(d): # 아 여기서 d만큼 회전, 회전, 회전이네
        x,y = -y,x

    return x,y

# 근데 방향 순서가 고정되잖아
# 근데 if total >= best니까, 같아도 덮어씀, 나중 값이 이김

patterns = [
    (-1,0),
    (0,-1),
    (0,0),
    (0,1)
]

def bfs(graph, start, visited):
    queue = deque([start])

    visited[start] = True

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

