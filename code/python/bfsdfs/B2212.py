# 센서
# 최선의 선택을 매 순간 해야 하니까 greedy는 ok

N = int(input())
K = int(input())
arr = list(map(int, input().split()))
arr.sort()

Narray = []
Narray.append(arr)

Karray = []

length = arr[-1] - arr[0]
gap = []
for i in range(len(arr)-1): # len(arr)은 6 이니까 지금 012345 까지돈다
    gap.append(arr[i+1] - arr[i]) # 여기서 gap[i] = arr[i+1] - arr[i] 잖아. 근데 list가 비어있는데 index로 접근해서 에러나는것
# gap[i] = arr[i+1] - arr[i]로 할거면 gap을 미리 다 0으로 초기화해두면 가능함
# 012345까지 도는데 arr[6]이 나오면안되긴하지
# 01234까지 돌고, arr[5] - arr[4]

gap.sort(reverse=True)

answer = sum(gap) - sum(gap[:K-1])

print(answer)