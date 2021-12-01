# 084
h, b, c, s = input().split()
h = int(h)
b = int(b)
c = int(c)
s = int(s)
MB = h*b*c*s/(1024*1024*8)
print(format(MB, ".1f")+' MB')

# 085
w, h, b = input().split()
w = int(w)
h = int(h)
b = int(b)
MB = w*h*b/(8*1024*1024)
print(format(MB, ".2f")+' MB')

# 086
input_num = int(input())
sum = 0
i = 1
while sum < input_num:
    sum = sum+i
    i = i+1
print(sum)

# 087
input_num = int(input())
for i in range(1, input_num+1):
    if i % 3 != 0:
        print(i, end=' ')

# 088
input_a, input_b, input_c = input().split()
input_a = int(input_a)
input_b = int(input_b)
input_c = int(input_c)
sum = input_b*(input_c-1)+input_a
print(sum)

# 089
a, r, n = input().split()
a = int(a)
r = int(r)
n = int(n)
sum = a*(r**(n-1))
print(sum)

# 090
a, m, d, n = input().split()
a = int(a)
m = int(m)
d = int(d)
n = int(n)
sum = a

if n == 1:
    print(sum)
else:
    for i in range(2, n+1):
        sum = (sum*m)+d
    print(sum)

# 091 -> 처음부터 끝까지 내 머리에서 나온 방법이 아니므로 나중에 다시 풉시다..ㅎㅎㅎㅎ
a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)
for i in range(max(max(a, b), c), (a*b*c)+1):
    if i % a == 0 and i % b == 0 and i % c == 0:
        print(i)
        break
