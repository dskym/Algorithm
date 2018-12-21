#1000 + 70 * x < c * x
#a < (c-b) * x
#x > a / (c-b)

import math

a, b, c = map(int, input().split(' '))

if b >= c:
    print(-1)
else:
    x = a / (c - b)

    if math.ceil(x) == x:
        print(int(math.ceil(x)) + 1)
    else:
        print(math.ceil(x))
