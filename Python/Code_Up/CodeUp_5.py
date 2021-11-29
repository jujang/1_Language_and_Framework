#042
float_num = float(input())
print(format(float_num, ".2f"))

#043
input_float_1, input_float_2 = input().split()
input_float_1 = float(input_float_1)
input_float_2 = float(input_float_2)
print(format(input_float_1/input_float_2, ".3f"))

#044
input_num_1, input_num_2 = input().split(' ')
input_num_1 = int(input_num_1)
input_num_2 = int(input_num_2)
print(input_num_1+input_num_2)
print(input_num_1-input_num_2)
print(input_num_1*input_num_2)
print(input_num_1//input_num_2)
print(input_num_1%input_num_2)
print(format(input_num_1/input_num_2, ".2f"))

#045
input_num1, input_num2, input_num3 = input().split(' ')
input_num1 = int(input_num1)
input_num2 = int(input_num2)
input_num3 = int(input_num3)
print(input_num1+input_num2+input_num3, format(input_num1+input_num2+input_num3/3, ".2f"))

#046
input_num = int(input())
print(input_num<<1)

#047
input_a, input_b = input().split()
input_a = int(input_a)
input_b = int(input_b)
print(input_a<<input_b)

#048
input_1, input_2 = input().split()
input_1 = int(input_1)
input_2 = int(input_2)
print(input_1<input_2)

#049
input_x, input_y = input().split()
input_x = int(input_x)
input_y = int(input_y)
print(input_x==input_y)

#050
input_v, input_w = input().split()
input_v = int(input_v)
input_w = int(input_w)
print(input_v<=input_w)
