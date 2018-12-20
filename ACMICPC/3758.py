t = int(input())

for a in range(t):
    n, k, t, m = map(int, input().split(' '))

    score = [[0 for col in range(k)] for row in range(n)]
    result = [[0 for col in range(4)] for row in range(n)]

    for b in range(n):
        result[b][0] = b+1

    for b in range(m):
        i, j, s = map(int, input().split(' '))

        result[i-1][2] += 1
        result[i-1][3] = (b+1)

        score[i-1][j-1] = max(score[i-1][j-1], s)

    for b in range(n):
        result[b][1] = sum(score[b])

    result.sort(key=lambda row: row[3])
    result.sort(key=lambda row: row[2])
    result.sort(reverse=True, key=lambda row: row[1])

    for rank, b in enumerate(result):
        if b[0] == t:
            print(rank + 1)
            break
