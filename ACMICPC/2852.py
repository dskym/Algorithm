n = int(input())

win_time = [0, 0]
score = [0, 0]

bef_stamp = 0
cur_stamp = 0
temp = 0

for i in range(n):
    team_no, time = input().split(' ')

    team_no = int(team_no)
    hh, mm = time.split(':')

    hh = int(hh)
    mm = int(mm)

    cur_stamp = hh * 60 + mm

    if score[0] == score[1]:
        pass
    elif score[0] > score[1]:
        win_time[0] += (cur_stamp - bef_stamp)
    elif score[0] < score[1]:
        win_time[1] += (cur_stamp - bef_stamp)

    score[team_no-1] += 1

    bef_stamp = cur_stamp

final_stamp = 48 * 60

if score[0] == score[1]:
    pass
elif score[0] > score[1]:
    win_time[0] += (final_stamp - bef_stamp)
elif score[0] < score[1]:
    win_time[1] += (final_stamp - bef_stamp)

print(str(int(win_time[0] / 60)).zfill(2) + ':' + str(win_time[0] % 60).zfill(2))
print(str(int(win_time[1] / 60)).zfill(2) + ':' + str(win_time[1] % 60).zfill(2))
