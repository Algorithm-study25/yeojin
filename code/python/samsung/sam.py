# # 미생물연구
# import sys
# input = sys.stdin.readline
# from collections import deque

# N, Q = map(int, input().split())

# grid = [[0]*N for _ in range(N)]
# groups = {}

# dx = [1,-1,0,0]
# dy = [0,0,1,-1]

# def bfs(start, cells):
#     visited = set()
# # set의 특징 s = set()
# # s = {(1,2), (1,2)}이면 결과가 {(1,2)}
# # (1,2) in s #o(1), 거의 바로 찾을 수 있다.
# # cells = set((x,y)) 하면, 이 그룹이 차지하는 좌표를 바로 알 수 있다.
# # cells 를 set 안쓰고 list쓰면 o(n)이니까 시간초과남
# # 그룹을 관리해야한다(좌표, 크기, 생성순서)
# # groups[gid] = {
# #     "cells": new_cells,
# #     "size": len(new_cells),
# #     "time": gid
# # } id로 관리해야할때(그룹 번호,노드 번호) / 여러 정보를 묶어야 할 때 dict를 쓴다.

# import sys
# input = sys.stdin.readline
# from collections import deque

# N, Q = map(int, input().split())

# grid = [[0]*N for _ in range(N)]
# grid = [[0]*N for _ in range(N)]
# groups = {}

# dx = [1,-1,0,0]
# dy = [0,0,1,-1]

# def bfs(start, cells):
#     visited = set() # 왜 여기서 set?
#     q = deque()
#     q.append([start])

#     visited.add(start) 

#     while q:
#         x,y = q.popleft()

#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]

#             if 0 <= nx < N and 0 <= ny < M:
#                 # if array[nx][ny] == 1 and not visited[nx][ny]:
#                     visited.add((nx, ny))
#                     q.append((nx, ny))
#     return visited

# def add_group(r1, r2, c1, c2):
#     global gid

#     new_cells = set()
#     for x in range(r1, r2):
#         for y in range(c1, c2):
#             new_cells.add((x,y))
    
#     overlapped = set()

#     for (x,y) in new_cells:
#         if grid[x][y] != 0:
#             overlapped.add(grid[x][y])

#     # 기존 그룹 제거
#     for g in overlapped:
#         cells = groups[g]["cells"]
#         for (x,y) in cells:
#             grid[x][y] = 0
#         del groups[g]

#     # 쪼개짐 체크
#     to_delete = []
#     for g in list(groups.keys()):
#         cells = groups[g]["cells"]
#         start = next(iter(cells))
#         comp = bfs(start, cells)

#         if len(comp) != len(cells):
#             # 쪼개짐 -> 삭제
#             for (x,y) in cells:
#                 grid[x][y] = 0
#             to_delete.append(g)     
#     for j in to_delete:
#         del groups[g]

#     # 새 그룹 추가
#     for(x,y) in new_cells:
#         grid[x][y] = gid

#     groups[gid] = {
#         "cells": new_cells,
#         "size": len(new_cells),
#         "time": gid
#     }
#     gid += 1

# def can_place(cells, ox, oy, new_grid):
#     for (x,y) in cells:
#         nx, ny = x + ox, y + oy

#         if nx < 0 or ny < 0 or nx >= N or ny >= N:
#             continue

#         if new_grid[nx][ny] != 0:
#             return False 

#     return True

from collections import deque

N, Q = map(int, input().split())

grid = [[0]*N for _ in range(N)]
groups = {}
gid = 1  # 그룹 id

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(start, cells):
    visited = set()
    q = deque([start])
    visited.add(start)

    while q:
        x,y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (nx,ny) in cells and (nx,ny) not in visited:
                visited.add((nx,ny))
                q.append((nx,ny))
    return visited

def add_group(r1,c1,r2,c2):
    global gid

    new_cells = set()
    for x in range(r1, r2):
        for y in range(c1, c2):
            new_cells.add((x,y))

    overlapped = set()
    for (x,y) in new_cells:
        if grid[x][y] != 0:
            overlapped.add(grid[x][y])

    # 기존 그룹 제거
    for g in overlapped:
        cells = groups[g]["cells"]
        for (x,y) in cells:
            grid[x][y] = 0
        del groups[g]

    # 쪼개짐 체크 (남은 그룹들)
    to_delete = []
    for g in list(groups.keys()):
        cells = groups[g]["cells"]
        start = next(iter(cells))
        comp = bfs(start, cells)
        if len(comp) != len(cells):
            # 쪼개짐 → 삭제
            for (x,y) in cells:
                grid[x][y] = 0
            to_delete.append(g)

    for g in to_delete:
        del groups[g]

    # 새 그룹 추가
    for (x,y) in new_cells:
        grid[x][y] = gid

    groups[gid] = {
        "cells": new_cells,
        "size": len(new_cells),
        "time": gid
    }

    gid += 1

def can_place(cells, ox, oy, new_grid): # 새로운 grid에 이동하는거지
    for (x,y) in cells:
        nx, ny = x + ox, y + oy
        if not (0 <= nx < N and 0 <= ny < N):
            return False
        if new_grid[nx][ny] != 0:
            return False
    return True

def place_groups():
    new_grid = [[0]*N for _ in range(N)]
    new_groups = {}

    items = sorted(groups.items(), key=lambda x: (-x[1]["size"], x[1]["time"]))

    for g, info in items:
        cells = info["cells"]

        # 기준점 (0,0 기준으로 이동)
        minx = min(x for x,y in cells)
        miny = min(y for x,y in cells)

        norm_cells = [(x-minx, y-miny) for (x,y) in cells]

        placed = False

        for i in range(N):
            for j in range(N):
                if can_place(norm_cells, i, j, new_grid):
                    new_cells = set()
                    for (x,y) in norm_cells:
                        nx, ny = x+i, y+j
                        new_grid[nx][ny] = g
                        new_cells.add((nx,ny))

                    new_groups[g] = {
                        "cells": new_cells,
                        "size": len(new_cells),
                        "time": info["time"]
                    }
                    placed = True
                    break
            if placed:
                break

    return new_grid, new_groups

def calc_score():
    seen = set()
    score = 0

    for x in range(N):
        for y in range(N):
            if grid[x][y] == 0:
                continue
            for d in range(4):
                nx, ny = x+dx[d], y+dy[d]
                if 0 <= nx < N and 0 <= ny < N:
                    a = grid[x][y]
                    b = grid[nx][ny]
                    if a != 0 and b != 0 and a != b:
                        pair = tuple(sorted((a,b)))
                        if pair not in seen:
                            seen.add(pair)
                            score += groups[a]["size"] * groups[b]["size"]
    return score

# 메인 실행
for _ in range(Q):
    c1, c2, r1, r2 = map(int, input().split())

    add_group(c1, c2, r1, r2)

    grid, groups = place_groups()

    print(calc_score())