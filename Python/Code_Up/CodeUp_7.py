# 065
input_a, input_b, input_c = input().split()
input_a = int(input_a)
input_b = int(input_b)
input_c = int(input_c)
if input_a%2 == 0:
    print(input_a)
if input_b%2 == 0:
    print(input_b)
if input_c%2 == 0:
    print(input_c)

# 066
input_a, input_b, input_c = input().split()
input_a = int(input_a)
input_b = int(input_b)
input_c = int(input_c)
if input_a%2 == 0:
    print("even")
else:
    print("odd")

if input_b%2 == 0:
    print("even")
else:
    print("odd")

if input_c%2 == 0:
    print("even")
else:
    print("odd")

# 067
input_num = input()
input_num = int(input_num)
if(input_num < 0):
    if(input_num%2 == 0):
        print("A")
    else:
        print("B")
else:
    if(input_num%2 == 0):
        print("C")
    else:
        print("D")

# 068
input_num = input()
input_num = int(input_num)
if(input_num >= 90):
    print("A")
elif(input_num >= 70):
    print("B")
elif(input_num >= 40):
    print("C")
else:
    print("D")

# 069
input_chr = input()
if(input_chr == "A"):
    print("best!!!")
elif(input_chr == "B"):
    print("good!!")
elif(input_chr == "C"):
    print("run!")
elif(input_chr == "D"):
    print("slowly~")
else:
    print("what?")

# 070
input_num = input()
input_num = int(input_num)
if(input_num//3 == 1):
    print("spring")
elif(input_num//3 == 2):
    print("summer")
elif(input_num//3 == 3):
    print("fall")
else:
    print("winter")

# 071
n = int(input())
while n!=0:
    print(n)
    n = int(input())

# 072
n = int(input())
while n>0:
    print(n)
    n = n-1
    
# 073
n = int(input())
n = n-1
while n>=0:
    print(n)
    n = n-1

# 074
character = ord(input())
compare_chr = ord("a")
while character>=compare_chr:
    print(chr(compare_chr))
    compare_chr = compare_chr+1

# 075
num = int(input())
compare_num = 0
while num>=compare_num:
    print(compare_num)
    compare_num = compare_num+1

#076
num = int(input())
for i in range(num+1):
    print(i)