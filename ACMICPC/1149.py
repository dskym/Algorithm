n = int(input())

dp = [[0 for i in range(3)] for j in range(n)]
data = [[0 for i in range(3)] for j in range(n)]

for i in range(n) :
    for j, value in enumerate(list(map(int, input().split(' ')))) :
        data[i][j] = value

dp[0] = data[0]

for i in range(1, n) :
    for j in range(3) :
        if j == 0 :
            dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + data[i][j]
        elif j == 1 :
            dp[i][j] = min(dp[i-1][0], dp[i-1][2]) + data[i][j]
        elif j == 2 :
            dp[i][j] = min(dp[i-1][0], dp[i-1][1]) + data[i][j]

print(min(dp[n-1]))