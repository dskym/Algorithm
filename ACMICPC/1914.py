def move(fro, to, temp, n):
    if n == 1:
        print(str(fro+1) + " " + str(to+1))
    else:
        move(fro, temp, to, n-1)
        print(str(fro+1) + " " + str(to+1))
        move(temp, to, fro, n-1)        

n = int(input())

print(2 ** n - 1)

if n <= 20:
    move(0, 2, 1, n)
