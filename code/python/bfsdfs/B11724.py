# 1260 → 11724 → 2667 → 2178 → 2606 순서로 풀기
N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, input().split())
