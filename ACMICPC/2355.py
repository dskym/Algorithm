def sum(n):
    return n * (n+1) / 2


a, b = input().split(' ')

a = int(a)
b = int(b)

if a > b:
    a, b = b, a

result = int((a+b) * (b-a+1) / 2)

print(result)
