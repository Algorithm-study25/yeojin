R,C,T = map(int, input().split())

A = [list(map(int, input().split())) for _ in range(R)]

filter = [] # [(1,1), (1,2)]

for i in range(R):
    if A[i][0] == -1:
        filter.append(i)

up = filter[0]
down = filter[1] # 위쪽, 아래쪽 공기청정기

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def spread():
    # 확산은 동시에 일어나니까 반드시 옮겨서 temp배열을 사용해야한다.
    temp = [[0] * C for _ in range(R)]

    for r in range(R):
        for c in range(C):
            if A[r][c] > 0:
                s = A[r][c] // 5
                cnt = 0

                for i in range(4):
                    nr = r + dx[i]
                    nc = c + dy[i]

                    if 0<= nr < R and 0<= nc < C and A[nr][nc] != -1:
                        temp[nr][nc] += s
                        cnt += 1
                temp[r][c] += A[r][c] - s * cnt

    temp[up][0] = -1
    temp[down][0] = -1 # 공청기 유지

    return temp

def clean():
    # 위쪽
    # 위
    for i in range(up-1, 0, -1):
        A[i][0] = A[i-1][0]

    for i in range(C-1):
        A[0][i] = A[0][i+1]
    
    for i in range(up):
        A[i][C-1] = A[i+1][C-1]

    for i in range(C-1, 1, -1):
        A[up][i] = A[up][i-1]
    A[up][1] = 0 # 공기청정기에서 나온 그 칸은 0이 되어야 함

    # 아래쪽
    for i in range(down+1, R-1):
        A[i][0] = A[i+1][0]
    # 오른쪽
    for i in range(C-1):
        A[R-1][i] = A[R-1][i+1]
    # 위
    for i in range(R-1, down, -1):
        A[i][C-1] = A[i-1][C-1]
    # 왼쪽
    for i in range(C-1, 1, -1):
        A[down][i] = A[down][i-1]
    A[down][1] = 0

for _ in range(T):
    A = spread()
    clean()

result = 0
for r in range(R):
    for c in range(C):
        if A[r][c] > 0:
            result += A[r][c]

print(result)