# ./arithmetic_module.py가 entry.py와 같은 경로에 있었을 때의 예제임.
# import arithmetic_module
# print(arithmetic_module.sum(1,2))

# ./arithmetic_module.py에 entry.py와 같은 경로에 있었을 때의 예제임.
# import statistics_module
# print(statistics_module.sum(1,2))

# from statistics_module import sum  
# #이렇게 하면 이 파일에서는 앞으로 sum이라는 이름으로 
# statistics_module모듈의 sum함수 사용이 가능함
# print(sum(1,2))

# from statistics_module import sum as ssum
# 이렇게 하면 sum함수를 ssum이라는 별명으로 사용하게됨. 
# 다만, sum으로는 사용이 안 됨 / 근데 as 붙은거랑 as 안 붙은거 둘 다 써두면 둘 다 사용 가능함.
# print(ssum(1,2))


# ./number_package/statistics_module.py의 경로에 있었을 때의 entry파일의 예제
# import number_package.statistics_module
# print(number_package.statistics_module.sum(1,2))

# from을 사용해서 위와 같은 효과를 내 줄때의 코드 모습
# from number_package.statistics_module import sum
# print(sum(1,2))

# as를 써서 별칭을 사용할 경우의 코드의 모습
from number_package.statistics_module import sum as ssum
print(ssum(1,2))
