s = input()

a, b = s.split(':')

a = int(a)
b = int(b)

ta = a
tb = b

while a != 0:
    if a < b:
        a, b = b, a

    a = a % b

print(int(ta / b), int(tb/b), sep=':')