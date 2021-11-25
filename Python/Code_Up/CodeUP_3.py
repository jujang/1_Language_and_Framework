#021
input_s = input()
print(input_s[0])
print(input_s[1])
print(input_s[2])
print(input_s[3])
print(input_s[4])

#022
input_s_2 = input()
print(input_s_2[0:2]+' '+input_s_2[2:4]+' '+input_s_2[4:6])

#023
time1, time2, time3 = input().split(':')
print(time2)

#024
str_1, str_2 = input().split(' ')
print(str_1+''+str_2)

#025
num_1,num_2 = input().split(' ')
num_3 = int(num_1) + int(num_2)
print(num_3)

#026
float_1 = float(input())
float_2 = float(input())
print(float_1+float_2)

#027
input_data = int(input())
print('%x'%input_data)

#028
input_data_2 = int(input())
print('%X'%input_data_2)

#029
input_data_3 = int(input(), 16)
print('%o'%input_data_3)

#030
input_data_4 = ord(input())
print(input_data_4)
