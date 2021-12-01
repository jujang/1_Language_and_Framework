# 092  -> 리스트를 아직 잘 활용할줄 모른다면 좋은 문제, 다시 풀어봅시다
input_num = int(input())
a = input().split()
for i in range(input_num):   # 0 ~ input_num-1 까지
    a[i] = int(a[i])

d = []
for j in range(24):  # 0 ~ 23 까지
    d.append(0)

for k in range(input_num):
    d[a[k]] += 1  # a의 값을 d에다가 [0]자리를 0이라고 두고 각각 개수만큼 넣어줌

for x in range(1, 24):
    print(d[x], end=' ')  # [1]자리부터 [23]자리까지의 값(불린 개수)을 출력함


# 093
input_num = int(input())
d = input().split()
for i in range(input_num):
    d[i] = int(d[i])
for j in range(input_num-1, -1, -1):
    print(d[j], end=' ')

# 094
input_num = int(input())
d = input().split()
for i in range(input_num):
    d[i] = int(d[i])
low_num = d[0]
for j in range(input_num):
    if d[j] < low_num:
        low_num = d[j]
print(low_num)

# 095 -> 이거 해내는데 참 오래걸렸음...;;; 몇번 더 풀어봅시다...ㅎㅎㅎ / 흠...그리고 x,y좌표에 대해서는 다른 거 더 보면서 좀 더 고민해봅시다...
d = []
for i in range(20):
    d.append([])
    for j in range(20):
        d[i].append(0)

input_num = int(input())
for a in range(input_num):
    y, x = input().split()
    y = int(y)
    x = int(x)
    d[x][y] = 1

for l_y in range(1, 20):
    for l_x in range(1, 20):
        print(d[l_x][l_y], end=' ')
    print()

# 096 -> 음... 이건 그냥 뻐큐임.... 굳이 또 해볼 필요 없을 듯....
# 전체 기본 좌표 입력부
d = []
for i in range(19):
    d.append([])
    d[i] = input().split()
# 좌표값 str->int 타입변경
for v in range(19):
    for w in range(19):
        if d[v][w] == '1':
            d[v][w] = 1
        else:
            d[v][w] = 0
# 입력된 좌표대로 뒤집기
input_num = int(input())
for j in range(input_num):
    y, x = input().split()
    y = int(y)
    x = int(x)
    for a in range(19):
        if d[y-1][a] == 1:
            d[y-1][a] = 0
        else:
            d[y-1][a] = 1
    for b in range(19):
        if d[b][x-1] == 1:
            d[b][x-1] = 0
        else:
            d[b][x-1] = 1
# 연산된 좌표 출력하기
for l_y in range(19):
    for l_x in range(19):
        print(d[l_y][l_x], end=' ')
    print()

# 097
input_h, input_w = input().split()
input_h = int(input_h)
input_w = int(input_w)
dd = []
for h in range(input_h):
    dd.append([])
    for w in range(input_w):
        dd[h].append(0)

input_num = int(input())
for i in range(input_num):
    l, d, x, y = input().split()
    l = int(l)
    d = int(d)
    x = int(x)
    y = int(y)
    if d == 0:
        for j in range(y-1, y-1+l):
            dd[x-1][j] = 1
    else:
        for k in range(x-1, x-1+l):
            dd[k][y-1] = 1
for a in range(input_h):
    for b in range(input_w):
        print(dd[a][b], end=' ')
    print()

# 098 -> 나쁘지 않음,,, 다만 또 풀고싶지는 않음
# 기본 셋팅
dd = []
for i in range(10):
    dd.append([])
    dd[i] = input().split()
# 좌표값 str->int로 변경
for j in range(10):
    for k in range(10):
        if dd[j][k] == '1':
            dd[j][k] = 1
        elif dd[j][k] == '2':
            dd[j][k] = 2
        else:
            dd[j][k] = 0
start_x = 1   # 이건 다른 한 줄로 작성하는 방법이 없나...???
start_y = 1
# 탐색
dd[start_x][start_y] = 9
while True:
    if dd[start_x][start_y+1] == 0:
        dd[start_x][start_y+1] = 9
        start_y += 1
    elif dd[start_x+1][start_y] == 0:
        dd[start_x+1][start_y] = 9
        start_x += 1
    elif (dd[start_x][start_y+1] == 2) or (dd[start_x+1][start_y] == 2):
        if dd[start_x][start_y+1] == 2:
            dd[start_x][start_y+1] = 9
            break
        else:
            dd[start_x+1][start_y] = 9
            break
    elif start_x == 8 and start_y == 8:
        break
# 결과 출력
for v in range(10):
    for w in range(10):
        print(dd[v][w], end=' ')
    print()
