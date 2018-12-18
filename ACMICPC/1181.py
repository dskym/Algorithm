n = int(input())

word_set = set()

for i in range(n):
    temp = input()

    word_set.add(temp)

words = list(word_set)

words.sort()

words.sort(key=lambda l: len(l))

for word in words:
    print(word)
