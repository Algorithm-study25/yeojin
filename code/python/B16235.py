N, M, K = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(N)]

good_stuff = [[5]*N for _ in range(N)] # 땅에 있는 양분, 배열

# dict 쓰는 게 나을까? 나이도 계산해야하니까?
# groups = {}

# def make_groups():
#     global gid

#     new_trees = set()
    
#     groups[gid] = {
#         "trees": new_trees,
#         "age": K,
#     }

# def spring():
#     ages = groups[g]["age"]

# 각 칸마다 나이 리스트
trees = [[[]for i in range(N)] for _ in range(N)]

for _ in range(M):
    x,y,z = map(int, input().split())
    trees[x-1][y-1].append(z)

for i in range(N):
    for j in range(N):
        trees[i][j].sort() # 이건 한번만 실행하니까 ㄱㅊ은데

# 8방향
dx = [-1,-1,-1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1] 
# 8방향은 자기자신 빼고 양옆대각선 다 포함

# spring & summer
def spring_summer():
    for i in range(N):
        for j in range(N):
            if not trees[i][j]: # tree가 없다면 넘어가고
                continue

            trees[i][j].sort() # 어린 나무부터 해야하니까
            # 아 이게 코드가 느림 O(NMK)   
            # 여기서 하면 매년 해야하니까 K * N * N * (각 칸의 나무수 LOG)         

            alive = [] # 그럼 이건 age만 저장하는 배열인가?그건아닌거같은데
            dead_good_stuff = 0

            for age in trees[i][j]:
                if good_stuff[i][j] >= age:
                    good_stuff[i][j] -= age
                    alive.append(age+1) # 나이 한살 더 먹기
                else:
                    dead_good_stuff += age #봄에 죽은 나무들의 나이를 일단 다 모아둠

            trees[i][j] = alive # 왜 이거지? 근데 trees는 그럼 2차원배열에 append로 뭐 달아둔 형태인건가?
            good_stuff[i][j] += dead_good_stuff // 2

def fall():
    new_trees = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
           for age in trees[i][j]:
               if age % 5 == 0:
                   for k in range(8):
                       nx = i + dx[k]
                       ny = j + dy[k]

                       if nx < 0 or ny < 0 or nx >= N or ny >= N:
                           continue
                       else:
                           new_trees[nx][ny].append(1) # 여기서 왜 append가 아니라 insert?
                           # trees[ni][nj].append(1) 이렇게 하면 앞에서 sort한거에 맨 뒤에 1이 들어감
                           # 그럼 다음 spring에서 또 sort()해야해
                           # insert [2, 3, 5] → insert(0,1) → [1, 2, 3, 5] 이런 효과

    for i in range(N):
        for j in range(N):
            if new_trees[i][j]:
                # trees[i][j] += new_trees[i][j] # 이렇게 하면 정렬 깨짐
                trees[i][j] = new_trees[i][j] + trees[i][j]

def winter():
    for i in range(N):
        for j in range(N):
            good_stuff[i][j] += array[i][j]


for _ in range(K):
    spring_summer()
    fall()
    winter()

answer = 0
for i in range(N):
    for j in range(N):
        answer += len(trees[i][j])

print(answer)