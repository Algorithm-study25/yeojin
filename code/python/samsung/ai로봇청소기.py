from collections import deque

N, K, L = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

robots = []
for _ in range(K):
    x, y = map(int, input().split())
    robots.append((x-1, y-1))

# 하우좌상
dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]

# =========================
# 방향 회전
# =========================
def rotate_dir(x, y, d):
    for _ in range(d):
        x, y = -y, x
    return x, y

# =========================
# 청소 패턴 (위 기준)
# =========================
patterns = [
    (-1, 0),
    (0, -1),
    (0, 0),
    (0, 1),
]

# =========================
# BFS (핵심 수정 포함)
# =========================
def bfs(sx, sy, robot_set):
    visited = [[False]*N for _ in range(N)]
    q = deque([(sx, sy, 0)])
    visited[sx][sy] = True

    candidates = []

    while q:
        x, y, dist = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny]: continue
                if arr[nx][ny] < 0: continue
                if (nx, ny) in robot_set: continue

                visited[nx][ny] = True

                if arr[nx][ny] == 0:
                    q.append((nx, ny, dist+1))
                else:
                    candidates.append((dist+1, nx, ny))

    if not candidates:
        return sx, sy   # ✅ 핵심 수정

    candidates.sort()
    _, nx, ny = candidates[0]
    return nx, ny


# =========================
# 이동
# =========================
def move_all(robots):
    new_robots = []
    robot_set = set(robots)

    for x, y in robots:
        robot_set.remove((x, y))

        if arr[x][y] > 0:
            nx, ny = x, y
        else:
            nx, ny = bfs(x, y, robot_set)

        new_robots.append((nx, ny))
        robot_set.add((nx, ny))

    return new_robots


# =========================
# 청소
# =========================
def clean_all(robots):
    for x, y in robots:
        best = -1
        best_dir = 0

        for d in range(4):
            total = 0

            for px, py in patterns:
                rx, ry = rotate_dir(px, py, d)
                nx = x + rx
                ny = y + ry

                if 0 <= nx < N and 0 <= ny < N:
                    if arr[nx][ny] > 0:
                        total += min(20, arr[nx][ny])

            if total >= best:  # tie-break 유지
                best = total
                best_dir = d # 가장 많이 청소되는 부분 선택인데

        # 실제 청소
        for px, py in patterns:
            rx, ry = rotate_dir(px, py, best_dir)
            nx = x + rx
            ny = y + ry

            if 0 <= nx < N and 0 <= ny < N:
                if arr[nx][ny] > 0:
                    arr[nx][ny] = max(0, arr[nx][ny] - 20)


# =========================
# 먼지 증가
# =========================
def add_dust():
    for i in range(N):
        for j in range(N):
            if arr[i][j] > 0:
                arr[i][j] += 5


# =========================
# 확산
# =========================
def spread():
    new_arr = [row[:] for row in arr]

    for i in range(N):
        for j in range(N):
            if arr[i][j] == 0:
                s = 0
                for d in range(4):
                    ni = i + dx[d]
                    nj = j + dy[d]

                    if 0 <= ni < N and 0 <= nj < N:
                        if arr[ni][nj] > 0:
                            s += arr[ni][nj]

                new_arr[i][j] = s // 10   # 원본 로직 유지

    return new_arr


# =========================
# 총합
# =========================
def get_total():
    return sum(arr[i][j] for i in range(N) for j in range(N) if arr[i][j] > 0)


# =========================
# 시뮬레이션
# =========================
for _ in range(L):

    # 1. 이동
    robots = move_all(robots)

    # 2. 청소
    clean_all(robots)

    # 3. 증가
    add_dust()

    # 4. 확산
    arr = spread()

    # 5. 출력
    total = get_total()
    print(total)

    if total == 0:
        break
    # 시뮬레이션 문제에서 중요한 포인트인데, 더 이상 변화가 없으면 시뮬을 멈춰야해