N, K =map(int, input().split())

A = [int(input()) for _ in range(N)]

A.sort(reverse=True)

count = 0

for money in A:
    count += K // money # count = count + (K//money)
    K %= money # k = k % money 

print(count)