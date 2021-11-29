#051
input_num_1, input_num_2 = input().split()
input_num_1 = int(input_num_1)
input_num_2 = int(input_num_2)
print(input_num_1 != input_num_2)

#052
input_num = input()
input_num = int(input_num)
print(bool(input_num != 0))

#053
input_num = input()
input_num = int(input_num)
print(not bool(input_num))

#054
input_a, input_b = input().split()
input_a = int(input_a)
input_b = int(input_b)
print(bool(input_a and input_b))

#055
input_a, input_b = input().split()
print(bool(int(input_a) or int(input_b)))

#056
input_x, input_y = input().split()
input_x = bool(int(input_x))
input_y = bool(int(input_y))
print((input_x and (not input_y)) or ((not input_x) and input_y))

#057
input_x, input_y = input().split()
print(bool(int(input_x) == int(input_y)))

#058
input_x, input_y = input().split()
input_x = bool(int(input_x))
input_y = bool(int(input_y))
print(bool((input_x == False) and (input_y == False)))

#059
input_a = int(input())
print(~input_a)

#060
input_a, input_b = input().split()
print(int(input_a)&int(input_b))

#061
input_a, input_b = input().split()
print(int(input_a)|int(input_b))

#062
input_a, input_b = input().split()
print(int(input_a)^int(input_b))

#063
input_a, input_b = input().split()
a = int(input_a)
b = int(input_b)
c = (a if a>b else b)
print(c)

#064
input_a, input_b, input_c = input().split()
a = int(input_a)
b = int(input_b)
c = int(input_c)
d = ((a if a<b else b) if((a if a<b else b) < c) else c)
print(d)
