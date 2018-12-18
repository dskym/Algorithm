s = input()

m_s = s.strip()

r = m_s.split(' ')

if len(r) == 1:
    if r[0] == '':
        print(0)
    else:
        print(1)
else:
    print(len(r))
