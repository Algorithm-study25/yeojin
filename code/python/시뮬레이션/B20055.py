# n,k = map(int, input().split())

# a = list(map(int, input().split())) # 내구도

# robots= {}
# graph = [[0] * n]
# graph.append(robots)

# def rotate():
#     new_a = [] # 새로운 배열
#     new_a[0] = a[2*n]
#     new_a[2*n] = a[2*n-1]
#     for i in range(1, 2*n-1):
#        new_a[i] = a[i-1]

# def move_robots(a):
#     for i in range(n-1):
#         if a[i] >= 1 and graph[i + 1] != 1:
#             # robots ++

# def put_robots():
#     if a[0] != 0:
#         # 로봇 올려라
#         # 

# count_zero = 0
# for i in range(2*n):
#     if a[i] == 0:
#         count_zero += 1

# if count_zero >= k:
#     break

n,k = map(int, input().split())
a = list(map(int, input().split()))

robots = [0] * n # 로봇의 위치가 0 ~ n-1임

step = 0

while True:
    step += 1
    a = [a[-1]] + a[:-1]
    robots = [0] + robots[:-1] # 맨 앞에 0을 추가하고, 나머지는 한 칸씩 오른쪽으로 이동한다.
    robots[-1] = 0

    for i in range(n-2, -1, -1): # 뒤에서부터
        if robots[i] == 1 and robots[i+1] == 0 and a[i+1] >= 1:
            robots[i] = 0
            robots[i+1] = 1
    
    robots[-1] = 0 # 로봇제거

    if a[0] > 0:
        robots[0] = 1
        a[0] = a[0] -1
    
    if a.count(0) >= k:
        break

print(step)