# # 2025 상반기 2번
# Q = int(input())
# N = 0
# for i in range(Q):
#     array = list(map(int, input().split()))
    
#     Code = array[0]

#     if i == 0:
#         N
#     else:
#         N == array[1]

Q = int(input())

houses = []

for _ in range(Q):
    arr = list(map(int, input().split()))
    code = arr[0]

    if code == 100:
        N = arr[1]
        houses = [0] + arr[2:]
    elif code == 200:
        houses.append(arr[1])
    elif code == 300:
        houses.remove(arr[1])
    elif code == 400:
        r = arr[1]

        houses.sort()
        gap = []

        for i in range(1, len(houses)):
            gap.append(houses[i] - houses[i-1])

        gap.sort(reverse=True)

        total = houses[-1] - houses[0] # 가장 오른쪽 집(최댓값) - 가장 왼쪽 집 (최솟값) => 전체 길이(전 구간 길이)
        answer = total - sum(gap[:r-1])

# houses = [0,2,4,7,8,15]
# gap = [2,2,3,1,7]
# gap.sort(reverse=True)니까, gap = [7,3,2,2,1]
# gap[0] 은 값 하나로 대응되지만
# gap[:1] 은 [list]로 나오기 때문에 sum하기 쉬움
