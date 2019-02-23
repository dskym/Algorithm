n = int(input())

l = []

for i in range(n):
    s = input()

    a, b = s.split(' ')
    a, b = int(a), int(b)

    l.append((a, b))

l.sort(key=lambda v : v[1])
l.sort(key=lambda v : v[0])

for c in l:
    print(c[0], c[1])
