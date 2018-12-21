import math

a, b, c = map(int, input().split(' '))

diag = math.sqrt(b ** 2 + c ** 2)

width = a * c / diag
height = a * b / diag

print(int(height), int(width))
