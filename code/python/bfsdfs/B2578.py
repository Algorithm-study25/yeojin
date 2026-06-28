arr = [list(map(int, input().split())) for _ in range(5)]
answer = [list(map(int, input().split())) for _ in range(5)]

pos = {} # dictionary, 값 -> 위치를 바로 찾기 위한 표
# 예) pos[7] = (2,3)
# board[2][3] = 17 이면, pos[17] = (2,3) # 이건 튜플. x = 2 y = 3

for i in range(5):
    for j in range(5):
        pos[arr[i][j]] = (i,j)

visited = [[False] * 5 for _ in range(5)]

def bingo_count():
    cnt = 0

    # 가로
    for i in range(5):
        if all(visited[i][j] for j in range(5)): # all(리스트)는, 전부 True라면, return True
            cnt += 1
    # 세로
    for j in range(5):
        if all(visited[i][j] for i in range(5)):
            cnt +=1
    # 대각선
    if all(visited[i][i] for i in range(5)):
        cnt += 1

    if all(visited[i][4-i] for i in range(5)):
        cnt += 1
    
    return cnt

count = 0

for i in range(5):
    for j in range(5):
        count += 1
        num = answer[i][j]

        x,y = pos[num]
        visited[x][y] = True

        if bingo_count() >= 3:
            print(count)
            exit() # 이거 대신 break찍으면 바깥 for문은 계속 돌기 때문에 break대신 exit


