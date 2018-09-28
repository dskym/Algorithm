import sys

def lis(index) :
    if dp[index] != -1 :
        return dp[index]

    result = 1

    for i in range(index + 1, n) :
        if data[index] < data[i] :
            result = max(result, lis(i) + 1)

    dp[index] = result

    return result

sys.setrecursionlimit(1000000)

n = int(input())

dp = [-1 for i in range(n + 1)]

data = list(map(int, input().split(' ')))

result = 0

for i in range(n) :
    result = max(result, lis(i))

print(result)