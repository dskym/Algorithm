t = int(input())

for i in range(t):
    result = 0

    n = int(input())

    temp = list(map(int, input().split(' ')))

    start = (temp[0], temp[1])
    end = (temp[2], temp[3])

    homes = []

    for j in range(4, len(temp), 2):
        homes.append((temp[j], temp[j+1]))

    pos = start

    while True:
        dis = 10000
        p = None

        for cur in homes:
            tempDis = abs(cur[0]-pos[0]) + abs(cur[1]-pos[1])

            if dis > tempDis:
                p = cur
                dis = tempDis

        print(p)
        pos = p
        homes.remove(p)
        result += dis

        if len(homes) == 0:
            result += abs(pos[0] - end[0]) + abs(pos[1] - end[1])
            break


    print('#' + str(i + 1) + " " + str(result))
