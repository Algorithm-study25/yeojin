N = int(input())

array = list(map(int, input().split()))

M = int(input())

array2 = list(map(int, input().split()))

# 중요한 건 시간복잡도네. o(1)
count = {}

for num in array:
    if num in count:
        count[num] += 1
    else:
        count[num] = 1

for x in array2:
    if x in count:
        print(count[x], end=' ')
    else:
        print(0, end=' ')


