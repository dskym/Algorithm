while True:
    n = int(input())

    if n == 0:
        break

    pos = 0

    for i in range(n):
        line = input()

        space = False

        for index, c in enumerate(line):
            if c == ' ' and index + 1 >= pos:
                pos = index + 1
                space = True
                break

        if space is False:
            if len(line) + 1 >= pos:
                pos = len(line) + 1

    print(pos)
