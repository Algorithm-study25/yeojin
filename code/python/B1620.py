# # 
# N, M = map(int, input().split())

# name_to_num = {}
# num_to_name = {}
# # dict 2개쓰는이유
# # name_to_num = {
# #     "Pikachu": 25,
# #     "Charmander": 4
# # }
# # name_to_num["Pikachu"]  # O(1) 빠름
# # 번호 -> 이름일때 문제ㅜㅜ # O(N)임
# # for key, value in name_to_num.items():
# #     if value == 25:
# #         print(key)

# for i in range(1, N+1):
#     name = input().strip() # 문자열.strip()쓰면 믄자열의 양쪽 공백을 제거해줌
#     # input() → "Pikachu\n"이니까 \n을 제거하기 위함
#     name_to_num[name] = i
#     num_to_name[i] = name

# # 문제처리
# for _ in range(M):
#     q = input().strip()

#     if q.isdigit(): # 숫자면 # 근데 isdigit()은 숫자로 생긴 문자열인지 확인할뿐, q 자체는 여전히 str이다
#         print(num_to_name[int(q)])
#     else: # 문자열이면
#         print(name_to_num[q])

N,M = map(int, input().split())

name_to_int = {}
int_to_name = {}

for i in range(1, N+1):
    name = input().strip()
    name_to_int[name] = i
    int_to_name[i] = name

for _ in range(M):
    q = input().strip()

    if q.isdigit():
        print(int_to_name[int(q)])
    else:
        print(name_to_int[q]) 