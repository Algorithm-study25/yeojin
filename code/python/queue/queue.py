# deque
from collections import deque
queue = []
queue.append(1) # 뒤에 추가 O(1)
queue.pop(0) # 앞에서 제거 O(N)

queue = deque() # deque로됨. 양쪽에서 넣고 뺄 수 있음
queue.append(1) # 뒤에 추가 O(1)
queue.popleft() # 앞에서제거 근데 얘도 O(1)

queue.append(x) # 뒤에 넣기
queue.popleft() # 앞에서 빼기
queue.appendleft() # 앞에넣기
queue.pop(x) # 뒤에서 빼기

# bfs에서 deque쓰는이유
# fifo, 먼저 들어온 게 먼저 나감
# queue = deque([start])
# while queue:
# v = queue.popleft()

