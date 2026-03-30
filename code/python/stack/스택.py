# 2026-01-28
import sys
input = sys.stdin.readline

n = int(input())
stack = []
result = []

for _ in range(n):
    cmd = input().split()
    op = str(cmd[0])

    if op == 'push':
        stack.append(int(cmd[1]))
    elif op == 'top':
        result.append(str(stack[-1]) if stack else '-1')
    elif op == 'size':
        result.append(str(len(stack)))
    elif op == 'empty':
        result.append('1' if not stack else '0')
    elif op == 'pop':
        result.append(str(stack.pop()) if stack else '-1')

print("\n".join(result))