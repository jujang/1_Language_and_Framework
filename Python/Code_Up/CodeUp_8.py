# 077
input_num = int(input())
compare_num = 2
sum = 0
while input_num >= compare_num:
    if compare_num % 2 == 0:
        sum = sum+compare_num
    compare_num = compare_num+1
print(sum)

# 078
input_chr = input()
while input_chr != 'q':
    print(input_chr)
    input_chr = input()
print(input_chr)

# 079
input_num = int(input())
sum = 0
for i in range(input_num):
    if sum < input_num:
        sum = sum+i
    else:
        print(i-1)
        break

# 080
input_a, input_b = input().split()
input_a = int(input_a)
input_b = int(input_b)
for i in range(input_a):
    for j in range(input_b):
        print(i+1, j+1)

# 081 => 다시 풀어볼만한 기본 출력 종합 문제
input_16num = int(input(), 16)
for i in range(1, 16):
    print('%X' % input_16num+'*'+'%X' % i+'='+'%X' % (input_16num*i))

# 또는
# print('%X'%input_16num, '*%X'%i, '=%X'%(input_16num*i), sep='')

# 082 => 이것도 괜찮은 다시 풀어볼만한 문제...
input_num = int(input())
for i in range(1, input_num+1):
    if i % 10 == 3 or i % 10 == 6 or i % 10 == 9:
        print('X', end=' ')
    else:
        print(i, end=' ')

# 083
input_r, input_g, input_b = input().split()
input_r = int(input_r)
input_g = int(input_g)
input_b = int(input_b)
sum = 0
for i in range(input_r):
    for j in range(input_g):
        for k in range(input_b):
            print(i, j, k)
            sum = sum+1
print(sum)
