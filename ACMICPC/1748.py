n = int(input())

pos = 8
length = [i+1 for i in range(9)]
result = 0

while pos != -1:
    base = 10 ** pos

    if int(n / base) != 0 :
        temp = n - base + 1
        result += (length[pos] * temp)
        n -= temp

    pos -= 1

print(result)