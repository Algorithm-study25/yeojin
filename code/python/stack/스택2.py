# 2026-01-28
import sys
input = sys.stdin.readline

n = int(input())
stack = []
outputs = []

for _ in range(n):
    cmd = input().split()
    op = int(cmd[0])

    if op == 1:
        x = int(cmd[1])
        stack.append(x)
    elif op == 2:
        outputs.append(str(stack.pop() if stack else -1))
    elif op == 3:
        outputs.append(str(len(stack)))
    elif op == 4:
        outputs.append('1' if not stack else '0')
    elif op == 5:
        outputs.append(str(stack[-1] if stack else -1))

print("\n".join(outputs))